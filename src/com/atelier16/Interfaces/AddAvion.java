package com.atelier16.Interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

import com.atelier16.Dao.DaoAvion;
import com.atelier16.Dao.DaoPilote;
import com.atelier16.commun.FocusForum;
import com.atelier16.commun.validatTextInput;
import com.atelier16.commun.validnumberinput;
import com.atelier16.entities.Avion;
import com.atelier16.entities.Pilote;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class AddAvion extends JInternalFrame {
	private JTextField txtcomp;
	private JTextField txttype;
	private DatePicker datePicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAvion frame = new AddAvion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddAvion() {
		setFrameIcon(new ImageIcon(AddAvion.class.getResource("/img src/add.png")));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));
		getContentPane().setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 569, 340);
		getContentPane().setLayout(null);

		
		txtcomp = new JTextField();
		txtcomp.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtcomp.setBackground(new Color(154, 205, 50));
		txtcomp.setColumns(10);
		txtcomp.setBounds(190, 100, 160, 30);
		getContentPane().add(txtcomp);
		
		JLabel lblIdpilot = new JLabel("Compagnie :");
		lblIdpilot.setForeground(new Color(255, 255, 255));
		lblIdpilot.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilot.setBounds(40, 100, 152, 30);
		getContentPane().add(lblIdpilot);
		
		txttype = new JTextField();
		txttype.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txttype.setBackground(new Color(154, 205, 50));
		txttype.setColumns(10);
		txttype.setBounds(190, 140, 160, 30);
		getContentPane().add(txttype);
		
		JLabel lblPrenom = new JLabel("Type :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(40, 140, 152, 30);
		getContentPane().add(lblPrenom);
		
		JLabel lblDateNaissance = new JLabel("Date Mise Marche :");
		lblDateNaissance.setForeground(new Color(255, 255, 255));
		lblDateNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateNaissance.setBounds(40, 180, 152, 30);
		getContentPane().add(lblDateNaissance);
		
		JButton btnadd = new JButton("Ajouter Avion");
		btnadd.setIcon(new ImageIcon(AddAvion.class.getResource("/img src/add.png")));
		btnadd.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if (txtcomp.getText().isEmpty() || txttype.getText().isEmpty() ||  datePicker.getComponentDateTextField().getText().isEmpty()) {
						chekingforumisEmpty();
					
				} else{
				
			
					try {
						

						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						//Date date =format.parse(datePicker.getDate().toString());
						

						Avion a=new Avion();
						
						a.setCompagnie(txtcomp.getText());
						a.setType(txttype.getText());
						a.setDateMiseMarche(format.parse(datePicker.getDate().toString()));
						DaoAvion.AddAvion(a);
						JOptionPane.showMessageDialog(null, "Ajouter avec succès");
						ClearForum();

						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnadd.setBounds(410, 101, 127, 34);
		getContentPane().add(btnadd);
		
		JButton btnclear = new JButton("Initialisair");
		btnclear.setIcon(new ImageIcon(AddAvion.class.getResource("/img src/eraser.png")));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclear.setBackground(new Color(255, 255, 255));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClearForum();
				
			}
		});
		btnclear.setBounds(410, 146, 127, 34);
		getContentPane().add(btnclear);
		
		JButton btnclose = new JButton("Fermer");
		btnclose.setIcon(new ImageIcon(AddAvion.class.getResource("/img src/close.png")));
		btnclose.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclose.setBackground(new Color(255, 255, 255));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnclose.setBounds(410, 191, 127, 34);
		getContentPane().add(btnclose);
		
		datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setIcon(new ImageIcon(AddAvion.class.getResource("/img src/calend2.png")));
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.getComponentDateTextField().setOpaque(false);
		datePicker.setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentDateTextField().setBackground(new Color(154, 205, 50));
		datePicker.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		datePicker.getComponentToggleCalendarButton().setText("");
		
		datePicker.setBounds(190, 180, 192, 30);
		getContentPane().add(datePicker);
		
		JLabel lblAjouterUnAvion = new JLabel("Ajouter un Avion");
		lblAjouterUnAvion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterUnAvion.setForeground(new Color(255, 255, 255));
		lblAjouterUnAvion.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblAjouterUnAvion.setBounds(136, 21, 277, 57);
		getContentPane().add(lblAjouterUnAvion);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtcomp, txttype, datePicker.getComponentDateTextField(), btnadd, btnclear, btnclose}));
		
		
		txtcomp.addKeyListener(new validatTextInput());
		txttype.addKeyListener(new validatTextInput());
		

		txtcomp.addFocusListener(new FocusForum());
		txttype.addFocusListener(new FocusForum());
		datePicker.getComponentDateTextField().addFocusListener(new FocusForum());
		

	}
	
	
	public void ClearForum(){
		txtcomp.setText("");
		txttype.setText("");
		datePicker.setText("");
		txtcomp.grabFocus();
	}
	
	public void chekingforumisEmpty() {

		if (txtcomp.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Compagnie");
			txtcomp.grabFocus();
			return;
		}
		if (txttype.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Type");
			txttype.grabFocus();
			return;
		}
		if (datePicker.getComponentDateTextField().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie la Date Mise Marche");
			datePicker.getComponentToggleCalendarButton().grabFocus();
			return;
		}
		
	}
}
