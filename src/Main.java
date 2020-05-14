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
		listEquip.add(e1);
		EquipPV e2 = new EquipPV("potion de vie", TypeEquip.Potion, 20, 10);
		listEquip.add(e2);
		EquipMagique e3 = new EquipMagique("potion de mana", TypeEquip.Potion, 20, 10);
		listEquip.add(e3);
		Arme a1 = new Arme("Beretta", 100, 6, 3);
		listEquip.add(a1);
		Arme a2 = new Arme("Dague",50,4,2);
		listEquip.add(a2);
		
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
		listSorts.add(s1);
		SortZone s2 = new SortZone("éclair en chaine",1,TypeSort.Energie,6,3,Portee.Faible);
		listSorts.add(s2);
		SortDegat s3 = new SortDegat("rayon de givre",1,TypeSort.Eau,6,3);
		listSorts.add(s3);
		SortPortee s4 = new SortPortee("lumière dansante",1,TypeSort.Energie,Portee.Moyenne);
		listSorts.add(s4);
		SortPortee s5 = new SortPortee("main de mage",1,TypeSort.Energie,Portee.Faible);
		listSorts.add(s5);
		
		//ajout sorts - perso p1
		p1.addSort(s1);
		//ajout sorts - perso p2
		p2.addSort(s2);
		
		char exit = 'n';
		Scanner sc = new Scanner(System.in);
		do { 
			//menu principal
			System.out.println("Menu:");
			System.out.println("1. affichage...");
			System.out.println("2. ajout...");
			int startMenu = sc.nextInt();
			//affichage
			if (startMenu == 1) {
				System.out.println("Menu affichage:");
				System.out.println("1. liste des personnages...");
				System.out.println("2. liste des équipements...");
				System.out.println("3. liste des sorts...");
				sc.nextLine();
				int affMenu = sc.nextInt();
				//affichage des persos
				if (affMenu == 1) {	
					ViewPerso.viewList(listPersos);
				} 
				//affichage des équipements
				else if (affMenu == 2) {
					ViewEquip.viewList(listEquip);
				}
				//affichage des sorts
				else if (affMenu == 3) {
					ViewSorts.viewList(listSorts);
				}
			}
			//ajout équipement / sorts
			else if (startMenu == 2) {
				System.out.println("personnage à modifier:");
				int i = 0;
				for (Personnage perso : listPersos ) {
					System.out.println(i+". "+perso.getNom());
					i++;
				}
				sc.nextLine();
				int choice = sc.nextInt();
				Personnage perso = listPersos.get(choice);
				System.out.println("éditer: ");
				System.out.println("1. équipement");
				System.out.println("2. sorts");
				sc.nextLine();
				int menuEquip = sc.nextInt();
				
				if (menuEquip == 1) {
					char goMenu = 'n';
					List <Equip> listAchats = new ArrayList<Equip>();
					do {
						System.out.println("liste des équipements:");
						int j = 0;
						for (Equip equip : listEquip ) {
							System.out.println(j+". "+equip.getNom());
							j++;
						}
						if (! sc.hasNextLine()) {
							sc.nextLine();
						}
						
						int choiceEquip = sc.nextInt();
						Equip equip = listEquip.get(choiceEquip);
						perso.addEquip(equip);
						listAchats.add(equip);
						System.out.println("équipement "+ equip.getNom()+" ajouté !");
						System.out.println("Retour au menu principal ? y/n");
						sc.nextLine();
						String sexit = sc.nextLine();
						goMenu = sexit.charAt(0);
					} while (goMenu != 'y');
					int sum = listAchats.stream().map(x -> x.getPrix()).reduce(0,(x,y) -> x+y);
					System.out.println("total achats: "+sum);
				}
			}
			if (! sc.hasNextLine()) {
				sc.nextLine();
			}
			System.out.println("Quitter ? y/n");
			String sexit = sc.nextLine();
			exit = sexit.charAt(0);
		}while (exit != 'y');
		sc.close();
		
		//test sort s1
		/*System.out.println("test boule de feu");
		System.out.println("dégats: "+s1.lancer());*/
		
		
	
	}

}
