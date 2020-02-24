package com.shark.example.controller;

import com.shark.example.aop.DoneTime;
import com.shark.example.asyncTask.test.QueueTestAsyncTask;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@RequiredArgsConstructor
@RequestMapping(value = "/test")
@RestController
public class TestController {

    @Qualifier("taskExecutor")
    private final TaskExecutor taskExecutor;

    private final QueueTestAsyncTask queueTestAsyncTask;

    @GetMapping("/test1")
    @DoneTime(param = "index")
    public String test1(){
        return "test1";
    }

    @GetMapping("/test2")
    @DoneTime(param = "index")
    public String test2(){
        return "test2";
    }

    @GetMapping("/testAsyncTaskQueue")
    public String testAsyncTaskQueue(){

        List<CompletableFuture> completableFutureList = new ArrayList<>();
        for(int i = 0; i < 50; i ++) {
            while (true) {
                int queueSize = ((ThreadPoolTaskExecutor) taskExecutor).getThreadPoolExecutor().getQueue().size();
                System.out.println("queueSize: " + queueSize);
                int activeCount =  ((ThreadPoolTaskExecutor) taskExecutor).getThreadPoolExecutor().getActiveCount();
                System.out.println("activeCount: " + activeCount);
//                int corePoolSize =  ((ThreadPoolTaskExecutor) taskExecutor).getThreadPoolExecutor().getCorePoolSize();
//                System.out.println("corePoolSize: " + corePoolSize);
//                int poolSize =  ((ThreadPoolTaskExecutor) taskExecutor).getThreadPoolExecutor().getPoolSize();
//                System.out.println("poolSize: " + poolSize);
                long taskCount =  ((ThreadPoolTaskExecutor) taskExecutor).getThreadPoolExecutor().getTaskCount();
                System.out.println("taskCount: " + taskCount);
                System.out.println("=================================");
                if(queueSize >= 24) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
            completableFutureList.add(queueTestAsyncTask.start(i));
        }
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
        return "testAsyncTaskQueue";
    }
}
