package org.suleiman.DataJpaWithVertx.Config;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class VertxConfiguration {

    private Logger LOGGER = LoggerFactory.getLogger(VertxConfiguration.class.getName());
//    @Value("${WORKER_POOL_SIZE:40}")
//    int workerPoolSize;
//    @Value("${BLOCKED_THREAD_CHECK_INTERVAL_IN_SECONDS:5}")
//    int blockedThreadCheckIntervalInSeconds;
//    @Value("${MAX_EVENT_LOOP_EXECUTE_TIME_IN_MS:300}")
//    int maxEventLoopExecuteTime;
//    @Value("${MAX_WORKER_LOOP_EXECUTE_TIME_IN_SECONDS:30}")
//    int maxWorkerExecuteTime;
//    @Value("${WARNING_EXCEPTION_TIME_IN_SECONDS:20}")
//    int warningExceptionTime;
    @Bean
    Vertx vertx() {
//
//        VertxOptions options = new VertxOptions();
//        options.setWorkerPoolSize(workerPoolSize);
//        System.out.println ("Number of worker threads is "+workerPoolSize);
//        // check for blocked threads every 5 seconds
//        options.setBlockedThreadCheckInterval(blockedThreadCheckIntervalInSeconds);
//        options.setBlockedThreadCheckIntervalUnit(TimeUnit.SECONDS);
//
//        // warn if an event loop thread handler took more than 300ms to execute
//        options.setMaxEventLoopExecuteTime(maxEventLoopExecuteTime);
//        options.setMaxEventLoopExecuteTimeUnit(TimeUnit.MILLISECONDS);
//
//        // warn if a worker thread handler took more than 30s to execute
//        options.setMaxWorkerExecuteTime(maxWorkerExecuteTime);
//        options.setMaxWorkerExecuteTimeUnit(TimeUnit.SECONDS);
//
//        // log the stack trace if an event loop or worker handler took more than 20s to execute
//        options.setWarningExceptionTime(warningExceptionTime);
//        options.setWarningExceptionTimeUnit(TimeUnit.SECONDS);

        Vertx vertx = Vertx.vertx();
        return vertx;
    }

}
