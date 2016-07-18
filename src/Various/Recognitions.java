package Various;

public class Recognitions {
	
	String[] ItemTypes = new String[100];
	String[] ItemSlots = new String[100];
	String[] ItemQualities = new String[20];
	String[] ItemBinds = new String[20];
	double[] ItemSpeeds = new double[30];
	String[] ItemSocketBonusType = new String[20];
	String[] ItemProfession = new String[10];

	public Recognitions() {
		
		MakeItemTypes();
		MakeItemSlots();
		MakeItemQualities();
		MakeItemBinds();
		MakeItemSpeeds();
		MakeSocketBonusTypes();
		MakeItemProfessions();
		
	}
	
	private void MakeItemProfessions() {
		
		int X = 0;
		X++;
		ItemProfession[X] = "Blacksmithing";
		X++;
		ItemProfession[X] = "Weaponsmith";
		X++;
		ItemProfession[X] = "Armorsmith";
		X++;
		ItemProfession[X] = "Engineering";
		
	}

	private void MakeSocketBonusTypes() {
		
		int X = 0;
		X++;
		ItemSocketBonusType[X] = "Intellect";
		X++;
		ItemSocketBonusType[X] = "Stamina";
		X++;
		ItemSocketBonusType[X] = "Spirit";
		X++;
		ItemSocketBonusType[X] = "Spell Power";
		X++;
		ItemSocketBonusType[X] = "Agility";
		X++;
		ItemSocketBonusType[X] = "Strength";
		X++;
		ItemSocketBonusType[X] = "Haste Rating";
		X++;
		ItemSocketBonusType[X] = "Critical Strike Rating";
		X++;
		ItemSocketBonusType[X] = "Hit Rating";
		X++;
		ItemSocketBonusType[X] = "Attack Power";
		X++;
		ItemSocketBonusType[X] = "Expertise Rating";
		X++;
		ItemSocketBonusType[X] = "Penetration Rating";
		X++;
		ItemSocketBonusType[X] = "mana per 5 sec";
		                         //mana per 5 sec
		
	}

	private void MakeItemSpeeds() {
		
		int X = 0;
		X++;
		ItemSpeeds[X] = 1.1;
		X++;
		ItemSpeeds[X] = 1.2;
		X++;
		ItemSpeeds[X] = 1.3;
		X++;
		ItemSpeeds[X] = 1.4;
		X++;
		ItemSpeeds[X] = 1.5;
		X++;
		ItemSpeeds[X] = 1.6;
		X++;
		ItemSpeeds[X] = 1.7;
		X++;
		ItemSpeeds[X] = 1.8;
		X++;
		ItemSpeeds[X] = 1.9;
		X++;
		ItemSpeeds[X] = 2.0;
		X++;
		ItemSpeeds[X] = 2.1;
		X++;
		ItemSpeeds[X] = 2.2;
		X++;
		ItemSpeeds[X] = 2.3;
		X++;
		ItemSpeeds[X] = 2.4;
		X++;
		ItemSpeeds[X] = 2.5;
		X++;
		ItemSpeeds[X] = 2.6;
		X++;
		ItemSpeeds[X] = 2.7;
		X++;
		ItemSpeeds[X] = 2.8;
		X++;
		ItemSpeeds[X] = 2.9;
		X++;
		ItemSpeeds[X] = 3.0;
		X++;
		ItemSpeeds[X] = 3.1;
		X++;
		ItemSpeeds[X] = 3.2;
		X++;
		ItemSpeeds[X] = 3.3;
		X++;
		ItemSpeeds[X] = 3.4;
		X++;
		ItemSpeeds[X] = 3.5;
		X++;
		ItemSpeeds[X] = 3.6;
		X++;
		ItemSpeeds[X] = 3.7;
		X++;
		ItemSpeeds[X] = 3.8;
		X++;
		ItemSpeeds[X] = 3.9;
		
	}

	private void MakeItemBinds() {

		int X = 0;
		X++;
		ItemBinds[X] = "Binds when picked up";
		X++;
		ItemBinds[X] = "Binds when equipped";
		
	}

	private void MakeItemQualities() {
		
		int X = 0;
		X++;
		ItemQualities[X] = "GreyQuality";
		X++;
		ItemQualities[X] = "WhiteQuality";
		X++;
		ItemQualities[X] = "GreenQuality";
		X++;
		ItemQualities[X] = "BlueQuality";
		X++;
		ItemQualities[X] = "PurpleQuality";
		X++;
		ItemQualities[X] = "OrangeQuality";
		
	}

