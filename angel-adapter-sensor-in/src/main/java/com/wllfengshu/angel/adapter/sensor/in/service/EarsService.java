package com.wllfengshu.angel.adapter.sensor.in.service;

/**
 * @author wangll
 * @date 2020-09-14 23:26
 */
public interface EarsService {

    /**
     * 听
     */
    void hear();

    /**
     * 听声音
     * @param timbre 音色
     * @param volume 音量
     * @param content 内容
     */
    void hearVoice(String timbre,String volume,byte[] content);
}
