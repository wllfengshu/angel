package com.wllfengshu.angel.sensor.in.service;

import com.wllfengshu.angel.sensor.in.model.EyesSeeTextVO;

/**
 * @author wangll
 * @date 2020-09-14 23:26
 */
public interface EyesService {

    /**
     * 看
     */
    void see();

    /**
     * 看画面
     * @param brightness 亮度
     * @param content 内容
     */
    void seeFrame(String brightness,byte[] content);

    /**
     * 看文本
     * @param eyesSeeTextVO
     */
    void seeText(EyesSeeTextVO eyesSeeTextVO);
}
