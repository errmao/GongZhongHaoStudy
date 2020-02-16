package com.xiaoshu.jyl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxddds
 */
@RestController
public class TestController {

    @GetMapping("test1")
    public String test1(){
        return "测试1";
    }
}
