package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

        try (Session session = new Util().session().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS user (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20) NOT NULL, lastName VARCHAR(20) NOT NULL ," +
                    " age TINYINT NOT NULL )").executeUpdate();
            System.out.println("Таблица User создана");
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    @Override
    public void dropUsersTable() {

        try (Session session = new Util().session().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS Kata1JDBC.user").executeUpdate();
            System.out.println("Таблица User удалена");
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = new Util().session().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            System.out.printf("User %s %s добавлен \n", name, lastName);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public void removeUserById(long id) {

        try (Session session = new Util().session().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();

            System.out.printf("User с id = %d удален", id);
        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> list;

        try (Session session = new Util().session().openSession()) {
            Transaction transaction = session.beginTransaction();
            list = (List<User>) session.createQuery("from User").list();
            list.stream().forEachOrdered(System.out::println);
            transaction.commit();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {

        try (Session session = new Util().session().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM User w").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
