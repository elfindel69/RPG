import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


import equip.Arme;
import equip.Equip;
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
		int i = 0;
		//équipement
		System.out.println(" - équipement:");
		List<String> listNoms1 = listEquip.stream().filter(x -> x.getType() == TypeEquip.Equipement).map(x-> x.getNom()).collect(Collectors.toList());
		for (String nom : listNoms1) {
			System.out.println(i+". "+nom );
			i++;
		}
		System.out.println("---");
		//armement
		System.out.println(" - armement:");
		List<String> listNoms2 = listEquip.stream().filter(x -> x.getType() == TypeEquip.Armement).map(x-> x.getNom()).collect(Collectors.toList());
		for (String nom : listNoms2) {
			System.out.println(i+". "+nom );
			i++;
		}
		System.out.println("---");
		System.out.println(" - potions:");
		List<String> listNoms3 = listEquip.stream().filter(x -> x.getType() == TypeEquip.Potion).map(x-> x.getNom()).collect(Collectors.toList());
		for (String nom : listNoms3) {
			System.out.println(i+". "+nom );
			i++;
		}
		System.out.println("***");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		
		int choice = sc.nextInt();
		return choice;
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
		
		System.out.println(" -------- ");
	}

}
