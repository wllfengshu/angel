package com.wllfengshu.angel.system.memory.configs;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangll
 * @date 2020-09-16 21:53
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "system-memory")
public class Properties implements InitializingBean {

    /**
     * 最小权重
     * 解释：小于该权重的数据会在Gc中被清除
     */
    private int youngMinWeight = 2;

    /**
     * 最久更新时间（单位ms）
     * 一天的毫秒数：3600 * 24 * 1000
     * 解释：如果memoryVo的updateTime>(now+maxUpdateTime)，则数据会被清除
     */
    private long youngMaxUpdateTime = 86400000;

    /**
     * 最大大小
     * 解释：大于该值将触发Gc
     */
    private int youngMaxSize = 100;

    ///////////////////////////////////////////////////////////////////////////

    /**
     * 最小权重
     * 解释：小于该权重的数据会在Gc中被清除
     */
    private int oldMinWeight = 4;

    /**
     * 最久更新时间（单位ms）
     * 7天的毫秒数：3600 * 24 * 1000 * 7
     * 解释：如果memoryVo的updateTime>(now+maxUpdateTime)，则数据会被清除
     */
    private long oldMaxUpdateTime = 604800000;

    /**
     * 最大大小
     * 解释：大于该值将触发Gc
     */
    private int oldMaxSize = 1000;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("环境变量：" + this.toString());
    }
}
