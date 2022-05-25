package it.prova.gestioneordini.test;

import it.prova.gestioneordini.dao.EntityManagerUtil;
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
	
	

}

















