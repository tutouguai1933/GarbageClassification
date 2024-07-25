package com.djy.garbageclassification.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.djy.garbageclassification.common.Result;
import com.djy.garbageclassification.pojo.Attempt;
import com.djy.garbageclassification.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author djy
 * @since 2024-05-19
 */
@RestController
@RequestMapping("/attempt")
public class AttemptController {

    @Autowired
    private IService<Attempt> attemptService;

    @Autowired
    private IService<Test> testIService;

    @GetMapping("/getAllAttempts")
    public Result<List<Attempt>> getAllAttempts() {
        return Result.success(attemptService.list());
    }

    @GetMapping("/getAttemptById/{id}")
    public Result<Attempt> getAttemptById(@PathVariable Integer id) {
        Attempt attempt = attemptService.getById(id);
        if (attempt != null) {
            return Result.success(attempt);
        } else {
            return Result.error("404", "尝试未找到");
        }
    }

    @PostMapping("/addAttempt")
    public Result<?> addAttempt(@RequestBody Attempt attempt) {
        boolean success = attemptService.save(attempt);
        if (success) {
            List<Attempt> list = attemptService.lambdaQuery().eq(Attempt::getTestId, attempt.getTestId()).list();
            int correctNum = 0;
            for (Attempt item : list){
                correctNum += item.getIsCorrect()?1:0;
            }
            Test test = testIService.getById(attempt.getTestId());
            test.setCorrectRate(1.0*correctNum/list.size());
            testIService.updateById(test);
            return Result.success(attempt.getAttemptId());
        } else {
            return Result.error("500", "无法添加尝试");
        }
    }

    @GetMapping("/getAttemptsByTestId/{testId}")
    public Result<List<Attempt>> getAttemptsByTestId(@PathVariable Integer testId) {
        return Result.success(attemptService.lambdaQuery().eq(Attempt::getTestId, testId).list());
    }
}
