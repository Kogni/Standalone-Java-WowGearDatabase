package Various;


public class Identifier {

	public Recognitions Recognizer;
	
	public Identifier(String unknown) {
		
		//System.out.println("Identifier starting to work");
		Recognizer = new Recognitions();
		
	}
	
	public String FindItemType(String Unknown) {
		
		return Recognizer.LocateItemType(Unknown);

	}

	public String FindItemSlot(String Unknown) {

		return Recognizer.LocateItemSlot(Unknown);
	}

	public String FindItemQuality(String Unknown) {

		return Recognizer.LocateItemQuality(Unknown);
	}

	public String FindItemBind(String Unknown) {

		return Recognizer.LocateItemBind(Unknown);
	}

	public boolean FindItemUnique(String Unknown) {

		return Recognizer.LocateItemUnique(Unknown);
	}

	public int FindItemLvl(String Unknown) {

		return Recognizer.LocateItemLvl(Unknown);
	}

	public int FindItemArmor(String Unknown) {

		return Recognizer.LocateItemArmor(Unknown);
	}

	public int FindItemStamina(String Unknown) {

		return Recognizer.LocateItemStamina(Unknown);
	}

	public int FindItemIntellect(String Unknown) {

		return Recognizer.LocateItemIntellect(Unknown);
	}

	public int FindItemSpirit(String Unknown) {

		return Recognizer.LocateItemSpirit(Unknown);
	}

	public int FindItemAgility(String Unknown) {

		return Recognizer.LocateItemAgility(Unknown);
	}

	public int FindItemStrength(String Unknown) {

		return Recognizer.LocateItemStrength(Unknown);
	}

	public boolean FindItemEffect(String Unknown) {

		return Recognizer.LocateItemEffect(Unknown);
	}

	public int FindItemSpell(String Unknown) {

		return Recognizer.LocateItemSpell(Unknown);
	}

	public int FindItemHaste(String Unknown) {

		return Recognizer.LocateItemHaste(Unknown);
	}

	public int FindItemCrit(String Unknown) {

		return Recognizer.LocateItemCrit(Unknown);
	}

	public int FindItemHit(String Unknown) {

		return Recognizer.LocateItemHit(Unknown);
	}

	public int FindItemAP(String Unknown) {

		return Recognizer.LocateItemAP(Unknown);
	}

	public int FindItemExpR(String Unknown) {

		return Recognizer.LocateItemExpR(Unknown);
	}

	public int FindItemPenetR(String Unknown) {

		return Recognizer.LocateItemPenetR(Unknown);
	}

	public int FindItemMP5(String Unknown) {

		return Recognizer.LocateItemMP5(Unknown);
	}

	public int FindItemSocketY(String Unknown) {

		return Recognizer.LocateItemSocketY(Unknown);
	}

	public int FindItemSocketR(String Unknown) {

		return Recognizer.LocateItemSocketR(Unknown);
	}

	public int FindItemSocketB(String Unknown) {

		return Recognizer.LocateItemSocketB(Unknown);
	}

	public int FindItemSocketM(String Unknown) {

		return Recognizer.LocateItemSocketM(Unknown);
	}

	public int FindItemMinDmg(String Unknown) {

		return Recognizer.LocateItemMinDmg(Unknown);
	}

	public int FindItemMaxDmg(String Unknown) {

		return Recognizer.LocateItemMaxDmg(Unknown);
	}

	public double FindItemSpeed(String Unknown) {

		return Recognizer.LocateItemSpeed(Unknown);
	}

	public String FindItemSocketBonusType(String Unknown) {

		return Recognizer.LocateItemSocketBonusType(Unknown);
	}

	public int FindItemSocketBonusAmount(String Unknown) {

		return Recognizer.LocateItemSocketBonusAmount(Unknown);
	}

	public boolean FindItemClass(String unknown, String Class) {

		return Recognizer.LocateItemClass(unknown, Class);
	}

	public String FindItemProf(String unknown) {

		return Recognizer.LocateItemProf(unknown);
	}

	public boolean CheckGlyph(String unknown) {

		return Recognizer.CheckGlyph(unknown);
	}

	public boolean CheckTankItem(String unknown) {

		return Recognizer.CheckTankitem(unknown);
	}

	public int FindLevelReq(String unknown) {

		//System.out.println( "leter etter lvl req" );
		return Recognizer.LocateLvlReq(unknown);
	}
	
	public boolean IsEquippable(String unknown) {

		return Recognizer.IsEquippable(unknown);
	}
	

}
