package com.wllfengshu.angel.system.memory.service.impl;

import com.wllfengshu.angel.system.memory.model.MemoryDTO;
import com.wllfengshu.angel.system.memory.model.MemoryVO;
import com.wllfengshu.angel.system.memory.ram.YoungGeneration;
import com.wllfengshu.angel.system.memory.service.MemoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wangll
 * @date 2020-09-16 21:43
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemoryServiceImpl implements MemoryService {

    @NonNull
    private YoungGeneration youngGeneration;

    @Override
    public MemoryDTO save(MemoryVO memoryVO) {
        // 存储记忆
        MemoryDTO dto = new MemoryDTO();
        dto.setContent(memoryVO.getContent());
        Date now = new Date();
        dto.setCreateTime(now);
        dto.setUpdateTime(now);
        youngGeneration.add(dto);

        // 寻找记忆，并返回
        return youngGeneration.get(0);
    }
}
