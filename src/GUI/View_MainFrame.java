package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import Various.*;

public class View_MainFrame extends JFrame implements ActionListener {
	
	Controller Class_Controller;
	
	JPanel TotalPanel = new JPanel();
		JTabbedPane TabPanel = new JTabbedPane();
		public Panel_Import Class_Panel_Import;
		public Panel_Produce Class_Panel_Produce;
		public Panel_Clean Class_Panel_Clean;
		//public Panel_ItemOverview Class_Panel_ItemOverview;
		//public Panel_ItemOverview2 Class_Panel_ItemOverview2;
		//public Panel_ItemOverview3 Class_Panel_ItemOverview3;
		
		public JPanel QueuePanel = new JPanel();
			JLabel[] QueueLine = new JLabel[10];
			JButton StartQueue = new JButton("Start queue");
			JButton ResetQueue = new JButton("Reset queue");
			
		public StatusBar Statusbaren = new StatusBar();

	public View_MainFrame(Controller Class_Controller) {
		super( "WoW Gear Database Maker" );
		this.Class_Controller = Class_Controller;
		
		setSize( 1200, 400 );
		setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.LINE_AXIS));
        
        Class_Panel_Import = new Panel_Import(Class_Controller);
        Class_Panel_Produce = new Panel_Produce(Class_Controller);
        Class_Panel_Clean = new Panel_Clean(Class_Controller);
        //Class_Panel_ItemOverview = new Panel_ItemOverview(Class_Controller);
        //Class_Panel_ItemOverview2 = new Panel_ItemOverview2(Class_Controller);
        //Class_Panel_ItemOverview3 = new Panel_ItemOverview3(Class_Controller);
        TabPanel.addTab("Import", Class_Panel_Import);
        TabPanel.addTab("Produce", Class_Panel_Produce);
        TabPanel.addTab("Clean", Class_Panel_Clean);
        //TabPanel.addTab("Item overview", Class_Panel_ItemOverview);
        //TabPanel.addTab("Item overview2", Class_Panel_ItemOverview2);
        //TabPanel.addTab("Item overview3", Class_Panel_ItemOverview3);
        TotalPanel.add(TabPanel);
        
        QueuePanel.setPreferredSize(new Dimension(300,400));
        for ( int X = 0 ; X < QueueLine.length ; X++ ) {
        	QueueLine[X] = new JLabel("");
            QueuePanel.add(QueueLine[X]);
        }
        StartQueue.addActionListener(this);
        ResetQueue.addActionListener(this);
        QueuePanel.add(Statusbaren, java.awt.BorderLayout.SOUTH);
        QueuePanel.add(StartQueue);
        QueuePanel.add(ResetQueue);
        QueuePanel.setLayout(new BoxLayout(QueuePanel, BoxLayout.PAGE_AXIS));
        TotalPanel.add(QueuePanel);
        
		add(TotalPanel);
        setVisible( true );
		
	}
	
	public void InsertTask( String Task ) {
		
		boolean Saved = false;
        for ( int X = 0 ; X < QueueLine.length ; X++ ) {
        	if ( Saved == false ) {
            	if ( QueueLine[X].getText().equals("")) {
            		QueueLine[X].setText(Task);
            		Saved = true;
            	}
        	}
        }
        
	}

	public void FinishedTask(String Task) {

		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		boolean Found = false;
        for ( int X = 0 ; X < QueueLine.length ; X++ ) {
        	if ( Found == false ) {
            	if ( QueueLine[X].getText().equals(Task)) {
            		QueueLine[X].setText("Completed "+new Date());
            		Found = true;
            	}
        	}
        }
        StartNextTask();
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if ( arg0.getSource().equals(StartQueue)) {
			StartQueue.setEnabled(false);
			FinishedTask("  ");
		} else if ( arg0.getSource().equals(ResetQueue)) {
	        for ( int X = 0 ; X < QueueLine.length ; X++ ) {
	        	QueueLine[X].setText(" ");
	        }
		}
		
	}
	
	private void StartNextTask() {
		
		boolean Found = false;
        for ( int X = 0 ; X < QueueLine.length ; X++ ) {
        	if ( Found == false ) {
            	if ( QueueLine[X].getText().equals(" ") == false) {
            		if ( QueueLine[X].getText().length() > 10 ) {
                    	if ( QueueLine[X].getText().substring(0, 10).equals("Completed  ") == false) {
                    		Found = true;
                    		
                    		if ( QueueLine[X].getText().substring(0, 7).equals("Import ")) {
                    			boolean PTR = false;
                    			String Filename = QueueLine[X].getText().substring(15, QueueLine[X].getText().length());
                    			//Import Live to Outputfile
                    			if ( QueueLine[X].getText().substring(7, 10).equals("PTR")) {
                    				PTR = true;
                    				//Import PTR to Outputfile
                    				Filename = QueueLine[X].getText().substring(14, QueueLine[X].getText().length());
                    			}
                    			Class_Controller.StartImport(PTR, Filename);
                    		} else if ( QueueLine[X].getText().substring(0, 19).equals("Produce items from ")) {
                    			int TilNavn = QueueLine[X].getText().indexOf(" to ");
                    			String FilenameFrom = QueueLine[X].getText().substring(19, TilNavn);
                    			String FilenameTo = QueueLine[X].getText().substring((TilNavn+4), QueueLine[X].getText().length());
                    			Class_Controller.StartProduction(FilenameFrom, FilenameTo);
                    		} else if ( QueueLine[X].getText().substring(0, 17).equals("Clean items from ")) {
                    			int TilNavn = QueueLine[X].getText().indexOf(" to ");
                    			String FilenameFrom = QueueLine[X].getText().substring(17, TilNavn);
                    			String FilenameTo = QueueLine[X].getText().substring((TilNavn+4), QueueLine[X].getText().length());
                    			Class_Controller.StartCleaning(FilenameFrom, FilenameTo);
                    		} else {
                    			System.out.println("Gjenkjente ikke oppgave: "+QueueLine[X].getText());
                    			StartQueue.setEnabled(true);
                    		}

                    	}
            		}
            	} else {
            		StartQueue.setEnabled(true);
            	}
        	}
        }
		
	}
}
