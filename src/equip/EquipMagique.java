package equip;

public class EquipMagique extends Equip {
	
	private int mana;

	public EquipMagique() {
		super();
	}
	
	public EquipMagique(String lNom, TypeEquip lType, int lPrix, int lMana) {
		super(lNom, lType, lPrix);
		mana = lMana;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

}
