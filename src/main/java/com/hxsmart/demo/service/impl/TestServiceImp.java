package com.hxsmart.demo.service.impl;

import com.hxsmart.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 测试服务
 */
@Service("testService")
public class TestServiceImp implements TestService {
    //@Autowired(required = false)
    @Autowired

    public Integer getById() {
        return 123456;
    }
}