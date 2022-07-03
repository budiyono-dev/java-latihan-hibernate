package budi.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

/**
 * Latihan Hibernate Basic
 * Lihat AppTest.java
 */
public class App {
    public static void main(String[] args) {
        addSiswa();
    }
    public static void addSiswa(){
        //create object
        Siswa siswa = new Siswa();

//        siswa.setId(001);
        siswa.setName("Budiyono3");
        siswa.setEmail("budiyono3.dev@gmail.com");

        //add config
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Siswa.class);

        //implement session
        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(siswa);
        transaction.commit();
    }
}
