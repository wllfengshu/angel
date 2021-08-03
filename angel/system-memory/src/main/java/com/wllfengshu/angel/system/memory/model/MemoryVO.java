package com.wllfengshu.angel.system.memory.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 记忆-VO
 *
 * @author wangll
 * @date 2020-09-16 21:57
 */
@Data
public class MemoryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 内容
     */
    private String content;
}
