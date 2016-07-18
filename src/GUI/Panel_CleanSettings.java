package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import Various.*;

public class Panel_CleanSettings extends JPanel {
	
	Controller Class_Controller;
	
	JPanel TotalPanel = new JPanel();
		JScrollPane ScrollVindu;
		JPanel GridFrame = new JPanel();
		JPanel LineFrame = new JPanel();
			JPanel[] GridCollumns = new JPanel[2];
			Border FrameBorder;
			public JComboBox[] Setting = new JComboBox[34];

	public Panel_CleanSettings (Controller Class_Controller) {
		this.Class_Controller = Class_Controller;
		
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.PAGE_AXIS));
		
		ScrollVindu = new JScrollPane(GridFrame);
		ScrollVindu.setPreferredSize ( new Dimension ( 400, 275 ) );
		TotalPanel.add(ScrollVindu);
		
		FrameBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		GridFrame.setLayout(new GridLayout( 1,1 ));;
		GridFrame.setBorder(FrameBorder);
		
		LineFrame.setLayout(new BoxLayout(LineFrame, BoxLayout.LINE_AXIS));
		GridFrame.add(LineFrame);
		
		JComboBox Test = new JComboBox();
		Test.getSelectedIndex();
		
		for ( int X = 0 ; X < GridCollumns.length ; X++ ) {
			GridCollumns[X] = new JPanel();
			GridCollumns[X].setLayout(new GridLayout( 0,1 ));
			LineFrame.add(GridCollumns[X]);
		}
		
		GridCollumns[0].add(new JLabel(" "));
		GridCollumns[0].add(new JLabel("Grey"));
		GridCollumns[0].add(new JLabel("White"));
		GridCollumns[0].add(new JLabel("Green"));
		GridCollumns[0].add(new JLabel("Blue"));
		GridCollumns[0].add(new JLabel("Purple"));
		GridCollumns[0].add(new JLabel("Others"));
		GridCollumns[0].add(new JLabel(" "));
		GridCollumns[0].add(new JLabel("0-83 (TBC low lvl)"));
		GridCollumns[0].add(new JLabel("84-124 (TBC green-blue)"));
		GridCollumns[0].add(new JLabel("125-164 (TBC blue-purple, WotLK green-blue)"));
		GridCollumns[0].add(new JLabel("165-187  (WotLK green-blue)"));
		GridCollumns[0].add(new JLabel("188+ (WotLK blue-purple)"));
		GridCollumns[0].add(new JLabel(" "));
		GridCollumns[0].add(new JLabel("Unknown item name"));
		GridCollumns[0].add(new JLabel("'Unknown' item"));
		GridCollumns[0].add(new JLabel("Unknown slot"));
		GridCollumns[0].add(new JLabel("Unknown item type"));
		GridCollumns[0].add(new JLabel("Unknown quality"));
		GridCollumns[0].add(new JLabel("Tank items"));
		GridCollumns[0].add(new JLabel(" "));
		GridCollumns[0].add(new JLabel("Glyphs"));
		GridCollumns[0].add(new JLabel("Quest items"));
		GridCollumns[0].add(new JLabel("Gems"));
		GridCollumns[0].add(new JLabel("Reagent"));
		GridCollumns[0].add(new JLabel("Mount"));
		GridCollumns[0].add(new JLabel("Meat"));
		GridCollumns[0].add(new JLabel("Cooking"));
		GridCollumns[0].add(new JLabel("Trade Goods"));
		GridCollumns[0].add(new JLabel("Book"));
		GridCollumns[0].add(new JLabel("Holiday"));
		GridCollumns[0].add(new JLabel("Key"));
		GridCollumns[0].add(new JLabel("First Aid"));
		GridCollumns[0].add(new JLabel("Herb"));
		GridCollumns[0].add(new JLabel("Metal & stone"));
		GridCollumns[0].add(new JLabel("Currency"));
		GridCollumns[0].add(new JLabel("Ammo"));
		GridCollumns[0].add(new JLabel("Devices"));
		
		for ( int X = 0 ; X < Setting.length ; X++ ) {
			Setting[X] = new JComboBox();
			Setting[X].addItem("Delete ALL");
			Setting[X].addItem("Keep ALL");
			Setting[X].addItem("Neither");
		}
		
		GridCollumns[1].add(new JLabel("Qualities"));
		int X = -1;
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Neither");
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Neither");
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Neither");
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Neither");
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Neither");
		GridCollumns[1].add(new JLabel("Item levels"));
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Neither");
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Neither");
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Neither");
		GridCollumns[1].add(new JLabel("Various"));
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		GridCollumns[1].add(new JLabel("Item types"));
		X ++;
		GridCollumns[1].add(Setting[X]);
		Setting[X].setSelectedItem("Keep ALL");
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
		X ++;
		GridCollumns[1].add(Setting[X]);
        
		add(TotalPanel);
        setVisible( true );
		
	}

}
