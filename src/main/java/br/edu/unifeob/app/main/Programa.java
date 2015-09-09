package br.edu.unifeob.app.main;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifeob.app.daos.CidadeDAO;
import br.edu.unifeob.app.daos.JPAUtil;
import br.edu.unifeob.app.entidades.Cidade;

public class Programa {

	public static void main(String[] args) {
		
		JPAUtil jpaUtil = new JPAUtil();
		EntityManager entityManager = jpaUtil.geEntityManager();
		
		try {
			
			jpaUtil.inicarTransacao();
			
			CidadeDAO dao = new CidadeDAO(entityManager);
			
			List<Cidade> cidades = dao.todasAsCidades();
			
			for(Cidade cidade : cidades){
				System.out.println("ID: " + cidade.getId() + " - Nome: " + cidade.getNome());
			}
			
			jpaUtil.commitarTransacao();
			
		} catch (Exception e) {
			
			jpaUtil.cancelarTransacao();
			
		} finally {
			
			jpaUtil.fecharEntityManger();
			jpaUtil.fecharEntityManagerFactory();
			
		}
		
	}

}
