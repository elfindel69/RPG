package equip;

public class EquipArmure extends Equip {
	
	private int armure;
	
	public EquipArmure() {
		super();
	}
	
	public EquipArmure(String lNom, int lPrix, int lArmure) {
		super(lNom, TypeEquip.Protection, lPrix);
		this.armure = lArmure;
	}

	public int getArmure() {
		return armure;
	}

	public void setArmure(int armure) {
		this.armure = armure;
	}

}
