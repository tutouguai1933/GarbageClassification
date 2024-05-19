package com.djy.garbageclassification;

import com.djy.garbageclassification.pojo.User;
import com.djy.garbageclassification.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GarbageClassificationApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private IUserService userService;

    @Test
    public void testGetAllUsers() {
        List<User> users = userService.list();
        assertNotNull(users);
    }

    @Test
    public void testGetUserById() {
        User user = userService.getById(1);
        assertNotNull(user);
    }
}


