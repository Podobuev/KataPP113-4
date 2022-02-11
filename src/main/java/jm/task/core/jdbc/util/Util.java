package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

    private String url = "jdbc:mysql://localhost:3306/Kata1JDBC";
    private String userName = "root";
    private String pasword = "Cgfhnfr254!";


    public Statement connection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, userName, pasword);
        System.out.println("Соединение успешно создано");

        return connection.createStatement();
    }
}



