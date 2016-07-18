package GUI;

import java.awt.*;
import javax.swing.*;

public class StatusBar extends JLabel {
	
	public StatusBar() {
		
		super();
		super.setPreferredSize(new Dimension(100,16));
		
	}
	
	public void SetMessage( String message ) {
		
		setText(message);
		
	}

}
