
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clientes");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Laboratorio laboratorio = entityManager.find(Laboratorio.class, 1l);
		
		List<Computador> computadores = laboratorio.getComputadores();
		
		for(Computador computador: computadores){
			System.out.println(computador.getMarca());
		}
		
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
