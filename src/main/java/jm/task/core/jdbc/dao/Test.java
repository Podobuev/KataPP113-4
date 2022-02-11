package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.util.Util;

public class Test {

    public static void main(String[] args) {


        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        //user.createUsersTable();
        //user.dropUsersTable();
         user.saveUser("Dima", "Bannikov", (byte) 33);
        //user.removeUserById(8);
    }
}
