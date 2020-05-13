import java.util.List;

import sorts.Sort;

/**
 * affichage des Sorts
 * @author elfindel69
 * @version 0.0.1
 *
 */
public class ViewSorts {

	public ViewSorts() {
		// TODO Auto-generated constructor stub
	}
	static void viewList(List<Sort> listSorts) {
		System.out.println("liste des sorts");
		listSorts.stream().forEach(ViewSorts::describe);
		System.out.println("***");
	}


	/**
	 * affichage d'un Sort
	 * @param sort - sort à afficher
	 */
	private static void describe(Sort sort) {
		System.out.println("Sort: ");
		System.out.println("nom: " + sort.getNom());
		System.out.println("type: "+ sort.getType());
		System.out.println("niveau: "+ sort.getNiveau());
		System.out.println(" ------ ");
		System.out.println("Dé: "+ sort.getDe());
		System.out.println("modif: "+ sort.getModif());
		System.out.println(" -------- ");

	}
}
