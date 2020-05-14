import java.util.List;
import java.util.Scanner;

import personnage.Personnage;

/**
 * classe d'affichage console des Personnages
 * @author elfindel69
 * @version 0.0.1
 *
 */
public class ViewPerso {

	public ViewPerso() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * affichage List de Personnage
	 * @param listPersos - liste � afficher
	 */
	static int viewList(Scanner sc, List<Personnage> listPersos) {
		System.out.println("Liste de personnages");
		int i=0;
		for (Personnage perso : listPersos) {
			System.out.println(i+". "+perso.getNom());
			i++;
		}
		System.out.println("***");
		if(!sc.hasNextLine()) {
			sc.hasNextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	/**
	 * affichage Personnage
	 * @param perso
	 */
	 static void describe (Personnage perso) {
		System.out.println("Personnage: ");
		System.out.println("nom: " + perso.getNom());
		System.out.println("archetype: "+ perso.getArchetype());
		System.out.println("metier: "+ perso.getMetier());
		System.out.println("corps: "+ perso.getCorps());
		System.out.println("esprit: "+ perso.getEsprit());
		System.out.println("relationnel: "+perso.getRelationnel());
		System.out.println("argent: "+perso.getArgent());
		System.out.println("PV: "+perso.getPV());
		System.out.println("XP: "+perso.getXP());
		System.out.println("mana: "+perso.getMana());
		
		if (perso.getlEquip().size() > 0) {
			System.out.println(" ----- ");
			System.out.println("Equipement: ");
			perso.getlEquip().stream().forEach(System.out::println);
		}
		if (perso.getlSorts().size() > 0) {
			System.out.println(" ----- ");
			System.out.println("Sorts: ");
			perso.getlSorts().stream().forEach(System.out::println);
		}
		System.out.println(" -------- ");
	}

}
