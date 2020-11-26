package com.atelier16.Interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

import com.atelier16.Dao.DaoPilote;
import com.atelier16.commun.FocusForum;
import com.atelier16.commun.validatTextInput;
import com.atelier16.commun.validnumberinput;
import com.atelier16.entities.Pilote;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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

public class EditPilote extends JInternalFrame {
	private JTextField txtnom;
	private JTextField txtaddr;
	private JTextField txtprenom;
	private JTextField txttele;
	private DatePicker datePicker;
	private DatePicker datePicker2;
	DefaultComboBoxModel<Object> model;
	private JComboBox comboBoxpilote;
	private JButton btnsave;
	private JButton btnSupprimer;
	private JButton btnclear;
	private JButton btnclose;
	private JButton btnmod;
	private JLabel lblM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPilote frame = new EditPilote();
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
	public EditPilote() {
		setFrameIcon(new ImageIcon(EditPilote.class.getResource("/img src/edit.png")));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 569, 407);

		getContentPane().setLayout(null);

		JLabel lblIdpilote = new JLabel("Id Pilote :");
		lblIdpilote.setForeground(new Color(255, 255, 255));
		lblIdpilote.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilote.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilote.setBounds(37, 75, 141, 30);
		getContentPane().add(lblIdpilote);

		txtnom = new JTextField();
		txtnom.setToolTipText("Saisie le nom");
		txtnom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtnom.setBackground(new Color(154, 205, 50));
		txtnom.setColumns(10);
		txtnom.setBounds(174, 115, 156, 30);
		getContentPane().add(txtnom);

		JLabel lblIdpilot = new JLabel("Nom :");
		lblIdpilot.setForeground(new Color(255, 255, 255));
		lblIdpilot.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilot.setBounds(37, 115, 141, 30);
		getContentPane().add(lblIdpilot);

		txtaddr = new JTextField();
		txtaddr.setToolTipText("Saisie l'adresse");
		txtaddr.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtaddr.setBackground(new Color(154, 205, 50));
		txtaddr.setColumns(10);
		txtaddr.setBounds(174, 195, 156, 30);
		getContentPane().add(txtaddr);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setForeground(new Color(255, 255, 255));
		lblAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdresse.setBounds(37, 195, 141, 30);
		getContentPane().add(lblAdresse);

