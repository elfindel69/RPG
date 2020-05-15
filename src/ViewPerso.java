import java.util.List;
import java.util.Scanner;

import personnage.Archetype;
import personnage.Personnage;
import personnage.Sexe;

/**
 * classe d'affichage console des Personnages
 * @author elfindel69
 * @version 0.0.1
 *
 */
public class ViewPerso {
	
	/**
	 * affichage List de Personnage
	 * @param listPersos - liste à afficher
	 */
	static int viewList(Scanner sc, List<Personnage> listPersos) {
		System.out.println("Liste de personnages");
		
		for (Personnage perso : listPersos) {
			System.out.println(perso.getID()+". "+perso.getNom());
			
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
		System.out.println("pts de destin: "+perso.getPtsDestin());
		System.out.println("PC habiletés: "+perso.getPCHab());
		System.out.println("PC spés: "+perso.getPCSpe());
		//équipement
		if (perso.getlEquip().size() > 0) {
			System.out.println(" ----- ");
			System.out.println("Equipement: ");
			perso.getlEquip().stream().forEach(System.out::println);
		}
		//sorts
		if (perso.getlSorts().size() > 0) {
			System.out.println(" ----- ");
			System.out.println("Sorts: ");
			perso.getlSorts().stream().forEach(System.out::println);
		}
		//habiletés
		if (perso.getListHab().size() > 0) {
			System.out.println(" ----- ");
			System.out.println("Habiletés: ");
			perso.getListHab().stream().forEach(System.out::println);
		}
		//spés
		if (perso.getListSpe().size() > 0) {
			System.out.println(" ----- ");
			System.out.println("Spés: ");
			perso.getListSpe().stream().forEach(System.out::println);
		}
		System.out.println(" -------- ");
	}
	 
	 	/**
		 * affichage Personnage
		 * @param perso
		 */
		 static Personnage create (Scanner sc) {
			System.out.println("nouveau Personnage: ");
			System.out.println("nom: ");
			sc.nextLine();
			String lNom = sc.nextLine();
			System.out.println("sexe: 0 (M) / 1 (F)");
			int choiceSexe = sc.nextInt();
			Sexe lSexe =Sexe.values()[choiceSexe];
			System.out.println("archetype: ");
			System.out.println("0. rogue");
			System.out.println("1. guerrier");
			System.out.println("2. magicien");
			sc.nextLine();
			int choiceArche = sc.nextInt();
			Archetype lArche  = Archetype.values()[choiceArche];
			System.out.println("metier: ");
			sc.nextLine();
			String lMetier = sc.nextLine();
			
			return new Personnage(lNom,lSexe,lMetier,lArche);
			
		}

}
