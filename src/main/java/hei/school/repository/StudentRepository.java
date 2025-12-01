package hei.school.repository;

import hei.school.entity.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final Connection connection = DataSource.getConnection();


    public void insert(Student student) {
        String sql = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());
            stmt.executeUpdate();
            System.out.println("Étudiant ajouté !");
        } catch (SQLException e) {
            System.out.println("Erreur INSERT : " + e.getMessage());
        }
    }


    public List<Student> findAll() {
        String sql = "SELECT id, name, age FROM student";
        List<Student> list = new ArrayList<>();

        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur SELECT : " + e.getMessage());
        }
        return list;
    }


    public void updateName(int id, String newName) {
        String sql = "UPDATE student SET name = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Nom mis à jour !");
        } catch (SQLException e) {
            System.out.println("Erreur UPDATE : " + e.getMessage());
        }
    }


    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Étudiant supprimé !");
        } catch (SQLException e) {
            System.out.println("Erreur DELETE : " + e.getMessage());
        }
    }
}
