package com.wllfengshu.angel.system.memory.rest;


import com.wllfengshu.angel.system.memory.model.MemoryVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemoryRestTest {

    @Autowired
    private MemoryRest memoryRest;

    @Test
    public void testMemory() {
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                MemoryVO vo = new MemoryVO();
                vo.setContent("aaaa"+i);
                memoryRest.save(vo);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                MemoryVO vo = new MemoryVO();
                vo.setContent("aaaa"+i);
                memoryRest.save(vo);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                MemoryVO vo = new MemoryVO();
                vo.setContent("aaaa"+i);
                memoryRest.save(vo);
            }
        }).start();
    }
}