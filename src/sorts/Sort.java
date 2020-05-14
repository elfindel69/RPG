package sorts;

/**
 * Sortilèges
 * @author elfindel69
 * @version 0.0.1
 *
 */
public abstract class Sort{
	protected String nom;
	protected int niveau;
	protected TypeSort type;
	
	
	public Sort(String lNom, int lNiveau, TypeSort lType) {
		nom = lNom;
		niveau = lNiveau;
		type = lType;
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

	

	@Override
	public String toString() {
		return this.nom;
	}

	


	

}
