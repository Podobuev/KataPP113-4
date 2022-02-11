package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {

        try (Statement statement = new Util().connection()) {

            statement.executeUpdate("CREATE TABLE user (Id INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(20), LastName VARCHAR(20), Age TINYINT)");
            System.out.println("Таблица созданна");

        } catch (ClassNotFoundException | SQLException e) {
            if (e.getMessage().equals("Table 'user' already exists")) {
                System.out.println("Таблица уже существует");
            } else {
                System.out.println(e);
            }
        }
    }

    public void dropUsersTable() {
        try (Statement statement = new Util().connection()) {

            statement.executeUpdate("DROP TABLE Kata1JDBC.user");
            System.out.println("Таблица удалена");
        } catch (ClassNotFoundException | SQLException e) {
            if (e.getMessage().equals("Unknown table 'kata1jdbc.user'")) {
                System.out.println("Таблицы не существует");
            } else {
                System.out.println(e);
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = new Util().connection()) {

            statement.executeUpdate("INSERT into Kata1JDBC.user (Name, LastName, Age) VALUES ('" + name + "', '" + lastName + "', '" + age + "')");
            System.out.printf("User с именем – %s добавлен в базу данных \n", name);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = new Util().connection()) {

            statement.executeUpdate("DELETE FROM Kata1JDBC.user WHERE Id = '" + id + "' ");
            System.out.printf("User с id = %d удален", id);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try (Statement statement = new Util().connection()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Kata1JDBC.user");
            while (resultSet.next()) {
                User user = new User(resultSet.getString(2), resultSet.getString(3),
                        resultSet.getByte(4));
                user.setId((long) resultSet.getInt(1));
                list.add(user);

            }
            list.stream().forEachOrdered(System.out::println);
            return list;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void cleanUsersTable() {
        try (Statement statement = new Util().connection()) {

            statement.executeUpdate("TRUNCATE TABLE Kata1JDBC.user");
            System.out.println("Таблица очищена");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
