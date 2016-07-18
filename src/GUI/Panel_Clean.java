package GUI;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import Various.Controller;

public class Panel_Clean extends JPanel implements ActionListener {
	
	Controller Class_Controller;
	
	JPanel TotalPanel = new JPanel();
		JPanel LeftHalf = new JPanel();
		JPanel RightHalf = new JPanel();
		
		JTextField DirtyFile = new JTextField("No file selected");
		JTextField CleanFile = new JTextField("No file selected");
		
public Panel_CleanSettings Class_Panel_CleanSettings;
		JButton Clean = new JButton("Clean");

	public Panel_Clean (Controller Class_Controller) {
		this.Class_Controller = Class_Controller;
		
		setSize( 900, 400 );
		
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.PAGE_AXIS));
		TotalPanel.add(LeftHalf);
		TotalPanel.add(RightHalf);
        
		LeftHalf.setLayout(new BoxLayout(LeftHalf, BoxLayout.LINE_AXIS));
		LeftHalf.add(new JLabel("File to clean: "));
		LeftHalf.add(DirtyFile);
		LeftHalf.add(new JLabel("Output: "));
		LeftHalf.add(CleanFile);
		
		Class_Panel_CleanSettings = new Panel_CleanSettings(Class_Controller);
		RightHalf.setLayout(new BoxLayout(RightHalf, BoxLayout.PAGE_AXIS));
		RightHalf.add(Class_Panel_CleanSettings);
		Clean.addActionListener(this);
		RightHalf.add(Clean);
        
		add(TotalPanel);
        setVisible( true );
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if ( arg0.getSource().equals(Clean)) {
			Class_Controller.Queue("Clean items from "+DirtyFile.getText()+" to "+CleanFile.getText());
		}
		
	}
}
