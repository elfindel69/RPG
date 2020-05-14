import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import equip.Arme;
import equip.Equip;
import equip.EquipMagique;
import equip.EquipPV;
import equip.TypeEquip;
import personnage.Archetype;
import personnage.Personnage;
import personnage.Sexe;
import sorts.Portee;
import sorts.Sort;
import sorts.SortDegat;
import sorts.SortPortee;
import sorts.SortZone;
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
		EquipPV e2 = new EquipPV("potion de vie", TypeEquip.Potion, 20, 10);
		EquipMagique e3 = new EquipMagique("potion de mana", TypeEquip.Potion, 20, 10);
		Arme a1 = new Arme("Beretta", 100, 6, 3);
		Arme a2 = new Arme("Dague",50,4,2);
		listEquip.add(e1);
		listEquip.add(a1);
		listEquip.add(a2);
		listEquip.add(e2);
		listEquip.add(e3);
		
		//ajout équipement - perso p1
		p1.addEquip(e1);
		p1.addEquip(e2);
		p1.addEquip(e3);
		p1.addEquip(a1);
		//ajout equipement - perso p2
		p2.addEquip(a2);
		p2.addEquip(e2);
		p2.addEquip(e3);
		
		//sorts
		SortDegat s1 = new SortDegat("boule de feu",1,TypeSort.Feu,6,3);
		SortZone s2 = new SortZone("éclair en chaine",1,TypeSort.Energie,6,3,Portee.Faible);
		SortDegat s3 = new SortDegat("rayon de givre",1,TypeSort.Eau,6,3);
		SortPortee s4 = new SortPortee("lumière dansante",1,TypeSort.Energie,Portee.Moyenne);
		SortPortee s5 = new SortPortee("main de mage",1,TypeSort.Energie,Portee.Faible);
		listSorts.add(s3);
		listSorts.add(s2);
		listSorts.add(s5);
		listSorts.add(s4);
		listSorts.add(s1);
		
		//ajout sorts - perso p1
		p1.addSort(s1);
		//ajout sorts - perso p2
		p2.addSort(s2);
		
		char exit = 'n';
		Scanner sc = new Scanner(System.in);
		do { 
			//menu principal
			int startMenu = ViewMenu.startMenu(sc);
			//affichage
			if (startMenu == 1) {
				int affMenu = ViewMenu.viewMenu(sc);
				//affichage des persos
				if (affMenu == 1) {	
					int choice = ViewPerso.viewList(sc, listPersos);
					Personnage perso = listPersos.get(choice);
					ViewPerso.describe(perso);
				} 
				//affichage des équipements
				else if (affMenu == 2) {
					int choice = ViewEquip.viewList(sc, listEquip);
					Equip equip = listEquip.get(choice);
					ViewEquip.describe(equip);
				}
				//affichage des sorts
				else if (affMenu == 3) {
					int choice = ViewSorts.viewList(sc, listSorts);
					Sort sort = listSorts.get(choice);
					ViewSorts.describe(sort);
				}
			}
			//ajout équipement / sorts
			else if (startMenu == 2) {
				System.out.println("personnage à modifier:");
				int choice = ViewPerso.viewList(sc, listPersos);
				Personnage perso = listPersos.get(choice);
				int menuEquip = ViewMenu.editMenu(sc);
				//équipement
				if (menuEquip == 1) {
					char goMenu = 'n';
					List <Equip> listAchats = new ArrayList<Equip>();
					do {
						int choiceEquip = ViewEquip.viewList(sc, listEquip);
						Equip equip = listEquip.get(choiceEquip);
						perso.addEquip(equip);
						listAchats.add(equip);
						goMenu = ViewMenu.editMenuEnd(sc, equip.getNom());
					} while (goMenu != 'y');
					//somme des achats
					int sum = listAchats.stream().map(x -> x.getPrix()).reduce(0,(x,y) -> x+y);
					System.out.println("total achats: "+sum);
				}
				//sorts
				else if (menuEquip == 2) {
					char goMenu = 'n';
					do {
						int choiceSorts = ViewSorts.viewList(sc, listSorts);
						Sort sort = listSorts.get(choiceSorts);
						perso.addSort(sort);
						goMenu = ViewMenu.editMenuEnd(sc, sort.getNom());
					} while (goMenu != 'y');
				}
			}
			
			sc.nextLine();
			
			System.out.println("Quitter ? y/n");
			String sexit = sc.nextLine();
			exit = sexit.charAt(0);
		}while (exit != 'y');
		sc.close();
		
		
		
		
	
	}

}
