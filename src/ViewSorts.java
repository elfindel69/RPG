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
		
		System.out.println("liste des sorts");
		//eau
		System.out.println(" - eau:");
		List<Sort> listSorts1 = listSorts.stream().filter(x -> x.getType() == TypeSort.Eau).collect(Collectors.toList());
		for (Sort sort : listSorts1) {
			System.out.println(sort.getID()+". "+sort.getNom() );
		}
		System.out.println("---");
		//�nergie
		System.out.println(" - �nergie:");
		List<Sort> listSorts2 = listSorts.stream().filter(x -> x.getType() == TypeSort.Energie).collect(Collectors.toList());
		for (Sort sort : listSorts2) {
			System.out.println(sort.getID()+". "+sort.getNom());
		}
		System.out.println("---");
		System.out.println(" - feu:");
		List<Sort> listSorts3 = listSorts.stream().filter(x -> x.getType() == TypeSort.Feu).collect(Collectors.toList());
		for (Sort sort : listSorts3) {
			System.out.println(sort.getID()+". "+sort.getNom() );
		}
		System.out.println("***");
		if(!sc.hasNextLine()) {
			sc.hasNextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}

	/**
	 * r�cup�ration sort par id
	 * @param id - id � r�cup�rer
	 * @param listSorts - liste � scanner
	 * @return Sort - sort trouv�
	 */
	static Sort recupSortByID(int ID, List<Sort> listSorts) {
		Sort sort = null;
		for (Sort s: listSorts) {
			if(s.getID() == ID) {
				sort = s;
				break;
			}
		}
		return sort;
		
	}
	
	
	/**
	 * affichage d'un Sort
	 * @param sort - sort � afficher
	 */
	 static void describe(Sort sort) {
		System.out.println("Sort: ");
		System.out.println("nom: " + sort.getNom());
		System.out.println("type: "+ sort.getType());
		System.out.println("niveau: "+ sort.getNiveau());
		System.out.println(" --- ");
		if (sort instanceof SortDegat) {
			System.out.println("D�: "+ ((SortDegat) sort).getDe());
			System.out.println("modif: "+ ((SortDegat) sort).getModif());
		}
		if (sort instanceof SortPortee) {
			System.out.println("Port�e: "+ ((SortPortee) sort).getPortee());
		}
		if (sort instanceof SortZone) {
			System.out.println("Port�e: "+ ((SortZone) sort).getPortee());
		}
		System.out.println("------");
		

	}
}
