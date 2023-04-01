
package jp2.op;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author DELL
 */
public class Test {

    public static JFileChooser fc = new JFileChooser();

    public static List<Opportunity> listOpportunity = new ArrayList<>();

    public static void taoDanhSachCoHoi() {
        for (int i = 0; i < 5; i++) {
            Opportunity o = new Opportunity();
            o.input();
            listOpportunity.add(o);
        }
    }

    public static void themCoHoi() {
        Opportunity o = new Opportunity();
        o.input();
        listOpportunity.add(o);
    }

    public static void luuSanhSach() {
        if (listOpportunity.isEmpty()) {
            System.out.println("Chưa có cơ hội nào trong danh sách!");
            return;
        }
//        int returnVal = fc.showSaveDialog(fc);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
        try {
//                File file = fc.getSelectedFile();
            PrintWriter pw = new PrintWriter("C:\\Users\\DELL\\Documents\\Vi-et\\data_file.txt");

            for (Opportunity opportunity : listOpportunity) {
                pw.print(opportunity);
            }

            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, "Luu thanh cong!");
        } catch (Exception e) {
        }
    }
//    }

    public static void moFile() {
        File f = new File("C:\\Users\\DELL\\Documents\\Vi-et\\data_file.txt");
//        ‪C:\Users\DQT\Desktop\JP2
        try {
            List<String> allText = Files.readAllLines(f.toPath());
            for (String string : allText) {
                System.out.println(string);
            }
        } catch (Exception e) {
        }
    }

    public static void timCoHoi() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập cơ hội muốn tìm: ");
        String coHoi = sc.nextLine();
        File f = new File("C:\\Users\\DELL\\Documents\\Vi-et\\data_file.txt");
        try {
            boolean timThay = false;
            List<String> allText = Files.readAllLines(f.toPath());
            for (String string : allText) {
                int indexStart = string.indexOf("'") + 1;
                int indexEnd = string.indexOf("'", indexStart);
                String coHoii = string.substring(indexStart, indexEnd);
                coHoi = coHoi.toLowerCase();
                coHoii = coHoii.toLowerCase();
                if (coHoii.indexOf(coHoi) > 0) {
                    System.out.println("Cơ hội bạn muốn tìm là: ");
                    System.out.println(string);
                    timThay = true;
                }
            }
            if (!timThay) {
                System.out.println("Không tìm thấy cơ hội bạn muốn tìm!");
            }
        } catch (Exception e) {
        }
    }

    public static void ghiDanhSachDuoiDangDoiTuong() {
        File file = new File("C:\\Users\\DELL\\Documents\\Vi-et\\data2_file.txt");
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (Opportunity opportunity : listOpportunity) {
                oos.writeObject(opportunity);
            }
            System.out.println("Ghi thanh cong!");
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void docDoiTuongTuDanhSach() {
        File file = new File("C:\\Users\\DELL\\Documents\\Vi-et\\data2_file.txt");
        if (file.exists()) {
            try {
                InputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is);
                while (is.available() > 0) {
                    Opportunity op = (Opportunity) ois.readObject();
                    listOpportunity.add(op);
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        } else {
            System.out.println("File khong ton tai!");
        }
    }

    public static void enter() {
        System.out.println("-------------------------------");
    }

    public static void hienThiDanhSachCoHoi() {
        for (Opportunity opportunity : listOpportunity) {
            System.out.println(opportunity);
        }
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-----Các chức năng-----");
        System.out.println("1. Tạo danh danh sách cơ hội");
        System.out.println("2. Thêm cơ hội");
        System.out.println("3. Lưu danh sách cơ hội vào file data_file.txt");
        System.out.println("4. Mở tệp data_file.txt và hiển thị danh sách cơ hội");
        System.out.println("5. Tìm một cơ hội trong file data_file.txt");
        System.out.println("6. Hiển thị danh sách cơ hội");
        System.out.println("7. Lưu danh sách dưới dạng đối tượng vào file data2_file.txt");
        System.out.println("8. Đọc danh sách đối tượng từ file data2_file.txt");
        System.out.println("9. Thoát");
        System.out.println("Bạn chọn");
        int lchon = 0;
        try {
            lchon = sc.nextInt();
            enter();
        } catch (Exception e) {
            System.out.println("Bạn nhập sai dữ liệu,  mời nhập lại");
            menu();
            return;
        }
        switch (lchon) {
            case 1:
                taoDanhSachCoHoi();
                menu();
                break;
            case 2:
                themCoHoi();
                menu();
                break;
            case 3:
                luuSanhSach();
                menu();
                break;
            case 4:
                moFile();
                menu();
                break;
            case 5:
                timCoHoi();
                menu();
                break;
            case 6:
                hienThiDanhSachCoHoi();
                menu();
                break;
            case 7:
                ghiDanhSachDuoiDangDoiTuong();
                menu();
                break;
            case 8:
                docDoiTuongTuDanhSach();
                menu();
                break;
            case 9:
                return;
            default:
                System.out.println("Ban chon sai moi chon lai");
                menu();
                return;
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        new Test();
        menu();
    }
}

