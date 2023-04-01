/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

    private static final String fileName = "Persons.obj";

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader("input.txt");
            reader = new BufferedReader(fileReader);
            while (reader.ready()) {
                Student st = new Student();

                String name = reader.readLine();

                int age = Integer.parseInt(reader.readLine());
                String phone = reader.readLine();

                String spaceLine = reader.readLine();

                System.out.println(name + " " + age + " " + phone);

                st.setName(name);
                st.setAge(age);
                st.setPhone(phone);

                list.add(st);
            }
            if (list != null) {
                System.out.println("Read form file input.txt succesfully");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
                fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));

            out.writeObject(list);

            System.out.println("Write to file Persons.obj Successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
