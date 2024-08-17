package com.ap.Framework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.ArrayList;
import java.util.List;

public class ejemplo1 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> callableTasks = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            callableTasks.add(() -> {
                return taskId * taskId;
            });
        }

        List<Future<Integer>> futures = executorService.invokeAll(callableTasks);

        for (Future<Integer> future : futures) {
            System.out.println("Resultado: " + future.get());
        }

        executorService.shutdown();
    }
}
