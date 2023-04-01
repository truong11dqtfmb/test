/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.wait_notify;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DQT
 */
public class Waiterer extends Thread{
    private final Integer holder;

    public Waiterer(int msg) {
        this.holder = msg;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (holder) {
            for (int i = 1; i < holder ; i+=2) {
                try {
                    holder.wait();
                    System.out.println("[" + threadName + "]" + i);
                    holder.notify();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if(holder%2 == 0){
                System.out.println("end");
            }
            Thread.interrupted();
        }
    }
}

//package question1;
//
//import java.util.Queue;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Waiter extends Thread {
//
//    private final Integer holder;
//
//    public Waiter(int msg) {
//        this.holder = msg;
//    }
//
//    @Override
//    public void run() {
//        String threadName = Thread.currentThread().getName();
//        synchronized (holder) {
//            for (int i = 1; i < holder ; i+=2) {
//                try {
//                    holder.wait();
//                    System.out.println("[" + threadName + "]" + i);
//                    holder.notify();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//            if(holder%2 == 0){
//                System.out.println("end");
//            }
//            Thread.interrupted();
//        }
//    }
//
//}
//package question1;
//
//import java.util.Queue;
//import java.util.Random;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Notifier extends Thread {
//
//    private final Integer holder;
//
//    public Notifier(Integer msg) {
//        this.holder = msg;
//    }
//
//    @Override
//    public void run() {
//        String threadName = Thread.currentThread().getName();
//        Random rand = new Random();
//        synchronized (holder) {
//            for (int i = 0; i < holder; i+=2) {
//                System.out.println("[" + threadName + "]" + i);
//                holder.notify();
//                try {
//                    holder.wait();
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
//            if(holder%2 == 1) System.out.println("end");
//            Thread.interrupted();
//        }
//    }
//}
//package question1;
//
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Test {
//    public static void main(String[] args) {
//        System.out.printf("n = ");
//        Scanner in = new Scanner(System.in);
//        Integer holder = null;
//        do {
//            try {
//                holder = Integer.parseInt(in.nextLine());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        } while (holder <= 0);
//
//        Waiter waiter = new Waiter(holder+1);
//        Notifier notifier = new Notifier(holder+1);
//
//        notifier.setName("THREAD1");
//        waiter.setName("THREAD2");
//
//        waiter.start();
//        notifier.start();
//
//    }
//}
