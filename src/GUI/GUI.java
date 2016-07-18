package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

import Old.Reader;
import Various.Item;

public class GUI extends JFrame implements ActionListener {
	
	Reader Class_Reader;

	JPanel TotalPanel;
	JPanel Top;
	JPanel Bottom;
	JPanel[] Topics = new JPanel[2];
	JPanel[] Info = new JPanel[2];
	
	JLabel[] Topic = new JLabel[52];
	
	JComboBox NameList;
	
	JTextField Name;
	JTextField Type;
	JTextField Slot;
	JTextField Quality;
	JTextField Bind;
	JTextField Unique;
	JTextField LevelReq;
	JTextField Effect;
	
	JTextField Armor;
	JTextField Stamina;
	JTextField Intellect;
	JTextField Spirit;
	JTextField Agility;
	JTextField Strength;
	JTextField SpellPower;
	JTextField HasteRating;
	JTextField CritRating;
	JTextField HitRating;
	JTextField AttackPower;
	JTextField ExpertRate;
	JTextField PenetRate;
	JTextField MP5;
	
	JTextField SocketYellow;
	JTextField SocketRed;
	JTextField SocketBlue;
	JTextField SocketMeta;
	JTextField SocketBonusType;
	JTextField SocketBonusAmount;
	
	JTextField MinDmg;
	JTextField MaxDmg;
	JTextField WpnSpeed;
	
	JTextField Valuable;
	JTextField[] Classes = new JTextField[11];
	JTextField RequiredProf;
	JTextField Unknown;
	
	JButton Save; 
	
	Item Selected;
	boolean Turnofflisteners = false;
	
	public GUI ( Reader Class_Reader ) {
		
		this.Class_Reader = Class_Reader;
		
		Startup();
        FillLists();
		
	}
	
