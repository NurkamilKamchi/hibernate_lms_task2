package peaksoft.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;

import java.util.Properties;

public class Util {
    private final UserServiceImpl userService = new UserServiceImpl();
    // реализуйте настройку соеденения с БД
    public static SessionFactory getSession(){

        Properties properties = new Properties();
        properties.put(Environment.JAKARTA_JDBC_DRIVER,"org.postgresql.Driver");
        properties.put(Environment.JAKARTA_JDBC_URL,"jdbc:postgresql://localhost:5432/hibernate");
        properties.put(Environment.JAKARTA_JDBC_USER,"postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD,"nurkamil192.168");
//        birirnchi "create" kylyp koush kk
        properties.put(Environment.HBM2DDL_AUTO,"update");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(User.class);
//        bir neche class bolso ushunday ele kylabyz birok classtyn atyn ozgortup koobuz
        return configuration.buildSessionFactory();
    }
    public static EntityManagerFactory getEntityManager(){
        return getSession().unwrap(EntityManagerFactory.class);
    }
}
