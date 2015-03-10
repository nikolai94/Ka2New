package facade;

import entity.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author petersodborgchristensen
 */
public class MyFacade {

    EntityManagerFactory emf;
    EntityManager em;

    public MyFacade() {
        emf = Persistence.createEntityManagerFactory("Ka2NewPU");
    }

    public Person getPerson(int id) {
        em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        em.close();
        return p;
    }

    public void addPerson(InfoEntity infoEntity, Person person, Phone phone, Address address, Cityinfo cityInfo,Hobby hobby) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            phone.AddPhoneToInfoEntity(infoEntity);
            infoEntity.addPhone(phone);

            System.out.println("address object start");
            infoEntity.addAddress(address);
            // address.addInfoEntity(infoEntity);
            System.out.println("address object slut");

            // cityInfo.addAddress(address);
            address.addCityInfo(cityInfo);
            
           // person.addHobby(hobby);
            hobby.addPerson(person);
            
            
            em.persist(phone);
            System.out.println("phone");
            em.persist(address);
            System.out.println("adress");
            em.persist(infoEntity);
            System.out.println("infoEntity");
            em.persist(person);
            System.out.println("person");
            em.persist(cityInfo);
            System.out.println("cityInfo");
            em.persist(hobby);
            System.out.println("hobby");

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();

    }

    public List<Person> getPersons() {
        em = emf.createEntityManager();
        String q = "select Persons from Person Persons ";

        List<Person> list = em.createQuery(q).getResultList();
        em.close();
        return list;

    }

    public List<Person> getPersons(int zipCode) {
        em = emf.createEntityManager();
        String q = "SELECT Persons FROM Person WHERE name = :zipCode";

        List<Person> list = em.createQuery(q).getResultList();
        em.close();
        return list;
    }

    public Company getCompany(int cvr) {
        em = emf.createEntityManager();
        Company c = em.find(Company.class, cvr);
        em.close();
        return c;
    }

}
