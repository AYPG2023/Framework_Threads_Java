package com.ap.Threads;

//Clase que implementa la interfaz Runnable
class MyRunnable implements Runnable {

 // Sobrescribir el método run() para definir lo que hará el hilo
 @Override
 public void run() {
     // Imprimir un mensaje indicando que el hilo se está ejecutando
     System.out.println("Hilo " + Thread.currentThread().getName() + " está ejecutándose.");
 }
}

//Clase principal para ejecutar los hilos
public class ejemplo2 {
 public static void main(String[] args) {
     // Crear instancias de MyRunnable
     MyRunnable runnable1 = new MyRunnable();
     MyRunnable runnable2 = new MyRunnable();

     // Crear hilos utilizando las instancias de MyRunnable
     Thread thread1 = new Thread(runnable1);
     Thread thread2 = new Thread(runnable2);

     // Iniciar los hilos
     thread1.start();
     thread2.start();
 }
}

