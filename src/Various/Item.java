package Various;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import Threads.Thread_IdentifyItem;


public class Item {

	public String Name;
	public int ItemLevel;
	public String Quality;
	public String Slot;
	public String ItemType;
	public String Bind;
	public boolean Unique = false;
	public int LevelReq = 0;
	public boolean Effect = false;
	
	public int Armor = 0;
	public int Stamina = 0;
	public int Intellect = 0;
	public int Spirit = 0;
	public int Agility = 0;
	public int Strength = 0;
	public int SpellPower = 0;
	public int HasteRating = 0;
	public int CritRating = 0;
	public int HitRating = 0;
	public int AttackPower = 0;
	public int ExpertRate = 0;
	public int PenetRate = 0;
	public int MP5 = 0;
	
	public boolean Tankitem = false;
	
	public int SocketYellow = 0;
	public int SocketRed = 0;
	public int SocketBlue = 0;
	public int SocketMeta = 0;
	public String SocketBonusType;
	public int SocketBonusAmount = 0;
	
	public int MinDmg = 0;
	public int MaxDmg = 0;
	public double WpnSpeed = 0;
	
	public String Unknown = "";
	
	public boolean Valuable = true;
	
	public HashMap<String, Boolean> Classes = new HashMap<String, Boolean>();
	public Set set = Classes.entrySet();
    public Iterator keyIterator = set.iterator();
    
    public  String RequiredProf = "";
    
    
    public Identifier Class_Identifier = new Identifier(Unknown);
	
	public Item() {
		

	}
	
	public void InputInfo(String Text) {
		
		Unknown = Unknown + Text+" ";
		//System.out.println("- Unknown info updated: "+Unknown);
		
	}
	
	public void StartIdentifier(Model_Producer Model_Producer) {
		
		new Thread_IdentifyItem(this, Model_Producer).start();

	}
	
	public void CheckItem() {
		
		if ( this.Name == null ) {
			System.out.println("Name="+Name+" "+this.ItemType+" " + this.LevelReq + " "+this.Unknown);
			this.Valuable = false;
		}

		if ( (this.Slot == null) && (this.ItemType == null) ) {
			System.out.println("No known slot or itemtype: "+Name+" slot="+Slot+" itemtype="+ItemType+" "+Unknown);
			this.Valuable = false;
		}

		/*
		if ( this.ItemType != null ) {
			if ( (this.LevelReq < 74) && (this.LevelReq == 0 ) && (this.ItemType.equals("Glyph") == false) ) {
				System.out.println("Levelreq too low: "+Name+" : "+LevelReq);
				this.Valuable = false;
			}
		}
		*/
		if ( (Quality == null) ||(this.Quality.equals("GreyQuality")) ) {
			System.out.println("vendortrash: "+Name+" : "+Quality);
			this.Valuable = false;
		}
		if ( ((Quality == null) || this.Quality.equals("WhiteQuality")) ) {
			if ( ( this.ItemType != null ) && ( this.ItemType.equals("Glyph") == false) ) {
				System.out.println("white: "+Name+" : "+Quality);
				this.Valuable = false;
			}
		}
		if ( (Quality == null) ||this.Quality.equals("GreenQuality") ) {
			System.out.println("greenie: "+Name+" : "+Quality);
			this.Valuable = false;
		}
		for ( int X = 22 ; X < this.Class_Identifier.Recognizer.ItemTypes.length ; X++ ) {
			if ( Valuable == true ) {
				if ( ItemType == Class_Identifier.Recognizer.ItemTypes[X] ) {
					this.Valuable = false;
					System.out.println("Bad item type: "+Name+" : "+ItemType);
				}
			}
		}
		for ( int X = 22 ; X < this.Class_Identifier.Recognizer.ItemTypes.length ; X++ ) {
			if ( Valuable == true ) {
				if ( Class_Identifier.Recognizer.ItemTypes[X] != null  ) {
					if ( Slot == Class_Identifier.Recognizer.ItemTypes[X] ) {
						this.Valuable = false;
						System.out.println("Bad item slot: "+Name+" : "+Slot);
					}
				}
			}
		}
		if ( Tankitem == true ) {
			Valuable = false;
		}
		//System.out.println("Name="+Name+" Valuable="+Valuable);
		
	}
	
}
