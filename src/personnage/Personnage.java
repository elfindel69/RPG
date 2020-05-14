package personnage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import equip.Equip;
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
	private int corps = 0;
	private int esprit  = 0;
	private int relationnel = 0;
	private int argent = 0;
	private List<Sort> lSorts = new ArrayList<Sort>();
	private List<Equip> lEquip = new ArrayList<Equip>();
	
	public Personnage(String lNom, Sexe lSexe, String lMetier, Archetype lArche) {
		nom = lNom;
		sexe = lSexe;
		metier = lMetier;
		archetype = lArche;
		
		corps = ThreadLocalRandom.current().nextInt(0, 100);
		esprit = ThreadLocalRandom.current().nextInt(0, 100);
		relationnel = ThreadLocalRandom.current().nextInt(0, 100);
		argent = ThreadLocalRandom.current().nextInt(500, 2000);
		
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
		return lSorts;
	}
	public void addSort(Sort s) {
		this.lSorts.add(s);
	}
	
	public List<Equip> getlEquip() {
		return lEquip;
	}
	public void addEquip(Equip equip) {
		if (equip instanceof EquipMagique) {
			mana += ((EquipMagique) equip).getMana();
		}
		if (equip instanceof EquipPV) {
			PV += ((EquipPV) equip).getPV();
		}
		argent -= equip.getPrix();
		this.lEquip.add(equip);
	}

	public int getID() {
		return ID;
	}

}
