package com.gs.subproject.user.web;

import com.github.pagehelper.PageInfo;
import com.gs.subproject.user.ao.GetUserAO;
import com.gs.subproject.user.ao.UserListAO;
import com.gs.subproject.user.ao.UserListInRangeAO;
import com.gs.subproject.user.domain.UserDO;
import com.gs.subproject.user.service.UserService;
import com.gs.web.BaseResult;
import com.gs.web.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "用户模块")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value="用户列表", notes="获取用户列表")
    @PostMapping("/list")
    public BaseResult<PageInfo<UserDO>> userList(@Valid @RequestBody UserListAO param) {
        return ResultUtils.success(userService.listUser(param.getPage(), param.getLimit()));
    }

    @ApiOperation(value = "获取用户信息", notes = "根据userId获取用户信息")
    @PostMapping("/get")
    public BaseResult<UserDO> getUser(@Valid @RequestBody GetUserAO param) {
        return ResultUtils.success(userService.getUser(param.getUserId()));
    }

    @ApiOperation(value = "批量获取用户信息", notes = "根据userId列表批量获取用户信息")
    @PostMapping("/listinrange")
    public BaseResult<List<UserDO>> userListInRange(@Valid @RequestBody UserListInRangeAO param) {
        return ResultUtils.success(userService.listUserInRange(param.getUserIds()));
    }



}
