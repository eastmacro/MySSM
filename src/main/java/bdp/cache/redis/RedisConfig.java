package bdp.cache.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;

/**
 * @Author xiong
 */
@Configuration
public class RedisConfig{

    @Value("${sentinel.master}")
    private String master;

    @Value("${sentinel.host}")
    private String host;


    @Value("${sentinel.port}")
    private int port;


    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration(){
        return new RedisSentinelConfiguration()
                        .master(master)
                        .sentinel(host,port);

    }
}
