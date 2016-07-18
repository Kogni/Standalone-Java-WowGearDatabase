package GUI;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import Various.*;

public class Panel_Produce extends JPanel implements ActionListener {
	
	Controller Class_Controller;
	
	JPanel TotalPanel = new JPanel();
		JPanel[] LinePanel = new JPanel[10];
		
		JTextField FromFile = new JTextField("No file selected");
		JTextField ToFile = new JTextField("No file selected");
		JButton Produce = new JButton("Produce");

	public Panel_Produce(Controller Class_Controller) {
		this.Class_Controller = Class_Controller;
		
		setSize( 500, 400 );
		
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.PAGE_AXIS));
		for ( int X = 0 ; X < LinePanel.length ; X++ ) {
			LinePanel[X] = new JPanel();
			LinePanel[X].setLayout(new BoxLayout(LinePanel[X], BoxLayout.LINE_AXIS));
			TotalPanel.add(LinePanel[X]);
		}
		
		LinePanel[0].add(new JLabel("Produce item file"));
        
		FromFile.addActionListener(this);
		FromFile.setMaximumSize(new Dimension(100, 20));
		LinePanel[1].add(new JLabel("Raw file: "));
		LinePanel[1].add(FromFile);

		ToFile.addActionListener(this);
		ToFile.setMaximumSize(new Dimension(100, 20));
		LinePanel[2].add(new JLabel("Output file: "));
		LinePanel[2].add(ToFile);
		
		Produce.addActionListener(this);
		LinePanel[3].add(Produce);
        
		add(TotalPanel);
        setVisible( true );
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if ( arg0.getSource().equals(Produce)) {
			Class_Controller.Queue("Produce items from "+FromFile.getText()+" to "+ToFile.getText());
		}
		
	}
}
