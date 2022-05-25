package it.prova.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

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
		if (o == null)
			throw new RuntimeException("ERRORE INPUT");

		o = entityManager.merge(o);

	}

	@Override
	public void insert(Categoria o) throws Exception {
		if (o == null)
			throw new RuntimeException("ERRORE INPUT");

		entityManager.persist(o);

	}

	@Override
	public void delete(Categoria o) throws Exception {
		if (o == null)
			throw new RuntimeException("ERRORE INPUT");

		entityManager.remove(o);

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public Categoria findByIdFetchingArticoli(Long idDaCercare) throws Exception {
		TypedQuery<Categoria> query = entityManager.createQuery(
				"select c from Categoria c left join fetch c.articoli a where c.id = :idCat", Categoria.class);
		query.setParameter("idCat", idDaCercare);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public List<Categoria> findAllDistinctByOrdine(Ordine ordine) throws Exception {
		TypedQuery<Categoria> query = entityManager.createQuery("Select distinct c from Categoria c join c.articoli a join a.ordine o where o.id= :idO", Categoria.class);
		query.setParameter("idO", ordine.getId());
		return query.getResultList();
	}

	@Override
	public List<String> findCodiciByMese() throws Exception {
		//Voglio la lista distinta di codici di categorie di ordini effettuati a febbraio di quest’anno
		return entityManager.createQuery("select distinct c.codice from Categoria c join c.articoli a join a.ordine o where o.dataSpedizione like '2022-02%'", String.class).getResultList();
	}

}



















