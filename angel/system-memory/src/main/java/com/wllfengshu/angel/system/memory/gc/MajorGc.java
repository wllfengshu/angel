package com.wllfengshu.angel.system.memory.gc;

import com.wllfengshu.angel.system.memory.configs.Properties;
import com.wllfengshu.angel.system.memory.dao.OldGenerationDao;
import com.wllfengshu.angel.system.memory.ram.OldGeneration;
import com.wllfengshu.angel.system.memory.model.MemoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;

/**
 * 清理老年代
 *
 * @author wangll
 * @date 2020-09-16 21:54
 */
@Slf4j
@Configuration
public class MajorGc extends OldGeneration{

    @Autowired
    private Properties properties;
    @Autowired
    private OldGenerationDao oldGenerationDao;

    public void run() {
        log.info("majorGc开始");
        this.clearOldGeneration();
        log.info("majorGc结束");
    }

    /**
     * 清除老年代：清除时间久且权重低的数据
     */
    private void clearOldGeneration() {
        log.info("clearOldGeneration开始");
        int deleteCount = 0;
        int moveCount = 0;
        Iterator<MemoryDTO> iterator = oldMemory.iterator();
        while (iterator.hasNext()) {
            MemoryDTO dto = iterator.next();
            // 很久不更新、并且权重小的数据，会被删除掉
            if (dto.getUpdateTime().getTime() > (System.currentTimeMillis() + properties.getOldMaxUpdateTime())
                && dto.getWeight() < properties.getOldMinWeight()) {
                iterator.remove();
                ++deleteCount;
            }
            // 权重大的数据会被写入数据库永久保留
            if (dto.getWeight() >= properties.getOldMinWeight()) {
                oldGenerationDao.insertSelective(dto);
                iterator.remove();
                ++moveCount;
            }
        }
        if (0 == deleteCount && 0 == moveCount) {
            log.warn("警告：该次majorGc没有回收任何垃圾");
        } else {
            log.info("本次majorGc删除数据条数：{}，移动到永久代数据条数：{}", deleteCount,moveCount);
        }
        log.info("clearOldGeneration结束");
    }
}
