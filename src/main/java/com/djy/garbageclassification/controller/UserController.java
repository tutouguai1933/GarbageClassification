package com.djy.garbageclassification.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.djy.garbageclassification.common.Result;
import com.djy.garbageclassification.pojo.User;
import com.djy.garbageclassification.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.management.Query;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author djy
 * @since 2024-05-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IService<User> userService;

    @GetMapping("/getAllUsers")
    public Result<List<User>> getAllUsers() {
        return Result.success(userService.list());
    }

    @GetMapping("/getUserById/{id}")
    public Result<User> getUserById(@PathVariable Integer id) {
        User user = userService.getById(id);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("404", "用户未找到");
        }
    }

    @PostMapping("/addUser")
    public Result<?> addUser(@RequestBody User user) {
        boolean success = userService.save(user);
        if (success) {
            return Result.success();
        } else {
            return Result.error("500", "无法添加用户");
        }
    }

    @PostMapping("/login")
    public Result<Integer> login(@RequestBody User user) {
        String username = user.getUsername();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User existingUser = userService.getOne(queryWrapper);

        if (existingUser != null) {
            // 用户已经存在，返回用户的ID
            return Result.success(existingUser.getUserId());
        } else {
            // 用户不存在，创建新用户
            boolean success = userService.save(user);
            if (success) {
                return Result.success(user.getUserId());
            } else {
                return Result.error("500", "无法创建用户");
            }
        }
    }
}
