package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/mydb";
            String user = "root";
            String password = "27082009";
            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar com o banco de dados");
        }
    }
}