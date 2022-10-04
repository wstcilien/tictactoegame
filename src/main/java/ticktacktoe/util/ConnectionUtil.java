package ticktacktoe.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
            String driver = (String) props.get("spring.datasource.driver-class-name);
            Class.forName(driver);

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
        return conn;
    }

}
