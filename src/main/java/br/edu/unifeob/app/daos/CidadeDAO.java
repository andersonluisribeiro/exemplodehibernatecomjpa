package br.edu.unifeob.app.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.unifeob.app.entidades.Cidade;

public class CidadeDAO {
	
	private EntityManager entityManager;
	
	public CidadeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvar(Cidade cidade){
		entityManager.persist(cidade);		
	}
	
	public void atualizar(Cidade cidade){
		entityManager.merge(cidade);
	}
	
	public void deletar(Cidade cidade){
		entityManager.remove(cidade);
	}

	public List<Cidade> todasAsCidades(){
		String consulta = "from Cidade";
		TypedQuery<Cidade> query = entityManager.createQuery(consulta, Cidade.class);
		return query.getResultList();
	}
	
	public Cidade encontrarPorId(Long id){
		return entityManager.find(Cidade.class, id);
	}
}
