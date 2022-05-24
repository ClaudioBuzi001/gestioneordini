package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;

public interface ArticoloService {
	// Implemento firma metodi crud

//	list 
	public List<Articolo> listaTutti() throws Exception;

//	get 
	public Articolo caricaSingoloArticolo(Long idArticoloDaCaricare) throws Exception;

//	update 
	public void aggiorna(Articolo articoloInstance) throws Exception;

//	insert
	public void inserisci(Articolo articoloInstance) throws Exception;

//	delete
	public void rimuovi(Long idArticoloDaRimovere) throws Exception;

	// per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);

}
