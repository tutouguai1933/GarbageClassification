package com.djy.garbageclassification.service.impl;

import com.djy.garbageclassification.pojo.Users;
import com.djy.garbageclassification.mapper.UsersMapper;
import com.djy.garbageclassification.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
