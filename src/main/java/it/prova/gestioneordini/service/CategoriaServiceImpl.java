package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.CategoriaDAO;
import it.prova.gestioneordini.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Categoria categoriaInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Categoria categoriaInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Long idCategoriaDaRimuovere) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

}
