package Various;

import java.io.*;
import java.net.*;
import java.util.*;

public class Model_Importer {
	
	Controller Class_Controller;
	
	int NextItemID = 47000;
	boolean PTR =  false;
	String Outputfile;
	
	public Model_Importer( Controller Class_Controller ) {
		
		NextItemID = 47000;
		this.Class_Controller = Class_Controller;
		
	}

	public void ImportItems( boolean PTR, String Outputfile ) {
		
		System.out.println( "Starter import" );
		//File slettfil2 = new File ( Outputfile );
		//slettfil2.delete ( );
		this.PTR = PTR;
		this.Outputfile = Outputfile;
		NextItemID = 23747;
		
	}
	
	public void ImportOneItem() {
		
		if ( NextItemID < 47000 ) {
			
			Class_Controller.Class_View_MainFrame.Statusbaren.SetMessage("Copying item #"+NextItemID+" from server");
			try {
				PrintStream utfil;
				FileOutputStream appendFilen = new FileOutputStream ( Outputfile, true );
				utfil = new PrintStream ( appendFilen );

				URL url;
				if ( PTR == true ) {
					url = new URL("http://wow.allakhazam.com/cluster/item-xml.pl?witem="+NextItemID+"&source=test");
				} else {
					url = new URL("http://wow.allakhazam.com/cluster/item-xml.pl?witem="+NextItemID);
				}
				
				InputStream stream = url.openStream();
				StringBuffer buffer = new StringBuffer();
				
				int p = 0;
				boolean Continue = true;
				while ( ((p = stream.read()) != -1) && Continue ) {
					buffer.append((char)p);
				}
				utfil.append(buffer);
				
				NextItemID ++;
				
				utfil.close ( );
				
				if ( NextItemID >= 47000 ) {
					try {
						String PTR_String = "Live";
						if ( PTR == true ) {
							PTR_String = "PTR";
						}
						Class_Controller.Class_View_MainFrame.FinishedTask("Import "+PTR_String+" to "+Outputfile);
					} catch ( NullPointerException Null ) {
						
					}
				}
				
			} catch ( Exception T ) {
				System.out.println("Kunne ikke lese fil b");
				System.out.println ( "Throwable message: " + T.getMessage ( ) );
				System.out.println ( "Throwable cause: " + T.getCause ( ) );
				System.out.println ( "Throwable class: " + T.getClass ( ) );
			}
		}
		
	}
	
}
