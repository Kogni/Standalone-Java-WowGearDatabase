package Old;
import java.io.*;
import java.net.URL;
import java.util.Date;

import Various.Item;

public class Reader2 {
	
	//String Content = "";
	Item[] Itemlist = new Item[30000];
	int Items = 0;
	
	public Reader2() throws IOException {

		System.out.println("Reader2 started");

		ReadItems();
		//SaveItemToFile();
		//GetIlvl();
		ApplyILevels();
		SaveItemToFile();
		
		System.out.println("Reader2 finished");
	}

	private void ReadItems() {
		
		System.out.println("Startet readitems");
		File filen = new File ( "Items Cleaned.txt" );
		Date Start = new Date();
		String Content = "";
		int CharsRead = 0;
		try {
			FileInputStream fstream = new FileInputStream ( filen );
			DataInputStream in = new DataInputStream ( fstream );
			
			int CharsTotal =  in.available();
			double TimeStarted = (Start.getTime()/1000.0)/60.0;
			while ( in.available() != 0 ) {
				Content = Content + (in.readLine());
				//System.out.println("Leser inn. chars="+Content.length()+" CharsRead="+CharsRead+" CharsTotal="+CharsTotal);
				//finn starten på item
				//finn starten på neste item
				//send mellomlegg til filteritems
				if (Content.length() >= 9 ) {
					int FirstNew = Content.indexOf("-NEWITEM-");
					int SecondNew = Content.indexOf("-NEWITEM-", (FirstNew+9));
					while ( SecondNew > 9 ) {
							
						int CharsLeft = CharsTotal - CharsRead;
						Date Now = new Date();
						double TimeNow = (Now.getTime()/1000.0)/60.0;
						
						double Progress = ((int)((CharsRead/CharsTotal)*100*100))/100.0;
						double Elapsed = (TimeNow - TimeStarted);
						Elapsed = ((int)(Elapsed * 100))/100.0;
						double TimeTotal = ((Elapsed / CharsRead)*CharsTotal);
						TimeTotal = ((int)(TimeTotal * 100))/100.0;
						double TimeLeft = (TimeTotal - Elapsed);
						TimeLeft = ((int)(TimeLeft * 100))/100.0;
						//System.out.println("Progress: "+Progress+"% Elapsed: "+Elapsed+" Time Total: "+TimeTotal+" Time Left: "+TimeLeft);
						
						FilterItems( Content.substring(FirstNew, SecondNew) );
						Content = Content.substring(SecondNew);
						CharsRead = CharsRead + SecondNew;
						//System.out.println("chars="+Content.length());
						SecondNew = Content.indexOf("-NEWITEM-", (FirstNew+9));
						
					}
				}
			}
			
			in.close ( );
		} catch ( Exception T ) {
			System.out.println("Kunne ikke lese fil b");
			System.out.println ( "Throwable message: " + T.getMessage ( ) );
			System.out.println ( "Throwable cause: " + T.getCause ( ) );
			System.out.println ( "Throwable class: " + T.getClass ( ) );
			if ( T.getStackTrace ( ) != null ){
				System.out.println ( "Exception origin: ");
				System.out.println ( "Class: " + T.getStackTrace ( )[0].getClassName ( ) );
				System.out.println ( "Method: " + T.getStackTrace ( )[0].getMethodName ( ) );
				System.out.println ( "Line: " + T.getStackTrace ( )[0].getLineNumber ( ) );
			}
		}	
		System.out.println("readitems ferdig. ");
	}

	private void FilterItems( String ItemContent ) {

		Item Newitem = new Item();
		Newitem.InputInfo(ItemContent);
		Newitem.StartIdentifier();
		//SaveItemToFile(Newitem);
		
		Items ++;
		Itemlist[Items] = Newitem;
		
	}
	
