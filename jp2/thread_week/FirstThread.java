/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.thread_week;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class FirstThread extends Threadtest {

    public static List<String> listDaysOfWeek = new ArrayList<>();
    Random rd = new Random();

    public String runn() {
        listDaysOfWeek.add("Thu hai");
        listDaysOfWeek.add("Thu ba");
        listDaysOfWeek.add("Thu tu");
        listDaysOfWeek.add("Thu nam");
        listDaysOfWeek.add("Thu sau");
        listDaysOfWeek.add("Thu bay");
        listDaysOfWeek.add("Chu nhat");
        String day = "";
        try {
            Threadtest.sleep(100);
            int a = rd.nextInt(7);
//            System.out.println(a);
            Threadtest.soRanDom = a;
            day = listDaysOfWeek.get(a);
            System.out.println("Hom nay la: " + day);
        } catch (InterruptedException ex) {
        }
        return day;
    }
}