	private void MakeItemTypes() {
		
		int X = 0;
		X++;
		ItemTypes[X] = "Sword";
		X++;
		ItemTypes[X] = "Mace";
		X++;
		ItemTypes[X] = "Axe";
		X++;
		ItemTypes[X] = "Polearm";
		X++;
		ItemTypes[X] = "Dagger";
		X++;
		ItemTypes[X] = "Staff";
		X++;
		ItemTypes[X] = "Shirt";
		X++;
		ItemTypes[X] = "Cloth";
		X++;
		ItemTypes[X] = "Leather";
		X++;
		ItemTypes[X] = "Mail";
		X++;
		ItemTypes[X] = "Plate";
		X++;
		ItemTypes[X] = "Miscellaneous";
		X++;
		ItemTypes[X] = "Wand";
		X++;
		ItemTypes[X] = "Bow";
		X++;
		ItemTypes[X] = "Gun";
		X++;
		ItemTypes[X] = "Crossbow";
		X++;
		ItemTypes[X] = "Totem";
		X++;
		ItemTypes[X] = "Libram";
		X++;
		ItemTypes[X] = "Idol";
		X++;
		ItemTypes[X] = "Sigil";
		X++;
		ItemTypes[X] = "Shield";
		X++;
		ItemTypes[X] = "Throwing";
		X++;
		ItemTypes[X] = "Thrown";

		X++;
		ItemTypes[X] = "Quest Item";
		X++;
		ItemTypes[X] = "Gems";
		X++;
		ItemTypes[X] = "Reagent";
		X++;
		ItemTypes[X] = "Mount";
		X++;
		ItemTypes[X] = "Meat";
		X++;
		ItemTypes[X] = "Cooking";
		X++;
		ItemTypes[X] = "Jewelcrafting";
		X++;
		ItemTypes[X] = "Trade Goods";
		X++;
		ItemTypes[X] = "Enchanting";
		X++;
		ItemTypes[X] = "Alchemy";
		X++;
		ItemTypes[X] = "Other";
		X++;
		ItemTypes[X] = "Tailoring";
		X++;
		ItemTypes[X] = "Engineering";
		X++;
		ItemTypes[X] = "Book";
		X++;
		ItemTypes[X] = "Holiday";
		X++;
		ItemTypes[X] = "Key";
		X++;
		ItemTypes[X] = "First Aid";
		X++;
		ItemTypes[X] = "Herb";
		X++;
		ItemTypes[X] = "Prismatic";
		X++;
		ItemTypes[X] = "Metal & Stone";
		X++;
		ItemTypes[X] = "Red ";
		X++;
		ItemTypes[X] = "Orange ";
		X++;
		ItemTypes[X] = "Yellow ";
		X++;
		ItemTypes[X] = "Green ";
		X++;
		ItemTypes[X] = "Blue ";
		X++;
		ItemTypes[X] = "Purple ";
		X++;
		ItemTypes[X] = "Currency";
		X++;
		ItemTypes[X] = "Ammo Arrow";
		X++;
		ItemTypes[X] = "Ammo Bullet";
		X++;
		ItemTypes[X] = "Devices";
		X++;
		ItemSlots[X] = "Meta";
		
	}
	
	private void MakeItemSlots() {
		
		int X = 0;
		X++;
		ItemSlots[X] = "Main Hand";
		X++;
		ItemSlots[X] = "One-Hand";
		X++;
		ItemSlots[X] = "Held In Hand";
		X++;
		ItemSlots[X] = "Off Hand";
		X++;
		ItemSlots[X] = "Two-Hand";
		X++;
		ItemSlots[X] = "Staff";
		//X++;
		//ItemSlots[X] = "Shirt";
		X++;
		ItemSlots[X] = "Legs";
		X++;
		ItemSlots[X] = "Feet";
		X++;
		ItemSlots[X] = "Chest";
		X++;
		ItemSlots[X] = "Hands";
		X++;
		ItemSlots[X] = "Waist";
		X++;
		ItemSlots[X] = "Bracers";
		X++;
		ItemSlots[X] = "Neck";
		X++;
		ItemSlots[X] = "Shoulder";
		X++;
		ItemSlots[X] = "Trinket";
		X++;
		ItemSlots[X] = "Relic";
		X++;
		ItemSlots[X] = "Wrist";
		X++;
		ItemSlots[X] = "Head";
		X++;
		ItemSlots[X] = "Finger";
		X++;
		ItemSlots[X] = "Back";
		X++;
		ItemSlots[X] = "Thrown";
		
		
	}
	
	public String LocateItemType(String Unknown) {
		
		int Location = -1;
		
		for (int X = 1; X < ItemTypes.length ; X++) {
			if ( ItemTypes[X] != null ) {
				Location = Unknown.indexOf(ItemTypes[X]);
				if ( Location != -1 ) {
					return ItemTypes[X];
				}
			}
		}
		return null;
	}

	public String LocateItemSlot(String Unknown) {
		
		int Location = -1;
		
		for (int X = 1; X < ItemSlots.length ; X++) {
			if ( ItemSlots[X] != null ) {
				Location = Unknown.indexOf(ItemSlots[X]);
				if ( Location != -1 ) {
					return ItemSlots[X];
				}
			}
		}
		return null;
	}

