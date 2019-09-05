package com.jizheping.api.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
}
