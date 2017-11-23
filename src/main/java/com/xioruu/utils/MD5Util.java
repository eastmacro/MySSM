package com.xioruu.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author xiong
 */
public class MD5Util {
    public static String md5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }

    public static void main(String[] args) {
        System.out.println(md5("123456","xrj"));
    }
}
