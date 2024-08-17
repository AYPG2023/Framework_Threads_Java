package com.ap.Threads;

//Clase que simula una tarea de producción-consumo
class SharedResource {
 private boolean available = false;

 public synchronized void produce() {
     while (available) {
         try {
             wait();
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
     }
     System.out.println("Producto producido por " + Thread.currentThread().getName());
     available = true;
     notify();
 }

 public synchronized void consume() {
     while (!available) {
         try {
             wait();
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
     }
     System.out.println("Producto consumido por " + Thread.currentThread().getName());
     available = false;
     notify();
 }
}

//Clase que implementa Runnable para la tarea de producción
class ProducerRunnable implements Runnable {
 private SharedResource resource;

 public ProducerRunnable(SharedResource resource) {
     this.resource = resource;
 }

 @Override
 public void run() {
     for (int i = 0; i < 5; i++) {
         resource.produce();
     }
 }
}

//Clase que implementa Runnable para la tarea de consumo
class ConsumerRunnable implements Runnable {
 private SharedResource resource;

 public ConsumerRunnable(SharedResource resource) {
     this.resource = resource;
 }

 @Override
 public void run() {
     for (int i = 0; i < 5; i++) {
         resource.consume();
     }
 }
}

//Clase principal para ejecutar los hilos
public class ejemplo3 {
 public static void main(String[] args) {
     // Crear una instancia compartida de SharedResource
     SharedResource resource = new SharedResource();

     // Crear instancias de ProducerRunnable y ConsumerRunnable
     ProducerRunnable producer = new ProducerRunnable(resource);
     ConsumerRunnable consumer = new ConsumerRunnable(resource);

     // Crear e iniciar hilos
     Thread producerThread = new Thread(producer);
     Thread consumerThread = new Thread(consumer);

     producerThread.start();
     consumerThread.start();

     // Esperar a que ambos hilos terminen
     try {
         producerThread.join();
         consumerThread.join();
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }
}
