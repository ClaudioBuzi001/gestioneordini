package it.prova.gestioneordini.test;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.model.Articolo;
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
		OrdineService ordineServiceInstance	= MyServiceFactory.getOrdineServiceInstance();
		
		try {
			
			//TODO Modificare il file xml con crate
			System.out.println("_-----------Inizio Batteria di Test-----------_");
			
			//testInserimentoOrdine(ordineServiceInstance);
			
			System.out.println(ordineServiceInstance.listaTutti().size());
			
			testAggiornaOrdine(ordineServiceInstance);
			
			//testAggiungiArticoloAOrdine(articoloServiceInstance,ordineServiceInstance);
			
			testRimuoviArticoloAOrdine(articoloServiceInstance,ordineServiceInstance);
			
		
		
		
		
		}catch(Exception e) {
			
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
		
		if(ordineDaInserire.getId() < 1  )
			throw new RuntimeException("testInserimentoOrdine FAILED-----------");
		
		System.out.println("-----------testInserimentoOrdine PASSED----_");
		
		
	}
	
	

	private static void testAggiornaOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("---------------Inizio testAggiornaOrdine----------");
		
		//Ci prendiamo l ordine e lo modifiichiamo
		Ordine ordineDaAggiornare = ordineServiceInstance.caricaSingoloElemento(1L);
		
		ordineDaAggiornare.setIndirizzoSpedizione("VIA San Giuorgio");
		ordineServiceInstance.aggiorna(ordineDaAggiornare);
		
		
		if(!ordineDaAggiornare.getIndirizzoSpedizione().equals("VIA San Giuorgio") )
			throw new RuntimeException("testAggiornaOrdine FAILED-----------");
		
		System.out.println("-----------testAggiornaOrdine PASSED----_");
		
		
	}
	
	private static void testAggiungiArticoloAOrdine(ArticoloService articoloService, OrdineService ordineService) throws Exception{
		System.out.println("-----------testAggiungiArticoloAOrdine PASSED----_");
		
		//Mi predno un ordine e collego i due
		Ordine daCollegare = ordineService.caricaSingoloElemento(1L);
		//Mi creo un nuovo articolo e lo inserisco
		Articolo daInserire = new Articolo();
		daInserire.setNumeroSeriale("HAIHU");
		daInserire.setDescrizione("CARINO");
		daInserire.setOrdine(daCollegare);
		
		articoloService.inserisci(daInserire);
		if(daInserire.getId() < 1)
			throw new RuntimeException("ERRORE ARTICOLO NON ISERITO");
		
		
		//Mi predno un ordine e collego i due
		
		
		ordineService.aggiungiArticolo(daCollegare, daInserire);
		
		
		System.out.println("-----------testAggiungiArticoloAOrdine PASSED----_");
		
	}
	
	
	
	private static void testRimuoviArticoloAOrdine(ArticoloService articoloService, OrdineService ordineService) throws Exception{
		System.out.println("-----------testRimuoviArticoloAOrdine iniziato----_");
		
		//Mi prendo l articolo creato prima 
		Articolo daDissociare = articoloService.caricaSingoloArticolo(1L);
		
		//e l ordine creato prima e li dissocio
		Ordine ordineMaster = ordineService.caricaSingoloElemento(1L);
		
		ordineService.rimuoviArticolo(ordineMaster, daDissociare);
		
		
		System.out.println("-----------testRimuoviArticoloAOrdine PASSED----_");
	}

}

















