package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Andrey", "Podobuev", (byte) 34);
        userDaoJDBC.saveUser("Dmitriy", "Bannikov", (byte) 33);
        userDaoJDBC.saveUser("Sergey", "Ivanov", (byte) 30);
        userDaoJDBC.saveUser("Igor", "Petrov", (byte) 22);

        List<User> list = userDaoJDBC.getAllUsers();

        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();

    }

}
