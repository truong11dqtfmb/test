/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.wait_notify;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DQT
 */
public class Notifier  extends Thread{
    private final Integer holder;

    public Notifier(Integer msg) {
        this.holder = msg;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        Random rand = new Random();
        synchronized (holder) {
            for (int i = 0; i < holder; i+=2) {
                System.out.println("[" + threadName + "]" + i);
                holder.notify();
                try {
                    holder.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if(holder%2 == 1) System.out.println("end");
            Thread.interrupted();
        }
    }
}
