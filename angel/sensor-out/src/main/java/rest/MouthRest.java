package rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.MouthSayTextVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MouthService;

/**
 * @author wangll
 * @date 2020-09-14 23:26
 */
@Api("眼睛")
@Slf4j
@RestController
@RequestMapping("/eyes")
@RequiredArgsConstructor
public class MouthRest {

    @NonNull
    private MouthService mouthService;

    @ApiOperation(value = "说")
    @GetMapping("/say")
    public void say(MouthSayTextVO mouthSayTextVO) {
        mouthService.say(mouthSayTextVO);
    }
}
