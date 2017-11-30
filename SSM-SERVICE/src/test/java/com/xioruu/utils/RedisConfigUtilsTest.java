package com.xioruu.utils;

import org.junit.Test;

/**
 * @author xiong
 */
public class RedisConfigUtilsTest {
    @Test
    public void test(){
        System.out.println(RedisConfigUtils.getProperties("redis.host"));
    }
}
