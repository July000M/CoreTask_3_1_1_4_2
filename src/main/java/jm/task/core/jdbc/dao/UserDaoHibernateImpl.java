package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.Query;





public class UserDaoHibernateImpl implements UserDao {

    SessionFactory sessionFactory = Util.getSessionFactory();
    public UserDaoHibernateImpl() {

    }
    private static String sql;


    @Override
    public void createUsersTable() {
        try (Session session =  sessionFactory.openSession()) {
            String sql = //"CREATE TABLE IF NOT EXISTS users" +
//                    "  (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastname VARCHAR(30),age TINYINT(100));";
                    "CREATE TABLE IF NOT EXISTS USERS" +
                    "  id       BIGINT       PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "  name     VARCHAR(250) DEFAULT NULL," +
                    "  lastname VARCHAR(250) DEFAULT NULL," +
                    "  age      TINYINT      DEFAULT NULL)";
            session.beginTransaction();
            session.createNativeQuery(sql);
//           session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            System.out.println("create__________________________________________________");
        }
    }

    @Override
    public void dropUsersTable() {
      try (Session session =  sessionFactory.openSession()){
            session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS test.users").executeUpdate();
//            session.createSQLQuery("DROP TABLE IF EXISTS users")
//                    .executeUpdate();

          session.getTransaction().commit();
          System.out.println("drop___________________________________________");

    }}
//    public void dropUsersTable() {
//        Session session = Util.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        sql = "DROP TABLE IF EXISTS users";
//
//        Query query = session.createSQLQuery(sql).addEntity(User.class);
//        query.executeUpdate();
//
//        transaction.commit();
//        session.close();
//    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session =  sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));

            session.getTransaction().commit();
            System.out.println("save_______________________________________");
        }
    }



    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
 //           session.delete(session.get(User.class, id));//1й вариант
            session.createQuery("delete User where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("remove___________________________________________");

        }}


    @Override
    public List<User> getAllUsers() {
        List<User> userList;


       try( Session session = sessionFactory.openSession()){
           session.beginTransaction();
           userList = session.createQuery("from User", User.class)
                  // .getResultList();
           .list();
           session.getTransaction().commit();

       }
        System.out.println( " work getUsers" + userList);
        return userList;

    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
            System.out.println("work cleanUsers________________________________________________");
        }
    }
}
