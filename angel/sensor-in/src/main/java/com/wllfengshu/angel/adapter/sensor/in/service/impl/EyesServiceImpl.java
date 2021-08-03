package com.wllfengshu.angel.adapter.sensor.in.service.impl;

import com.wllfengshu.angel.adapter.sensor.in.model.EyesSeeTextVO;
import com.wllfengshu.angel.adapter.sensor.in.service.EyesService;
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
public class EyesServiceImpl implements EyesService {

    @Override
    public void see() {
        log.info("我看到了");
    }

    @Override
    public void seeFrame(String brightness,byte[] content) {
        log.info("看画面");
    }

    @Override
    public void seeText(EyesSeeTextVO eyesSeeTextVO) {
        log.info("看文字");
    }
}
