package jm.task.core.jdbc.dao;

import com.mysql.cj.jdbc.ha.MultiHostMySQLConnection;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        try (Statement statement = new Util().connection()) {

            statement.executeUpdate("CREATE TABLE user (Id INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(20), LastName VARCHAR(20), Age TINYINT)");
            System.out.println("Таблица созданна");

        } catch (Exception e) {
            if (e.getMessage().equals("Table 'user' already exists")) {
                System.out.println("Таблица уже существует");
            } else {
                System.out.println(e);
            }
        }
    }



    public void dropUsersTable() {

        try (Statement statement = new Util().connection()) {

            statement.executeUpdate("DROP TABLE user");
            System.out.println("Таблица удалена");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        try (Statement statement = new Util().connection()) {

            statement.executeUpdate("INSERT into Kata1JDBC.user (Name, LastName, Age) VALUES ('" + name + "', '" + lastName + "', '" + age + "')");
            System.out.printf("User с именем – %s добавлен в базу данных", name);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void removeUserById(long id) {

        try (Statement statement = new Util().connection()) {
            System.out.println("Соединение успешно создано");

            statement.executeUpdate("DELETE FROM User WHERE Id = '" + id + "' ");
            System.out.printf("Пользователь с id = %d удален", id);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
