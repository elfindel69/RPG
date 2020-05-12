import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnage p1 = new  Personnage ("TOTO", Sexe.M, "guerrier", Archetype.Guerrier );
		Personnage p2 = new Personnage ("TITI", Sexe.M, "magicien", Archetype.Magicien);
		List<Personnage> listPersos = new ArrayList<Personnage>();
		
		listPersos.add(p1);
		listPersos.add(p2);
		
		listPersos.stream().forEach(Main::describe);
		
		System.out.println(p1.getNom());
		System.out.println("avant achat: ");
		System.out.println("PV: "+p1.getPV());
		System.out.println("argent: "+p1.getArgent());
		Equip e1 = new Equip("Couette", TypeEquip.Equipement,50);
		p1.addEquip(e1);
		EquipPV e2 = new EquipPV("potion de vie", TypeEquip.Equipement, 20, 10);
		p1.addEquip(e2);
		System.out.println("équipement achetés: ");
		p1.getlEquip().stream().forEach(System.out::println);
		int sum = p1.getlEquip().stream().map(x -> x.getPrix()).reduce(0,(x,y) -> x+y);
		System.out.println("total achats: "+sum);
		System.out.println("après achat: ");
		System.out.println("PV: "+p1.getPV());
		System.out.println("argent: "+p1.getArgent());
		
		Sort s1 = new Sort("boule de feu",1,TypeSort.Feu,6,3);
		System.out.println("test boule de feu");
		System.out.println("dégats: "+s1.lancer());
		p1.addSort(s1);
		
		p1.addEquip(new Equip("Beretta", TypeEquip.Armement, 100));
		
		System.out.println("equipement Perso 1");
		p1.getlEquip().stream().filter(x -> x.getType() == TypeEquip.Equipement ).forEach(System.out::println);
	
	}
	
	private static void describe (Personnage perso) {
		System.out.println("Personnage: ");
		System.out.println("nom: " + perso.getNom());
		System.out.println("archetype: "+ perso.getArchetype());
		System.out.println("metier: "+ perso.getMetier());
		System.out.println("corps: "+ perso.getCorps());
		System.out.println("esprit: "+ perso.getEsprit());
		System.out.println("relationnel: "+perso.getRelationnel());
		System.out.println("argent: "+perso.getArgent());
		System.out.println(" ------ ");
	}

}
