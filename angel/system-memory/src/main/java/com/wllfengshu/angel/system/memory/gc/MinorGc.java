package com.wllfengshu.angel.system.memory.gc;

import com.wllfengshu.angel.system.memory.configs.Properties;
import com.wllfengshu.angel.system.memory.model.MemoryDTO;
import com.wllfengshu.angel.system.memory.ram.OldGeneration;
import com.wllfengshu.angel.system.memory.ram.YoungGeneration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;

/**
 * 清理年轻代
 *
 * @author wangll
 * @date 2020-09-16 21:54
 */
@Slf4j
@Configuration
public class MinorGc extends YoungGeneration {

    @Autowired
    private Properties properties;
    @Autowired
    private OldGeneration oldGeneration;

    public void run() {
        log.info("minorGc开始");
        this.clearYoungGeneration();
        log.info("minorGc结束");
    }

    /**
     * 清除年轻代
     * 注意：短期内存入大量新数据，可能会导致oom
     */
    private void clearYoungGeneration() {
        log.info("clearYoungGeneration开始");
        int deleteCount = 0;
        int moveCount = 0;
        Iterator<MemoryDTO> iterator = youngMemory.iterator();
        while (iterator.hasNext()) {
            MemoryDTO dto = iterator.next();
            // 很久不更新、并且权重小的数据，会被删除掉
            if (dto.getUpdateTime().getTime() > (System.currentTimeMillis() + properties.getYoungMaxUpdateTime())
                    && dto.getWeight() < properties.getYoungMinWeight()) {
                iterator.remove();
                ++deleteCount;
            }
            // 权重大的数据会被移动到老年代
            if (dto.getWeight() >= properties.getYoungMinWeight()) {
                oldGeneration.add(dto);
                iterator.remove();
                ++moveCount;
            }
        }
        if (0 == deleteCount && 0 == moveCount) {
            log.warn("警告：该次minorGc没有回收任何垃圾");
        } else {
            log.info("本次minorGc删除数据条数：{}，移动到老年代数据条数：{}", deleteCount, moveCount);
        }
        log.info("clearYoungGeneration结束");
    }
}
