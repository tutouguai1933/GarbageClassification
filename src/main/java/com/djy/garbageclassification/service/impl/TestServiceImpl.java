package com.djy.garbageclassification.service.impl;

import com.djy.garbageclassification.pojo.Test;
import com.djy.garbageclassification.mapper.TestMapper;
import com.djy.garbageclassification.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-05-19
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
