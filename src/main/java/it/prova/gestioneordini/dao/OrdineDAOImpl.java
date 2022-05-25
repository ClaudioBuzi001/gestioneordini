package it.prova.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;

	// TODO
	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null)
			throw new RuntimeException("ERRORE INPUT");

		ordineInstance = entityManager.merge(ordineInstance);

	}

	@Override
	public void insert(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null)
			throw new RuntimeException("ERRORE INPUT");

		entityManager.persist(ordineInstance);

	}

	@Override
	public void delete(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(ordineInstance));

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Ordine findByIdFetchingArticoli(Long idDaCercare) throws Exception {
		TypedQuery<Ordine> query = entityManager
				.createQuery("select o from Ordine o left join fetch o.articoli a where o.id = :idOrd", Ordine.class);
		query.setParameter("idOrd", idDaCercare);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public List<Ordine> findAllByCategoria(Categoria categoriaInstance) {
		TypedQuery<Ordine> query = entityManager.createQuery("select o from Ordine o join o.articoli a join a.categorie c where c = :cat", Ordine.class);
		query.setParameter("cat", categoriaInstance);
		return query.getResultList();
	}

}











