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
        System.out.println("Closing entity transaction");
        em.close();    	
    	
    }    
}
