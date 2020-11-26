package com.atelier16.Interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

import com.atelier16.Dao.DaoAvion;
import com.atelier16.Dao.DaoPilote;
import com.atelier16.Dao.DaoTrajet;
import com.atelier16.commun.FocusForum;
import com.atelier16.commun.validatTextInput;
import com.atelier16.entities.Avion;
import com.atelier16.entities.Pilote;
import com.atelier16.entities.Trajet;

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class AddTrajet extends JInternalFrame {
	private JTextField txtdepart;
	private JTextField txtarrive;
	private JComboBox comboBoxduree;
	
	DefaultComboBoxModel<Object> model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTrajet frame = new AddTrajet();
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
	public AddTrajet() {
		setFrameIcon(new ImageIcon(AddTrajet.class.getResource("/img src/add.png")));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));
		getContentPane().setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 569, 340);
		getContentPane().setLayout(null);
		
		txtdepart = new JTextField();
		txtdepart.setBackground(new Color(154, 205, 50));
		txtdepart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtdepart.setColumns(10);
		txtdepart.setBounds(192, 101, 160, 30);
		getContentPane().add(txtdepart);
		
		JLabel lblIdpilot = new JLabel("Aeroport Depart :");
		lblIdpilot.setForeground(new Color(255, 255, 255));
		lblIdpilot.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilot.setBounds(52, 101, 140, 30);
		getContentPane().add(lblIdpilot);
		
		txtarrive = new JTextField();
		txtarrive.setBackground(new Color(154, 205, 50));
		txtarrive.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtarrive.setColumns(10);
		txtarrive.setBounds(192, 141, 160, 30);
		getContentPane().add(txtarrive);
		
		JLabel lblPrenom = new JLabel("Aeroport Arrive :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(52, 141, 140, 30);
		getContentPane().add(lblPrenom);
		
		JButton btnadd = new JButton("Ajouter");
		btnadd.setIcon(new ImageIcon(AddTrajet.class.getResource("/img src/add.png")));
		btnadd.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (txtdepart.getText().isEmpty() || txtarrive.getText().isEmpty() || comboBoxduree.getSelectedItem().toString().toString().isEmpty()) {
					chekingforumisEmpty();
				
			} else{
				
			
					try {
						

						//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						//Date date =format.parse(datePicker.getDate().toString());
						

						Trajet t=new Trajet();
						
						t.setAeroportDepart(txtdepart.getText());
						t.setAeroportArrivee(txtarrive.getText());
						t.setDuree_vol(Integer.valueOf(comboBoxduree.getSelectedItem().toString()));
						DaoTrajet.AddTrajet(t);
						JOptionPane.showMessageDialog(null, "Ajouter avec succès");
						ClearForum();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
				
			}
		});
		btnadd.setBounds(390, 101, 127, 34);
		getContentPane().add(btnadd);
		
		JButton btnclear = new JButton("Initialisair");
		btnclear.setIcon(new ImageIcon(AddTrajet.class.getResource("/img src/eraser.png")));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclear.setBackground(new Color(255, 255, 255));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClearForum();
				
			}
		});
		btnclear.setBounds(390, 146, 127, 34);
		getContentPane().add(btnclear);
		
		JButton btnclose = new JButton("Fermer");
		btnclose.setIcon(new ImageIcon(AddTrajet.class.getResource("/img src/close.png")));
		btnclose.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclose.setBackground(new Color(255, 255, 255));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnclose.setBounds(390, 191, 127, 34);
		getContentPane().add(btnclose);
		
		JLabel lblDuree = new JLabel("Duree Vol :");
		lblDuree.setForeground(new Color(255, 255, 255));
		lblDuree.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuree.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDuree.setBounds(52, 181, 140, 30);
		getContentPane().add(lblDuree);
		
		comboBoxduree = new JComboBox();
		comboBoxduree.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxduree.setBackground(new Color(255, 255, 255));
		comboBoxduree.setBounds(192, 181, 60, 30);
		getContentPane().add(comboBoxduree);
		
		
		model=new DefaultComboBoxModel<>();
		comboBoxduree.setModel(model);
		
		JLabel lblAjouterTrajet = new JLabel("Ajouter Trajet");
		lblAjouterTrajet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterTrajet.setForeground(new Color(255, 255, 255));
		lblAjouterTrajet.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblAjouterTrajet.setBounds(152, 30, 271, 58);
		getContentPane().add(lblAjouterTrajet);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtdepart, txtarrive, comboBoxduree, btnadd, btnclear, btnclose}));

		model.addElement("");
		model.addElement("1");
		model.addElement("2");
		model.addElement("3");
		model.addElement("4");
		model.addElement("5");
		model.addElement("6");
		model.addElement("7");
		model.addElement("8");
		model.addElement("9");
		model.addElement("10");
		
		txtarrive.addKeyListener(new validatTextInput());
		txtdepart.addKeyListener(new validatTextInput());

		txtdepart.addFocusListener(new FocusForum());
		txtarrive.addFocusListener(new FocusForum());
	}
	
	
	public void ClearForum(){
		txtdepart.setText("");
		txtarrive.setText("");
		comboBoxduree.setSelectedIndex(0);
		txtdepart.grabFocus();
	}
	
	

	public void chekingforumisEmpty() {

		if (txtdepart.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Depart");
			txtdepart.grabFocus();
			return;
		}
		if (txtarrive.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Arrive");
			txtarrive.grabFocus();
			return;
		}
		if (comboBoxduree.getSelectedItem().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Choisie la Duree");
			comboBoxduree.grabFocus();
			return;
		}
		
	}
}