	public String LocateItemQuality(String Unknown) {
		
		int Location = -1;
		
		for (int X = 1; X < ItemQualities.length ; X++) {
			if ( ItemQualities[X] != null ) {
				Location = Unknown.indexOf(ItemQualities[X]);
				if ( Location != -1 ) {
					return ItemQualities[X];
				}
			}
		}
		return null;
	}

	public String LocateItemBind(String Unknown) {
		
		int Location = -1;
		
		for (int X = 1; X < ItemBinds.length ; X++) {
			if ( ItemBinds[X] != null ) {
				Location = Unknown.indexOf(ItemBinds[X]);
				if ( Location != -1 ) {
					return ItemBinds[X];
				}
			}
		}
		return null;
	}

	public boolean LocateItemUnique(String Unknown) {
		
		int Location = -1;
		Location = Unknown.indexOf("Unique");
		if ( Location != -1 ) {
			return true;
		}
		return false;
	}

	public int LocateLvlReq(String unknown) {
		
		int Location = -1;
		for (int X = 10; X <= 80 ; X++) {
			Location = unknown.indexOf("<minlevel>"+X+"</minlevel>");
			                          //Requires Level 70
			if ( Location != -1 ) {
				System.out.println( "fant lvl req: "+X );
				return X;
			}
		}
		return 0;
	}

