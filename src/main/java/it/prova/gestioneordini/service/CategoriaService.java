package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.CategoriaDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;


public interface CategoriaService {
	
	public List<Categoria> listAll() throws Exception;

	public Categoria caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Long idCategoriaDaRimuovere) throws Exception;
	
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	public void aggiungiArticolo(Categoria categoria, Articolo articolo) throws Exception;
	
	public List<Categoria> trovaTutteDisinteDatoOrdine(Ordine ordine) throws Exception;

}
