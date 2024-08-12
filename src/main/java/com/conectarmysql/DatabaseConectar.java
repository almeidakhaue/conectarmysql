package com.conectarmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


 
public class DatabaseConectar 
{
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/teste";
        String username = "root";
        String password = "root"; 

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            System.out.println("Conectado ao MySQL com sucesso!");

            String sql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(100) NOT NULL,"
                    + "email VARCHAR(100) NOT NULL UNIQUE"
                    + ")";

            Statement statement = connection.createStatement();
            statement.execute(sql);

            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro na conexão ao MySQL.");
            e.printStackTrace();
        }
    }

}
