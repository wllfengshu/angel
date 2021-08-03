package com.wllfengshu.angel.system.memory;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangll
 * @date 2020-09-16 21:43
 */
@MapperScan(value = "com.wllfengshu.angel.system.memory.dao")
@SpringBootApplication
public class SystemMemoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemMemoryApplication.class);
    }
}
