package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectionBD {
    public static final String URL = "jdbc:postgresql://localhost:5432/BarDaFavaFBD";
    public static final String LOGIN = "postgres";
    public static final String SENHA = "crflamengo";
    private static Connection conexao = null;

    private ConectionBD() {
    }

    public static Connection getInstance() {

        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(
                        URL,
                        LOGIN,
                        SENHA);
                System.out.println("Conectou");
            }
        } catch (SQLException e) {
            System.out.println("Deu pau!");
            e.printStackTrace();
        }
        return conexao;

    }
}