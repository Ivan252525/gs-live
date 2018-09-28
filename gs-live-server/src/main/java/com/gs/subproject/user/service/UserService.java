package com.gs.subproject.user.service;

import com.github.pagehelper.PageInfo;
import com.gs.subproject.user.domain.UserDO;

import java.util.List;

public interface UserService {

    PageInfo<UserDO> listUser(int page, int limit);

    UserDO getUser(int userId);

    List<UserDO> listUserInRange(List<Integer> userIds);

}
