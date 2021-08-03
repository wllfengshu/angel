package com.wllfengshu.angel.adapter.sensor.in.service.impl;

import com.wllfengshu.angel.sensor.in.service.EarsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2020-09-14 23:26
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EarsServiceImpl implements EarsService {

    @Override
    public void hear() {
        log.info("我听到了");
    }

    @Override
    public void hearVoice(String timbre,String volume,byte[] content) {
        log.info("听声音");
    }
}
