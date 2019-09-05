package com.jizheping.controller;

import com.jizheping.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务控制类
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LoginInfoService loginInfoService;

    @RequestMapping(value = "/registry",method = RequestMethod.POST)
    public Map<String,Object> registrtUser(String username,String password){
        Map<String,Object> resultMap = new HashMap<>();

        boolean result = loginInfoService.registerUser(username,password);

        resultMap.put("code",200);
        resultMap.put("msg",null);
        resultMap.put("data",result);

        return resultMap;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(String username,String password){
        Map<String,Object> map = loginInfoService.login(username,password);

        return map;
    }
}
