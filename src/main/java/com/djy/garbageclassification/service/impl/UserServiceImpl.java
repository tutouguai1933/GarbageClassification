package com.djy.garbageclassification.service.impl;

import com.djy.garbageclassification.pojo.User;
import com.djy.garbageclassification.mapper.UserMapper;
import com.djy.garbageclassification.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-05-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