		txtprenom = new JTextField();
		txtprenom.setToolTipText("Saisie le prenom");
		txtprenom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtprenom.setBackground(new Color(154, 205, 50));
		txtprenom.setColumns(10);
		txtprenom.setBounds(174, 155, 156, 30);
		getContentPane().add(txtprenom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(37, 155, 141, 30);
		getContentPane().add(lblPrenom);

		JLabel lblDateNaissance = new JLabel("Date naissance :");
		lblDateNaissance.setForeground(new Color(255, 255, 255));
		lblDateNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateNaissance.setBounds(37, 275, 141, 30);
		getContentPane().add(lblDateNaissance);

		txttele = new JTextField();
		txttele.setToolTipText("Saisie le Telephone");
		txttele.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txttele.setBackground(new Color(154, 205, 50));
		txttele.setColumns(10);
		txttele.setBounds(174, 235, 156, 30);
		getContentPane().add(txttele);

		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setForeground(new Color(255, 255, 255));
		lblTelephone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelephone.setBounds(37, 235, 141, 30);
		getContentPane().add(lblTelephone);

		JLabel lblDateEmbauche = new JLabel("Date Embauche :");
		lblDateEmbauche.setForeground(new Color(255, 255, 255));
		lblDateEmbauche.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateEmbauche.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateEmbauche.setBounds(37, 315, 141, 30);
		getContentPane().add(lblDateEmbauche);

		btnmod = new JButton("Modifier");
		btnmod.setIcon(new ImageIcon(EditPilote.class.getResource("/img src/edit.png")));
		btnmod.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnmod.setBackground(new Color(255, 255, 255));
		btnmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ActiveButtn(true);
				setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtnom,txtprenom, txtaddr, txttele, datePicker.getComponentDateTextField(), datePicker2.getComponentDateTextField(), btnSupprimer, btnmod, btnsave, btnclear, btnclose}));


			}
		});
		btnmod.setBounds(400, 160, 127, 34);
		getContentPane().add(btnmod);

		btnclear = new JButton("Initialisair");
		btnclear.setIcon(new ImageIcon(EditPilote.class.getResource("/img src/eraser.png")));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclear.setBackground(new Color(255, 255, 255));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClearForum();

			}
		});
		btnclear.setBounds(400, 249, 127, 34);
		getContentPane().add(btnclear);

		btnclose = new JButton("Fermer");
		btnclose.setIcon(new ImageIcon(EditPilote.class.getResource("/img src/close.png")));
		btnclose.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclose.setBackground(new Color(255, 255, 255));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnclose.setBounds(400, 291, 127, 34);
		getContentPane().add(btnclose);

		datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setIcon(new ImageIcon(EditPilote.class.getResource("/img src/calend2.png")));
		datePicker.getComponentDateTextField().setToolTipText("Choisie la date de Naissance");
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.getComponentDateTextField().setOpaque(false);
		datePicker.setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton()
				.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentDateTextField().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		datePicker.getComponentToggleCalendarButton().setText("");

		datePicker.setBounds(174, 275, 192, 30);
		getContentPane().add(datePicker);

		datePicker2 = new DatePicker();
		datePicker2.getComponentToggleCalendarButton().setIcon(new ImageIcon(EditPilote.class.getResource("/img src/calend2.png")));
		datePicker2.getComponentDateTextField().setToolTipText("Choisie la date D'embauche");
		datePicker2.getComponentDateTextField().setEditable(false);
		datePicker2.getComponentDateTextField().setOpaque(false);
		datePicker2.setBackground(new Color(154, 205, 50));
		datePicker2.getComponentToggleCalendarButton()
				.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker2.getComponentDateTextField()
				.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker2.getComponentDateTextField().setBackground(new Color(154, 205, 50));
		datePicker2.getComponentToggleCalendarButton().setText("");
		datePicker2.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker2.setBounds(174, 315, 192, 30);
		getContentPane().add(datePicker2);

		comboBoxpilote = new JComboBox();
		comboBoxpilote.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxpilote.setBackground(new Color(255, 255, 255));
		comboBoxpilote.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				comboBoxpilote.setSelectedItem("");
				
				try {
					
					int id = Integer.parseInt(comboBoxpilote.getSelectedItem().toString());

					Pilote p;

					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Locale locale = new Locale("fr", "FR");
					Locale locale2 = new Locale("en", "US");
					DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
					DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.DEFAULT, locale2);
					String date = dateFormat.format(new Date());
					String date2 = dateFormat2.format(new Date());
					
					
					p = DaoPilote.getonePilote(id);
					txtnom.setText(p.getNom());
					txtprenom.setText(p.getPrenom());
					txtaddr.setText(p.getAdresse());
					txttele.setText(p.getTel());
					// textField.setText(String.valueOf(p.getDateNaissance()));
					datePicker.setText(dateFormat.format(p.getDateNaissance()));
					datePicker2.setText(dateFormat.format(p.getDateEmbauche()));
					datePicker.setText(dateFormat2.format(p.getDateNaissance()));
					datePicker2.setText(dateFormat2.format(p.getDateEmbauche()));
					// p.setDateNaissance(format.parse(datePicker.getDate().toString()));

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBoxpilote.setBounds(173, 75, 156, 30);
		getContentPane().add(comboBoxpilote);

		try {
			model = new DefaultComboBoxModel<>(DaoPilote.getAllidPilote().toArray());
			comboBoxpilote.setModel(model);

			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setIcon(new ImageIcon(EditPilote.class.getResource("/img src/delete.png")));
			btnSupprimer.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
			btnSupprimer.setBackground(new Color(255, 255, 255));
			btnSupprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ActiveButtn(false);
					
					int i=Integer.parseInt(comboBoxpilote.getSelectedItem().toString());
					
					if(i!=0){
						
				
					
					
					int n = JOptionPane.showConfirmDialog(null, "Vous-Voulez Vraiment supprimer ce Pilote ?",
							"Supression", JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.OK_OPTION) {
						try {
							int id = Integer.parseInt(comboBoxpilote.getSelectedItem().toString());

							int a = DaoPilote.RemovePilote(id);

							if (a != 0) {
								JOptionPane.showMessageDialog(null, "Supprimer avec succès");

								model.removeElement(id);
							}

						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
					}
					else
						JOptionPane.showMessageDialog(null, "Select id vous voulez supprimer");
				}
			});
			btnSupprimer.setBounds(400, 115, 127, 34);
			getContentPane().add(btnSupprimer);
			
			btnsave = new JButton("Enregistrer");
			btnsave.setIcon(new ImageIcon(EditPilote.class.getResource("/img src/save.png")));
			btnsave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
					if (txtnom.getText().isEmpty() || txtprenom.getText().isEmpty() || txtaddr.getText().isEmpty()
							|| txttele.getText().isEmpty() || datePicker.getComponentDateTextField().getText().isEmpty()
							|| datePicker2.getComponentDateTextField().getText().isEmpty()) {
						chekingforumisEmpty();
						
					} else{
					
						ActiveButtn(false);	
					
						try {
							Pilote p = new Pilote();

							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

							p.setIdPilote(Integer.parseInt(comboBoxpilote.getSelectedItem().toString()));
							p.setNom(txtnom.getText());
							p.setPrenom(txtprenom.getText());
							p.setAdresse(txtaddr.getText());
							p.setTel(txttele.getText());
							p.setDateNaissance(format.parse(datePicker.getDate().toString()));
							p.setDateEmbauche(format.parse(datePicker2.getDate().toString()));

							int a = DaoPilote.UpdatePilote(p);

							if (a != 0)
								JOptionPane.showMessageDialog(null, "Pilote Modifie avec succes");
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					
					}
				}
			});
			btnsave.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
			btnsave.setBackground(Color.WHITE);
			btnsave.setBounds(400, 205, 127, 34);
			getContentPane().add(btnsave);
			
			lblM = new JLabel("Modifier Pilotes");
			lblM.setHorizontalAlignment(SwingConstants.CENTER);
			lblM.setForeground(new Color(255, 255, 255));
			lblM.setFont(new Font("Segoe Print", Font.BOLD, 24));
			lblM.setBounds(131, 11, 288, 53);
			getContentPane().add(lblM);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtnom,txtprenom, txtaddr, txttele, datePicker.getComponentDateTextField(), datePicker2.getComponentDateTextField(), btnSupprimer, btnmod, btnsave, btnclear, btnclose}));

		ActiveButtn(false);
		txtnom.addKeyListener(new validatTextInput());
		txtprenom.addKeyListener(new validatTextInput());
		txtaddr.addKeyListener(new validatTextInput());
		txttele.addKeyListener(new validnumberinput());
		

		txtnom.addFocusListener(new FocusForum());
		txtprenom.addFocusListener(new FocusForum());
		txtaddr.addFocusListener(new FocusForum());
		txttele.addFocusListener(new FocusForum());
	
		datePicker.getComponentDateTextField().addFocusListener(new FocusForum());
		datePicker2.getComponentDateTextField().addFocusListener(new FocusForum());
		
	}

	public void ClearForum() {
		txtnom.setText("");
		txtprenom.setText("");
		txtaddr.setText("");
		txttele.setText("");
		datePicker.setText("");
		datePicker2.setText("");
		txtnom.grabFocus();
	}
	
	void ActiveButtn(boolean etat) {

		txtnom.setEditable(etat);
		txtprenom.setEditable(etat);
		txtaddr.setEditable(etat);
		txttele.setEditable(etat);
		datePicker.setEnabled(etat);
		datePicker2.setEnabled(etat);
		}
	
	public void chekingforumisEmpty() {

		if (txtnom.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Nom");
			txtnom.grabFocus();
			return;
		}
		if (txtprenom.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Prenom");
			txtprenom.grabFocus();
			return;
		}
		if (txtaddr.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie Adresse");
			txtaddr.grabFocus();
			return;
		}
		if (txttele.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Telephone");
			txttele.grabFocus();
			return;
		}
		if (datePicker.getComponentDateTextField().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie la Date de Naissace");
			datePicker.getComponentToggleCalendarButton().grabFocus();
			return;
		}
		if (datePicker2.getComponentDateTextField().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie la Date Embauche");
			datePicker2.getComponentToggleCalendarButton().grabFocus();
			return;
		}
	}
}
