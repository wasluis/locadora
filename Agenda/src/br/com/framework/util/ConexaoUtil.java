package br.com.framework.util;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Washington
 */
public class ConexaoUtil {
    
    public static Connection getConnection() throws Exception{
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5433/Agenda";
        String login = "postgres";
        String senha = "postgres";
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, login, senha);
        
        return connection;
  
    }
    
    
}
