package com.wllfengshu.angel.sensor.in.rest;

import com.wllfengshu.angel.sensor.in.service.EarsService;
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
@Api("耳朵")
@Slf4j
@RestController
@RequestMapping("/ears")
@RequiredArgsConstructor
public class EarsRest {

    @NonNull
    private EarsService earsService;

    @ApiOperation(value = "听")
    @GetMapping("/hear")
    public void hear(){
        earsService.hear();
    }

    @ApiOperation(value = "听声音")
    @PostMapping("/hearVoice")
    public void hearVoice(@RequestParam(defaultValue = "0") String timbre,
                          @RequestParam(defaultValue = "0") String volume,
                          @RequestBody byte[] content){
        earsService.hearVoice(timbre,volume,content);
    }
}
