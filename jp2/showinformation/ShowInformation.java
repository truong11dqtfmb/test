package jp2.showinformation;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ShowInformation {

    public static String name = "Ho Van Cuong";
    public static String dob = "20-11-1991";
    public static double free = 2000;

    public static void localeVi() {
        System.out.println("Ho va ten: " + name);
        String[] date = dob.split("-");
        System.out.println("Ban sinh vao Ngay " + date[0] + " thang " + date[1] + " nam " + date[2]);
        String hocPhi = free + "";
        String hocPhii = hocPhi.substring(0, hocPhi.length() - 2);
        String[] arrayHPhi = hocPhii.split("");
        String HocPhi = "";
        int sl = arrayHPhi.length;
        while (true) {
            if (sl > 3) {
                HocPhi = arrayHPhi[sl - 1].concat(HocPhi);
                HocPhi = arrayHPhi[sl - 2].concat(HocPhi);
                HocPhi = arrayHPhi[sl - 3].concat(HocPhi);
                HocPhi = ".".concat(HocPhi);
                sl -= 3;
            } else {
                while (sl > 0) {
                    HocPhi = arrayHPhi[sl - 1].concat(HocPhi);
                    sl--;
                }
                break;
            }
        }
        System.out.println("Ban can tra khi tham gia khoa hoc ACCP la " + HocPhi + " đ");
    }

    public static String timThang(int thang) {
        String kq = "";
        switch (thang) {
            case 1:
                kq = "January";
                break;
            case 2:
                kq = "February";
                break;
            case 3:
                kq = "March";
                break;
            case 4:
                kq = "April";
                break;
            case 5:
                kq = "May";
                break;
            case 6:
                kq = "June";
                break;
            case 7:
                kq = "July";
                break;
            case 8:
                kq = "August";
                break;
            case 9:
                kq = "September";
                break;
            case 10:
                kq = "October";
                break;
            case 11:
                kq = "November";
                break;
            case 12:
                kq = "December";
                break;
            default:
                System.out.println("Error");
        }
        return kq;
    }

    public static void localeEn() {
        System.out.println("Your name is " + name);
        String[] date = dob.split("-");
        String thang = timThang(Integer.valueOf(date[1]));
        System.out.println("Wou were born in " + thang + " " + date[0] + ", " + date[2]);

        // tien khoa hoc
        String freee = free + "";
        String Freee = freee.substring(0, freee.length() - 2);
        String[] arrayFree = Freee.split("");
        int sl = arrayFree.length;
        String Free = "";
        while (true) {
            if (sl > 3) {
                Free = arrayFree[sl - 1].concat(Free);
                Free = arrayFree[sl - 2].concat(Free);
                Free = arrayFree[sl - 3].concat(Free);
                Free = ",".concat(Free);
                sl -= 3;
            } else {
                while (sl > 0) {
                    Free = arrayFree[sl - 1].concat(Free);
                    sl--;
                }
                break;
            }
        }
        Free = "$".concat(Free).concat(".00");
        System.out.println("You pay for your ACCP course is " + Free);
    }

    public static void menu() {
        int use = 0;
        System.out.println("1. Show message is English.");
        System.out.println("2. Tin nhan hien thi la tieng Viet.");
        System.out.print("Ban chon: ");
        Scanner sc = new Scanner(System.in);
        try {
            use = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Du lieu sai, ban hay nhap lai!");
            menu();
            return;
        }
        switch (use) {
            case 1:
                localeEn();
                break;
            case 2:
                localeVi();
                break;
            default:
                System.out.println("Du lieu sai, ban hay nhap lai!");
                menu();
                return;
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
