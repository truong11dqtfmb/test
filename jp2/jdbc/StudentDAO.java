package jp2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {

    public List<Student> getAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<Student> list = new ArrayList<>();
        con = DBConnect.open();
        String sql = "SELECT * FROM students";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Student st = new Student();
//    int id, String name, int gender, String clazz, double toan, double ly, double hoa
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setGender(rs.getInt("gender"));
                st.setClazz(rs.getString("clazz"));
                st.setToan(rs.getDouble("toan"));
                st.setLy(rs.getDouble("ly"));
                st.setHoa(rs.getDouble("hoa"));

                list.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.closeAll(con, stm, rs);
        }
        return list;
    }

    public Student findDetailById(int id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        con = DBConnect.open();
        String sql = "SELECT * FROM students WHERE id = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                Student st = new Student();
                st.setId(id);
                st.setName(rs.getString("name"));
                st.setGender(rs.getInt("gender"));
                st.setClazz(rs.getString("clazz"));
                st.setToan(rs.getDouble("toan"));
                st.setLy(rs.getDouble("ly"));
                st.setHoa(rs.getDouble("hoa"));

                return st;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.closeAll(con, stm, rs);
        }
        return null;
    }

    public boolean insertStudent(Student s) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        con = DBConnect.open();

        String sql = "INSERT INTO students(id,name,gender,clazz,toan,ly,hoa) VALUES(?,?,?,?,?,?,?)";

        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, s.getId());
            stm.setString(2, s.getName());
            stm.setInt(3, s.getGender());
            stm.setString(4, s.getClazz());
            stm.setDouble(5, s.getToan());
            stm.setDouble(6, s.getLy());
            stm.setDouble(7, s.getHoa());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.closeAll(con, stm, rs);
        }
        return false;
    }

    public boolean updateStudent(Student s) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        con = DBConnect.open();
        String sql = "UPDATE students SET name=?,gender=?,clazz=?,toan=?,ly=?,hoa=? WHERE id=?";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, s.getName());
            stm.setInt(2, s.getGender());
            stm.setString(3, s.getClazz());
            stm.setDouble(4, s.getToan());
            stm.setDouble(5, s.getLy());
            stm.setDouble(6, s.getHoa());
            stm.setInt(7, s.getId());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.closeAll(con, stm, rs);
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        con = DBConnect.open();
        String sql = "DELETE FROM students WHERE id = ?";
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.closeAll(con, stm, rs);
        }
        return false;
    }
}
