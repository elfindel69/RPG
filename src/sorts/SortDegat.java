package sorts;

import Utils.Degat;

public class SortDegat extends Sort implements Degat {
	private int De;
	private int modif;
	
	public SortDegat() {
		super();
	}
	
	public SortDegat(String lNom, int lNiveau, TypeSort lType, int lDe, int lModif) {
		super(lNom, lNiveau, lType);
		this.De = lDe;
		this.modif = lModif;
	}
	
	
	public int lancer() {
		return doDegats(De, modif);
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
