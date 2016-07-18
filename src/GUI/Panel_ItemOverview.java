package GUI;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import Various.*;

public class Panel_ItemOverview extends JPanel {
	
	Controller Class_Controller;
	
	JScrollPane 		ScrollingPane = new JScrollPane();
	JTable 				Table = new JTable();
	DefaultTableModel 	TableModel = new DefaultTableModel();
	Vector 				CollumnNames = new Vector();
	Vector 				RowContent = new Vector();
	
	public Panel_ItemOverview( Controller Class_Controller ) {
		
		System.out.println("Lager table");
		this.Class_Controller = Class_Controller;
		
		CollumnNames.addElement("Name");
		CollumnNames.addElement("Item Level");
		CollumnNames.addElement("Quality");
		CollumnNames.addElement("Slot");
		CollumnNames.addElement("Item Type");
		CollumnNames.addElement("Bind");
		CollumnNames.addElement("Unique");
		CollumnNames.addElement("LevelReq");
		CollumnNames.addElement("Effect");
		
		TableModel.setDataVector( RowContent, CollumnNames );
		Table = new JTable( TableModel );
		
		TableColumn column;
		int X = 0;
		column = Table.getColumnModel().getColumn(X); //name
		column.setPreferredWidth(200);
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
		
		ScrollingPane = new JScrollPane(Table);
		ScrollingPane.setPreferredSize(new Dimension(980, 350));
		
		add(ScrollingPane);
		
	}
	
	public void AppendItem( Item Itemet ) {
		
		Vector Temp = new Vector();
		Temp.addElement(Itemet.Name);
		Temp.addElement(Itemet.ItemLevel);
		Temp.addElement(Itemet.Quality);
		Temp.addElement(Itemet.Slot);
		Temp.addElement(Itemet.ItemType);
		Temp.addElement(Itemet.Bind);
		Temp.addElement(Itemet.Unique);
		Temp.addElement(Itemet.LevelReq);
		Temp.addElement(Itemet.Effect);
		
		RowContent.addElement(Temp);
		TableModel.fireTableDataChanged();
		
	}

}
