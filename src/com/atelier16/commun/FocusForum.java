package com.atelier16.commun;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class FocusForum implements FocusListener {

	
	
	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField)e.getSource();
		
		txt.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField)e.getSource();
		
		txt.setBackground(Color.getColor("9acd32"));
		txt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));

		
	}
}
