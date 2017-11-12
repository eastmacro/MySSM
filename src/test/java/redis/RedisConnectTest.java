package redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author xiong
 */
public class RedisConnectTest {


    Jedis jedis;
    JedisPool pool;

    @Before
    public void setUp() {
        pool = new JedisPool(new JedisPoolConfig(), "92.168.0.113");
        jedis = pool.getResource();
    }


  @Test
   public void testConnection() {
      assert "PONG".equals(jedis.ping());
  }
}
