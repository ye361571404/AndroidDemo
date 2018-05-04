package com.hua.feature.player;

public class ReadMe {


    /**
     * 1. IPlayback
     *      定义播放器功能接口
     *          * 播放
     *          * 暂停
     *          * 获取播放进度
     *          * 获取是否正在播放
     *          * 播放上一首
     *          * 播放下一首
     *          * 获取当前正在播放歌曲信息
     *          * 设置播放列表
     *          * 设置播放进度
     *          * 设置播放模式
     *          * 注册播放状态更新回调
     *          * 注销播放状态更新回调
     *          * 移除播放状态所有回调
     *          * 重置播放器状态
     *
     * 2. IPlayback.Callback
     *       定义播放状态回调
     *          * 切换歌曲更新暂时歌曲信息回调
     *          * 暂停和播放状态回调
     *          * 播放完成状态回调
     *
     * 3. Player 实现 IPlayback 接口,实现播放器功能
     *    Player 实现 MediaPlayer.OnCompletionListener 接口,在此接口实现方法onCompletion(MediaPlayer mp)根据播放模式,判断是否继续进行播放
     *
     * 4. PlaybackService 实现 IPlayback 接口,在实现方法中调用Player实现的播放器功能
     *    PlaybackService 实现 IPlayback.Callback 接口,并添加到Player中的mCallbacks集合,
     *    当播放状态改变时,调用实现状态回调接口的实现类相关方法
     *
     * 5.MusicPlayerActivity 实现 IPlayback.Callback 接口,
     *    并添加到Player中的mCallbacks集合,当播放状态改变时,调用实现状态回调接口的实现类相关方法
     *
     * 6. MusicPlayerContract.View
     *          * 定义绑定播放器方法
     *          * 定义解绑播放器方法
     *          * 定义更新暂停和播放状态方法
     *          * 定义更新播放模式方法
     *          * 定义切换歌曲更新暂时歌曲信息方法
     *          * 定义播放出错方法
     *
     * 7. MusicPlayerContract.Presenter
     *          * 定义绑定播放器服务方法
     *          * 定义解绑播放器服务方法
     *          * 定义获取上一次的播放模式方法
     *
     */










}
