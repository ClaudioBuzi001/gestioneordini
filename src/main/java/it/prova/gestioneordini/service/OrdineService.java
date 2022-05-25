package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.OrdineDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineService {

	public void setOrdineDAO(OrdineDAO ordineDAOInstance);

	public List<Ordine> listaTutti() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstace) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Long idOrdine) throws Exception;
	
	//Metodo aggiungi articolo
	public void aggiungiArticolo(Ordine ordineInstance, Articolo articoloInstance) throws Exception;
	
	public void rimuoviArticolo(Ordine ordineInstance, Articolo articoloInstance) throws Exception;
	
	public List<Ordine> trovaTuttiDataCategoria(Categoria categoriaInstance) throws Exception;
	
	//TODO
	//Trova ordine con data piu vicina
	public Ordine trovaOrdineConDataSpedizionePiuVicinaDataCategoria(Categoria categoria) throws Exception;

}
