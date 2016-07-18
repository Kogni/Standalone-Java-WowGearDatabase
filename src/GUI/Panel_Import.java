package GUI;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import Various.Controller;

public class Panel_Import extends JPanel implements ActionListener {
	
	Controller Class_Controller;
	
	JPanel TotalPanel = new JPanel();
		JPanel LeftHalf = new JPanel();
		JPanel RightHalf = new JPanel();
		
		public JComboBox FileServer = new JComboBox();
		public JTextField ToFile = new JTextField("No file selected");
		JButton Import = new JButton("Import");

	public Panel_Import(Controller Class_Controller) {
		this.Class_Controller = Class_Controller;
		
		setSize( 500, 400 );
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		FileServer.addItem("Live");
		FileServer.addItem("PTR");
		FileServer.setMaximumSize(new Dimension(300, 20));

		ToFile.setMaximumSize(new Dimension(300, 20));
		
		Import.addActionListener(this);
		
		TotalPanel.add(new JLabel("Copying items from server to append file"));
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.PAGE_AXIS));
		TotalPanel.add(FileServer);
		TotalPanel.add(new JLabel("Save to file: "));
		TotalPanel.add(ToFile);
		TotalPanel.add(Import);
        
		add(TotalPanel);
        setVisible( true );
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if ( arg0.getSource().equals(Import)) {
			Class_Controller.Queue("Import "+FileServer.getSelectedItem().toString()+" to "+ToFile.getText());
		}
		
	}
}
