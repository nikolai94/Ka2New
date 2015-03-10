package facade;
import entity.Company;
import entity.Person;
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
    public MyFacade(){
        emf = Persistence.createEntityManagerFactory("Ka2NewPU");
    }
    public Person getPerson(int id){
        em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        em.close();
        return p; 
    }
    
    public List<Person> getPersons(){
        em = emf.createEntityManager();
        String q = "select Persons from Person Persons ";

        List<Person> list = em.createQuery(q).getResultList();
        em.close();
        return list;
        
    }
    public List<Person> getPersons(int zipCode){  
        em = emf.createEntityManager();
        String q = "SELECT Persons FROM Person WHERE name = :zipCode";

        List<Person> list = em.createQuery(q).getResultList();
        em.close();
        return list;        
    }
    public Company getCompany(int cvr){
         em = emf.createEntityManager();
        Company c = em.find(Company.class, cvr);
        em.close();
        return c;
    }
    
    
}
