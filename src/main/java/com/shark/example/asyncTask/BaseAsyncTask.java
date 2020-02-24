package com.shark.example.asyncTask;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;

public abstract class BaseAsyncTask<Input, Data> {

    @Async(value = "taskExecutor")
    public CompletableFuture<Data> start(Input input) {
        return completedFuture(work(input));
    };

    protected abstract Data work(Input input);
}
