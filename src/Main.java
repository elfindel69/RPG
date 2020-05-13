import java.util.ArrayList;
import java.util.List;

import equip.Arme;
import equip.Equip;
import equip.EquipMagique;
import equip.EquipPV;
import equip.TypeEquip;
import personnage.Archetype;
import personnage.Personnage;
import personnage.Sexe;
import sorts.Sort;
import sorts.TypeSort;

public class Main {

	public static void main(String[] args) {
		
		//listes
		List<Personnage> listPersos = new ArrayList<Personnage>();
		List <Equip> listEquip = new ArrayList<Equip>();
		List <Sort> listSorts = new ArrayList<Sort>();
		
		//personnages
		Personnage p1 = new  Personnage ("TOTO", Sexe.M, "guerrier", Archetype.Guerrier);
		Personnage p2 = new Personnage ("TITI", Sexe.M, "magicien", Archetype.Magicien);
		listPersos.add(p1);
		listPersos.add(p2);
		
		//équipements
		Equip e1 = new Equip("Couette", TypeEquip.Equipement,20);
		listEquip.add(e1);
		EquipPV e2 = new EquipPV("potion de vie", TypeEquip.Potion, 20, 10);
		listEquip.add(e2);
		EquipMagique e3 = new EquipMagique("potion de mana", TypeEquip.Potion, 20, 10);
		listEquip.add(e3);
		Arme a1 = new Arme("Beretta", 100, 6, 3);
		listEquip.add(a1);
		Arme a2 = new Arme("Dague",50,4,2);
		listEquip.add(a2);
		
		//sorts
		Sort s1 = new Sort("boule de feu",1,TypeSort.Feu,6,3);
		listSorts.add(s1);
		Sort s2 = new Sort("éclair en chaine",1,TypeSort.Energie,6,3);
		listSorts.add(s2);
		
		//affichage des persos
		ViewPerso.viewList(listPersos);
		
		//test achat équipements - perso p1
		//affichage avant achats
		System.out.println(p1.getNom());
		System.out.println("avant achat: ");
		System.out.println("PV: "+p1.getPV());
		System.out.println("mana: "+p1.getMana());
		System.out.println("argent: "+p1.getArgent());
		//ajout d'équipement - perso p1
		p1.addEquip(e1);
		p1.addEquip(e2);
		p1.addEquip(e3);
		//calcul somme achats
		System.out.println("équipement achetés: ");
		p1.getlEquip().stream().forEach(System.out::println);
		int sum = p1.getlEquip().stream().map(x -> x.getPrix()).reduce(0,(x,y) -> x+y);
		System.out.println("total achats: "+sum);
		//affichage après achats
		System.out.println("après achat: ");
		System.out.println("PV: "+p1.getPV());
		System.out.println("mana: "+p1.getMana());
		System.out.println("argent: "+p1.getArgent());
		
		//test sort s1
		System.out.println("test boule de feu");
		System.out.println("dégats: "+s1.lancer());
		//ajout sort s1 - perso p1
		p1.addSort(s1);
		//ajout arme a1 - perso p1
		p1.addEquip(a1);
		
		//affichage des potions - perso p1
		System.out.println("potions Perso 1");
		p1.getlEquip().stream().filter(x -> x.getType() == TypeEquip.Potion ).forEach(System.out::println);
		
		//ajout equipement - perso p2
		p2.addEquip(a2);
		p2.addEquip(e2);
		p2.addEquip(e3);
		//ajout sort - perso p2
		p2.addSort(s2);
		
		ViewPerso.viewList(listPersos);
		
		ViewSorts.viewList(listSorts);
		ViewEquip.viewList(listEquip);
	}
	
	

}
