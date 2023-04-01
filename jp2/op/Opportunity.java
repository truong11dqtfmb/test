package jp2.op;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opportunity implements Serializable {

    private String id;
    private String jobTitle;
    private float expectedSalary;
    private List<String> skills = new ArrayList<>();
    private List<String> education = new ArrayList<>();

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập: ");
        try {
            System.out.print("ID: ");
            this.id = sc.nextLine();

            System.out.print("Cơ hội: ");
            this.jobTitle = sc.nextLine();
            if (this.jobTitle.length() < 10) {
                System.out.println("Cơ hội phải có ít nhất 10 kí tự!");
                this.input();
                return;
            }

            System.out.print("Mức lương: ");
            this.expectedSalary = sc.nextFloat();
            if (this.expectedSalary <= 20) {
                System.out.println("Mức lương phải lớn hơn 20!");
                this.input();
                return;
            }

            sc.nextLine();
            System.out.print("Số kỹ năng: ");
            int sKnang = sc.nextInt();
            if (sKnang < 2) {
                System.out.println("Phải có ít nhất 2 kỹ năng!");
                this.input();
                return;
            }
            sc.nextLine();
            for (int i = 1; i <= sKnang; i++) {
                System.out.print("Kỹ năng " + i + ": ");
                String kNangi = sc.nextLine();
                this.skills.add(kNangi);
            }

            System.out.print("Số lượng thông tin trình độ học vấn: ");
            int tdo = sc.nextInt();
            if (tdo < 1) {
                System.out.println("Phải có ít nhất 1 trình độ học vấn");
                this.input();
                return;
            }
            sc.nextLine();
            for (int i = 0; i < tdo; i++) {
                System.out.print("Hoc vấn(" + i + "): ");
                String hocVan = sc.nextLine();
                this.education.add(hocVan);
            }
        } catch (Exception e) {
            System.out.println("B nhap du lieu sai, hay nhap lai!");
            this.input();
            return;
        }
        this.enter();
    }

    public void enter() {
        System.out.println("-------------------");
    }

    public Opportunity() {
    }

    public Opportunity(String id, String jobTitle, float expectedSalary, List<String> skills, List<String> education) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.expectedSalary = expectedSalary;
        this.skills = skills;
        this.education = education;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public float getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(float expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }
    
    

}
