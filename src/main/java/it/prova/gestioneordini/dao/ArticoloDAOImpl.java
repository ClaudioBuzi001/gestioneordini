package it.prova.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Articolo;

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

}
