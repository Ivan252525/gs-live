package com.gs.subproject.user.dao;

import com.gs.subproject.user.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDOMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    List<UserDO> selectUser();

    List<UserDO> selectUserInRange(@Param("userIds") List<Integer> userIds);
}