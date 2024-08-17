package com.ap.Framework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ejemplo3 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> callableTask = () -> {
            return 5 + 10;
        };

        Future<Integer> future = executorService.submit(callableTask);

        System.out.println("Resultado de Callable: " + future.get());

        executorService.shutdown();
    }
}
