package com.shark.example.asyncTask;

import org.springframework.stereotype.Service;

@Service
public class ExceptionAsyncTask extends BaseAsyncTask<String, Boolean> {
    @Override
    protected Boolean work(String message) {
        throw new RuntimeException(message);
    }
}
