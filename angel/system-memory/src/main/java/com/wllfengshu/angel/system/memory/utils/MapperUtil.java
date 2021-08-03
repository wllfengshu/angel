package com.wllfengshu.angel.system.memory.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper
 *     注意：该接口不能被扫描到，否则会出错
 *
 * @author wangll
 */
public interface MapperUtil<T> extends Mapper<T>, MySqlMapper<T> {
}
