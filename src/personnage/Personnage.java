package personnage;
import java.util.ArrayList;
import java.util.List;

import Utils.MyRandom;
import competence.Habilete;
import competence.Specialisation;
import equip.Equip;
import equip.EquipArmure;
import equip.EquipMagique;
import equip.EquipPV;
import sorts.Sort;

/**
 * Classe personnage
 * 
 * @author elfindel69
 * @version 0.0.1
 *
 */
public class Personnage {
	private static int sID;
	private int ID;
	private String nom;
	private Sexe sexe;
	private String metier;
	private Archetype archetype;
	private int niveau = 1;
	private int XP = 0;
	private int mana = 25;
	private int PV = 50;
	private int armure = 0;
	private int corps = 0;
	private int esprit  = 0;
	private int relationnel = 0;
	private int argent = 0;
	private int ptsDestin = 0;
	private int PCHab = 8;
	private int PCSpe = 8;
	private List<Sort> listSorts = new ArrayList<Sort>();
	private List<Equip> listEquip = new ArrayList<Equip>();
	private List<Habilete> listHab = new ArrayList<Habilete>();
	private List<Specialisation> listSpe = new ArrayList<Specialisation>();
	
	public Personnage(String lNom, Sexe lSexe, String lMetier, Archetype lArche) {
		nom = lNom;
		sexe = lSexe;
		metier = lMetier;
		archetype = lArche;
		
		corps = (new MyRandom(0,99)).randomize();
		esprit = (new MyRandom(0,99)).randomize();
		relationnel = (new MyRandom(0,99)).randomize();
		argent = (new MyRandom(500,2000)).randomize();
		
		ptsDestin = (new MyRandom(0,3)).randomize();
		ID = sID;
		sID++;
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Sexe getSexe() {
		return sexe;
	}
	public String getMetier() {
		return metier;
	}
	public void setMetier(String metier) {
		this.metier = metier;
	}
	public Archetype getArchetype() {
		return archetype;
	}
	public void setArchetype(Archetype archetype) {
		this.archetype = archetype;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getXP() {
		return XP;
	}
	public void setXP(int xP) {
		XP = xP;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getPV() {
		return PV;
	}
	public void setPV(int pV) {
		PV = pV;
	}
	public int getCorps() {
		return corps;
	}
	public void setCorps(int corps) {
		this.corps = corps;
	}
	public int getEsprit() {
		return esprit;
	}
	public void setEsprit(int esprit) {
		this.esprit = esprit;
	}
	public int getRelationnel() {
		return relationnel;
	}
	public void setRelationnel(int relationnel) {
		this.relationnel = relationnel;
	}
	public int getArgent() {
		return argent;
	}
	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	public List<Sort> getlSorts() {
		return listSorts;
	}
	/**
	 * ajout de sorts
	 * @param s - Sort à ajouter
	 * @return bool - sort ajouté ?
	 */
	public boolean addSort(Sort s) {
		boolean added = false;
		if (listSorts.size() < 3 + (niveau - 1)) {
			this.listSorts.add(s);
			added = true;
		}
		else {
			System.out.println("liste de sorts pleine!");
		}
		return added;
	}
	
	public List<Equip> getlEquip() {
		return listEquip;
	}
	
	/**
	 * ajout équipement
	 * @param equip - classe Equip à ajouter
	 */
	public void addEquip(Equip equip) {
		if (equip instanceof EquipMagique) {
			mana += ((EquipMagique) equip).getMana();
		}
		if (equip instanceof EquipPV) {
			PV += ((EquipPV) equip).getPV();
		}
		if (equip instanceof EquipArmure) {
			armure += ((EquipArmure) equip).getArmure();
		}
		argent -= equip.getPrix();
		this.listEquip.add(equip);
	}

	public int getID() {
		return ID;
	}

	public int getPtsDestin() {
		return ptsDestin;
	}
	
	/**
	 * ajout de points de destin
	 * @param lptsDestin - nb de pts à ajouter
	 */
	public void addPtsDestin(int lptsDestin) {
		this.ptsDestin += lptsDestin;
	}

	public int getPCHab() {
		return PCHab;
	}
	
	/**
	 * ajout de pts d'habileté
	 * @param lPCHab - nb de pts à ajouter
	 */
	public void addPCHab(int lPCHab) {
		PCHab += lPCHab;
	}

	public int getPCSpe() {
		return PCSpe;
	}

	/**
	 * ajout de pts de spécialisation
	 * @param lPCSpe - nb de pts à ajouter
	 */
	public void addPCSpe(int lPCSpe) {
		PCSpe += lPCSpe;
	}


	public List<Habilete> getListHab() {
		return listHab;
	}

	/**
	 * ajout habileté
	 * @param lHab - Habilete à ajouter
	 * @return bool - habileté ajoutée ? 
	 */
	public boolean addListHab(Habilete lHab) {
		boolean added = false;
		if (niveau == 1 && listHab.size() <= 3 && PCHab > 0) {
			this.listHab.add(lHab);
			PCHab -= lHab.getNiveau();
			added = true;
		} 
		else if ( niveau == 3 && listHab.size() <= 4 && PCHab >0) {
			this.listHab.add(lHab);
			PCHab -= lHab.getNiveau();
			added = true;
		}
		else if (niveau == 7 && listHab.size() <= 5 && PCHab >0) {
			this.listHab.add(lHab);
			PCHab -= lHab.getNiveau();
			added = true;
		}
		else if (niveau == 12 && listHab.size() <= 6 && PCHab >0) {
			this.listHab.add(lHab);
			PCHab -= lHab.getNiveau();
			added = true;
		}
		else {
			System.out.println("liste d'habiletés pleine!");
		}
		return added;
	}

	public List<Specialisation> getListSpe() {
		return listSpe;
	}

	/**
	 * ajout de spécialisation
	 * @param lSpe - Specialisation à ajouter
	 * @return bool - spé ajoutée ? 
	 */
	public boolean addListSpe(Specialisation lSpe) {
		boolean added  = false;
		if (niveau == 1 && listSpe.size() <= 3 && PCSpe > 0) {
			this.listSpe.add(lSpe);
			PCSpe -= lSpe.getNiveau();
			added = true;
		} 
		else if ( niveau == 2 && listSpe.size() <= 4 && PCSpe >0) {
			this.listSpe.add(lSpe);
			PCSpe -= lSpe.getNiveau();
			added = true;
		}
		else if (niveau == 5 && listSpe.size() <= 5 && PCSpe >0) {
			this.listSpe.add(lSpe);
			PCSpe -= lSpe.getNiveau();
			added = true;
		}
		else if (niveau == 10 && listSpe.size() <= 6 && PCSpe >0) {
			this.listSpe.add(lSpe);
			PCSpe -= lSpe.getNiveau();
			added = true;
		}
		else {
			System.out.println("liste de spécilisations pleine!");
		}
		return added;
	}

	public int getArmure() {
		return armure;
	}

	public void setArmure(int armure) {
		this.armure = armure;
	}

	

}
