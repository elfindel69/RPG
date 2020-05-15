import java.util.List;
import java.util.Scanner;

import competence.Competence;
import competence.TypeCompetence;


public class ViewCompetence {
	/**
	 * affichage List de Competence
	 * @param listPersos - liste à afficher
	 */
	static int viewList(Scanner sc, List<Competence> listCompetence, TypeCompetence type) {
		System.out.println("Liste de compétences ("+type+")");
		
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
	 * récupération compétence par id
	 * @param id - id à récupérer
	 * @param listEquip - liste à scanner
	 * @return Competence - compétence trouvée
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
		System.out.println("Compétence: ");
		System.out.println("nom: " + comp.getNom());
		System.out.println("type: "+comp.getType());
		System.out.println("niveau: " + comp.getNiveau());
		System.out.println(" -------- ");
	}
	 
}
