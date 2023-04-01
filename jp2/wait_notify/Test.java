/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.wait_notify;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author DQT
 */
public class Test {

    public static void main(String[] args) {
        System.out.printf("n = ");
        Scanner in = new Scanner(System.in);
        Integer holder = null;
        do {
            try {
                holder = Integer.parseInt(in.nextLine());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (holder <= 0);

        Waiterer waiter = new Waiterer(holder + 1);
        Notifier notifier = new Notifier(holder + 1);

        notifier.setName("THREAD1");
        waiter.setName("THREAD2");

        waiter.start();
        notifier.start();

    }
}
