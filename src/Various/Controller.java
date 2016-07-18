package Various;
import java.io.*;

import GUI.*;

public class Controller {
	
	Model_Items Class_Model_Items;
	Model_Importer Class_Model_Importer;
	Model_Producer Class_Model_Producer;
	Model_Cleaner Class_Model_Cleaner;
	
	//GUI
	public View_MainFrame Class_View_MainFrame;
	
	//timers
	TimeKeeper TimeKeeper_Import;
	TimeKeeper TimeKeeper_Production;
	TimeKeeper TimeKeeper_Cleaning;
	
	public Controller() {
		
		Class_Model_Items = new Model_Items();
		Class_Model_Importer = new Model_Importer(this);
		Class_Model_Producer = new Model_Producer(this);
		Class_Model_Cleaner = new Model_Cleaner(this);
		TimeKeeper_Import = new TimeKeeper(this, 2000);
		TimeKeeper_Production = new TimeKeeper(this, 1);
		TimeKeeper_Cleaning = new TimeKeeper(this, 1);
		
		//GUI
		Class_View_MainFrame = new View_MainFrame(this);
		
	}

	public void TimeTick(TimeKeeper Sender) {

		//System.out.println("Tick from "+Sender);
		if ( Sender == TimeKeeper_Import ) {
			Class_Model_Importer.ImportOneItem();
		} else if ( Sender == TimeKeeper_Production ) {
			Class_Model_Producer.ProduceOneItem();
		} else if ( Sender == TimeKeeper_Cleaning ) {
			Class_Model_Cleaner.CleanOneItem();
		}
		
	}
	
	public void Queue(String Task) {

		Class_View_MainFrame.InsertTask(Task);
		
	}

	public void StartImport( boolean PTR, String Filename ) {
		
		Class_Model_Importer.ImportItems(PTR, Filename);
		
	}

	public void StartProduction(String filenameFrom, String filenameTo) {
		
		Class_Model_Producer.ProduceItems( filenameFrom, filenameTo );
		
	}

	public void StartCleaning(String filenameFrom, String filenameTo) {

		Class_Model_Cleaner.CleanItems( filenameFrom, filenameTo );
		
	}

}
