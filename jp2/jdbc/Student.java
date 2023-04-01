package jp2.jdbc;

public class Student {

    private int id;
    private String name;
    private int gender;
    private String clazz;
    private double toan;
    private double ly;
    private double hoa;

    public Student() {
    }

    public Student(int id, String name, int gender, String clazz, double toan, double ly, double hoa) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.clazz = clazz;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getLy() {
        return ly;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }

    public double getHoa() {
        return hoa;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", clazz=" + clazz + ", toan=" + toan + ", ly=" + ly + ", hoa=" + hoa + '}';
    }

}
