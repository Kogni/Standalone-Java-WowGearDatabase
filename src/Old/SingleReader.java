package Old;
import java.io.*;
import java.net.URL;
import java.util.Date;


public class SingleReader {
	
	//første ID=23747
	//siste fra allakhazam: 24572
	int NextItem = 25856;
	
	public SingleReader() {
		
		//File slettfil2 = new File ( "Ilevel Armory.txt" );
		//slettfil2.delete ( );//tømmer fila
		
	}

	public void GetIlvl() {
		if ( NextItem < 47000 ) {
			
			System.out.println(new Date()+" Copying item #"+NextItem+" from server");
			try {
				PrintStream utfil;
				FileOutputStream appendFilen = new FileOutputStream ( "Ilevel Allakhazam Live.txt", true );
				utfil = new PrintStream ( appendFilen );
				//første ID=23747

				URL url = new URL("http://wow.allakhazam.com/cluster/item-xml.pl?witem="+NextItem);
				                 //http://www.wowarmory.com/item-info.xml?i=
				InputStream stream = url.openStream();
				StringBuffer buffer = new StringBuffer();
				
				int p = 0;
				boolean Continue = true;
				while ( ((p = stream.read()) != -1) && Continue ) {
					buffer.append((char)p);
				}
				utfil.append(buffer);
				
				NextItem ++;
				
				utfil.close ( );
				//wait(10);
			} catch ( Exception T ) {
				System.out.println("Kunne ikke lese fil b");
				System.out.println ( "Throwable message: " + T.getMessage ( ) );
				System.out.println ( "Throwable cause: " + T.getCause ( ) );
				System.out.println ( "Throwable class: " + T.getClass ( ) );
			}
			//System.out.println("Server copying finished");
		}
		
	}
	
}
