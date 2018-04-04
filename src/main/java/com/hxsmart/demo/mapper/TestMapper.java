package com.hxsmart.demo.mapper;

import com.hxsmart.demo.model.Test;

public interface TestMapper {
    Test selectByPrimaryKey(Integer id);
}