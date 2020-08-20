package org.jplus.controller;

import org.jplus.constant.Constants;
import org.jplus.exception.BizException;
import org.jplus.exception.ResultBody;
import org.jplus.pojo.UserDO;
import org.jplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
@Controller
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 全局异常测试
    @PostMapping("/test")
    @ResponseBody
    public String test(String name) {
        if (name == null) {
            throw new BizException("-1","用户姓名不能为空！");
        }
        return "test success";
    }

    @PostMapping("/insert")
    @ResponseBody
    public ResultBody insertUser(@RequestBody UserDO user) {
        user.setIs_deleted(Constants.NOT_DELETED);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        user.setGmt_create(d);
        user.setGmt_modified(d);
        userService.insertUser(user);
        return ResultBody.success();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResultBody deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResultBody.success();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResultBody updateUser(@PathVariable("id") Integer id, @RequestBody UserDO user) {
        user.setId(id);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        user.setGmt_modified(d);
        userService.updateUser(user);
        return ResultBody.success();
    }

}
