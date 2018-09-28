package com.gs.subproject.user.mapper;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.gs.subproject.user.dao.UserDOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDOMapperTest {

    @Autowired
    UserDOMapper userDOMapper;

    @Test
    public void selectByPrimaryKey() {
        System.out.println(JSON.toJSONString(userDOMapper.selectByPrimaryKey(1)));
    }

    @Test
    public void selectUser() {
        PageHelper.startPage(1, 2);
        System.out.println(JSON.toJSONString(
                userDOMapper.selectUser()
        ));
    }
}