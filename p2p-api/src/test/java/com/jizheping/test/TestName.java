package com.jizheping.test;

import com.jizheping.api.entity.SystemDictionaryItem;

public class TestName {
    public static void main(String[] args) {
        String realName = "张三";
        //3
        int len = realName.length();

        System.out.println(len);

        //name = 张
        String name = realName.substring(0,1);

        System.out.println(name);

        for(int i=1;i<len;i++){
            name += "*";
        }

        System.out.println(name);
    }
}
