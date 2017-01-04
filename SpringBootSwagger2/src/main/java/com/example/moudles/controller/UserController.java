package com.example.moudles.controller;

import com.example.moudles.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/7.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> getUserLists(){

        ArrayList<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(100010L);
        user1.setName("张三");
        user1.setAge(20);
        users.add(user1);
        User user2 = new User();
        user2.setId(100011L);
        user2.setName("李四");
        user2.setAge(21);
        users.add(user2);
        return users;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="saveUser", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {

        System.out.println(user);

        return "success";
    }

}
