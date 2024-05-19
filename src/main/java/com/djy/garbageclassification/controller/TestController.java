package com.djy.garbageclassification.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.djy.garbageclassification.common.Result;
import com.djy.garbageclassification.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private IService<Test> testService;

    @GetMapping("/getAllTests")
    public Result<List<Test>> getAllTests() {
        return Result.success(testService.list());
    }

    @GetMapping("/getTestById/{id}")
    public Result<Test> getTestById(@PathVariable Integer id) {
        Test test = testService.getById(id);
        if (test != null) {
            return Result.success(test);
        } else {
            return Result.error("404", "测试未找到");
        }
    }

    @PostMapping("/addTest")
    public Result<?> addTest(@RequestBody Test test) {
        boolean success = testService.save(test);
        if (success) {
            return Result.success();
        } else {
            return Result.error("500", "无法添加测试");
        }
    }

    @GetMapping("/getTestsByUserId/{userId}")
    public Result<List<Test>> getTestsByUserId(@PathVariable Integer userId) {
        return Result.success(testService.lambdaQuery().eq(Test::getUserId, userId).list());
    }
}
