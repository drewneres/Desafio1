package com.loja.util;

import src.com.loja.util.DatabaseConfig;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            System.out.println("Conexão com o banco de dados bem-sucedida!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
