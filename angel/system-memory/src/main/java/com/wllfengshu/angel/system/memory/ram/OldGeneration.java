package com.wllfengshu.angel.system.memory.ram;

import com.wllfengshu.angel.system.memory.configs.Properties;
import com.wllfengshu.angel.system.memory.gc.MajorGc;
import com.wllfengshu.angel.system.memory.model.MemoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;
import java.util.Vector;

/**
 * 老年代数据区
 *
 * @author wangll
 * @date 2020-09-16 21:53
 */
@Slf4j
@Configuration
public class OldGeneration {

    @Autowired
    private Properties properties;
    @Autowired
    private MajorGc majorGc;
    protected static final Vector<MemoryDTO> oldMemory = new Vector<>();

    public synchronized boolean add(MemoryDTO memoryDTO) {
        log.info("OldGenerationAdd，老年代添加前大小{}", oldMemory.size());
        for (MemoryDTO dto : oldMemory) {
            if (memoryDTO.getContent().equals(dto.getContent())) {
                dto.setUpdateTime(memoryDTO.getUpdateTime());
                dto.setWeight(dto.getWeight() + memoryDTO.getWeight());
                return true;
            }
        }
        if (oldMemory.size() >= properties.getOldMaxSize()) {
            majorGc.run();
        }
        return oldMemory.add(memoryDTO);
    }

    public synchronized boolean remove(String content) {
        log.info("OldGenerationRemove，老年代删除前大小{}", oldMemory.size());
        Iterator<MemoryDTO> iterator = oldMemory.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getContent().equals(content)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public synchronized MemoryDTO get(int index) {
        return oldMemory.get(index);
    }
}
