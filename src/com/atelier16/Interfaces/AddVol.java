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
import com.atelier16.Dao.DaoVol;
import com.atelier16.commun.FocusForum;
import com.atelier16.entities.Avion;
import com.atelier16.entities.Pilote;
import com.atelier16.entities.VOL;

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
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.MatteBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class AddVol extends JInternalFrame {
	private DatePicker datePicker;
	DefaultComboBoxModel<Object> modelHeure;
	DefaultComboBoxModel<Object> modelMinute;
	DefaultComboBoxModel<Object> modelpilote;
	DefaultComboBoxModel<Object> modelavion;
	DefaultComboBoxModel<Object> modelTrajet;
	private JComboBox comboBoxheure;
	private JComboBox comboBoxmin;
	private JComboBox comboBoxpilote;
	private JComboBox comboBoxavion;
	private JComboBox comboBoxTrajet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVol frame = new AddVol();
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
	public AddVol() {
		setFrameIcon(new ImageIcon(AddVol.class.getResource("/img src/add.png")));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));
		getContentPane().setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 569, 406);
		getContentPane().setLayout(null);
		
		JButton btnadd = new JButton("Ajouter");
		btnadd.setIcon(new ImageIcon(AddVol.class.getResource("/img src/add.png")));
		btnadd.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (  datePicker.getComponentDateTextField().getText().isEmpty() || comboBoxheure.getSelectedItem().toString().trim().isEmpty() || comboBoxmin.getSelectedItem().toString().trim().isEmpty() || comboBoxpilote.getSelectedItem().toString().trim().isEmpty() || comboBoxavion.getSelectedItem().toString().trim().isEmpty() || comboBoxTrajet.getSelectedItem().toString().trim().isEmpty()) {
						chekingforumisEmpty();
					
				} else{
				
			
					try {
						

						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						//Date date =format.parse(datePicker.getDate().toString());
						
						VOL v=new VOL();
						v.setDatevol(format.parse(datePicker.getDate().toString()));
						v.setHeureDecalage(Integer.parseInt(comboBoxheure.getSelectedItem().toString()));
						v.setMinuteDecalage(Integer.parseInt(comboBoxmin.getSelectedItem().toString()));
						v.setIdPilote(Integer.parseInt(comboBoxpilote.getSelectedItem().toString()));
						v.setIdAvion(Integer.parseInt(comboBoxavion.getSelectedItem().toString()));
						v.setIdTrajet(Integer.parseInt(comboBoxTrajet.getSelectedItem().toString()));
						DaoVol.AddVol(v);
						JOptionPane.showMessageDialog(null, "Ajouter avec succès");
						ClearForum();
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnadd.setBounds(393, 144, 127, 34);
		getContentPane().add(btnadd);
		
		JButton btnclear = new JButton("Initialisair");
		btnclear.setIcon(new ImageIcon(AddVol.class.getResource("/img src/eraser.png")));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclear.setBackground(new Color(255, 255, 255));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClearForum();
				
			}
		});
		btnclear.setBounds(393, 189, 127, 34);
		getContentPane().add(btnclear);
		
		JButton btnclose = new JButton("Fermer");
		btnclose.setIcon(new ImageIcon(AddVol.class.getResource("/img src/close.png")));
		btnclose.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclose.setBackground(new Color(255, 255, 255));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnclose.setBounds(393, 234, 127, 34);
		getContentPane().add(btnclose);
		
		JLabel lblIdpilot = new JLabel("Minute Decalage :");
		lblIdpilot.setForeground(new Color(255, 255, 255));
		lblIdpilot.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilot.setBounds(32, 163, 141, 27);
		getContentPane().add(lblIdpilot);
		
		JLabel lblPrenom = new JLabel("Heure Decalage :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(32, 129, 141, 27);
		getContentPane().add(lblPrenom);
		
		JLabel lblDateNaissance = new JLabel("Date vol");
		lblDateNaissance.setForeground(new Color(255, 255, 255));
		lblDateNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateNaissance.setBounds(32, 93, 141, 27);
		getContentPane().add(lblDateNaissance);
		
		datePicker = new DatePicker();
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.getComponentToggleCalendarButton().setIcon(new ImageIcon(AddVol.class.getResource("/img src/calend2.png")));
		datePicker.getComponentDateTextField().setOpaque(false);
		datePicker.setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentDateTextField().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		datePicker.getComponentToggleCalendarButton().setText("");
		
		datePicker.setBounds(183, 93, 185, 30);
		getContentPane().add(datePicker);
		
		JLabel lblIdPilote = new JLabel("Id Pilote :");
		lblIdPilote.setForeground(new Color(255, 255, 255));
		lblIdPilote.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdPilote.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdPilote.setBounds(32, 201, 141, 27);
		getContentPane().add(lblIdPilote);
		
		JLabel lblIdAvion = new JLabel("Id Avion :");
		lblIdAvion.setForeground(new Color(255, 255, 255));
		lblIdAvion.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdAvion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdAvion.setBounds(32, 239, 141, 27);
		getContentPane().add(lblIdAvion);
		
		JLabel lblIdTrajet = new JLabel("Id Trajet :");
		lblIdTrajet.setForeground(new Color(255, 255, 255));
		lblIdTrajet.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdTrajet.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdTrajet.setBounds(32, 277, 141, 27);
		getContentPane().add(lblIdTrajet);
		
		comboBoxheure = new JComboBox();
		comboBoxheure.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxheure.setBackground(new Color(255, 255, 255));
		
		comboBoxheure.setBounds(183, 131, 157, 26);
		getContentPane().add(comboBoxheure);
		
		comboBoxmin = new JComboBox();
		comboBoxmin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxmin.setBackground(new Color(255, 255, 255));
		comboBoxmin.setBounds(183, 165, 157, 26);
		getContentPane().add(comboBoxmin);
		
		comboBoxpilote = new JComboBox();
		comboBoxpilote.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxpilote.setBackground(new Color(255, 255, 255));
		comboBoxpilote.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int id=Integer.parseInt(comboBoxheure.getSelectedItem().toString());

			}
		});
		comboBoxpilote.setBounds(183, 203, 157, 26);
		getContentPane().add(comboBoxpilote);
		
		comboBoxavion = new JComboBox();
		comboBoxavion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxavion.setBackground(new Color(255, 255, 255));
		comboBoxavion.setBounds(183, 241, 157, 26);
		getContentPane().add(comboBoxavion);
		
		comboBoxTrajet = new JComboBox();
		comboBoxTrajet.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxTrajet.setBackground(new Color(255, 255, 255));
		comboBoxTrajet.setBounds(183, 278, 157, 26);
		getContentPane().add(comboBoxTrajet);
		
		
		modelHeure=new DefaultComboBoxModel();
		comboBoxheure.setModel(modelHeure);
		modelHeure.addElement("01");
		modelHeure.addElement("02");
		modelHeure.addElement("03");
		modelHeure.addElement("04");
		modelHeure.addElement("06");
		modelHeure.addElement("07");
		modelHeure.addElement("08");
		modelHeure.addElement("09");
		modelHeure.addElement("10");
		modelHeure.addElement("11");
		modelHeure.addElement("12");
		modelHeure.addElement("13");
		modelHeure.addElement("14");
		modelHeure.addElement("15");
		modelHeure.addElement("16");
		modelHeure.addElement("17");
		modelHeure.addElement("18");
		modelHeure.addElement("19");
		modelHeure.addElement("20");
		modelHeure.addElement("21");
		modelHeure.addElement("22");
		modelHeure.addElement("23");
		modelHeure.addElement("00");
		
		
		
		

		modelMinute=new DefaultComboBoxModel();
		comboBoxmin.setModel(modelMinute);
		modelMinute.addElement("00");
		modelMinute.addElement("15");
		modelMinute.addElement("30");
		modelMinute.addElement("45");
		modelMinute.addElement("55");

		
		
		try {
			modelpilote = new DefaultComboBoxModel<>(DaoPilote.getAllidPilote().toArray());
			comboBoxpilote.setModel(modelpilote);
			
			modelavion = new DefaultComboBoxModel<>(DaoAvion.getAllidAvion().toArray());
			comboBoxavion.setModel(modelavion);
			
			modelTrajet = new DefaultComboBoxModel<>(DaoTrajet.getAllidTrajet().toArray());
			comboBoxTrajet.setModel(modelTrajet);
			
			JLabel lblAjouterVol = new JLabel("Ajouter Vol");
			lblAjouterVol.setHorizontalAlignment(SwingConstants.CENTER);
			lblAjouterVol.setForeground(new Color(255, 255, 255));
			lblAjouterVol.setFont(new Font("Segoe Print", Font.BOLD, 25));
			lblAjouterVol.setBounds(137, 11, 264, 59);
			getContentPane().add(lblAjouterVol);
			setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{datePicker.getComponentDateTextField(), comboBoxheure, comboBoxmin, comboBoxpilote, comboBoxavion, comboBoxTrajet, btnadd, btnclear, btnclose}));

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		
		datePicker.getComponentDateTextField().addFocusListener(new FocusForum());

	}
	
	
	public void ClearForum(){
		
		datePicker.setText("");
	}
	
	
	
	

	public void chekingforumisEmpty() {

		
		if (datePicker.getComponentDateTextField().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie la Date de Vol");
			datePicker.getComponentToggleCalendarButton().grabFocus();
			return;
		}
		
		if (comboBoxheure.getSelectedItem().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Choisie l'heure de vol");
			comboBoxheure.grabFocus();
			return;
		}
		if (comboBoxmin.getSelectedItem().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Choisie Minute de vol");
			comboBoxmin.grabFocus();
			return;
		}
		if (comboBoxpilote.getSelectedItem().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Choisie le pilote de vol");
			comboBoxpilote.grabFocus();
			return;
		}
		if (comboBoxavion.getSelectedItem().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Choisie l'Avion de vol");
			comboBoxavion.grabFocus();
			return;
		}
		if (comboBoxTrajet.getSelectedItem().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Choisie Trajet de vol");
			comboBoxTrajet.grabFocus();
			return;
		}
		
	}
}
