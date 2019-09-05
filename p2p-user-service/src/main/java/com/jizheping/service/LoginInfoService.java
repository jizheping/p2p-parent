package com.jizheping.service;

import java.util.Map;

public interface LoginInfoService {
    boolean registerUser(String username, String password);

    Map<String, Object> login(String username, String password);
}
