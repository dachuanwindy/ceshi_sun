package com.spring.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/16 14:54
 */
public class AsyncThreadPool implements AsyncConfigurer {
    /**
     * The {@link Executor} instance to be used when processing async
     * method invocations.
     */
    @Override
    @Bean(name = "myAsync")
    public Executor getAsyncExecutor() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        return poolExecutor;
    }

    /**
     * The {@link AsyncUncaughtExceptionHandler} instance to be used
     * when an exception is thrown during an asynchronous method execution
     * with {@code void} return type.
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
