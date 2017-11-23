package com.xioruu.intercept;

import com.xioruu.utils.RedisUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiong
 */
public class RedisMethodInterceptor implements MethodInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    private Logger logger = Logger.getLogger(RedisMethodInterceptor.class);
    private static final Long DEFAULT_CACHE_EXPIRETIME = 3600L;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object value = null;

        String targetName = invocation.getThis().getClass().getName();
        String methodName = invocation.getMethod().getName();
        Object[] arguments = invocation.getArguments();
        String argumentsString = "";
        if ((arguments != null) && (arguments.length != 0)) {
            for (Object object : arguments) {
                argumentsString += object;
            }
        }

        logger.debug("targetName is " + targetName);
        logger.debug("methodName is " + methodName);
        logger.debug("args is " + argumentsString);
        String key = getCacheKey(targetName, methodName, arguments);
        logger.debug("redisKey: " + key);


        try {
            // 判断是否有缓存
            if (redisUtil.exists(key)) {
                return redisUtil.get(key);
            }
            // 写入缓存
            value = invocation.proceed();
            if (value != null) {
                final String tkey = key;
                final Object tvalue = value;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        redisUtil.set(tkey, tvalue, DEFAULT_CACHE_EXPIRETIME);
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (value == null) {
                return invocation.proceed();
            }
        }
        return value;
    }



    /**
     * 创建缓存key
     *
     * @param targetName
     * @param methodName
     * @param arguments
     */
    private String getCacheKey(String targetName, String methodName, Object[] arguments) {
        StringBuffer sbu = new StringBuffer();
        sbu.append(targetName).append("_").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sbu.append("_").append(arguments[i]);
            }
        }
        return sbu.toString();
    }


}
