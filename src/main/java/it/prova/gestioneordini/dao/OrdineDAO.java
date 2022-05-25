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
	
	//voglko il piu recente ordine in temrini di spedizione relativo ad una categoria data in input
	public Ordine findOrdineConSpedizionePiuRecenteByCategoria(Categoria categoria) throws Exception;
	
	//Voglio la lista distinta di indirizzi di ordini che contengano una determinata stringa nel numero seriale dei relativi articoli
	public List<String> getIndirizziSpedizioneDistinti(String numeroSeriale) throws Exception;
}