	private void Startup() {
		
		System.out.println("Starter GUI");
		
		setSize(900, 600);
		setMinimumSize(new Dimension(700,500));
        setMaximumSize(new Dimension(1000,700));
		
		TotalPanel = new JPanel();
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.PAGE_AXIS));
        TotalPanel.setBackground(new Color((int)(210),(int)(225),(int)(240)));
        add(TotalPanel);
        
        Top = new JPanel();
        Top.setLayout(new BoxLayout(Top, BoxLayout.LINE_AXIS));
        Top.setBackground(new Color((int)(210),(int)(225),(int)(240)));
        TotalPanel.add(Top);
        
        Bottom = new JPanel();
        Bottom.setLayout(new BoxLayout(Bottom, BoxLayout.LINE_AXIS));
        Bottom.setBackground(new Color((int)(210),(int)(225),(int)(240)));
        TotalPanel.add(Bottom);
        
        NameList = new JComboBox();
        NameList.addActionListener(this);
        NameList.setActionCommand("NameList");
        Top.add(NameList);
        
        for ( int X = 0 ; X < 2 ; X ++ ) {
            Topics[X] = new JPanel();
            Topics[X].setLayout(new BoxLayout(Topics[X], BoxLayout.PAGE_AXIS));
            Topics[X].setBackground(new Color((int)(210),(int)(225),(int)(240)));
            Bottom.add(Topics[X]);
            
            Info[X] = new JPanel();
            Info[X].setLayout(new BoxLayout(Info[X], BoxLayout.PAGE_AXIS));
            Info[X].setBackground(new Color((int)(210),(int)(225),(int)(240)));
            Bottom.add(Info[X]);
        }
        
        int X = 0;
    	Name = new JTextField("-");
    	Info[0].add(Name);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Name");
    	
    	Type = new JTextField("-");
    	Info[0].add(Type);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Type");
    	
    	Slot = new JTextField("-");
    	Info[0].add(Slot);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Slot");
    	
    	Quality = new JTextField("-");
    	Info[0].add(Quality);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Quality");
    	
    	Bind = new JTextField("-");
    	Info[0].add(Bind);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Bind");
    	
    	Unique = new JTextField("-");
    	Info[0].add(Unique);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Unique");
    	
    	LevelReq = new JTextField("-");
    	Info[0].add(LevelReq);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("LevelReq");
    	
    	Effect = new JTextField("-");
    	Info[0].add(Effect);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Effect");
    	
    	JTextField Space1 = new JTextField(" ");
    	Info[0].add(Space1);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText(" ");
    	
    	//----
    	
    	Armor = new JTextField(" ");
    	Info[1].add(Armor);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("Armor");
    	
    	Stamina = new JTextField(" ");
    	Info[1].add(Stamina);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("Stamina");
    	
    	Intellect = new JTextField(" ");
    	Info[1].add(Intellect);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("Intellect");
    	
    	Spirit = new JTextField(" ");
    	Info[1].add(Spirit);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("Spirit");
    	
    	Agility = new JTextField(" ");
    	Info[1].add(Agility);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("Agility");
    	
    	Strength = new JTextField(" ");
    	Info[1].add(Strength);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("Strength");
    	
    	SpellPower = new JTextField(" ");
    	Info[1].add(SpellPower);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("SpellPower");
    	
    	HasteRating = new JTextField(" ");
    	Info[1].add(HasteRating);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("HasteRating");
    	
    	CritRating = new JTextField(" ");
    	Info[1].add(CritRating);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("CritRating");
    	
    	HitRating = new JTextField(" ");
    	Info[1].add(HitRating);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("HitRating");
    	
    	AttackPower = new JTextField(" ");
    	Info[1].add(AttackPower);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("AttackPower");
    	
    	ExpertRate = new JTextField(" ");
    	Info[1].add(ExpertRate);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("ExpertRate");
    	
    	PenetRate = new JTextField(" ");
    	Info[1].add(PenetRate);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("PenetRate");
    	
    	MP5 = new JTextField(" ");
    	Info[1].add(MP5);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText("MP5");
    	
    	//--
    	
    	JTextField Space2 = new JTextField(" ");
    	Info[1].add(Space2);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[1].add(Topic[X]);
    	Topic[X].setText(" ");
    	
    	SocketYellow = new JTextField(" ");
    	Info[0].add(SocketYellow);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("SocketYellow");
    	
    	SocketRed = new JTextField(" ");
    	Info[0].add(SocketRed);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("SocketRed");
    	
    	SocketBlue = new JTextField(" ");
    	Info[0].add(SocketBlue);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("SocketBlue");
    	
    	SocketMeta = new JTextField(" ");
    	Info[0].add(SocketMeta);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("SocketMeta");
    	
    	SocketBonusType = new JTextField(" ");
    	Info[0].add(SocketBonusType);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("SocketBonusType");
    	
    	SocketBonusAmount = new JTextField(" ");
    	Info[0].add(SocketBonusAmount);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("SocketBonusAmount");
    	
    	//--
    	
    	JLabel Space3 = new JLabel(" ");
    	Info[0].add(Space3);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText(" ");
    	
    	MinDmg = new JTextField(" ");
    	Info[0].add(MinDmg);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("MinDmg");
    	
    	MaxDmg = new JTextField(" ");
    	Info[0].add(MaxDmg);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("MaxDmg");
    	
    	WpnSpeed = new JTextField(" ");
    	Info[0].add(WpnSpeed);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("WpnSpeed");
    	
    	//--
    	
    	JLabel Space4 = new JLabel(" ");
    	Info[0].add(Space4);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText(" ");
    	
    	Valuable = new JTextField(" ");
    	Info[0].add(Valuable);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Valuable");
    	
    	JLabel Space5 = new JLabel(" ");
    	Info[0].add(Space5);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText(" ");
    	
    	this.Class_Reader.ItemList[1].keyIterator = Class_Reader.ItemList[1].Classes.keySet().iterator();
    	for ( int Y = 1 ; Y < Classes.length ; Y++ ) {
			String Klassen = (String) Class_Reader.ItemList[1].keyIterator.next(); // her er nøkkelen.
    		Classes[Y] = new JTextField(" ");
        	Info[1].add(Classes[Y]);
        	X ++;
        	Topic[X] = new JLabel(X+"");
        	Topics[1].add(Topic[X]);
        	Topic[X].setText(Klassen);
    	}

    	JLabel Space6 = new JLabel(" ");
    	Info[0].add(Space6);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText(" ");
    	
    	RequiredProf = new JTextField(" ");
    	Info[0].add(RequiredProf);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("RequiredProf");
    	
    	JLabel Space7 = new JLabel(" ");
    	Info[0].add(Space7);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText(" ");
    	
    	Unknown = new JTextField(" ");
    	Info[0].add(Unknown);
    	X ++;
    	Topic[X] = new JLabel(X+"");
    	Topics[0].add(Topic[X]);
    	Topic[X].setText("Unknown");
    	
    	Save = new JButton("Save");
    	Save.addActionListener(this);
    	Save.setActionCommand("Save");
    	Info[0].add(Save);
        
        setVisible(true);

	}
	
	private void FillLists() {
		
		//System.out.println("Filling GUI");
		Turnofflisteners = true;
		NameList.removeAllItems();
		for ( int X = 0 ; X < Class_Reader.ItemList.length ; X++ ) {
			if ( Class_Reader.ItemList[X] != null ) {
				NameList.addItem(Class_Reader.ItemList[X].Name);
			}
		}
		Turnofflisteners = false;
		ShowItem();
		
	}
	
	private void ShowItem() {
		
		if ( Turnofflisteners == false ) {
			//System.out.println("Viser item");
			Selected = this.Class_Reader.FindItem(NameList.getSelectedItem().toString());
			Name.setText(Selected.Name);
	    	Type.setText(Selected.ItemType);
	    	Slot.setText(Selected.Slot);
	    	Quality.setText(Selected.Quality);
	    	Bind.setText(Selected.Bind);
	    	Unique.setText(Selected.Unique+"");
	    	LevelReq.setText(Selected.LevelReq+"");
	    	Effect.setText(Selected.Effect+"");
	    	
	    	Armor.setText(Selected.Armor+"");
	    	Stamina.setText(Selected.Stamina+"");
	    	Intellect.setText(Selected.Intellect+"");
	    	Spirit.setText(Selected.Spirit+"");
	    	Agility.setText(Selected.Agility+"");
	    	Strength.setText(Selected.Strength+"");
	    	SpellPower.setText(Selected.SpellPower+"");
	    	HasteRating.setText(Selected.HasteRating+"");
	    	CritRating.setText(Selected.CritRating+"");
	    	HitRating.setText(Selected.HitRating+"");
	    	AttackPower.setText(Selected.AttackPower+"");
	    	ExpertRate.setText(Selected.ExpertRate+"");
	    	PenetRate.setText(Selected.PenetRate+"");
	    	MP5.setText(Selected.MP5+"");
	    	
	    	SocketYellow.setText(Selected.SocketYellow+"");
	    	SocketRed.setText(Selected.SocketRed+"");
	    	SocketBlue.setText(Selected.SocketBlue+"");
	    	SocketMeta.setText(Selected.SocketMeta+"");
	    	SocketBonusType.setText(Selected.SocketBonusType+"");
	    	SocketBonusAmount.setText(Selected.SocketBonusAmount+"");
	    	
	    	MinDmg.setText(Selected.MinDmg+"");
	    	MaxDmg.setText(Selected.MaxDmg+"");
	    	WpnSpeed.setText(Selected.WpnSpeed+"");
	    	
	    	Valuable.setText(Selected.Valuable+"");

	    	Selected.keyIterator = Selected.Classes.keySet().iterator();
	    	for ( int Y = 1 ; Y < Classes.length ; Y++ ) {
				String Klassen = (String) Selected.keyIterator.next(); // her er nøkkelen.
				boolean Required = Selected.Classes.get(Klassen); // her er verdien.);
	    		Classes[Y].setText(Required+"");
	    	}
	    	RequiredProf.setText(Selected.RequiredProf+"");
	    	Unknown.setText(Selected.Unknown+"");
		}
	}

	@Override
	public void actionPerformed(ActionEvent E) {
		
		if ( E.getActionCommand().equals("NameList")) {
			ShowItem();
		}
		if ( E.getActionCommand().equals("Save")) {
			//System.out.println("Saving item");
			SaveItem();
			FillLists();
		}
		
	}
	
	private void SaveItem() {
		
		String OriginalName = Selected.Name;
		
		Selected.Name = Name.getText();
		Selected.ItemType = Type.getText();
		Selected.Slot = Slot.getText();
		Selected.Quality = Quality.getText();
		Selected.Bind = Bind.getText();
		Selected.Unique = Boolean.parseBoolean(Unique.getText());
		Selected.LevelReq = Integer.parseInt(LevelReq.getText());
		Selected.Effect = Boolean.parseBoolean(Effect.getText());
    	
		Selected.Armor = Integer.parseInt(Armor.getText());
		Selected.Stamina = Integer.parseInt(Stamina.getText());
		Selected.Intellect = Integer.parseInt(Intellect.getText());
		Selected.Spirit = Integer.parseInt(Spirit.getText());
		Selected.Agility = Integer.parseInt(Agility.getText());
		Selected.Strength = Integer.parseInt(Strength.getText());
		Selected.SpellPower = Integer.parseInt(SpellPower.getText());
		Selected.HasteRating = Integer.parseInt(HasteRating.getText());
		Selected.CritRating = Integer.parseInt(CritRating.getText());
		Selected.HitRating = Integer.parseInt(HitRating.getText());
		Selected.AttackPower = Integer.parseInt(AttackPower.getText());
		Selected.ExpertRate = Integer.parseInt(ExpertRate.getText());
		Selected.PenetRate = Integer.parseInt(PenetRate.getText());
		Selected.MP5 = Integer.parseInt(MP5.getText());
    	
		Selected.SocketYellow = Integer.parseInt(SocketYellow.getText());
		Selected.SocketRed = Integer.parseInt(SocketRed.getText());
		Selected.SocketBlue = Integer.parseInt(SocketBlue.getText());
		Selected.SocketMeta = Integer.parseInt(SocketMeta.getText());
		Selected.SocketBonusType = SocketBonusType.getText();
		Selected.SocketBonusAmount = Integer.parseInt(SocketBonusAmount.getText());
    	
		Selected.MinDmg = Integer.parseInt(MinDmg.getText());
		Selected.MaxDmg = Integer.parseInt(MaxDmg.getText());
		Selected.WpnSpeed = Double.parseDouble(WpnSpeed.getText());
    	
		Selected.Valuable = Boolean.parseBoolean(Valuable.getText());

    	Selected.keyIterator = Selected.Classes.keySet().iterator();
    	for ( int Y = 1 ; Y < Classes.length ; Y++ ) {
			String Klassen = (String) Selected.keyIterator.next(); // her er nøkkelen.
			Selected.Classes.put(Klassen, Boolean.parseBoolean(Classes[Y].getText()));
			//boolean Required = Selected.Classes.get(Klassen); // her er verdien.);
    		//Classes[Y].setText(Required+"");
    	}
    	Selected.RequiredProf = RequiredProf.getText();
    	Selected.Unknown = Unknown.getText();
    	
    	this.Class_Reader.SaveItemToFile();
		
	}
	
}
