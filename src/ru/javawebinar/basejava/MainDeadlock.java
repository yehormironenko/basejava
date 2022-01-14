package ru.javawebinar.basejava;

public class MainDeadlock {
    public static Object object1 = new Object();
    public static Object object2 = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object1) {
                System.out.println("Thread1: Holding object1");
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (object2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }


    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object2) {
                System.out.println("Thread2: Holding object2");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread2: Waiting for a lock2....");

                synchronized (object1) {
                    System.out.println("Thread2: Holding lock 1  and 2 ...");
                }
            }
        }
    }
}
