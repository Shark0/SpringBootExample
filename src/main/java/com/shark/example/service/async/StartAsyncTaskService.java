package com.shark.example.service.async;

import com.shark.example.asyncTask.TestQueueAsyncTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StartAsyncTaskService {

    private final TestQueueAsyncTask testQueueAsyncTask;

    public void start() {
        for(int i = 0; i < 40960; i ++) {
            try {
                testQueueAsyncTask.start(i);
            } catch (Exception e) {
                System.out.println("i: " + i);
                e.printStackTrace();
                return;
            }
        }
    }
}
