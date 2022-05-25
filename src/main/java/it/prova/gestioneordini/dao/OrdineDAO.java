package it.prova.gestioneordini.dao;

import it.prova.gestioneordini.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine>{
	
	//TODO aggiungi metodi aggiuntivi
	
	//AGGIUNGO metodo eager Fetching su articoli
	public Ordine findByIdFetchingArticoli(Long idDaCercare) throws Exception;

}
