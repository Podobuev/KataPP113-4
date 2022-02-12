package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.Property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Util {

    private String url = "jdbc:mysql://localhost:3306/Kata1JDBC";
    private String userName = "root";
    private String pasword = "Cgfhnfr254!";


    public Statement connection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, userName, pasword);
        //System.out.println("Соединение успешно создано");

        return connection.createStatement();
    }

    public SessionFactory session() {

        Properties properties = new Properties();

        properties.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Kata1JDBC");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "Cgfhnfr254!");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);

        return configuration.buildSessionFactory();
    }
}



