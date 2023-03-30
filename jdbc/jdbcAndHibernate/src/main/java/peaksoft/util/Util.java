package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД


    private static final String URL="jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME="postgres";
    private static final String PASSWORD="0307";
    public static Connection connection(){
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            System.out.println(" Подключение к postgresql успешно");
        }catch (SQLException e){
            e.getMessage();
        }return connection;
    }


}


