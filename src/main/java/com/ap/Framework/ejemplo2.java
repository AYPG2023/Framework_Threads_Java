package com.ap.Framework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ejemplo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> callableTask = () -> {
            throw new IllegalArgumentException("Error en la tarea Callable");
        };

        Future<Integer> future = executorService.submit(callableTask);

        try {
            Integer result = future.get();
        } catch (Exception e) {
            System.out.println("Excepción capturada: " + e.getCause());
        }

        executorService.shutdown();
    }
}
