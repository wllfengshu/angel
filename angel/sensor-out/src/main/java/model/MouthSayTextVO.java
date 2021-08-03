package model;

import lombok.Data;

import java.io.Serializable;

/**
 * 嘴巴说文本-实体类
 *
 * @author wangll
 * @date 2021-07-31 01:44
 */
@Data
public class MouthSayTextVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 内容
     */
    private String content;
}
