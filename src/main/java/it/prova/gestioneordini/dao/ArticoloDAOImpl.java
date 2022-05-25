package it.prova.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public class ArticoloDAOImpl implements ArticoloDAO {

	private EntityManager entityManager;

	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo articoloDaAggiornare) throws Exception {
		if (articoloDaAggiornare == null) {
			throw new Exception("Problema valore in input");
		}
		articoloDaAggiornare = entityManager.merge(articoloDaAggiornare);

	}

	@Override
	public void insert(Articolo articoloDaInserire) throws Exception {
		if (articoloDaInserire == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(articoloDaInserire);

	}

	@Override
	public void delete(Articolo articoloDaRimuovere) throws Exception {
		if (articoloDaRimuovere == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(articoloDaRimuovere);

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Articolo findByIdFetchingCategorie(Long idDaCercare) throws Exception {
		TypedQuery<Articolo> query= entityManager.createQuery("select a from Articolo left join fetch a.categorie c where a.id = :idArt", Articolo.class );
		query.setParameter("idArt", idDaCercare);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public Integer getSommaByCategoria(Categoria categoria) throws Exception {
		int conta = 0;
		TypedQuery<Articolo> query = entityManager.createQuery("select a from Articolo a  join a.categorie c where c.id = :idC", Articolo.class);
		query.setParameter("idC", categoria.getId());
		List<Articolo> result = query.getResultList();
		for(Articolo articoloItem : result ) {
			conta += articoloItem.getPrezzoSingolo();
		}
		return conta;
		
	}

	@Override
	public Long sommaPrezziDiArticoliIndirizzatiAMarioRossi() throws Exception {
		return entityManager.createQuery("select sum(a.prezzoSingolo) from Articolo a join a.ordine o where o.nomeDestinatario = 'Mario Rossi'", Long.class).getSingleResult();
	}
}
