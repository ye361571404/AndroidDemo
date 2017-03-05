package hua.demo.feature.player.activity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.utils.FileUtils;
import com.blankj.utilcode.utils.ToastUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hua.demo.R;
import hua.demo.feature.player.adapter.MusicAdapter;
import hua.demo.feature.player.model.AudioDecorator;
import hua.demo.feature.player.model.PlayList;
import hua.demo.feature.player.model.Song;
import hua.demo.feature.player.player.IPlayback;
import hua.demo.feature.player.player.PlayMode;
import hua.demo.feature.player.player.PlaybackService;
import hua.demo.feature.player.present.MusicPlayerContract;
import hua.demo.feature.player.present.MusicPresentImpl;
import hua.demo.feature.player.utils.FileUtil;
import hua.demo.feature.player.utils.PreferenceManager;
import hua.demo.feature.player.utils.TimeUtils;
import hua.demo.main.activity.BaseActivity;

/**
 * 音乐播放器
 * 测试时在Music目录下放入音频文件即可
 * Created by Administrator on 2017/3/6.
 *
 */

public class MusicPlayerActivity extends AppCompatActivity implements MusicPlayerContract.View,
        IPlayback.Callback,
        View.OnClickListener,
        AudioManager.OnAudioFocusChangeListener {


    private static final long UPDATE_PROGRESS_INTERVAL = 1000;

    @Bind(R.id.rv_content)
    RecyclerView rvContent;
    @Bind(R.id.rl_list)
    RelativeLayout rlList;
    @Bind(R.id.text_view_progress)
    TextView textViewProgress;
    @Bind(R.id.seek_bar)
    SeekBar seekBar;
    @Bind(R.id.text_view_duration)
    TextView textViewDuration;
    @Bind(R.id.layout_progress)
    LinearLayout layoutProgress;
    @Bind(R.id.button_play_mode_toggle)
    ImageView buttonPlayModeToggle;
    @Bind(R.id.button_play_last)
    ImageView buttonPlayLast;
    @Bind(R.id.button_play_toggle)
    ImageView buttonPlayToggle;
    @Bind(R.id.button_play_next)
    ImageView buttonPlayNext;
    @Bind(R.id.button_favorite_toggle)
    ImageView buttonFavoriteToggle;
    @Bind(R.id.layout_play_controls)
    LinearLayout layoutPlayControls;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;


    private Context mContext;

    private MusicPlayerContract.Presenter mPresenter;
    private IPlayback mPlayer;
    private PlayList<Song> playList;
    private MusicAdapter mAdapter;

    private Handler mHandler = new Handler();

    private Runnable mProgressCallback = new Runnable() {
        @Override
        public void run() {
            if (isFinishing()){
                return;
            }

            if (mPlayer.isPlaying()) {
                // int progress = (int) (seekBar.getMax() * ((float) mPlayer.getProgress() / (float) getCurrentSongDuration()));
                int progress = mPlayer.getProgress();
                updateProgressTextWithDuration(mPlayer.getProgress());
                if (progress >= 0 && progress <= seekBar.getMax()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        seekBar.setProgress(progress, true);
                    } else {
                        seekBar.setProgress(progress);
                    }
                    mHandler.postDelayed(this, UPDATE_PROGRESS_INTERVAL);
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player_activity);
        ButterKnife.bind(this);

        init();
        initData();
        setListener();
    }

    private void setListener() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    updateProgressTextWithProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mHandler.removeCallbacks(mProgressCallback);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekTo(getDuration(seekBar.getProgress()));
                if (mPlayer.isPlaying()) {
                    mHandler.removeCallbacks(mProgressCallback);
                    mHandler.post(mProgressCallback);
                }
            }
        });
    }

    private void init() {
        mContext = this;
    }


    private void initData() {
        playList = new PlayList();
        List<AudioDecorator<Song>> songs = new ArrayList<>();
        AudioDecorator<Song> audioDecorator;
        Song song;

        // File appRoot = FileUtil.getAppRoot();
        // 方法一
        /*File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        List<File> files = FileUtils.listFilesInDir(directory);
        for (int i = 0; i < files.size(); i++) {
            song = new Song();
            song.setId(i);
            song.setTitle(files.get(i).getName());
            song.setPath(files.get(i).getAbsolutePath());
            songs.add(song);
            LogUtils.e("fileName = " + files.get(i).getName());
        }*/


        // 方法二
        // 获取 /storage/emulated/0/Music 目录下的音乐(添加读取SD卡权限)
        File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        List<File> files = FileUtils.listFilesInDir(directory);
        for (File file : files) {
            song = FileUtil.fileToMusic(file);
            audioDecorator = new AudioDecorator<Song>(song);
            songs.add(audioDecorator);
        }


        playList.setSongs(songs);

        rvContent.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new MusicAdapter(this,playList);
        rvContent.setAdapter(mAdapter);

        // 绑定服务
        new MusicPresentImpl(mContext, this).subscribe();
    }


    // Click Events

    /** 播放和暂停 **/
    @OnClick(R.id.button_play_toggle)
    public void onPlayToggle(){
        if (mPlayer == null){
            return;
        }

        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        } else {
            mPlayer.play();
        }
        // ToastUtils.showShortToast(mContext, "暂停或播放");
    }

    /**
     * 获取音频焦点
     */
    private void requestAudioFocus() {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int result = audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
    }


    /** 上一首 **/
    @OnClick(R.id.button_play_last)
    public void onPlayLast(){
        if (mPlayer == null) {
            return;
        }
        mPlayer.playLast();
        ToastUtils.showShortToast(mContext, "上一首");
    }

    /** 下一首 **/
    @OnClick(R.id.button_play_next)
    public void onPlayNext(){
        if (mPlayer == null) {
            return;
        }
        mPlayer.playNext();
        ToastUtils.showShortToast(mContext, "下一首");
    }


    /** 设置播放模式 **/
    @OnClick(R.id.button_play_mode_toggle)
    public void onPlayModeToggleAction(View view) {
        if (mPlayer == null){
            return;
        }

        // 获取当前模式
        PlayMode current = PreferenceManager.lastPlayMode(mContext);
        // 切换下一个模式
        PlayMode newMode = PlayMode.switchNextMode(current);
        PreferenceManager.setPlayMode(mContext, newMode);
        mPlayer.setPlayMode(newMode);
        updatePlayMode(newMode);
    }


    // MVP View

    @Override
    public void handleError(Throwable error) {
        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 绑定服务
     * @param service
     */
    @Override
    public void onPlaybackServiceBound(PlaybackService service) {
        mPlayer = service;
        mPlayer.registerCallback(this);
        mPlayer.setPlayList(playList);
        // 设置当前第一首歌信息
        if (!playList.getSongs().isEmpty()) {
            playList.setPlayingIndex(0);
            onSongUpdated(playList.getSongs().get(0));
        }
    }

    /**
     * 解绑服务
     */
    @Override
    public void onPlaybackServiceUnbound() {
        mPlayer.unregisterCallback(this);
        mPlayer = null;
    }

    @Override
    public void onSongSetAsFavorite(@NonNull AudioDecorator song) {

    }

    /**
     * 绑定服务获取当前歌曲信息
     * @param song
     */
    @Override
    public void onSongUpdated(@Nullable AudioDecorator song) {
        if (song == null) {
            buttonPlayToggle.setImageResource(R.drawable.ic_play);
            seekBar.setProgress(0);
            updateProgressTextWithProgress(0);
            seekTo(0);
            mHandler.removeCallbacks(mProgressCallback);
            return;
        }

        // Step 1: Song name and artist
        // textViewName.setText(song.getDisplayName());
        // textViewArtist.setText(song.getArtist());
        // Step 2: favorite
        // buttonFavoriteToggle.setImageResource(song.isFavorite() ? R.drawable.ic_favorite_yes : R.drawable.ic_favorite_no);
        // Step 3: Duration
        // textViewDuration.setText(TimeUtils.formatDuration(getCurrentSongDuration()));
        // Step 4: Keep these things updated
        // - Album rotation
        // - Progress(textViewProgress & seekBarProgress)
        /*Bitmap bitmap = AlbumUtils.parseAlbum(song);
        if (bitmap == null) {
            imageViewAlbum.setImageResource(R.drawable.default_record_album);
        } else {
            imageViewAlbum.setImageBitmap(AlbumUtils.getCroppedBitmap(bitmap));
        }
        imageViewAlbum.pauseRotateAnimation();
        mHandler.removeCallbacks(mProgressCallback);
        if (mPlayer.isPlaying()) {
            imageViewAlbum.startRotateAnimation();
            mHandler.post(mProgressCallback);
            buttonPlayToggle.setImageResource(R.drawable.ic_pause);
        }*/

        setTitle(song.getAudio().getAudioName());
        // 设置音频时长
        int duration = getCurrentSongDuration();
        textViewDuration.setText(TimeUtils.formatDuration(duration));
        // 设置进度条长度
        seekBar.setMax(duration);

        mHandler.removeCallbacks(mProgressCallback);
        if (mPlayer.isPlaying()) {
            mHandler.post(mProgressCallback);
            buttonPlayToggle.setImageResource(R.drawable.ic_pause);
        }
    }

    /**
     * 更新播放模式
     * @param playMode
     */
    @Override
    public void updatePlayMode(PlayMode playMode) {
        if (playMode == null) {
            playMode = PlayMode.getDefault();
        }
        switch (playMode) {
            case LIST:
                buttonPlayModeToggle.setImageResource(R.drawable.ic_play_mode_list);
                break;
            case LOOP:
                buttonPlayModeToggle.setImageResource(R.drawable.ic_play_mode_loop);
                break;
            case SHUFFLE:
                buttonPlayModeToggle.setImageResource(R.drawable.ic_play_mode_shuffle);
                break;
            case SINGLE:
                buttonPlayModeToggle.setImageResource(R.drawable.ic_play_mode_single);
                break;
        }
    }

    /** 播放按钮状态改变 **/
    @Override
    public void updatePlayToggle(boolean play) {
        if(play){
            requestAudioFocus();
        }
        buttonPlayToggle.setImageResource(play ? R.drawable.ic_pause : R.drawable.ic_play);
    }

    @Override
    public void updateFavoriteToggle(boolean favorite) {

    }

    @Override
    public void setPresenter(MusicPlayerContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubscribe();
        super.onDestroy();
    }


    /**
     * 更新进度:
     *      * 时间进度
     *      * 进度条进度
     * @param progress
     */
    private void updateProgressTextWithProgress(int progress) {
        int targetDuration = getDuration(progress);
        textViewProgress.setText(TimeUtils.formatDuration(targetDuration));
    }

    /**
     * 更新进度
     *      * 时间进度
     * @param duration
     */
    private void updateProgressTextWithDuration(int duration) {
        textViewProgress.setText(TimeUtils.formatDuration(duration));
    }

    /**
     * 获取进度
     * @param progress
     * @return
     */
    private int getDuration(int progress) {
        return (int) (getCurrentSongDuration() * ((float) progress / seekBar.getMax()));
    }

    /**
     * 获取当前播放音频时长
     * @return
     */
    private int getCurrentSongDuration() {
        int duration = 0;
        AudioDecorator playingSong = mPlayer.getPlayingSong();
        if (playingSong != null) {
            duration = playingSong.getAudio().getAudioDuration();
        }
        return duration;
    }

    private void seekTo(int duration) {
        mPlayer.seekTo(duration);
    }



    // Player Callbacks

    /**
     * 切换上一首回调
     * @param last
     */
    @Override
    public void onSwitchLast(@Nullable AudioDecorator last) {
        onSongUpdated(last);
    }

    /**
     * 切换下一首回调
     * @param next
     */
    @Override
    public void onSwitchNext(@Nullable AudioDecorator next) {
        onSongUpdated(next);
    }

    /**
     * 切换指定歌曲
     * @param next
     */
    @Override
    public void onSwitchSong(@Nullable AudioDecorator next) {
        onSongUpdated(next);
    }

    /**
     * 播放完成回调
     * @param next
     */
    @Override
    public void onComplete(@Nullable AudioDecorator next) {
        onSongUpdated(next);
    }

    /**
     * 播放和暂停回调
     * @param isPlaying
     */
    @Override
    public void onPlayStatusChanged(boolean isPlaying) {
        updatePlayToggle(isPlaying);
        if (isPlaying) {
            mHandler.removeCallbacks(mProgressCallback);
            mHandler.post(mProgressCallback);
            // seekBar.setMax(getCurrentSongDuration());
            // textViewDuration.setText(TimeUtils.formatDuration(getCurrentSongDuration()));
        } else {
            mHandler.removeCallbacks(mProgressCallback);
        }
    }


    /**
     * 监听音频焦点
     * @param focusChange
     */
    @Override
    public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            case AudioManager.AUDIOFOCUS_GAIN:
                // resume playback
                /*if (mMediaPlayer == null) initMediaPlayer();
                else if (!mMediaPlayer.isPlaying()) mMediaPlayer.start();
                mMediaPlayer.setVolume(1.0f, 1.0f);*/

                ToastUtils.showLongToast(this,"AUDIOFOCUS_GAIN");
                break;
            case AudioManager.AUDIOFOCUS_LOSS:
                // Lost focus for an unbounded amount of time: stop playback and release media player
                /*if (mMediaPlayer.isPlaying()) mMediaPlayer.stop();
                mMediaPlayer.release();
                mMediaPlayer = null;*/

                if (mPlayer != null && mPlayer.isPlaying()) {
                    mPlayer.pause();
                }

                ToastUtils.showLongToast(this,"AUDIOFOCUS_LOSS");
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                // Lost focus for a short time, but we have to stop
                // playback. We don't release the media player because playback
                // is likely to resume
                /*if (mMediaPlayer.isPlaying()) mMediaPlayer.pause();*/

                if (mPlayer != null && mPlayer.isPlaying()) {
                    mPlayer.pause();
                }
                ToastUtils.showLongToast(this,"AUDIOFOCUS_LOSS_TRANSIENT");
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                // Lost focus for a short time, but it's ok to keep playing
                // at an attenuated level
                /*if (mMediaPlayer.isPlaying()) mMediaPlayer.setVolume(0.1f, 0.1f);*/
                ToastUtils.showLongToast(this,"AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.ll_item:
                int position = (int) v.getTag();
                mPlayer.play(position);
                ToastUtils.showShortToast(mContext,"position = " + position);
                break;
        }
    }

    public void test(AudioDecorator<Song> s){

    }

}