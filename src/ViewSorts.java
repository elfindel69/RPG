import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import sorts.Portee;
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

	/**
	 * affichage de liste Sorts
	 * @param sc - Scanner
	 * @param listSorts - liste des sorts
	 * @return int - sort choisi (ID)
	 */
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
		System.out.println(" - terre:");
		List<Sort> listSorts4 = listSorts.stream().filter(x -> x.getType() == TypeSort.Terre).collect(Collectors.toList());
		for (Sort sort : listSorts4) {
			System.out.println(sort.getID()+". "+sort.getNom() );
		}
		System.out.println("---");
		System.out.println(" - air:");
		List<Sort> listSorts5 = listSorts.stream().filter(x -> x.getType() == TypeSort.Air).collect(Collectors.toList());
		for (Sort sort : listSorts5) {
			System.out.println(sort.getID()+". "+sort.getNom() );
		}
		System.out.println("---");
		System.out.println(" - nature:");
		List<Sort> listSorts6 = listSorts.stream().filter(x -> x.getType() == TypeSort.Nature).collect(Collectors.toList());
		for (Sort sort : listSorts6) {
			System.out.println(sort.getID()+". "+sort.getNom() );
		}
		System.out.println("---");
		System.out.println(" - mort:");
		List<Sort> listSorts7 = listSorts.stream().filter(x -> x.getType() == TypeSort.Mort).collect(Collectors.toList());
		for (Sort sort : listSorts7) {
			System.out.println(sort.getID()+". "+sort.getNom() );
		}
		System.out.println("---");
		System.out.println(" - vie:");
		List<Sort> listSorts8 = listSorts.stream().filter(x -> x.getType() == TypeSort.Vie).collect(Collectors.toList());
		for (Sort sort : listSorts8) {
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
	 * menu cr�ation
	 * @param sc - Scanner
	 * @return int - menu s�lectionn�
	 */
	static int newMenu(Scanner sc) {
		System.out.println("cr�ation sort:");
		System.out.println("1. sort de d�g�ts...");
		System.out.println("2. sort de port�e...");
		System.out.println("3. sort de zone...");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	private static TypeSort chooseType(Scanner sc) {
		System.out.println("type");
		System.out.println("0. Feu");
		System.out.println("1. Eau");
		System.out.println("2. Terre");
		System.out.println("3. Air");
		System.out.println("4. Nature");
		System.out.println("5. Energie");
		System.out.println("6. Mort");
		System.out.println("7. Vie");
		int choice = sc.nextInt();
		TypeSort lType = TypeSort.values()[choice];
		return lType;
	}
	
	/**
	 * cr�ation SortDegat
	 * @param sc - Scanner
	 * @return SortDegat - sort cr��
	 */
	 static SortDegat createSortDegat (Scanner sc) {
		System.out.println("nouvel sort de d�g�ts: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("niveau: ");
		int lNiveau = sc.nextInt();
		sc.nextLine();
		TypeSort lType= chooseType(sc);
		sc.nextLine();
		System.out.println("D�: ");
		int lDe = sc.nextInt();
		sc.nextLine();
		System.out.println("modificateur: ");
		int lModif = sc.nextInt();
		return new SortDegat(lNom,lNiveau,lType,lDe,lModif);
	}
	 
	/**
	 * cr�ation SortPortee
	 * @param sc - Scanner
	 * @return SortPortee - sort cr��
	 */
	static SortPortee createSortPortee(Scanner sc) {
		System.out.println("nouvel sort de d�g�ts: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("niveau: ");
		int lNiveau = sc.nextInt();
		sc.nextLine();
		TypeSort lType= chooseType(sc);
		sc.nextLine();	
		System.out.println("port�e: ");
		System.out.println("0. Faible: ");
		System.out.println("1. Moyenne: ");
		System.out.println("2. Eloignee: ");
		int choice = sc.nextInt();
		Portee lPortee = Portee.values()[choice];
		return new SortPortee(lNom,lNiveau,lType, lPortee);
		}
	 
	/**
	 * cr�ation SortZone
	 * @param sc - Scanner
	 * @return SortZone - sort cr��
	 */
	 static SortZone createSortZone (Scanner sc) {
		System.out.println("nouvel sort de d�g�ts: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("niveau: ");
		int lNiveau = sc.nextInt();
		sc.nextLine();
		TypeSort lType= chooseType(sc);
		sc.nextLine();
		System.out.println("D�: ");
		int lDe = sc.nextInt();
		sc.nextLine();
		System.out.println("modificateur: ");
		int lModif = sc.nextInt();
		sc.nextLine();	
		System.out.println("port�e: ");
		System.out.println("0. Faible: ");
		System.out.println("1. Moyenne: ");
		System.out.println("2. Eloignee: ");
		int choice = sc.nextInt();
		Portee lPortee = Portee.values()[choice];
		return new SortZone(lNom,lNiveau,lType,lDe,lModif, lPortee);
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
