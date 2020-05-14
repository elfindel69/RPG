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
		System.out.println("***");
		if (! sc.hasNextLine()) {
			sc.nextLine();
		}
		
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
