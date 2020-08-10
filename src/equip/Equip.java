package equip;

public class Equip {
	protected static int sID;
	protected int ID;
	protected String nom;
	protected TypeEquip type;
	protected int prix;

	public Equip() {
		ID = sID;
		sID++;
	}
	public Equip(String lNom, TypeEquip lType,int lPrix) {
		nom = lNom;
		type = lType;
		prix = lPrix;
		ID = sID;
		sID++;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeEquip getType() {
		return type;
	}

	public void setType(TypeEquip type) {
		this.type = type;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public int getID() {
		return ID;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}

}
