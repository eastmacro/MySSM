package utils;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author xiong
 */
public class RedisConfigUtils {

    private static String FILE_PATH = "redis.properties";

    private static Properties ps;

    public synchronized static void init(){
        try {
            InputStream input = RedisConfigUtils.class.getClassLoader().getResourceAsStream(FILE_PATH);

            ps = new Properties();
            ps.load(input);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static String getProperties(String key){
        if (ps == null){
            init();
        }

        try{
            String value = ps.getProperty(key);
            return StringUtils.replace(value,"\\","/");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "";
    }
}
