import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import competence.Competence;
import competence.Habilete;
import competence.Specialisation;
import competence.TypeCompetence;
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
	
	
	private static void addSorts(Scanner sc, List<Sort> listSorts, Personnage perso) {
		char goMenu = 'n';
		do {
			int choiceSorts = ViewSorts.viewList(sc, listSorts);
			Sort sort = ViewSorts.recupSortByID(choiceSorts, listSorts);
			boolean added = perso.addSort(sort);
			goMenu = ViewMenu.editMenuEnd(sc, sort.getNom(), added, "sort");
		} while (goMenu != 'y');
	}
	
	
	private static void addEquips(Scanner sc, List<Equip> listEquip, Personnage perso) {
		char goMenu = 'n';
		List <Equip> listAchats = new ArrayList<Equip>();
		do {
			int choiceEquip = ViewEquip.viewList(sc, listEquip);
			Equip equip = ViewEquip.recupEquipByID(choiceEquip, listEquip);
			perso.addEquip(equip);
			listAchats.add(equip);
			goMenu = ViewMenu.editMenuEnd(sc, equip.getNom(),true, "équipement");
		} while (goMenu != 'y');
		//somme des achats
		int sum = listAchats.stream().map(x -> x.getPrix()).reduce(0,(x,y) -> x+y);
		System.out.println("total achats: "+sum);
	}
	
	private static void addComps(Scanner sc, List<Competence> listHab, Personnage perso, TypeCompetence type) {
		char goMenu = 'n';
		List <Competence> listAppris = new ArrayList<Competence>();
		do {
			int choiceComp = ViewCompetence.viewList(sc, listHab, type);
			Competence comp = ViewCompetence.recupCompByID(choiceComp, listHab);
			System.out.println("niveau: ");
			int niveau = sc.nextInt();
			comp.addNiveau(niveau - 1);
			boolean added = false;
			if (type == TypeCompetence.Habilete) {
				added = perso.addListHab((Habilete) comp);
			}
			if (type == TypeCompetence.Specialisation) {
				added = perso.addListSpe((Specialisation) comp);
			}
			if (added) {
				listAppris.add(comp);
			}
			goMenu = ViewMenu.editMenuEnd(sc, comp.getNom(),added,type.toString());
		} while (goMenu != 'y');
		//somme des PC
		int sum = listAppris.stream().map(x -> x.getNiveau()).reduce(0,(x,y) -> x+y);
		System.out.println("total PC dépensés: "+sum);
	}

	public static void main(String[] args) {
		
		//listes
		List<Personnage> listPersos = new ArrayList<Personnage>();
		List <Equip> listEquip = new ArrayList<Equip>();
		List <Sort> listSorts = new ArrayList<Sort>();
		List<Competence> listHab = new ArrayList<Competence>();
		List<Competence> listSpe = new ArrayList<Competence>();
		
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
		
		//habiletés
		Habilete h1 = new Habilete("Dextérité",1);
		Habilete h2 = new Habilete("Charisme",1);
		Habilete h3 = new Habilete("Persuasion",1);
		Habilete h4 = new Habilete("Agilité",1);
		listHab.add(h1);
		listHab.add(h2);
		listHab.add(h3);
		listHab.add(h4);
		
		//ajout habiletés - perso p1
		p1.addListHab(new Habilete("Dexterite",3));
		p1.addListHab(new Habilete("Charisme",2));
		p1.addListHab(new Habilete("Persuasion",3));
		//ajout habiletés - perso p2
		p2.addListHab(new Habilete("Charisme",3));
		p2.addListHab(new Habilete("Persuasion",3));
		p2.addListHab(new Habilete("Agilité",2));
		
		//spés
		Specialisation sp1 = new Specialisation("Maitrise des langues",1);
		Specialisation sp2 = new Specialisation("Pilote",1);
		Specialisation sp3 = new Specialisation("Soldat",1);
		Specialisation sp4 = new Specialisation("Soins",1);
		Specialisation sp5 = new Specialisation("Maitrise de l'energie",1);
		Specialisation sp6 = new Specialisation("Maitrise de la dague",1);
		listSpe.add(sp1);
		listSpe.add(sp2);
		listSpe.add(sp3);
		listSpe.add(sp4);
		listSpe.add(sp5);
		listSpe.add(sp6);
		
		//ajout spés - perso p1
		p1.addListSpe(new Specialisation("Pilote",3));
		p1.addListSpe(new Specialisation("Soldat",3));
		p1.addListSpe(new Specialisation("Soins",2));
		//ajout spés - perso p2
		p2.addListSpe(new Specialisation("Maitrise des langues",3));
		p2.addListSpe(new Specialisation("Maitrise de l'energie",3));
		p2.addListSpe(new Specialisation("Soins",2));
		
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
					Equip equip = ViewEquip.recupEquipByID(choice, listEquip);
					ViewEquip.describe(equip);
				}
				//affichage des sorts
				else if (affMenu == 3) {
					int choice = ViewSorts.viewList(sc, listSorts);
					Sort sort = ViewSorts.recupSortByID(choice, listSorts);
					ViewSorts.describe(sort);
				}
				//affichage des habiletés
				else if (affMenu == 4) {
					int choice = ViewCompetence.viewList(sc, listHab, TypeCompetence.Habilete);
					Competence comp = ViewCompetence.recupCompByID(choice, listHab);
					ViewCompetence.describe(comp);
				}
				//affichage des spés
				else if (affMenu == 5) {
					int choice = ViewCompetence.viewList(sc, listSpe, TypeCompetence.Specialisation);
					Competence comp = ViewCompetence.recupCompByID(choice, listSpe);
					ViewCompetence.describe(comp);
				}
			}
			//ajout item
			else if (startMenu == 2) {
				System.out.println("personnage à modifier:");
				int choice = ViewPerso.viewList(sc, listPersos);
				Personnage perso = listPersos.get(choice);
				int menuEquip = ViewMenu.editMenu(sc);
				//équipement
				if (menuEquip == 1) {
					addEquips(sc,listEquip,perso);
				}
				//sorts
				else if (menuEquip == 2) {
					addSorts(sc,listSorts,perso);
				}
				//habileté
				else if (menuEquip == 3) {
					addComps(sc,listHab,perso,TypeCompetence.Habilete);
				}
				//spés
				else if (menuEquip == 4) {
					addComps(sc,listSpe,perso,TypeCompetence.Specialisation);
				}
			}
			//création
			else if (startMenu == 3) {
				int creaMenu = ViewMenu.newMenu(sc);
				//personnage
				if (creaMenu == 1) {
					Personnage newPerso = ViewPerso.create(sc);
					listPersos.add(newPerso);
					addEquips(sc,listEquip,newPerso);
					addSorts(sc,listSorts,newPerso);
					addComps(sc,listHab,newPerso,TypeCompetence.Habilete);
					addComps(sc,listSpe,newPerso,TypeCompetence.Specialisation);
					ViewPerso.describe(newPerso);
				}
				//équipement
				if (creaMenu == 2) {
					int choice = ViewEquip.newMenu(sc);
					Equip newEquip = null;
					//équipement
					if (choice == 1) {
						newEquip = ViewEquip.createEquip(sc);
					}
					//arme
					if (choice == 2) {
						newEquip = ViewEquip.createArme(sc);
					}
					//équip PV
					if (choice == 3) {
						newEquip = ViewEquip.createEquipPV(sc);
					}
					//équip magique
					if (choice == 4) {
						newEquip = ViewEquip.createEquipMagique(sc);
					}
					listEquip.add(newEquip);
				}
				else if (creaMenu == 3) {
					int choice = ViewSorts.newMenu(sc);
					Sort newSort = null;
					//sort de dégâts
					if (choice == 1) {
						newSort = ViewSorts.createSortDegat(sc);
					}
					//sort de portee
					if (choice == 2) {
						newSort = ViewSorts.createSortPortee(sc);
					}
					//sort de zone
					if (choice == 3) {
						newSort = ViewSorts.createSortZone(sc);
					}
					listSorts.add(newSort);
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
