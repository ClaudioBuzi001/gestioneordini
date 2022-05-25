package it.prova.gestioneordini.dao;

import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo> {
	
	//Ereditiamo metodi crud da IBaseDAO
	
	//AGGIUNGO metodo eager fetching 
	public Articolo findByIdFetchingCategorie(Long idDaCercare) throws Exception;
	
	//TODO aggiungi metodi aggiuntivi
	//voglio la somma totale di tutti i prezzi degli articoli legati ad una data categoria (Categoria)
	public Integer getSommaByCategoria(Categoria categoria) throws Exception;

	//Voglio la somma totale dei prezzi di tutti gli articoli indirizzati a Mario Rossi  
	public Long sommaPrezziDiArticoliIndirizzatiAMarioRossi() throws Exception;
	
}
