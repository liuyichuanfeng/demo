package com.hxsmart.demo.controller;

import com.hxsmart.demo.service.Hxlog;
import com.hxsmart.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    @Qualifier("testService")
    private TestService testService;
    private Hxlog hxlog;
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Integer getTestById() {
        System.out.println("请求开始啦");
        hxlog.LogInfo("我是日志信息");
        return testService.getById();
    }
}