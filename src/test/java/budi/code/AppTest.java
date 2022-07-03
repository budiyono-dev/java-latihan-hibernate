package budi.code;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addSiswa(){
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
    @Test
    public void addSiswaWithEntityName(){
        SiswaEntityName siswa = new SiswaEntityName();
        siswa.setName("Yono");
        siswa.setEmail("yono@gmail.com");

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(SiswaEntityName.class);
        SessionFactory sf = con.buildSessionFactory();

        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        s.save(siswa);
        tr.commit();
    }
    @Test
    public void addSiswaWithCustomeEntity(){
        SiswaTableColumnCustom siswa = new SiswaTableColumnCustom();
        siswa.setName("budi");
        siswa.setEmail("budi@gmail.com");
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(SiswaTableColumnCustom.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        session.save(siswa);
        tr.commit();
    }
}
