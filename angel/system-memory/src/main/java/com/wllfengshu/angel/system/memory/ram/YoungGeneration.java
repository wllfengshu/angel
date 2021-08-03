package com.wllfengshu.angel.system.memory.ram;

import com.wllfengshu.angel.system.memory.configs.Properties;
import com.wllfengshu.angel.system.memory.gc.MinorGc;
import com.wllfengshu.angel.system.memory.model.MemoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

/**
 * 年轻代数据区
 *
 * @author wangll
 * @date 2020-09-16 21:53
 */
@Slf4j
@Configuration
public class YoungGeneration {

    @Autowired
    private Properties properties;
    @Autowired
    private MinorGc minorGc;
    protected static final Vector<MemoryDTO> youngMemory = new Vector<>();

    public synchronized boolean add(MemoryDTO memoryDTO) {
        log.info("YoungGenerationAdd，年轻代添加前大小{}", youngMemory.size());
        for (MemoryDTO dto : youngMemory) {
            if (memoryDTO.getContent().equals(dto.getContent())) {
                dto.setUpdateTime(new Date());
                dto.setWeight(dto.getWeight() + 1);
                return true;
            }
        }
        if (youngMemory.size() >= properties.getYoungMaxSize()) {
            minorGc.run();
        }
        return youngMemory.add(memoryDTO);
    }

    public synchronized boolean remove(String content) {
        log.info("YoungGenerationRemove，年轻代删除前大小{}", youngMemory.size());
        Iterator<MemoryDTO> iterator = youngMemory.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getContent().equals(content)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public synchronized MemoryDTO get(int index) {
        return youngMemory.get(index);
    }
}
