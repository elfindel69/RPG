/**
 * Sortilèges
 * @author elfindel69
 * @version 0.0.1
 *
 */
public class Sort implements Degat{
	private String nom;
	private int niveau;
	private TypeSort type;
	private int De;
	private int modif;
	
	public Sort(String lNom, int lNiveau, TypeSort lType, int lDe, int lModif) {
		nom = lNom;
		niveau = lNiveau;
		type = lType;
		De = lDe;
		modif = lModif;
		
	}
	
	public int lancer() {
		return doDegats(De, modif);
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

	public int getDe() {
		return De;
	}

	public void setDe(int de) {
		De = de;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	
	

	


	

}
