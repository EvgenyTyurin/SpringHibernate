package evgenyt.springdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Spring Hibernate Demo
 * Insert record, select and update to table person via
 * PersonEntity and hibernate session
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
        // SELECT * FROM person
        List<PersonEntity> persons = session.createQuery("FROM PersonEntity").list();
        for(PersonEntity person : persons)
            System.out.println(person);
        // Update person with person_id = 1
        PersonEntity personN1 = (PersonEntity) session.get(PersonEntity.class, 1);
        System.out.println("person N1 is " + personN1);
        personN1.setName("Atos");
        session.getTransaction().commit();
        session.close();
    }
}
