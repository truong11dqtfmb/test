//package jp2.book;
//
//
//import java.io.ByteArrayInputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.stream.Collectors;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
///**
// *
// * @author DQT
// */
//public class BookTest {
//
//    private final static String fileName = "author.txt";
//
//    public static void main(String[] args) {
////    writeBook();
//        readBook();
//        
////        ByteArrayInputStream
//
//    }
//
//    private static void writeBook() {
//        ObjectOutputStream out = null;
//
//        try {
//            List<Book> list = new ArrayList<>();
//            list.add(new Book("id001", "dao", "tacgia1", 11));
//            list.add(new Book("id002", "quoc", "tacgia2", 12));
//            list.add(new Book("id003", "truong", "tacgia3", 19));
//            list.add(new Book("id004", "tuan", "tacgia1", 23));
//            list.add(new Book("id005", "thanh", "tacgia1", 16));
//            list.add(new Book("id006", "alo", "tacgia3", 27));
//            list.add(new Book("id007", "oke", "tacgia1", 9));
//            list.add(new Book("id008", "yes", "tacgia3", 30));
//
//            out = new ObjectOutputStream(new FileOutputStream(fileName));
//            out.writeObject(list);
////            Map<String, List<Book>> listgroupByAuthor = list.stream().collect(Collectors.groupingBy(Book::getAuthor));
////            out.writeObject(listgroupByAuthor);
//        } catch (Exception ex) {
//            Logger.getLogger(BookTest.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                out.close();
//            } catch (IOException ex) {
//                Logger.getLogger(BookTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    private static void readBook() {
//        ObjectInputStream in = null;
//        try {
//            in = new ObjectInputStream(new FileInputStream(fileName));
//
////            Map<String, List<Book>> bookgroupByAuthor =  (Map<String, List<Book>>) in.readObject();
//            
////            bookgroupByAuthor.get(Book::getAuthor);
////            bookgroupByAuthor.forEach(System.out::println);
//        
//            List<Book> books = (List<Book>) in.readObject();
//            books.forEach(System.out::println);
//        } catch (Exception ex) {
//            Logger.getLogger(BookTest.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                in.close();
//            } catch (IOException ex) {
//                Logger.getLogger(BookTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//}
