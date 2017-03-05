package hua.demo.feature.player.utils;

import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

import hua.demo.common.HuaApplication;
import hua.demo.feature.player.model.Song;

/**
 * Created by Administrator on 2017/1/22.
 */

public class FileUtil {

    private static final String UNKNOWN = "unknown";


    /**
     * sdcard根目录
     */
    public static final String SDCARD_ROOT_PATH = Environment.getExternalStorageDirectory().getPath();
    /**
     * 机身根目录
     */
    public static final String DATA_ROOT_PATH = Environment.getDataDirectory() + "/data/" + getPackageName();
    private static final String MUSIC = "Music";


    /**
     * 获取SD卡或机身根目录
     * @return
     */
    public static String getRootDirectory(){
        String universalToeflDirectory = null;
        if (externalMemoryAvailable()) {
            universalToeflDirectory = SDCARD_ROOT_PATH;
        } else {
            universalToeflDirectory = DATA_ROOT_PATH;
        }
        return universalToeflDirectory;
    }

    /**
     * 获取根目录下的应用缓存目录
     * @param appRootDirectory  应用缓存目录
     * @return
     */
    public static String getAppRootDirectory(String appRootDirectory){
        return getRootDirectory() + File.separator + appRootDirectory;
    }


    /**
     * SDCARD是否存在
     */
    public static boolean externalMemoryAvailable() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }


    /**
     * 获取包名
     * @return
     */
    public static String getPackageName(){
        return HuaApplication.mContext.getPackageName();
    }


    public static File getAppRoot(){
        File file = new File(getAppRootDirectory(MUSIC));
        if (!file.exists()) {
            com.blankj.utilcode.utils.FileUtils.createOrExistsDir(file);
        }
        return file;
    }

    /**
     * 获取音频文件信息
     * @param file  音频文件路径
     * @return
     */
    public static Song fileToMusic(File file) {
        if (file.length() == 0) return null;

        MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
        metadataRetriever.setDataSource(file.getAbsolutePath());

        final int duration;

        String keyDuration = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        // ensure the duration is a digit, otherwise return null song
        if (keyDuration == null || !keyDuration.matches("\\d+")) return null;
        duration = Integer.parseInt(keyDuration);

        // 标题
        final String title = extractMetadata(metadataRetriever, MediaMetadataRetriever.METADATA_KEY_TITLE, file.getName());
        final String displayName = extractMetadata(metadataRetriever, MediaMetadataRetriever.METADATA_KEY_TITLE, file.getName());
        // 参与创作的艺术家
        final String artist = extractMetadata(metadataRetriever, MediaMetadataRetriever.METADATA_KEY_ARTIST, UNKNOWN);
        // 唱片集
        final String album = extractMetadata(metadataRetriever, MediaMetadataRetriever.METADATA_KEY_ALBUM, UNKNOWN);

        // 文件类型
        String mime = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);
        // 比特率
        String bitrate = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_BITRATE); // bit/s api >= 14
        String date = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DATE);

        final Song song = new Song();
        song.setTitle(title);
        song.setDisplayName(displayName);
        song.setArtist(artist);
        song.setPath(file.getAbsolutePath());
        song.setAlbum(album);
        song.setDuration(duration);
        song.setSize((int) file.length());
        return song;
    }

    /**
     * 获取音频文件信息
     * @param retriever
     * @param key
     * @param defaultValue
     * @return
     */
    private static String extractMetadata(MediaMetadataRetriever retriever, int key, String defaultValue) {
        String value = retriever.extractMetadata(key);
        if (TextUtils.isEmpty(value)) {
            value = defaultValue;
        }
        return value;
    }


}
