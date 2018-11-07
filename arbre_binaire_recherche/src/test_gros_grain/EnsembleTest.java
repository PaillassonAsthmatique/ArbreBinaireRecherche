package test_gros_grain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.NoeudRacineNonSupprimable;
import exceptions.ValeurDejaPresente;
import exceptions.ValeurNonTrouve;
import gros_grain.EnsembleGrosGrain;

class EnsembleGrosGrainTest {

	private EnsembleGrosGrain arbre;
	
	@BeforeEach
	public void beforeEach() {
		arbre = new EnsembleGrosGrain(10);
		try {
			arbre.inserer(11);
			arbre.inserer(9);
			arbre.inserer(8);
			arbre.inserer(6);
			arbre.inserer(7);
			arbre.inserer(13);
		} catch (ValeurDejaPresente e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsererValeursValides() {
		try {
			
			assertEquals(8, arbre.getNoeudRacine().getNoeudInferieur().getNoeudInferieur().getValeur());
			assertEquals(11, arbre.getNoeudRacine().getNoeudSuperieur().getValeur());
			assertEquals(13, arbre.getNoeudRacine().getNoeudSuperieur().getNoeudSuperieur().getValeur());
			assertEquals(9, arbre.getNoeudRacine().getNoeudInferieur().getValeur());
			assertEquals(6, arbre.getNoeudRacine().getNoeudInferieur().getNoeudInferieur().getNoeudInferieur().getValeur());
			assertEquals(7, arbre.getNoeudRacine().getNoeudInferieur().getNoeudInferieur().getNoeudInferieur().getNoeudSuperieur().getValeur());
			assertEquals(null, arbre.getNoeudRacine().getNoeudInferieur().getNoeudSuperieur());
			assertEquals(null, arbre.getNoeudRacine().getNoeudSuperieur().getNoeudInferieur());

		} catch (Exception e) {
			e.printStackTrace();
			fail("Le test ne doit pas lever l'exception");
		}
	}
	
	@Test 
	public void testSupprimerNoeudRacine() {
		
		try {
			arbre.supprimer(10);
			fail("Le test doit retourner l'exception NoeudRacineNonSupprimable");	
		}catch(NoeudRacineNonSupprimable e) {
			assert(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail("Le test doit retourner l'exception NoeudRacineNonSupprimable");
		}
	}
	
	@Test
	public void testSupprimerValeurNonTrouve() {
		try {				
			arbre.supprimer(14);		
		}catch(ValeurNonTrouve e) {
			assert(true);
		}catch(Exception e) {
			e.printStackTrace();
			fail("Le test doit retourner l'exception ValeurNonTrouve");
		}
	}
	
	@Test
	public void testSupprimerNoeudQuelconque() {

		try {	
			arbre.supprimer(13);
			arbre.supprimer(6);
			
			assertEquals(null, arbre.getNoeudRacine().getNoeudInferieur().getNoeudInferieur().getNoeudInferieur());
			assertEquals(null, arbre.getNoeudRacine().getNoeudSuperieur().getNoeudSuperieur());
			
		}catch (Exception e) {
			e.printStackTrace();
			fail("Le test ne doit pas retourner d'exception");
		}
		
	}
	
	@Test
	public void testContientValeurPresente() {
		assertEquals(true, arbre.contient(10));
		assertEquals(true, arbre.contient(13));
		assertEquals(true, arbre.contient(11));
		assertEquals(true, arbre.contient(9));
		assertEquals(true, arbre.contient(8));
		assertEquals(true, arbre.contient(7));
		assertEquals(true, arbre.contient(6));
	}
	
	@Test 
	public void testContientValeurNonPresente() {
		assertEquals(false, arbre.contient(1), "test contient 1");
		assertEquals(false, arbre.contient(14), "test contient 14");
	}
}
