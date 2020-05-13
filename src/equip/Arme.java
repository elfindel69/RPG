package equip;
import Utils.Degat;

public class Arme extends Equip implements Degat{

	private int de;
	private int modif;

	public Arme(String lNom, int lPrix, int lDe, int lModif) {
		super(lNom, TypeEquip.Armement, lPrix);
		this.de = lDe;
		this.modif = lModif;
		// TODO Auto-generated constructor stub
	}
	
	public int tirer() {
		return doDegats(de, modif);
	}

	public int getDe() {
		return de;
	}

	public void setDe(int de) {
		this.de = de;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

}
