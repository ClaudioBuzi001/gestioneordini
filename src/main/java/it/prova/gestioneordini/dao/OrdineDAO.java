package it.prova.gestioneordini.dao;

import java.util.List;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine>{
	
	//TODO aggiungi metodi aggiuntivi
	
	//AGGIUNGO metodo eager Fetching su articoli
	public Ordine findByIdFetchingArticoli(Long idDaCercare) throws Exception;
	
	//voglio tutti gli ordini effetuati data una categoria (Cateogoria)
	public List<Ordine> findAllByCategoria(Categoria categoriaInstance);

}
