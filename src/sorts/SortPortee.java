package sorts;

public class SortPortee extends Sort {

	private Portee portee;
	
	public SortPortee() {
		super();
	}
	
	public SortPortee(String lNom, int lNiveau, TypeSort lType, Portee lPortee) {
		super(lNom, lNiveau, lType);
		this.setPortee(lPortee);
	}
	
	public Portee getPortee() {
		return portee;
	}
	public void setPortee(Portee portee) {
		this.portee = portee;
	}

}
