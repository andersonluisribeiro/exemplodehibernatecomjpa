package br.edu.unifeob.app.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("loja");
	}
	
	public EntityManager geEntityManager(){
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void inicarTransacao(){
		entityManager.getTransaction().begin();
	}
	
	public void commitarTransacao(){
		entityManager.getTransaction().commit();
	}
	
	public void cancelarTransacao(){
		entityManager.getTransaction().rollback();
	}
	
	public void fecharEntityManger(){
		entityManager.close();
	}
	
	public void fecharEntityManagerFactory(){
		entityManagerFactory.close();
	}

}
