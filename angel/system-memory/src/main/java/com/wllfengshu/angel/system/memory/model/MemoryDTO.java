package com.wllfengshu.angel.system.memory.model;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 记忆-DTO
 *
 * @author wangll
 * @date 2020-09-16 21:57
 */
@Data
@Table(name = "tb_memory")
public class MemoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 更新时间
     */
    private Date updateTime = new Date();

    /**
     * 权重：添加的次数
     */
    private Integer weight = 0;

    /**
     * 内容
     */
    private String content;
}
