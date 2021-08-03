package com.wllfengshu.angel.sensor.in.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 眼睛看文本-实体类
 *
 * @author wangll
 * @date 2020-09-16 21:32
 */
@Data
public class EyesSeeTextVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 内容
     */
    private String content;
}
