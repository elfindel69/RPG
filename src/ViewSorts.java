import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import sorts.Sort;
import sorts.SortDegat;
import sorts.SortPortee;
import sorts.SortZone;
import sorts.TypeSort;

/**
 * affichage des Sorts
 * @author elfindel69
 * @version 0.0.1
 *
 */
public class ViewSorts {

	
	static int viewList(Scanner sc, List<Sort> listSorts) {
		int i = 0;
		System.out.println("liste des sorts");
		//eau
		System.out.println(" - eau:");
		List<String> listNoms1 = listSorts.stream().filter(x -> x.getType() == TypeSort.Eau).map(x-> x.getNom()).collect(Collectors.toList());
		for (String nom : listNoms1) {
			System.out.println(i+". "+nom );
			i++;
		}
		System.out.println("---");
		//énergie
		System.out.println(" - énergie:");
		List<String> listNoms2 = listSorts.stream().filter(x -> x.getType() == TypeSort.Energie).map(x-> x.getNom()).collect(Collectors.toList());
		for (String nom : listNoms2) {
			System.out.println(i+". "+nom );
			i++;
		}
		System.out.println("---");
		System.out.println(" - feu:");
		List<String> listNoms3 = listSorts.stream().filter(x -> x.getType() == TypeSort.Feu).map(x-> x.getNom()).collect(Collectors.toList());
		for (String nom : listNoms3) {
			System.out.println(i+". "+nom );
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
	 * affichage d'un Sort
	 * @param sort - sort à afficher
	 */
	 static void describe(Sort sort) {
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
			System.out.println("Portée: "+ ((SortZone) sort).getPortee());
		}
		System.out.println("------");
		

	}
}