	public int LocateItemArmor(String unknown) {

		int Location = -1;
		int X = 3000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<armor>"+X+"</armor>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemStamina(String unknown) {

		int Location = -1;
		int X = 2000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<stamina>"+X+"</stamina>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemIntellect(String unknown) {

		int Location = -1;
		int X = 300;
		while ( X > 0 ) {
			Location = unknown.indexOf("<intellect>"+X+"</intellect>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemSpirit(String unknown) {

		int Location = -1;
		int X = 300;
		while ( X > 0 ) {
			Location = unknown.indexOf("<spirit>"+X+"</spirit>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemAgility(String unknown) {

		int Location = -1;
		int X = 300;
		while ( X > 0 ) {
			Location = unknown.indexOf("<agility>"+X+"</agility>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemStrength(String unknown) {

		int Location = -1;
		int X = 300;
		while ( X > 0 ) {
			Location = unknown.indexOf("<strength>"+X+"</strength>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public boolean LocateItemEffect(String unknown) {

		int Location = -1;
		Location = unknown.indexOf("Effect: ");
		if ( Location != -1 ) {
			return true;
		}
		Location = unknown.indexOf("Use: ");
		if ( Location != -1 ) {
			return true;
		}
		return false;
	}

	public int LocateItemSpell(String unknown) {
		
		int Location = -1;
		int X = 1000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<spellpower>"+X+"</spellpower>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemHaste(String unknown) {
		
		int Location = -1;
		int X = 1000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<hasterating>"+X+"</hasterating>");
			                          //Improves haste rating by 36
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemCrit(String unknown) {
		
		int Location = -1;
		int X = 1000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<critrating>"+X+"</critrating>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}
		X = 1000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<critrating>"+X+"</critrating>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemHit(String unknown) {
		
		int Location = -1;
		int X = 1000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<hitrating>"+X+"</hitrating>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}
		X = 1000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<hitrating>"+X+"</hitrating>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemAP(String unknown) {
		
		int Location = -1;
		int X = 1000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<attackpower>"+X+"</attackpower>");
			                          //Increases attack power by 126.
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemExpR(String unknown) {
		
		int Location = -1;
		int X = 100;
		while ( X > 0 ) {
			Location = unknown.indexOf("<expertiserating>"+X+"</expertiserating>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemPenetR(String unknown) {
		
		int Location = -1;
		int X = 100;
		while ( X > 0 ) {
			Location = unknown.indexOf("Increases armor penetration rating by "+X);
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemMP5(String unknown) {
		
		int Location = -1;
		int X = 100;
		while ( X > 0 ) {
			Location = unknown.indexOf("<manaregen>"+X+"</manaregen>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemSocketY(String unknown) {
		
		for ( int X = 1 ; X < 4 ; X++ ) {
			if ( unknown.indexOf("<s_yellow>"+X+"</s_yellow>") > -1) {
				return X;
			}
		}

		return 0;
	}

	public int LocateItemSocketR(String unknown) {
		
		for ( int X = 1 ; X < 4 ; X++ ) {
			if ( unknown.indexOf("<s_red>"+X+"</s_red>") > -1) {
				return X;
			}
		}

		return 0;
	}

	public int LocateItemSocketB(String unknown) {
		
		for ( int X = 1 ; X < 4 ; X++ ) {
			if ( unknown.indexOf("<s_blue>"+X+"</s_blue>") > -1) {
				return X;
			}
		}

		return 0;
	}

	public int LocateItemSocketM(String unknown) {
		
		for ( int X = 1 ; X < 4 ; X++ ) {
			if ( unknown.indexOf("<s_meta>"+X+"</s_meta>") > -1) {
				return X;
			}
		}

		return 0;
		
	}

	public int LocateItemMinDmg(String unknown) {
		
		int Location = -1;
		int X = 1000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<dmg_low>"+X+"</dmg_low>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public int LocateItemMaxDmg(String unknown) {
		
		int Location = -1;
		int X = 2000;
		while ( X > 0 ) {
			Location = unknown.indexOf("<dmg_high>"+X+"</dmg_high>");
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public double LocateItemSpeed(String unknown) {
		
		int Location = -1;
		
		for (int X = 1; X < ItemSpeeds.length ; X++) {
			if ( ItemSpeeds[X] > 0 ) {
				Location = unknown.indexOf("Speed "+ItemSpeeds[X]);
				if ( Location != -1 ) {
					return ItemSpeeds[X];
				}
			}
		}
		return 0;
	}

	public String LocateItemSocketBonusType(String unknown) {
		
		int Location = -1;
		
		for (int X = 1; X < ItemSocketBonusType.length ; X++) {
			if ( ItemSocketBonusType[X] != null ) {
				for (int Y = 1; Y < 20 ; Y++) {
					Location = unknown.indexOf("Socket Bonus: +"+Y+" "+ItemSocketBonusType[X]);
					if ( Location != -1 ) {
						//System.out.println("Fant socket bonus type: "+ItemSocketBonusType[X]);
						return ItemSocketBonusType[X];
					}
					Location = unknown.indexOf("Socket Bonus:+"+Y+" "+ItemSocketBonusType[X]);
					if ( Location != -1 ) {
						//System.out.println("Fant socket bonus type: "+ItemSocketBonusType[X]);
						return ItemSocketBonusType[X];
					}
				}
			}
		}
		return null;
	}

	public int LocateItemSocketBonusAmount(String unknown) {
		
		//System.out.println("Leter etter socket bonus i string="+unknown);
		int Location = -1;
		int X = 20;
		while ( X > 0 ) {
			Location = unknown.indexOf("Socket Bonus: +"+X);
			if ( Location != -1 ) {
				return X;
			}
			Location = unknown.indexOf("Socket Bonus:+"+X);
			if ( Location != -1 ) {
				return X;
			}
			X --;
		}

		return 0;
	}

	public boolean LocateItemClass(String unknown, String Class) {

		//System.out.println("Leter etter "+Class);
		int Location = -1;
		Location = unknown.indexOf(Class);
		if ( Location != -1 ) {
			return true;
		}
		return false;
	}

	public String LocateItemProf(String unknown) {
		
		int Location = -1;
		
		for (int X = 1; X < ItemProfession.length ; X++) {
			if ( ItemProfession[X] != null ) {
				Location = unknown.indexOf(ItemProfession[X]);
				if ( Location != -1 ) {
					return ItemProfession[X];
				}
			}
		}
		return null;
	}

	public boolean CheckGlyph(String unknown) {

		if ( unknown.substring(0, "Glyph".length()).equals("Glyph") ) {
			return true;
		}
		if ( unknown.substring(0, " Glyph".length()).equals(" Glyph") ) {
			return true;
		}
		return false;
	}

	public boolean CheckTankitem(String unknown) {

		int Location = -1;
		Location = unknown.indexOf("Defense Rating");
		if ( Location != -1 ) {
			return true;
		}
		Location = unknown.indexOf("defense rating");
		if ( Location != -1 ) {
			return true;
		}
		Location = unknown.indexOf("dodge rating");
		if ( Location != -1 ) {
			return true;
		}
		Location = unknown.indexOf("parry rating");
		if ( Location != -1 ) {
			return true;
		}
		Location = unknown.indexOf("shield block rating");
		if ( Location != -1 ) {
			return true;
		}
		Location = unknown.indexOf("block value");
		if ( Location != -1 ) {
			return true;
		}
		
		return false;
	}

	public int LocateItemLvl(String unknown) {
		
		int Location = -1;
		for (int X = 1; X <= 300 ; X++) {
			Location = unknown.indexOf("<level>"+X+"</level>");
			if ( Location != -1 ) {
				return X;
			}
		}
		return 0;
		
	}
	
	public boolean IsEquippable( String unknown ) {
		
		int Location = -1;
		for (int X = 24; X < ItemTypes.length ; X++) {
			if ( ItemTypes[X] != null ) {
				Location = unknown.indexOf(ItemTypes[X]);
				if ( Location != -1 ) {
					return false;
				}
			}
		}
		return true;
		
	}
	
}
