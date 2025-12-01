package hei.school.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private  String URL = "jdbc:postgresql://localhost:5432/jdbc_school";
    private  String USER = "postgres";
    private  String PASSWORD = "postgres";

    public  Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

