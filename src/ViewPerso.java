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
		System.out.println(" ------ ");
		if (perso.getlEquip().size() > 0) {
			System.out.println("Equipement: ");
			perso.getlEquip().stream().forEach(System.out::println);
			System.out.println(" ------ ");
		}
		if (perso.getlSorts().size() > 0) {
			System.out.println("Sorts: ");
			perso.getlSorts().stream().forEach(System.out::println);
			System.out.println(" ------ ");
		}
	}

}
