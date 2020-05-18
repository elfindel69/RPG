import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


import equip.Arme;
import equip.Equip;
import equip.EquipArmure;
import equip.EquipMagique;
import equip.EquipPV;
import equip.TypeEquip;


/**
 * affichage classes Equip
 * @author elfindel69
 * @version 0.0.1
 *
 */
public class ViewEquip {

	public ViewEquip() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * affichage List des Equip
	 * @param listEquip - liste à afficher
	 */
	static int viewList(Scanner sc, List<Equip> listEquip) {
		System.out.println("liste des équipements: ");
	
		//équipement
		System.out.println(" - équipement:");
		List<Equip> listEquip1 = listEquip.stream().filter(x -> x.getType() == TypeEquip.Equipement).collect(Collectors.toList());
		for (Equip equip : listEquip1) {
			System.out.println(equip.getID()+". "+equip.getNom());
		}
		System.out.println("---");
		//armement
		System.out.println(" - armement:");
		List<Equip> listEquip2 = listEquip.stream().filter(x -> x.getType() == TypeEquip.Armement).collect(Collectors.toList());
		for (Equip equip : listEquip2) {
			System.out.println(equip.getID()+". "+equip.getNom());	
		}
		System.out.println("---");
		System.out.println(" - potions:");
		List<Equip> listEquip3 = listEquip.stream().filter(x -> x.getType() == TypeEquip.Potion).collect(Collectors.toList());
		for (Equip equip : listEquip3) {
			System.out.println(equip.getID()+". "+equip.getNom());
		}
		System.out.println("---");
		System.out.println(" - équimement magique:");
		List<Equip> listEquip4 = listEquip.stream().filter(x -> x.getType() == TypeEquip.Magique).collect(Collectors.toList());
		for (Equip equip : listEquip4) {
			System.out.println(equip.getID()+". "+equip.getNom());
		}
		System.out.println("---");
		System.out.println(" - armures:");
		List<Equip> listEquip5 = listEquip.stream().filter(x -> x.getType() == TypeEquip.Protection).collect(Collectors.toList());
		for (Equip equip : listEquip5) {
			System.out.println(equip.getID()+". "+equip.getNom());
		}
		System.out.println("***");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		System.out.println("choix: ");
		int choice = sc.nextInt();
		return choice;
	}
	
	/**
	 * récupération équip par id
	 * @param id - id à récupérer
	 * @param listEquip - liste à scanner
	 * @return Equip - équipement trouvé
	 */
	static Equip recupEquipByID(int ID, List<Equip> listEquip) {
		Equip equip = null;
		for (Equip e : listEquip) {
			if(e.getID() == ID) {
				equip = e;
				break;
			}
		}
		return equip;
		
	}
	/**
	 * menu création
	 * @param sc - Scanner
	 * @return int - menu sélectionné
	 */
	static int newMenu(Scanner sc) {
		System.out.println("création équipement:");
		System.out.println("1. équipement...");
		System.out.println("2. armement...");
		System.out.println("3. potion de vie...");
		System.out.println("4. equipement magique...");
		System.out.println("5. armure...");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		int choice = sc.nextInt();
		return choice;
	}
	
	/**
	 * création Equipement
	 * @param sc - Scanner
	 */
	 static Equip createEquip (Scanner sc) {
		System.out.println("nouvel Equipement: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("prix: ");
		int lPrix = sc.nextInt();
		Equip equip = new Equip(lNom,TypeEquip.Equipement,lPrix);
		return equip;
	}
	 
 	/**
	 * création Armement
	 * @param sc - Scanner
	 */
	 static Arme createArme (Scanner sc) {
		System.out.println("nouvelle Arme: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("prix: ");
		int lPrix = sc.nextInt();
		sc.nextLine();
		System.out.println("Dé: ");
		int lDe = sc.nextInt();
		sc.nextLine();
		System.out.println("modificateur: ");
		int lModif = sc.nextInt();
		return new Arme(lNom, lPrix, lDe, lModif);
	}
	 
	/** création équipement PV
	 * @param sc - Scanner
	 */
	 static EquipPV createEquipPV (Scanner sc) {
		System.out.println("nouvel équipement PV: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("prix: ");
		int lPrix = sc.nextInt();
		System.out.println("type: ");
		System.out.println("3. potion");
		System.out.println("4. magique");
		sc.nextLine();
		int choice = sc.nextInt();
		TypeEquip lType  = TypeEquip.values()[choice];
		System.out.println("PV gagnés: ");
		int lPV = sc.nextInt();
		return new EquipPV(lNom, lType, lPrix, lPV );
	}
	 
	/** création équipement magique
	 * @param sc - Scanner
	 */
	 static EquipMagique createEquipMagique (Scanner sc) {
		System.out.println("nouvel équipement Magique: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("prix: ");
		int lPrix = sc.nextInt();
		System.out.println("type: ");
		System.out.println("3. potion");
		System.out.println("4. magique");
		sc.nextLine();
		int choice = sc.nextInt();
		TypeEquip lType  = TypeEquip.values()[choice];
		sc.nextLine();
		System.out.println("PM gagnés: ");
		int lMana = sc.nextInt();
		return new EquipMagique(lNom, lType, lPrix, lMana);
	}
	 
	 /** création armure
	 * @param sc - Scanner
	 */
	 static EquipArmure createEquipArmure (Scanner sc) {
		System.out.println("nouvel équipement Magique: ");
		System.out.println("nom: ");
		sc.nextLine();
		String lNom = sc.nextLine();
		System.out.println("prix: ");
		int lPrix = sc.nextInt();
		System.out.println("type: ");
		System.out.println("3. potion");
		System.out.println("4. magique");
		sc.nextLine();
		System.out.println("Armure gagnée: ");
		int lArmure = sc.nextInt();
		return new EquipArmure(lNom, lPrix, lArmure);
	}
	
	/**
	 * affichage des Equip
	 * @param equip - équipement à afficher
	 */
	 static void describe(Equip equip) {
		System.out.println("Equipement: ");
		System.out.println("nom: " + equip.getNom());
		System.out.println("type: "+ equip.getType());
		System.out.println("prix: "+ equip.getPrix());
		
		if (equip instanceof Arme) {
			System.out.println(" ------ ");
			System.out.println("Dé: "+ ((Arme) equip).getDe());
			System.out.println("modif: "+ ((Arme) equip).getModif());
		}
		if  (equip instanceof EquipPV) {
			System.out.println(" ------ ");
			System.out.println("gain PV: "+ ((EquipPV) equip).getPV());
		}
		if  (equip instanceof EquipMagique) {
			System.out.println(" ------ ");
			System.out.println("gain mana: "+ ((EquipMagique) equip).getMana());
		}
		if  (equip instanceof EquipArmure) {
			System.out.println(" ------ ");
			System.out.println("gain armure: "+ ((EquipArmure) equip).getArmure());
		}
		System.out.println(" -------- ");
	}

}
