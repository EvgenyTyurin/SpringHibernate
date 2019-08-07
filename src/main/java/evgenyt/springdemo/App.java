package evgenyt.springdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Hibernate Demo
 * Insert record to table person via PersonEntity and hibernate session
 *
 * Aug 2019 EvgenyT
 */
public class App 
{
    public static void main( String[] args )
    {
        // Get application context from file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // Get factory bean
        SessionFactory sessionFactory = context.getBean("sessionFactory",
                SessionFactory.class);
        // Create session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Create person entity
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Bloody Mary");
        // Insert entity to table
        session.save(personEntity);
        session.getTransaction().commit();
        session.close();
    }
}
