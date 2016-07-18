package Threads;

import java.io.*;
import Various.*;

public class Thread_CleanItem extends Thread {
	
	Controller Class_Controller;
	
	File filen;
	String Content;
	FileInputStream fstream;
	DataInputStream in;
	
	public Thread_CleanItem( Controller Class_Controller, String ItemName ) {
		
		this.Class_Controller = Class_Controller;
		try {
			filen = new File ( "Items/"+ItemName );
			if ( !filen.exists() ) {
					filen.createNewFile();
			}
			fstream = new FileInputStream ( filen );
			in = new DataInputStream ( fstream );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void run() {
		
		CleanOneItem();
		
	}
	
	public void CleanOneItem() {

		//System.out.println( "Skal rengjøre item "+filen );
		if ( in != null ) {
			//System.out.println("2");
			try {
				//System.out.println("3");
				if ( in.available() != 0 ) {
					//System.out.println("4");
					
					Item Itemet = new Item();
					
					Itemet.Name = in.readLine();
					//System.out.println("Innlest navn: "+Itemet.Name);
					Itemet.ItemLevel = Integer.parseInt(in.readLine());
					Itemet.ItemType = in.readLine();
					Itemet.Slot = in.readLine();
					Itemet.Quality = in.readLine();
					Itemet.Bind = in.readLine();
					Itemet.Unique = Boolean.parseBoolean(in.readLine());
					Itemet.LevelReq = Integer.parseInt(in.readLine());
					Itemet.Effect = Boolean.parseBoolean(in.readLine());
					Itemet.Tankitem = Boolean.parseBoolean(in.readLine());
					
					Itemet.Armor = Integer.parseInt(in.readLine());
					Itemet.Stamina = Integer.parseInt(in.readLine());
					Itemet.Intellect = Integer.parseInt(in.readLine());
					Itemet.Spirit = Integer.parseInt(in.readLine());
					Itemet.Agility = Integer.parseInt(in.readLine());
					Itemet.Strength = Integer.parseInt(in.readLine());
					Itemet.SpellPower = Integer.parseInt(in.readLine());
					Itemet.HasteRating = Integer.parseInt(in.readLine());
					Itemet.CritRating = Integer.parseInt(in.readLine());
					Itemet.HitRating = Integer.parseInt(in.readLine());
					Itemet.AttackPower = Integer.parseInt(in.readLine());
					Itemet.ExpertRate = Integer.parseInt(in.readLine());
					Itemet.PenetRate = Integer.parseInt(in.readLine());
					Itemet.MP5 = Integer.parseInt(in.readLine());
					
					Itemet.SocketYellow = Integer.parseInt(in.readLine());
					Itemet.SocketRed = Integer.parseInt(in.readLine());
					Itemet.SocketBlue = Integer.parseInt(in.readLine());
					Itemet.SocketMeta = Integer.parseInt(in.readLine());
					Itemet.SocketBonusType = in.readLine();
					Itemet.SocketBonusAmount = Integer.parseInt(in.readLine());
					
					Itemet.MinDmg = Integer.parseInt(in.readLine());
					Itemet.MaxDmg = Integer.parseInt(in.readLine());
					Itemet.WpnSpeed = Double.parseDouble(in.readLine());

					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));
					Itemet.Classes.put(in.readLine(), Boolean.parseBoolean(in.readLine()));

					Itemet.RequiredProf = in.readLine();
					
					Itemet.Unknown = in.readLine();

					boolean Save = EvaluateItem( Itemet );
					//System.out.println("Save item? "+Save);
					if ( Save ) {
						OutputItems(Itemet);
					} else {
						//FileOutputStream Skrivefilen = new FileOutputStream ( filen, false );
						//PrintStream utfil = new PrintStream ( Skrivefilen );
						//System.out.println("Sletter skrot item: "+filen);
						//filen.delete();
					}
				} else {
					in.close ( );
				}
				
			} catch ( Exception e ) {
				System.out.println("Exception");
				System.out.println("Kunne ikke kjøre CleanOneItem");
				System.out.println ( "Throwable message: " + e.getMessage ( ) );
				System.out.println ( "Throwable cause: " + e.getCause ( ) );
				System.out.println ( "Throwable class: " + e.getClass ( ) );
				if ( e.getStackTrace ( ) != null ){
					System.out.println ( "Exception origin: ");
					System.out.println ( "Class: " + e.getStackTrace ( )[0].getClassName ( ) );
					System.out.println ( "Method: " + e.getStackTrace ( )[0].getMethodName ( ) );
					System.out.println ( "Line: " + e.getStackTrace ( )[0].getLineNumber ( ) );
				}
				for ( int y = 1 ; y < e.getStackTrace().length ; y++ ) {
					System.out.println (" ");
					System.out.println ( "Origin stack "+y+": ");
					System.out.println ( "Class: " + e.getStackTrace ( )[y].getClassName ( ) );
					System.out.println ( "Method: " + e.getStackTrace ( )[y].getMethodName ( ) );
					System.out.println ( "Line: " + e.getStackTrace ( )[y].getLineNumber ( ) );
				}
			}
		}

	}

