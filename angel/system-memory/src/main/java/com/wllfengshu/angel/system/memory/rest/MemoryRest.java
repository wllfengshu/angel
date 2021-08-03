package com.wllfengshu.angel.system.memory.rest;

import com.wllfengshu.angel.system.memory.model.MemoryDTO;
import com.wllfengshu.angel.system.memory.model.MemoryVO;
import com.wllfengshu.angel.system.memory.service.MemoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangll
 * @date 2020-09-16 21:41
 */
@Api("存储记忆")
@Slf4j
@RestController
@RequestMapping("/memory")
@RequiredArgsConstructor
public class MemoryRest {

    @NonNull
    private MemoryService memoryService;

    @ApiOperation(value = "存储")
    @PostMapping("/save")
    public MemoryDTO save(@RequestBody MemoryVO memoryVO){
        return memoryService.save(memoryVO);
    }
}