	private void SaveItemToFile() {

		try {
			File slettfil2 = new File ( "Items reformated.txt" );
			slettfil2.delete ( );//tømmer fila
			
			PrintStream utfil;
			FileOutputStream Skrivefilen = new FileOutputStream ( "Items reformated.txt", false );
			utfil = new PrintStream ( Skrivefilen );
			
			for ( int X = 0 ; X < Itemlist.length ; X++ ) {
				if ( Itemlist[X] != null ) {
					
					Itemlist[X].CheckItem();
					
					if ( Itemlist[X].Valuable == true ) {
						System.out.println("Skriver ut valuable item");
						utfil.println(Itemlist[X].Name);
						utfil.println(Itemlist[X].ItemLevel);
						utfil.println(Itemlist[X].ItemType);
						utfil.println(Itemlist[X].Slot);
						utfil.println(Itemlist[X].Quality);
						utfil.println(Itemlist[X].MinDmg);
						utfil.println(Itemlist[X].MaxDmg);
						utfil.println(Itemlist[X].Bind);
						utfil.println(Itemlist[X].Unique);
						utfil.println(Itemlist[X].LevelReq);
						utfil.println(Itemlist[X].Effect);
						utfil.println(Itemlist[X].Bind);
						
						utfil.println(Itemlist[X].Armor);
						utfil.println(Itemlist[X].Stamina);
						utfil.println(Itemlist[X].Intellect);
						utfil.println(Itemlist[X].Spirit);
						utfil.println(Itemlist[X].Agility);
						utfil.println(Itemlist[X].Strength);
						utfil.println(Itemlist[X].SpellPower);
						utfil.println(Itemlist[X].HasteRating);
						utfil.println(Itemlist[X].CritRating);
						utfil.println(Itemlist[X].HitRating);
						utfil.println(Itemlist[X].AttackPower);
						utfil.println(Itemlist[X].ExpertRate);
						utfil.println(Itemlist[X].PenetRate);
						utfil.println(Itemlist[X].MP5);
						
						utfil.println(Itemlist[X].SocketYellow);
						utfil.println(Itemlist[X].SocketRed);
						utfil.println(Itemlist[X].SocketBlue);
						utfil.println(Itemlist[X].SocketMeta);
						utfil.println(Itemlist[X].SocketBonusType);
						utfil.println(Itemlist[X].SocketBonusAmount);
						
						utfil.println(Itemlist[X].MinDmg);
						utfil.println(Itemlist[X].MaxDmg);
						utfil.println(Itemlist[X].WpnSpeed);
						
						utfil.println(Itemlist[X].Unknown);
						//System.out.println("Hasnext?="+Itemlist[X].keyIterator.hasNext());
						while ( Itemlist[X].keyIterator.hasNext()) {
							String Klassen = (String) Itemlist[X].keyIterator.next(); // her er nøkkelen.
							boolean Required = Itemlist[X].Classes.get(Klassen); // her er verdien.);
							utfil.println(Klassen); // her er nøkkelen.
							utfil.println(Required); // her er verdien.); // her er verdien.
						}
						utfil.println(Itemlist[X].RequiredProf);
					} else {
						//System.out.println("Item forkastet som invaluable");
					}
					
				}
			}
			

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
		}
		
	}
	
	private void ApplyILevels() {
		
		System.out.println("Leser fra Ilevel fil");
		try {
			File filen = new File ( "Item levels Live.txt" );
			FileInputStream fstream = new FileInputStream ( filen );
			DataInputStream in = new DataInputStream ( fstream );
			int X = 0;
			while ( in.available ( ) != 0 ) {
				String Line = in.readLine();
				String ItemName = Line.substring(5, Line.indexOf(" Level="));
				String ItemLevel = Line.substring((Line.indexOf(" Level=")+7), Line.length());
				boolean Found = false;
				for ( int Y = 0 ; Y < this.Items ; Y++ ) {
					if ( Found == false ) {
						if ( Itemlist[Y].Name.equals(ItemName)) {
							System.out.println( "Setter inn itemlevel: "+Integer.parseInt(ItemLevel) );
							Itemlist[Y].ItemLevel = Integer.parseInt(ItemLevel);
							Found = true;
						}
					}
				}
			}
		} catch ( Exception E ) {
			
		}
		try {
			File filen = new File ( "Item levels PTR.txt" );
			FileInputStream fstream = new FileInputStream ( filen );
			DataInputStream in = new DataInputStream ( fstream );
			int X = 0;
			while ( in.available ( ) != 0 ) {
				String Line = in.readLine();
				String ItemName = Line.substring(5, Line.indexOf(" Level="));
				String ItemLevel = Line.substring((Line.indexOf(" Level=")+7), Line.length());
				boolean Found = false;
				for ( int Y = 0 ; Y < this.Items ; Y++ ) {
					if ( Found == false ) {
						if ( Itemlist[Y].Name.equals(ItemName)) {
							Itemlist[Y].ItemLevel = Integer.parseInt(ItemLevel);
							Found = true;
						}
					}
				}
			}
		} catch ( Exception E ) {
			
		}
		
	}
	
	private void GetIlvl() {
		
		//String EmptyItem = "  <?xml version="1.0" encoding="UTF-8" ?> - <wowitem>   <display";
		System.out.println("Copying item levels from server");
		try {
			PrintStream utfil;
			File slettfil2 = new File ( "Ilevel2.txt" );
			slettfil2.delete ( );//tømmer fila
			FileOutputStream appendFilen = new FileOutputStream ( "Ilevel2.txt", true );
			utfil = new PrintStream ( appendFilen );
			//første ID=23747
			for ( int X = 44062 ; X < 46000 ; X ++ ) {
				//URL url = new URL("http://wow.allakhazam.com/cluster/item-xml.pl?witem="+X);
				URL url = new URL("http://thottbot.com/i"+X);
				InputStream stream = url.openStream();
				StringBuffer buffer = new StringBuffer();
				
				int p = 0;
				boolean Continue = true;
				while ( ((p = stream.read()) != -1) && Continue ) {
					buffer.append((char)p);
				}
				utfil.append(buffer);
				
			}
			utfil.close ( );
			//wait(10);
		} catch ( Exception T ) {
			System.out.println("Kunne ikke lese fil b");
			System.out.println ( "Throwable message: " + T.getMessage ( ) );
			System.out.println ( "Throwable cause: " + T.getCause ( ) );
			System.out.println ( "Throwable class: " + T.getClass ( ) );
		}
		System.out.println("Server copying finished");
		
	}

}
