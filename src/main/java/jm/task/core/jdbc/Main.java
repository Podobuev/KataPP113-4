package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

        userDaoHibernate.saveUser("Andrey", "Podobuev", (byte) 34);
        userDaoHibernate.saveUser("Dmitriy", "Bannikov", (byte) 33);
        userDaoHibernate.saveUser("Sergey", "Ivanov", (byte) 30);
        userDaoHibernate.saveUser("Igor", "Petrov", (byte) 22);

        List<User> list = userDaoHibernate.getAllUsers();

        userDaoHibernate.cleanUsersTable();

        userDaoHibernate.dropUsersTable();


//
//        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//
//        userDaoJDBC.createUsersTable();
//
//        userDaoJDBC.saveUser("Andrey", "Podobuev", (byte) 34);
//        userDaoJDBC.saveUser("Dmitriy", "Bannikov", (byte) 33);
//        userDaoJDBC.saveUser("Sergey", "Ivanov", (byte) 30);
//        userDaoJDBC.saveUser("Igor", "Petrov", (byte) 22);
//
//        List<User> list = userDaoJDBC.getAllUsers();
//
//        userDaoJDBC.cleanUsersTable();
//            userDaoJDBC.dropUsersTable();
//
    }

}
