package com.wllfengshu.angel.system.memory.dao;

import com.wllfengshu.angel.system.memory.model.MemoryDTO;
import com.wllfengshu.angel.system.memory.utils.MapperUtil;
import org.springframework.stereotype.Repository;

/**
 * @author wangll
 * @date 2020-09-16 22:42
 */
@Repository
public interface OldGenerationDao extends MapperUtil<MemoryDTO> {
}
