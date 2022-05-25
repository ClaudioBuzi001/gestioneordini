package it.prova.gestioneordini.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;
import it.prova.gestioneordini.service.ArticoloService;
import it.prova.gestioneordini.service.CategoriaService;
import it.prova.gestioneordini.service.MyServiceFactory;
import it.prova.gestioneordini.service.OrdineService;

public class TestGestioneOrdine {

	public static void main(String[] args) {
		// Aggiungi le instance
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();

		try {

			// TODO Modificare il file xml con crate
			System.out.println("_-----------Inizio Batteria di Test-----------_");

			// testInserimentoOrdine(ordineServiceInstance);

			System.out.println(ordineServiceInstance.listaTutti().size());

			testAggiornaOrdine(ordineServiceInstance);

			// testAggiungiArticoloAOrdine(articoloServiceInstance,ordineServiceInstance);

			// testRimuoviArticoloAOrdine(articoloServiceInstance,ordineServiceInstance);

			// testAggiungiArticoloACategoria(articoloServiceInstance,categoriaServiceInstance);
			//testAggiungiCategoriaAArticolo(articoloServiceInstance, categoriaServiceInstance);
			
			//testtrovaTuttiOrdiniDataCategoria(ordineServiceInstance, categoriaServiceInstance);
			
			//testTrovaTutteCategorieDatoOrdine(ordineServiceInstance, categoriaServiceInstance);
			
			testTrovaSommaArticoliDataCategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);
			
			testTrovaOrdineConDataSpedizionePiuVicinaDataCategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);
			
			

		} catch (Exception e) {

		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}

	private static void testInserimentoOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("---------------Inizio testInserimentoOrdine----------");

		Ordine ordineDaInserire = new Ordine("Lucia", "Via Dal Paparazzo", null);

		ordineServiceInstance.inserisciNuovo(ordineDaInserire);

		if (ordineDaInserire.getId() < 1)
			throw new RuntimeException("testInserimentoOrdine FAILED-----------");

		System.out.println("-----------testInserimentoOrdine PASSED----_");

	}

	private static void testAggiornaOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("---------------Inizio testAggiornaOrdine----------");

		// Ci prendiamo l ordine e lo modifiichiamo
		Ordine ordineDaAggiornare = ordineServiceInstance.caricaSingoloElemento(1L);

		ordineDaAggiornare.setIndirizzoSpedizione("VIA San Giuorgio");
		ordineServiceInstance.aggiorna(ordineDaAggiornare);

		if (!ordineDaAggiornare.getIndirizzoSpedizione().equals("VIA San Giuorgio"))
			throw new RuntimeException("testAggiornaOrdine FAILED-----------");

		System.out.println("-----------testAggiornaOrdine PASSED----_");

	}

	private static void testAggiungiArticoloAOrdine(ArticoloService articoloService, OrdineService ordineService)
			throws Exception {
		System.out.println("-----------testAggiungiArticoloAOrdine PASSED----_");

		// Mi predno un ordine e collego i due
		Ordine daCollegare = ordineService.caricaSingoloElemento(1L);
		// Mi creo un nuovo articolo e lo inserisco
		Articolo daInserire = new Articolo();
		daInserire.setNumeroSeriale("HAIHU");
		daInserire.setDescrizione("CARINO");
		daInserire.setOrdine(daCollegare);

		articoloService.inserisci(daInserire);
		if (daInserire.getId() < 1)
			throw new RuntimeException("ERRORE ARTICOLO NON ISERITO");

		// Mi predno un ordine e collego i due

		ordineService.aggiungiArticolo(daCollegare, daInserire);

		System.out.println("-----------testAggiungiArticoloAOrdine PASSED----_");

	}

	private static void testRimuoviArticoloAOrdine(ArticoloService articoloService, OrdineService ordineService)
			throws Exception {
		System.out.println("-----------testRimuoviArticoloAOrdine iniziato----_");

		// Mi prendo l articolo creato prima
		Articolo daDissociare = articoloService.caricaSingoloArticolo(1L);

		// e l ordine creato prima e li dissocio
		Ordine ordineMaster = ordineService.caricaSingoloElemento(1L);

		ordineService.rimuoviArticolo(ordineMaster, daDissociare);

		System.out.println("-----------testRimuoviArticoloAOrdine PASSED----_");
	}

	private static void testAggiungiArticoloACategoria(ArticoloService articoloService,
			CategoriaService categoriaService) throws Exception {
		System.out.println("-----------testAggiungiArticoloACategoria PASSED----_");

		// Mi predno un ordine e collego i due
		Categoria daCollegare = new Categoria("GGG", "ABZ");
		categoriaService.inserisciNuovo(daCollegare);
		if (daCollegare.getId() < 1)
			throw new RuntimeException();
		// Mi creo un nuovo articolo e lo inserisco
		Articolo daCollegareArt = articoloService.caricaSingoloArticolo(1L);

		// Mi predno un ordine e collego i due

		categoriaService.aggiungiArticolo(daCollegare, daCollegareArt);

		System.out.println("-----------testAggiungiArticoloACategoria PASSED----_");

	}

	private static void testAggiungiCategoriaAArticolo(ArticoloService articoloService,
			CategoriaService categoriaService) throws Exception {
		System.out.println("-----------testAggiungiCategoriaAArticolo PASSED----_");

		// Mi predno un ordine e collego i due
		Categoria daCollegare = categoriaService.caricaSingoloElemento(2L);
		// Mi creo un nuovo articolo e lo inserisco
		Articolo daCollegareArt = articoloService.caricaSingoloArticolo(1L);

		// Mi predno un ordine e collego i due
		articoloService.aggiungiCategoria(daCollegareArt, daCollegare);

		System.out.println("-----------testAggiungiCategoriaAArticolo PASSED----_");

	}

	// TODO TEST RIMUOVI

	private static void testtrovaTuttiOrdiniDataCategoria(OrdineService ordine, CategoriaService categoria) throws Exception {
		System.out.println("-----------testtrovaTuttiOrdiniDataCategoria PASSED----_");

		// Mi predno un ordine e collego i due
		Categoria daCollegare = categoria.caricaSingoloElemento(2L);
		// Mi creo un nuovo articolo e lo inserisco
		

		// Mi predno un ordine e collego i due
		List<Ordine> result = ordine.trovaTuttiDataCategoria(daCollegare);
		
		if(result.size() == 0)
			throw new RuntimeException("ERRORE");
		for(Ordine ordineItem : result)
			System.out.println(ordineItem.getIndirizzoSpedizione());

		System.out.println("-----------testtrovaTuttiOrdiniDataCategoria PASSED----_");

	}

	private static void testTrovaTutteCategorieDatoOrdine(OrdineService ordine, CategoriaService categoria) throws Exception {
		System.out.println("-----------testTrovaTutteCategorieDatoOrdine inizio----_");

		// Mi predno un ordine e collego i due
		Ordine daTrovare = ordine.caricaSingoloElemento(2L);
		// Mi creo un nuovo articolo e lo inserisco
		

		// Mi predno un ordine e collego i due
		List<Categoria> result = categoria.trovaTutteDisinteDatoOrdine(daTrovare);
		
		if(result.size() == 0)
			throw new RuntimeException("ERRORE");
		for(Categoria categoriaItem : result)
			System.out.println(categoriaItem.getDescrizione());

		System.out.println("-----------testTrovaTutteCategorieDatoOrdine PASSED----_");

	}
	
	private static void testTrovaSommaArticoliDataCategoria(ArticoloService articolo, CategoriaService categoria, OrdineService ordine) throws Exception{
		
		System.out.println("_------------testTrovaSommaArticoliDataCategoria------------_");
		Ordine ordineDaInserire = new Ordine("Lucia", "Via Dal Paparazzo", null);
		ordine.inserisciNuovo(ordineDaInserire);
		
		Articolo daInserire = new Articolo();
		daInserire.setNumeroSeriale("HAIHU");
		daInserire.setDescrizione("CARINO");
		daInserire.setPrezzoSingolo(300);
		daInserire.setOrdine(ordineDaInserire);
		
		
		
		//Chiamo mi creo categoria
		Categoria daCollegare = new Categoria("PROVA", "ABZ");
		
		daInserire.getCategorie().add(daCollegare);
		articolo.inserisci(daInserire);
		//Colletgo cateogria a articolo
		
		Integer result = articolo.prendiSommaDataCategoria(daCollegare);
		System.out.println(result);
		
		System.out.println("_------------testTrovaSommaArticoliDataCategoria------------_ PASSED");
	}
	
	private static void testTrovaOrdineConDataSpedizionePiuVicinaDataCategoria(ArticoloService articolo, CategoriaService categoria, OrdineService ordine) throws Exception {
		System.out.println("testTrovaOrdineConDataSpedizionePiuVicinaDataCategoria");
		
		Categoria daCercare = categoria.caricaSingoloElemento(24L);
		
		Ordine result = ordine.trovaOrdineConDataSpedizionePiuVicinaDataCategoria(daCercare);
		
		System.out.println(result);
		
		System.out.println("testTrovaOrdineConDataSpedizionePiuVicinaDataCategoria");
		
		
	
		
	
	}
}
