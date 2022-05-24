package it.prova.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;


import it.prova.gestioneordini.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

	private EntityManager entityManager;

	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria o) throws Exception {
		if(o == null)
			throw new RuntimeException("ERRORE INPUT");
		
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Categoria o) throws Exception {
		if(o == null)
			throw new RuntimeException("ERRORE INPUT");
		
		entityManager.persist(o);


	}

	@Override
	public void delete(Categoria o) throws Exception {
		if(o == null)
			throw new RuntimeException("ERRORE INPUT");
		
		entityManager.remove(o);


	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

}
