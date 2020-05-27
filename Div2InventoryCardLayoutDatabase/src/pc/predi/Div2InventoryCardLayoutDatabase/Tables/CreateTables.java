package pc.predi.Div2InventoryCardLayoutDatabase.Tables;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Hello world!
 *
 */
public class CreateTables 
{
    public static void main( String[] args )
    {
    	EntityManager em = Persistence.createEntityManagerFactory("CreateTables").createEntityManager();
    	em.getTransaction().begin();
        System.out.println( "Starting EntityTransaction" );
//        Weapon weapon = new Weapon("test1","test2","test3","test4","test5", "test6");
//        em.persist(weapon);
//        em.getTransaction().commit();
        System.out.println("Closing entity transaction");
        em.close();
        
        //testing code
//    	em = Persistence.createEntityManagerFactory("org.predi.HibernateTest").createEntityManager();
//    	em.getTransaction().begin();
//    	System.out.println("Starting EntityTransaction");
//    	System.out.println("Closing EntityTransaction");
//    	em.close();
    	
    	
    }    
}
