package Old;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

import Various.Controller;


public class ILevelRecognizer {

	Controller Class_Controller;
	
	public ILevelRecognizer() {
		
		ReadItems();
		
	}
	
	private void ReadItems() {
		
		System.out.println("Startet read ilevel file");
		File filen = new File ( "Ilevel Allakhazam Live.txt" );
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
				if (Content.length() >= 9 ) {
					int FirstNew = Content.indexOf("<wowitem>");
					int SecondNew = Content.indexOf("<wowitem>", (FirstNew+9));
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

						FilterItems( Content.substring(FirstNew, SecondNew) );
						Content = Content.substring(SecondNew);
						CharsRead = CharsRead + SecondNew;
						SecondNew = Content.indexOf("<wowitem>", (FirstNew+9));
						
					}
				}
			}
			
			in.close ( );
		} catch ( Exception T ) {
			System.out.println("Kunne ikke lese fil");
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

		System.out.println("------------------");
		try {
			int NameEnd = ItemContent.indexOf("&lt;/span&gt");
			String ItemName = "";
			int ItemLevel = 0;
			//int WhiteNameLoc = ItemContent.indexOf("whitename&quot;&gt;");
			//int GreenNameLoc = ItemContent.indexOf("greenname&quot;&gt;");
			int BlueNameLoc = ItemContent.indexOf("bluename&quot;&gt;");
			if ( BlueNameLoc  != -1) {
				System.out.println("Name start="+BlueNameLoc);
				ItemName = ItemContent.substring((BlueNameLoc+18), NameEnd);
				System.out.println("Blue name="+ItemName);
			}
			int PurpleNameLoc = ItemContent.indexOf("purplename&quot;&gt;");
			if ( PurpleNameLoc  != -1) {
				System.out.println("Name start="+PurpleNameLoc);
				ItemName = ItemContent.substring((PurpleNameLoc+20), NameEnd);
				System.out.println("Purple name="+ItemName);
			}
			//System.out.println("Text length="+ItemContent.length());
			//System.out.println("level index="+ItemContent.indexOf("<level>"));
			int ILevelStart = (ItemContent.indexOf("<level>")+7);
			int ILevelEnd = ItemContent.indexOf("</level>");
			if ( ILevelStart > -7 ) {
				ItemLevel = Integer.parseInt(ItemContent.substring(ILevelStart, ILevelEnd));
			}
			if ( ItemName.equals("") == false ) {
				System.out.println("Item name="+ItemName);
				System.out.println("Item level="+ItemLevel);
				SaveItemToFile(ItemName, ItemLevel);
			}
		} catch ( Exception T ) {
			System.out.println("Kunne ikke finne item info");
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
	}
	
	private void SaveItemToFile( String ItemName, int ItemLevel ) {

		try {
			PrintStream utfil;
			FileOutputStream Skrivefilen = new FileOutputStream ( "Item levels Live.txt", true );
			utfil = new PrintStream ( Skrivefilen );
			
			utfil.println("Item="+ItemName+" Level="+ItemLevel);

			utfil.close ( );
		} catch ( Exception e ) {
			System.out.println("Exception");
			System.out.println("Kunne ikke skrive til fil");
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

	
}
