/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.thread_week;

import java.util.Hashtable;

public class Threadtest extends Thread{
    public static Hashtable<String, String> mydictionary = new Hashtable<>();
    public static int soRanDom = 0;
    public static void main(String[] args) {
        mydictionary.put("Thu hai", "Monday");
        mydictionary.put("Thu ba", "Tuesday");
        mydictionary.put("Thu tu", "Wednesday");
        mydictionary.put("Thu nam", "Thursday");
        mydictionary.put("Thu sau", "Friday");
        mydictionary.put("Thu bay", "Saturday");
        mydictionary.put("Chu nhat", "Sunday");
        
        FirstThread thread = new FirstThread();
        String day = thread.runn();
        System.out.println(mydictionary.get(day) );
    }
}
