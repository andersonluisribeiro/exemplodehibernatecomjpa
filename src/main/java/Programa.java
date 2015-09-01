import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			
			
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
			factory.close();
		}
		
	}

}
