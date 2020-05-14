package sorts;

/**
 * Sortilèges
 * @author elfindel69
 * @version 0.0.1
 *
 */
public abstract class Sort{
	protected static int sID;
	protected int ID;
	protected String nom;
	protected int niveau;
	protected TypeSort type;
	
	
	public Sort(String lNom, int lNiveau, TypeSort lType) {
		nom = lNom;
		niveau = lNiveau;
		type = lType;
		ID = sID;
		sID++;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public TypeSort getType() {
		return type;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return this.nom;
	}

	


	

}
