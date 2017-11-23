package com.xioruu.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author xiong
 */
public class RedisConnectTest {


    Jedis jedis;

    @Before
    public void setUp() {
        jedis = new Jedis("192.168.0.100", 6379);
    }


    @Test
    public void testConnection() {
        assert "PONG".equals(jedis.ping());
    }
}
