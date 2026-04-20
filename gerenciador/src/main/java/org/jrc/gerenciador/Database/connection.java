package org.jrc.gerenciador.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connection {
    private static String URL = "jdbc:mysql://localhost:3306/gestao_servicos";
    private static String User = "root";
    private static String Password = "97428908jfc";
    private static String Driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(Driver);
            return DriverManager.getConnection(URL, User, Password);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro  na conexão" + e);
            
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();                
            }
        } catch (Exception e) {
            System.err.println("Erro ao fechar conexão " + e);
        }
    }

    
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();                
            }
        } catch (Exception e) {
            System.err.println("Erro ao fechar conexão " + e);
        }
    }

        public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();                
            }
        } catch (Exception e) {
            System.err.println("Erro ao fechar conexão " + e);
        }
    }


}
