package it.prova.gestioneordini.dao;


import java.util.List;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
	// TODO IMPLEMENTA METODI AGGIUNTIVI
	
	//AGGIUNGO metodo eager fetching su articoli
	public Categoria findByIdFetchingArticoli(Long idDaCercare) throws Exception;
	
	//-voglio tutte le categorie distinte degli articoli dato un determinato ordine 
	public List<Categoria> findAllDistinctByOrdine(Ordine ordine) throws Exception;

}
