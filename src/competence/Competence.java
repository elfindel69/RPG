package competence;

public abstract class Competence {
	protected static int sID;
	protected int ID;
	protected String nom;
	protected int niveau = 0;
	protected TypeCompetence type;
	
	public Competence() {
		this.ID = sID;
		sID++;
	}
	
	public Competence (String lNom, int lNiveau, TypeCompetence lType) {
		this.nom = lNom;
		addNiveau(lNiveau);
		this.type = lType;
		this.ID = sID;
		sID++;
	}

	public String getNom() {
		return nom;
	}

	public int getNiveau() {
		return niveau;
	}
	/**
	 * ajout de niveaux
	 * @param niveau - nb de niveaux à ajouter
	 */
	public void addNiveau(int niveau) {
		if (niveau < 16) {
			this.niveau += niveau;
		}
		else {
			System.out.println("niveau trop élevé");
		}
	}

	public TypeCompetence getType() {
		return type;
	}
	
	public int getID() {
		return this.ID;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}
