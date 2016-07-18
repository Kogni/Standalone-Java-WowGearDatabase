package GUI;

import java.awt.Dimension;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import Various.*;

public class Panel_ItemOverview2 extends JPanel {
	
	Controller Class_Controller;
	
	JScrollPane 		ScrollingPane = new JScrollPane();
	JTable 				Table = new JTable();
	DefaultTableModel 	TableModel = new DefaultTableModel();
	Vector 				CollumnNames = new Vector();
	Vector 				RowContent = new Vector();
	
	public Panel_ItemOverview2( Controller Class_Controller ) {
		
		System.out.println("Lager table");
		this.Class_Controller = Class_Controller;
		
		CollumnNames.addElement("Name");
		CollumnNames.addElement("Armor");
		CollumnNames.addElement("Stamina");
		CollumnNames.addElement("Intellect");
		CollumnNames.addElement("Spirit");
		CollumnNames.addElement("Agility");
		CollumnNames.addElement("Strength");
		CollumnNames.addElement("Spellpower");
		CollumnNames.addElement("HasteRating");
		CollumnNames.addElement("CritRating");
		CollumnNames.addElement("HitRating");
		CollumnNames.addElement("AttackPower");
		CollumnNames.addElement("ExpertRate");
		CollumnNames.addElement("PenetRate");
		CollumnNames.addElement("MP5");
		
		TableModel.setDataVector( RowContent, CollumnNames );
		Table = new JTable( TableModel );
		
		TableColumn column;
		int X = 0;
		column = Table.getColumnModel().getColumn(X); //name
		column.setPreferredWidth(200);
		/*
		X++;
		column = Table.getColumnModel().getColumn(X); //item level
		column.setPreferredWidth(10);
		X++;
		column = Table.getColumnModel().getColumn(X); //quality
		column.setPreferredWidth(40);
		X++;
		column = Table.getColumnModel().getColumn(X); //slot
		column.setPreferredWidth(10);
		X++;
		column = Table.getColumnModel().getColumn(X); //item type
		column.setPreferredWidth(20);
		X++;
		column = Table.getColumnModel().getColumn(X); //bind
		column.setPreferredWidth(90);
		X++;
		column = Table.getColumnModel().getColumn(X); //unique
		column.setPreferredWidth(10);
		X++;
		column = Table.getColumnModel().getColumn(X); //level req
		column.setPreferredWidth(10);
		X++;
		column = Table.getColumnModel().getColumn(X); //effect
		column.setPreferredWidth(20);
		*/
		
		ScrollingPane = new JScrollPane(Table);
		ScrollingPane.setPreferredSize(new Dimension(980, 350));
		
		add(ScrollingPane);
		
	}
	
	public void AppendItem( Item Itemet ) {
		
		Vector Temp = new Vector();
		Temp.addElement(Itemet.Name);
		Temp.addElement(Itemet.Armor);
		Temp.addElement(Itemet.Stamina);
		Temp.addElement(Itemet.Intellect);
		Temp.addElement(Itemet.Spirit);
		Temp.addElement(Itemet.Agility);
		Temp.addElement(Itemet.Strength);
		Temp.addElement(Itemet.SpellPower);
		Temp.addElement(Itemet.HasteRating);
		Temp.addElement(Itemet.CritRating);
		Temp.addElement(Itemet.HitRating);
		Temp.addElement(Itemet.AttackPower);
		Temp.addElement(Itemet.ExpertRate);
		Temp.addElement(Itemet.PenetRate);
		Temp.addElement(Itemet.MP5);
		
		RowContent.addElement(Temp);
		TableModel.fireTableDataChanged();
		
	}

}
