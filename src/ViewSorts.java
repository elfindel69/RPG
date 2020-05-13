import java.util.List;

import sorts.Sort;
import sorts.SortDegat;
import sorts.SortPortee;
import sorts.SortZone;

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
		System.out.println(" --- ");
		if (sort instanceof SortDegat) {
			System.out.println("Dé: "+ ((SortDegat) sort).getDe());
			System.out.println("modif: "+ ((SortDegat) sort).getModif());
		}
		if (sort instanceof SortPortee) {
			System.out.println("Portée: "+ ((SortPortee) sort).getPortee());
		}
		if (sort instanceof SortZone) {
			System.out.println("Dé: "+ ((SortZone) sort).getDe());
			System.out.println("modif: "+ ((SortZone) sort).getModif());
			System.out.println("Portée: "+ ((SortZone) sort).getPortee());
		}
		System.out.println("------");
		

	}
}
