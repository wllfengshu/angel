package service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.MouthSayTextVO;
import org.springframework.stereotype.Service;
import service.MouthService;

/**
 * @author wangll
 * @date 2020-09-14 23:26
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MouthServiceImpl implements MouthService {

    @Override
    public void say(MouthSayTextVO mouthSayTextVO) {
        log.info("说内容" + mouthSayTextVO.getContent());
    }
}
