package Various;

import java.io.*;
import java.util.Date;


public class Model_Producer {
	
	Controller Class_Controller;
	
	File filen;
	String Content;
	FileInputStream fstream;
	DataInputStream in;
	
	String filenameFrom;
	String filenameTo;

	public Model_Producer(Controller Class_Controller) {
		
		this.Class_Controller = Class_Controller;

	}
	
	public void ProduceItems(String filenameFrom, String filenameTo) {
		
		this.filenameFrom = filenameFrom;
		this.filenameTo = filenameTo;
		filen = new File ( filenameFrom );
		Content = "";
		try {
			fstream = new FileInputStream ( filen );
			in = new DataInputStream ( fstream );
		} catch ( Exception T ) {
			System.out.println("B2");
			System.out.println("Kunne ikke kjøre ProduceItems");
			System.out.println ( "Throwable message: " + T.getMessage ( ) );
			System.out.println ( "Throwable cause: " + T.getCause ( ) );
			System.out.println ( "Throwable class: " + T.getClass ( ) );
		}
		
	}

	public void ProduceOneItem() {

		if ( in != null ) {
			try {

				//System.out.println("Model producer leser en linje fra filen");
				if ( in.available() != 0 ) {
					Content = Content + (in.readLine());
					
					if (Content.length() >= 9 ) {
						int FirstNew = Content.indexOf("<wowitem>");
						int SecondNew = Content.indexOf("<wowitem>", (FirstNew+9));
						while ( SecondNew > 9 ) {

							FilterItems( Content.substring(FirstNew, SecondNew) );
							Content = Content.substring(SecondNew);
							SecondNew = Content.indexOf("<wowitem>", (FirstNew+9));
							
						}
					}
				} else {
					in.close ( );
					Class_Controller.Class_View_MainFrame.FinishedTask("Produce items from "+filenameFrom+" to "+filenameTo);
					in = null;
				}
				
			} catch ( Exception e ) {
				/*
				System.out.println("Exception");
				System.out.println("Kunne ikke kjøre ProduceOneItem");
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
				*/
			}
		}

	}

	private void FilterItems( String ItemContent ) {

		System.out.println("Lager et item");
		Item Newitem = new Item();
		//System.out.println("Innhold legges i item: "+ItemContent);
		Newitem.InputInfo(ItemContent);
		Newitem.StartIdentifier(this);
		
		//Class_Controller.Class_Model_Items.ItemCount ++;
		//Class_Controller.Class_Model_Items.LoadedItems[Class_Controller.Class_Model_Items.ItemCount] = Newitem;
		
		//OutputItems(Newitem);
		//Class_Controller.Class_View_MainFrame.Class_Panel_ItemOverview.AppendItem(Newitem);
		//Class_Controller.Class_View_MainFrame.Class_Panel_ItemOverview2.AppendItem(Newitem);
		//Class_Controller.Class_View_MainFrame.Class_Panel_ItemOverview3.AppendItem(Newitem);
		
	}
	
	public synchronized void OutputItems( Item Itemet ) {
		
		//System.out.println("Bedt om å skrive ut til filen "+filenameTo);
		try {
			File filen = new File ( filenameTo );
			if ( !filen.exists()) {
				filen.createNewFile();
			}
			FileOutputStream Skrivefilen = new FileOutputStream ( filen, true );
			PrintStream utfil = new PrintStream ( Skrivefilen ); //feil har ikke med GUI å gjøre
			
			if ( Itemet.Name.length() < 50 ) {
				if ( Itemet.Class_Identifier.IsEquippable(Itemet.Unknown)) {
				
					System.out.println("Skriver ut "+Itemet.Name+" "+Itemet.ItemType+" "+Itemet.Slot);
					utfil.println(Itemet.Name);
					utfil.println(Itemet.ItemLevel);
					utfil.println(Itemet.ItemType);
					utfil.println(Itemet.Slot);
					utfil.println(Itemet.Quality);
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
					
					//System.out.println("Hasnext?="+Itemet.keyIterator.hasNext());
					while ( Itemet.keyIterator.hasNext()) {
						String Klassen = (String) Itemet.keyIterator.next(); // her er nøkkelen.
						//System.out.println("Sjekker class requirement "+Klassen);
						boolean Required = Itemet.Classes.get(Klassen); // her er verdien.);
						//System.out.println(Klassen+": "+Required);
						utfil.println(Klassen); // her er nøkkelen.
						utfil.println(Required); // her er verdien.); // her er verdien.
					}
					utfil.println(Itemet.RequiredProf);
					
					utfil.println(Itemet.Unknown);

					utfil.close ( );
				}
			}
		} catch ( Exception e ) {
			/*
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
			*/
		}
		
	}

}
