package com.gs.subproject.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gs.subproject.user.dao.UserDOMapper;
import com.gs.subproject.user.domain.UserDO;
import com.gs.subproject.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDOMapper userDOMapper;

    @Override
    public PageInfo<UserDO> listUser(int page, int limit) {
        logger.info("page={}, limit={}", page, limit);
        return PageHelper.startPage(page, limit)
                .doSelectPageInfo(() -> userDOMapper.selectUser());
    }

    @Override
    public UserDO getUser(int userId) {
        logger.info("userId={}", userId);
        return userDOMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<UserDO> listUserInRange(List<Integer> userIds) {
        logger.info("userIds={}", userIds);
        return userDOMapper.selectUserInRange(userIds);
    }
}
