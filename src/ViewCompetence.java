import java.util.List;
import java.util.Scanner;

import competence.Competence;
import competence.Habilete;
import competence.Specialisation;
import competence.TypeCompetence;


public class ViewCompetence {
	/**
	 * affichage List de Competence
	 * @param listPersos - liste � afficher
	 */
	static int viewList(Scanner sc, List<Competence> listCompetence, TypeCompetence type) {
		System.out.println("Liste de comp�tences ("+type+")");
		
		for (Competence comp : listCompetence) {
			System.out.println(comp.getID()+". "+comp.getNom());
			
		}
		
		System.out.println("***");
		if(!sc.hasNextLine()) {
			sc.hasNextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	/**
	 * r�cup�ration comp�tence par id
	 * @param id - id � r�cup�rer
	 * @param listEquip - liste � scanner
	 * @return Competence - comp�tence trouv�e
	 */
	static Competence recupCompByID(int ID, List<Competence> listComp) {
		Competence comp = null;
		for (Competence c : listComp) {
			if(c.getID() == ID) {
				comp = c;
				break;
			}
		}
		return comp;
		
	}
	/**
	 * affichage Personnage
	 * @param perso
	 */
	 static void describe (Competence  comp) {
		System.out.println("Comp�tence: ");
		System.out.println("nom: " + comp.getNom());
		System.out.println("type: "+comp.getType());
		System.out.println("niveau: " + comp.getNiveau());
		System.out.println(" -------- ");
	}

	public static int newMenu(Scanner sc) {
		System.out.println("cr�ation comp�tence:");
		System.out.println("1. habilet�...");
		System.out.println("2. sp�cialisation...");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}

	public static Competence createHabilete(Scanner sc, TypeCompetence lType) {
		Competence comp = null;
		System.out.println("nouvel �quipement Magique: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("niveau: ");
		int lNiveau = sc.nextInt();
		
		if (lType == TypeCompetence.Habilete) {
			comp = new Habilete(lNom, lNiveau);
		}
		if (lType == TypeCompetence.Specialisation) {
			comp = new Specialisation(lNom, lNiveau);
		}
		return comp;
	}
	 
}
