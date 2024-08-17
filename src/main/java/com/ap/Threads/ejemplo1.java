package com.ap.Threads;

class MyThread extends Thread {

    // Sobrescribir el método run() que define lo que hará el hilo
    @Override
    public void run() {
        // Imprimir un mensaje indicando que el hilo se está ejecutando
        System.out.println("Hilo " + Thread.currentThread().getName() + " está ejecutándose.");
    }
}

// Clase principal para ejecutar los hilos
public class ejemplo1 {
    public static void main(String[] args) {
        // Crear instancias de MyThread
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        // Iniciar los hilos
        thread1.start();
        thread2.start();
    }
}
