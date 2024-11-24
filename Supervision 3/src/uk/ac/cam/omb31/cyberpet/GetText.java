package uk.ac.cam.omb31.cyberpet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class GetText implements ActionListener{
	private JTextField t;
	
	public GetText(JTextField t) {
		this.t = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		t.getText();
		
	}

}
