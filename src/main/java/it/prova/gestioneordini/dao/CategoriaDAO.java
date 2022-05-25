package it.prova.gestioneordini.dao;

import it.prova.gestioneordini.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
	// TODO IMPLEMENTA METODI AGGIUNTIVI
	
	//AGGIUNGO metodo eager fetching su articoli
	public Categoria findByIdFetchingArticoli(Long idDaCercare) throws Exception;

}
