package com.hua.feature.player.player;

import android.support.annotation.Nullable;

import com.hua.feature.player.model.AudioDecorator;
import com.hua.feature.player.model.BaseAudio;
import com.hua.feature.player.model.PlayList;



/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/5/16
 * Time: 6:02 PM
 * Desc: IPlayer
 */
public interface IPlayback {

    void setPlayList(PlayList list);

    boolean play();

    boolean play(PlayList list);

    /**
     * 播放指定下标音频
     * @param startIndex    音频下标
     * @return
     */
    boolean play(int startIndex);

    boolean play(PlayList list, int startIndex);

    boolean play(AudioDecorator<? extends BaseAudio> audio);

    boolean playLast();

    boolean playNext();

    boolean pause();

    boolean isPlaying();

    int getProgress();

    AudioDecorator<? extends BaseAudio> getPlayingSong();

    boolean seekTo(int progress);

    void setPlayMode(PlayMode playMode);

    void registerCallback(Callback callback);

    void unregisterCallback(Callback callback);

    void removeCallbacks();

    void releasePlayer();

    /**
     * 播放状态更新回调
     */
    interface Callback {

        /**
         * 切换上一首回调
         * @param last
         */
        void onSwitchLast(@Nullable AudioDecorator<? extends BaseAudio> last);

        /**
         * 切换下一首回调
         * @param next
         */
        void onSwitchNext(@Nullable AudioDecorator<? extends BaseAudio> next);

        /**
         * 切换指定歌曲
         * @param next
         */
        void onSwitchSong(@Nullable AudioDecorator<? extends BaseAudio> next);

        /**
         * 播放完成回调
         * @param next
         */
        void onComplete(@Nullable AudioDecorator<? extends BaseAudio> next);

        /**
         * 播放和暂停回调
         * @param isPlaying
         */
        void onPlayStatusChanged(boolean isPlaying);
    }
}
