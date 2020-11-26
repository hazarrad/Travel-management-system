package com.atelier16.commun;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class validatTextInput implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		JTextField txt=(JTextField) e.getSource();

		if(!Character.isAlphabetic(e.getKeyChar())){
			e.consume();
		}
	}
	
	

}
