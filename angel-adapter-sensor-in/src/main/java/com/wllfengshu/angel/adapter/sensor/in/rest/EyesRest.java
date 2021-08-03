package com.wllfengshu.angel.adapter.sensor.in.rest;

import com.wllfengshu.angel.sensor.in.model.EyesSeeTextVO;
import com.wllfengshu.angel.sensor.in.service.EyesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangll
 * @date 2020-09-14 23:26
 */
@Api("眼睛")
@Slf4j
@RestController
@RequestMapping("/eyes")
@RequiredArgsConstructor
public class EyesRest {

    @NonNull
    private EyesService eyesService;

    @ApiOperation(value = "看")
    @GetMapping("/see")
    public void see(){
        eyesService.see();
    }

    @ApiOperation(value = "看画面")
    @PostMapping("/seeFrame")
    public void seeFrame(@RequestParam(defaultValue = "0") String brightness,
                         @RequestBody byte[] content){
        eyesService.seeFrame(brightness,content);
    }

    @ApiOperation(value = "看文本")
    @PostMapping("/seeText")
    public void seeTest(@RequestBody EyesSeeTextVO eyesSeeTextVO){
        eyesService.seeText(eyesSeeTextVO);
    }
}
