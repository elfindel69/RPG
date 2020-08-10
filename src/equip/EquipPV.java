package equip;

public class EquipPV extends Equip {
	
	private int PV;
	
	public EquipPV() {
		super();
	}

	public EquipPV(String lNom, TypeEquip lType, int lPrix, int lPV) {
		super(lNom, lType, lPrix);
		setPV(lPV);
	}

	public int getPV() {
		return PV;
	}

	public void setPV(int pV) {
		PV = pV;
	}

}
