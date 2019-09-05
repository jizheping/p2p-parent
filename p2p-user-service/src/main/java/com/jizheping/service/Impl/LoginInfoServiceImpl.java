package com.jizheping.service.Impl;

import com.jizheping.api.entity.LoginInfo;
import com.jizheping.api.entity.UserInfo;
import com.jizheping.api.util.Md5Util;
import com.jizheping.feign.AccountFeign;
import com.jizheping.mapper.LoginInfoMapper;
import com.jizheping.mapper.UserInfoMapper;
import com.jizheping.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {
    @Autowired
    private LoginInfoMapper loginInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private AccountFeign accountFeign;

    @Transactional
    @Override
    public boolean registerUser(String username, String password) {
        LoginInfo login = loginInfoMapper.getUserInfoByUserName(username);

        //校验用户名唯一
        if(login == null){
            //向logininfo(账号表)中插入数据,返回账号的主键id
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setUsername(username);
            loginInfo.setPassword(Md5Util.md5(password));

            System.out.println(Md5Util.md5(password));

            loginInfoMapper.insertLoginInfo(loginInfo);

            Long id = loginInfo.getId();

            //使用账号表中添加返回的id向userinfo(用户信息表)插入记录
            UserInfo userInfo = UserInfo.empty(id);

            int row = userInfoMapper.insertUserInfo(userInfo);

            //使用Feign调用向account(账户表)中插入一条新记录
            accountFeign.createAccount(id);

            return row > 0;
        }

        return false;
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String,Object> map = new HashMap<>();

        LoginInfo loginInfo = loginInfoMapper.login(username);

        System.out.println(password);

        password = Md5Util.md5(password);

        System.out.println(password);

        if(loginInfo == null){
            map.put("code",404);
            map.put("msg","用户不存在");
        }else {
            if(!password.equals(loginInfo.getPassword())){
                map.put("code",500);
                map.put("msg","密码错误");
            }else {
                map.put("code",200);
                map.put("msg","登录成功");
            }
        }

        return map;
    }
}
