/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ClubManager {
    static List<Member> list = new ArrayList<>();
    static File file = new File("member_of_club.txt");
    
    public static boolean filterMemberId(String memberId) {
        String a = memberId.substring(0, 1);
        String b = memberId.substring(1, 3);
        try {
            int c = Integer.valueOf(memberId.substring(3));
        } catch (Exception e) {
            return false;
        }
        if (!(a.equals("T") || a.equals("V") || a.equals("A"))) {
            return false;
        }
        if (!(b.equals("MB") || b.equals("MT") || b.equals("MN"))) {
            return false;
        }
        if (memberId.substring(3).length() != 5) {
            return false;
        }
        return true;
    }
    
    public static void nhapDuLieu() throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
            System.out.print("Moi ban nhap Id: ");
            String id = br.readLine();
            if (!id.matches("^[TVA]M[BTN]\\d{5}")) {
                System.out.println("Id khong hop le!");
                System.out.println("Moi ban nhap lai!");
                nhapDuLieu();
                return;
            }
            System.out.print("Moi ban nhap Name: ");
            String name = br.readLine();
            System.out.print("Moi ban nhap Address: ");
            String address = br.readLine();
            Member member = new Member(id, name, address);
            list.add(member);
        
    }
    
    public static void luu() throws Exception {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            for (Member member : list) {
                oos.writeObject(member);
            }
            oos.flush();
            oos.close();
        } catch (Exception e) {
        }
    }   
    
    public static void doc() throws Exception {
        List<Member> listt = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            while (is.available() > 0) {
                Member m = (Member) ois.readObject();
                listt.add(m);
            }
        } catch (Exception e) {
        }
        System.out.println("Doc");
        for (Member member : listt) {
            System.out.println(member);
        }
    }
    
    public static void main(String[] args) throws Exception {
        nhapDuLieu();
        luu();
        doc();
    }
}
