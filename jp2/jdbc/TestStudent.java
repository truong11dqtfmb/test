package jp2.jdbc;

public class TestStudent {

    public static void main(String[] args) {
        StudentDAO stDao = new StudentDAO();
        Student s = new Student();

//        stDao.getAll().forEach(System.out::println);
//        System.out.println(stDao.insertStudent(new Student(2, "quoc", 0, "C2111L", 1.1, 2.2, 3.3)));
//        System.out.println(stDao.updateStudent(new Student(1, "truong update", 1, "C2108G2 update", 11.11, 22.22, 33.33)));
//        System.out.println(stDao.findDetailById(1));
        System.out.println(stDao.deleteStudent(2));
        stDao.getAll().forEach(System.out::println);

    }
}
