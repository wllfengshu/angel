package com.wllfengshu.angel.system.memory.service;

import com.wllfengshu.angel.system.memory.model.MemoryDTO;
import com.wllfengshu.angel.system.memory.model.MemoryVO;

/**
 * @author wangll
 * @date 2020-09-16 21:43
 */
public interface MemoryService {

    /**
     * 存储记忆
     * @param memoryVO
     */
    MemoryDTO save(MemoryVO memoryVO);
}
