package ticktacktoe.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class ConnectionUtil {
    private static Connection conn;
    private ConnectionUtil(){

    }

    public static Connection getConnection() {
        try {
            FileInputStream propertiesInput = new FileInputStream("./src/main/resources/application.properties");

            Properties props = new Properties();
            props.load(propertiesInput);
            String url = (String) props.get("spring.datasource.url");
            System.out.println(url);
            String username = (String) props.get("spring.datasource.username");
            String password = (String) props.get("spring.datasource.password");
//             String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            if (conn == null) {
                try {
                    conn = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//         catch (ClassNotFoundException ex) {
//             System.out.println("An error occurred. Maybe user/password is invalid");
//             ex.printStackTrace();
//         }
        return conn;
    }

}
