package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.OrdineDAO;
import it.prova.gestioneordini.model.Ordine;

public class OrdineServiceImpl implements OrdineService {

	private OrdineDAO ordineDAO;

	@Override
	public void setOrdineDAO(OrdineDAO ordineDAOInstance) {
		this.ordineDAO = ordineDAOInstance;

	}

	@Override
	public List<Ordine> listaTutti() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordine caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Ordine ordineInstace) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Long idGenere) throws Exception {
		// TODO Auto-generated method stub

	}

}