	private boolean EvaluateItem( Item Itemet ) {

		int X = -1;
		X ++;
		String DealGrey = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Quality.equals("GreyQuality")) {
			if ( DealGrey.equals("Delete ALL")) {
				//System.out.println(Itemet.Name+" hivd ut pga grey");
				return false;
			} else if ( DealGrey.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String DealWhite = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Quality.equals("WhiteQuality")) {
			if ( DealWhite.equals("Delete ALL")) {
				//System.out.println(Itemet.Name+" hivd ut pga white");
				return false;
			} else if ( DealWhite.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String DealGreen = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Quality.equals("GreenQuality")) {
			if ( DealGreen.equals("Delete ALL")) {
				//System.out.println(Itemet.Name+" hivd ut pga green");
				return false;
			} else if ( DealGreen.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String DealBlue = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Quality.equals("BlueQuality")) {
			if ( DealBlue.equals("Delete ALL")) {
				//System.out.println(Itemet.Name+" hivd ut pga blue");
				return false;
			} else if ( DealBlue.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String DealPurple = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Quality.equals("PurpleQuality")) {
			if ( DealPurple.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga purple");
				return false;
			} else if ( DealPurple.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String DealOthers = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Quality.equals(null)) {
			if ( DealOthers.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga null quality");
				return false;
			} else if ( DealOthers.equals("Keep ALL")) {
				return true;
			}
		}

		X ++;
		String Deal_0_83 = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemLevel <= 83) {
			if ( Deal_0_83.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga ItemLevel <= 83");
				return false;
			} else if ( Deal_0_83.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Deal_84_124 = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( (Itemet.ItemLevel <= 124) && (Itemet.ItemLevel >= 84) ) {
			if ( Deal_84_124.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga ItemLevel <= 124");
				return false;
			} else if ( Deal_84_124.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Deal_125_164 = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( (Itemet.ItemLevel <= 164) && (Itemet.ItemLevel >= 125) ) {
			if ( Deal_125_164.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga ItemLevel <= 164");
				return false;
			} else if ( Deal_125_164.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Deal_165_187 = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( (Itemet.ItemLevel <= 187) && (Itemet.ItemLevel >= 165) ) {
			if ( Deal_165_187.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga ItemLevel <= 187");
				return false;
			} else if ( Deal_165_187.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Deal_188 = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemLevel >= 188 ) {
			if ( Deal_188.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga ItemLevel >= 188");
				return false;
			} else if ( Deal_188.equals("Keep ALL")) {
				return true;
			}
		}

		
		X ++;
		String UnknownName = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Name == null ) {
			if ( UnknownName.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga null name");
				return false;
			} else if ( UnknownName.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String UnknownItem = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Name.equals("Unknown Item&lt;br/&gt;&lt;span class=&quot;akznotice&quot;&gt;Item display is courtesy &lt;a href=&quot;http://wow.allakhazam.com/&quot;&gt;wow.allakhazam.com&lt;/a&gt;.") ) {
			if ( UnknownItem.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga unidentified name");
				return false;
			} else if ( UnknownItem.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String UnknownSlot = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Slot == null ) {
			if ( UnknownSlot.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga null slot");
				return false;
			} else if ( UnknownSlot.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String UnknownItemType = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType == null ) {
			if ( UnknownItemType.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga null type");
				return false;
			} else if ( UnknownItemType.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String UnknownQuality = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Quality == null ) {
			if ( UnknownQuality.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga null quality");
				return false;
			} else if ( UnknownQuality.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String TankItem = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.Tankitem == true ) {
			if ( TankItem.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga tank item");
				return false;
			} else if ( TankItem.equals("Keep ALL")) {
				return true;
			}
		}
		
		X ++;
		String Glyph = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Glyph") ) {
			if ( Glyph.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga glyph");
				return false;
			} else if ( Glyph.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String QuestItem = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Quest Item") ) {
			if ( QuestItem.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga quest item");
				return false;
			} else if ( QuestItem.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Gem = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Gems") ) {
			if ( Gem.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga gem");
				return false;
			} else if ( Gem.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Reagent = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Reagent") ) {
			if ( Reagent.equals("Delete ALL")) {
				System.out.println(Itemet.Name+" hivd ut pga reagent");
				return false;
			} else if ( Reagent.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Mount = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Mount") ) {
			if ( Mount.equals("Delete ALL")) {
				return false;
			} else if ( Mount.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Meat = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Meat") ) {
			if ( Meat.equals("Delete ALL")) {
				return false;
			} else if ( Meat.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Cooking = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Cooking") ) {
			if ( Cooking.equals("Delete ALL")) {
				return false;
			} else if ( Cooking.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String TradeGoods = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Trade Goods") ) {
			if ( TradeGoods.equals("Delete ALL")) {
				return false;
			} else if ( TradeGoods.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Book = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Book") ) {
			if ( Book.equals("Delete ALL")) {
				return false;
			} else if ( Book.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Holiday = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Holiday") ) {
			if ( Holiday.equals("Delete ALL")) {
				return false;
			} else if ( Holiday.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Key = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Key") ) {
			if ( Key.equals("Delete ALL")) {
				return false;
			} else if ( Key.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String FirstAid = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("First Aid") ) {
			if ( FirstAid.equals("Delete ALL")) {
				return false;
			} else if ( FirstAid.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Herb = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Herb") ) {
			if ( Herb.equals("Delete ALL")) {
				return false;
			} else if ( Herb.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String MetalStone = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Metal & Stone") ) {
			if ( MetalStone.equals("Delete ALL")) {
				return false;
			} else if ( MetalStone.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Currency = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Currency") ) {
			if ( Currency.equals("Delete ALL")) {
				return false;
			} else if ( Currency.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Ammo = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( (Itemet.ItemType.equals("Ammo Arrow")) || (Itemet.ItemType.equals("Ammo Bullet")) ) {
			if ( Ammo.equals("Delete ALL")) {
				return false;
			} else if ( Ammo.equals("Keep ALL")) {
				return true;
			}
		}
		X ++;
		String Devices = this.Class_Controller.Class_View_MainFrame.Class_Panel_Clean.Class_Panel_CleanSettings.Setting[X].getSelectedItem().toString();
		if ( Itemet.ItemType.equals("Devices") ) {
			if ( Devices.equals("Delete ALL")) {
				return false;
			} else if ( Devices.equals("Keep ALL")) {
				return true;
			}
		}
		
		return true;
	}
	
	public void OutputItems( Item Itemet ) {
		
		//System.out.println("Bedt om å skrive ut til filen "+filen);
		try {
			filen = new File ( "Items/Cleaned/"+Itemet.Name+".txt" );
			FileOutputStream Skrivefilen = new FileOutputStream ( filen, false );
			PrintStream utfil = new PrintStream ( Skrivefilen );
			
			//System.out.println("Skriver ut item");
			utfil.println(Itemet.Name);
			utfil.println(Itemet.ItemLevel);
			utfil.println(Itemet.ItemType);
			utfil.println(Itemet.Slot);
			utfil.println(Itemet.Quality);
			utfil.println(Itemet.MinDmg);
			utfil.println(Itemet.MaxDmg);
			utfil.println(Itemet.Bind);
			utfil.println(Itemet.Unique);
			utfil.println(Itemet.LevelReq);
			utfil.println(Itemet.Effect);
			utfil.println(Itemet.Tankitem);
			
			utfil.println(Itemet.Armor);
			utfil.println(Itemet.Stamina);
			utfil.println(Itemet.Intellect);
			utfil.println(Itemet.Spirit);
			utfil.println(Itemet.Agility);
			utfil.println(Itemet.Strength);
			utfil.println(Itemet.SpellPower);
			utfil.println(Itemet.HasteRating);
			utfil.println(Itemet.CritRating);
			utfil.println(Itemet.HitRating);
			utfil.println(Itemet.AttackPower);
			utfil.println(Itemet.ExpertRate);
			utfil.println(Itemet.PenetRate);
			utfil.println(Itemet.MP5);
			
			utfil.println(Itemet.SocketYellow);
			utfil.println(Itemet.SocketRed);
			utfil.println(Itemet.SocketBlue);
			utfil.println(Itemet.SocketMeta);
			utfil.println(Itemet.SocketBonusType);
			utfil.println(Itemet.SocketBonusAmount);
			
			utfil.println(Itemet.MinDmg);
			utfil.println(Itemet.MaxDmg);
			utfil.println(Itemet.WpnSpeed);
			
			utfil.println(Itemet.Unknown);
			//System.out.println("Hasnext?="+Itemet.keyIterator.hasNext());
			Itemet.keyIterator = Itemet.Classes.keySet().iterator();
			while ( Itemet.keyIterator.hasNext()) {
				String Klassen = (String) Itemet.keyIterator.next(); // her er nøkkelen.
				//System.out.println("Sjekker class requirement "+Klassen);
				boolean Required = Itemet.Classes.get(Klassen); // her er verdien.);
				//System.out.println(Klassen+": "+Required);
				utfil.println(Klassen); // her er nøkkelen.
				utfil.println(Required); // her er verdien.); // her er verdien.
			}
			utfil.println(Itemet.RequiredProf);

			utfil.close ( );
		} catch ( Exception e ) {
			System.out.println("Exception");
			System.out.println("Kunne ikke lese fil b");
			System.out.println ( "Throwable message: " + e.getMessage ( ) );
			System.out.println ( "Throwable cause: " + e.getCause ( ) );
			System.out.println ( "Throwable class: " + e.getClass ( ) );
			if ( e.getStackTrace ( ) != null ){
				System.out.println ( "Exception origin: ");
				System.out.println ( "Class: " + e.getStackTrace ( )[0].getClassName ( ) );
				System.out.println ( "Method: " + e.getStackTrace ( )[0].getMethodName ( ) );
				System.out.println ( "Line: " + e.getStackTrace ( )[0].getLineNumber ( ) );
			}
			for ( int y = 1 ; y < e.getStackTrace().length ; y++ ) {
				System.out.println (" ");
				System.out.println ( "Origin stack "+y+": ");
				System.out.println ( "Class: " + e.getStackTrace ( )[y].getClassName ( ) );
				System.out.println ( "Method: " + e.getStackTrace ( )[y].getMethodName ( ) );
				System.out.println ( "Line: " + e.getStackTrace ( )[y].getLineNumber ( ) );
			}
		}
		
	}
}
