package redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author xiong
 */
public class RedisConnectTest {
  @Test
   public void testConnection(){
      Jedis jedis = new Jedis("127.0.0.1",6379);
      System.out.println(jedis.ping());

  }
}
