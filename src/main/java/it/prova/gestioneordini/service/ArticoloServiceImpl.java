package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;

public class ArticoloServiceImpl implements ArticoloService {

	private ArticoloDAO articoloDAO;

	// TODO
	@Override
	public List<Articolo> listaTutti() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articolo caricaSingoloArticolo(Long idArticoloDaCaricare) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Articolo articoloInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisci(Articolo articoloInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Long idArticoloDaRimovere) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
	}

}
