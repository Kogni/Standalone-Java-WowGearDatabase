package GUI;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;
import Various.Controller;
import Various.Item;

public class Panel_ItemOverview3 extends JPanel {
	
	Controller Class_Controller;
	
	JScrollPane 		ScrollingPane = new JScrollPane();
	JTable 				Table = new JTable();
	DefaultTableModel 	TableModel = new DefaultTableModel();
	Vector 				CollumnNames = new Vector();
	Vector 				RowContent = new Vector();
	
	public Panel_ItemOverview3( Controller Class_Controller ) {
		
		System.out.println("Lager table");
		this.Class_Controller = Class_Controller;
		
		CollumnNames.addElement("Name");
		CollumnNames.addElement("Tankitem");
		CollumnNames.addElement("SocketYellow");
		CollumnNames.addElement("SocketRed");
		CollumnNames.addElement("SocketBlue");
		CollumnNames.addElement("SocketMeta");
		CollumnNames.addElement("SocketBonusType");
		CollumnNames.addElement("SocketBonusAmount");
		CollumnNames.addElement("MinDmg");
		CollumnNames.addElement("MaxDmg");
		CollumnNames.addElement("WpnSpeed");
		
		/*
		public boolean Tankitem = false;
		public int SocketYellow = 0;
		public int SocketRed = 0;
		public int SocketBlue = 0;
		public int SocketMeta = 0;
		public String SocketBonusType;
		public int SocketBonusAmount = 0;
		public int MinDmg = 0;
		public int MaxDmg = 0;
		public double WpnSpeed = 0;
		*/
		
		TableModel.setDataVector( RowContent, CollumnNames );
		Table = new JTable( TableModel );
		
		TableColumn column;
		int X = 0;
		column = Table.getColumnModel().getColumn(X); //name
		column.setPreferredWidth(200);
		
		ScrollingPane = new JScrollPane(Table);
		ScrollingPane.setPreferredSize(new Dimension(980, 350));
		
		add(ScrollingPane);
		
	}
	
	public void AppendItem( Item Itemet ) {
		
		Vector Temp = new Vector();
		Temp.addElement(Itemet.Name);
		Temp.addElement(Itemet.Tankitem);
		Temp.addElement(Itemet.SocketYellow);
		Temp.addElement(Itemet.SocketRed);
		Temp.addElement(Itemet.SocketBlue);
		Temp.addElement(Itemet.SocketMeta);
		Temp.addElement(Itemet.SocketBonusType);
		Temp.addElement(Itemet.SocketBonusAmount);
		Temp.addElement(Itemet.MinDmg);
		Temp.addElement(Itemet.MaxDmg);
		Temp.addElement(Itemet.WpnSpeed);
		
		RowContent.addElement(Temp);
		TableModel.fireTableDataChanged();
		
	}

}
