import java.util.List;

import equip.Arme;
import equip.Equip;
import equip.EquipMagique;
import equip.EquipPV;

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
	 * @param listEquip - liste � afficher
	 */
	static void viewList(List<Equip> listEquip) {
		System.out.println("liste des �quipements");
		listEquip.stream().forEach(ViewEquip::describe);
		System.out.println("***");
	}
	
	/**
	 * affichage des Equip
	 * @param equip - �quipement � afficher
	 */
	private static void describe(Equip equip) {
		System.out.println("Equipement: ");
		System.out.println("nom: " + equip.getNom());
		System.out.println("type: "+ equip.getType());
		System.out.println("prix: "+ equip.getPrix());
		
		if (equip instanceof Arme) {
			System.out.println(" ------ ");
			System.out.println("D�: "+ ((Arme) equip).getDe());
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
