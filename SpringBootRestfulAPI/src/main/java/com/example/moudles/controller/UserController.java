package com.example.moudles.controller;

import com.example.moudles.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by admin on 2016/12/6.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {


    //创建线程安全的Map
    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }

    public void test(HttpServletRequest request){

        HttpSession session = request.getSession(true);
        if(session.getAttribute("userId") == null){
            //第一次登陆
            session.setAttribute("userId","login");

        }else{
            //第二次登录
        }


    }



}
