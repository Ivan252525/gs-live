package com.gs.subproject.user.web;

import com.gs.web.BaseResult;
import com.gs.web.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/get")
    public BaseResult<String> get() {
        return ResultUtils.success("aaa");
    }

    @RequestMapping("/info")
    public BaseResult<String> info() {
        return ResultUtils.success("info");
    }

}
