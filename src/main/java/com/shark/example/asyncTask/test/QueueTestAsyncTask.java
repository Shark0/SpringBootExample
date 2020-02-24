package com.shark.example.asyncTask.test;

import com.shark.example.asyncTask.BaseAsyncTask;
import org.springframework.stereotype.Service;

@Service
public class QueueTestAsyncTask extends BaseAsyncTask<Integer, Boolean> {
    @Override
    protected Boolean work(Integer integer) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task index: " + integer);
        return true;
    }
}
