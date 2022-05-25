package it.prova.gestioneordini.dao;

import it.prova.gestioneordini.model.Articolo;

public interface ArticoloDAO extends IBaseDAO<Articolo> {
	
	//Ereditiamo metodi crud da IBaseDAO
	
	//AGGIUNGO metodo eager fetching 
	public Articolo findByIdFetchingCategorie(Long idDaCercare) throws Exception;
	
	//TODO aggiungi metodi aggiuntivi

}
