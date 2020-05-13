package sorts;

public class SortZone extends SortDegat {

	private Portee portee;

	public SortZone(String lNom, int lNiveau, TypeSort lType, int lDe, int lModif, Portee lPortee) {
		super(lNom, lNiveau, lType, lDe, lModif);
		this.setPortee(lPortee);
	}

	public Portee getPortee() {
		return portee;
	}

	public void setPortee(Portee portee) {
		this.portee = portee;
	}

}
