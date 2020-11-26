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
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.MatteBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class EditTrajet extends JInternalFrame {
	private JTextField txtdepart;
	private JTextField txtarrive;
	private JComboBox comboBoxTrajet;
	DefaultComboBoxModel<Object> model;
	private JComboBox comboBoxduree;
	DefaultComboBoxModel<Object> modelduree;
	private JButton btnSupprimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTrajet frame = new EditTrajet();
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
	public EditTrajet() {
		setFrameIcon(new ImageIcon(EditTrajet.class.getResource("/img src/edit.png")));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));
		getContentPane().setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 569, 340);
		getContentPane().setLayout(null);

		JLabel lblIdTrajet = new JLabel("Id Trajet :");
		lblIdTrajet.setForeground(new Color(255, 255, 255));
		lblIdTrajet.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdTrajet.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdTrajet.setBounds(36, 68, 136, 30);
		getContentPane().add(lblIdTrajet);

		txtdepart = new JTextField();
		txtdepart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtdepart.setBackground(new Color(154, 205, 50));
		txtdepart.setColumns(10);
		txtdepart.setBounds(181, 108, 150, 30);
		getContentPane().add(txtdepart);

		JLabel lblIdpilot = new JLabel("Aeroport Depart :");
		lblIdpilot.setForeground(new Color(255, 255, 255));
		lblIdpilot.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilot.setBounds(36, 108, 136, 30);
		getContentPane().add(lblIdpilot);

		txtarrive = new JTextField();
		txtarrive.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtarrive.setBackground(new Color(154, 205, 50));
		txtarrive.setColumns(10);
		txtarrive.setBounds(181, 148, 150, 30);
		getContentPane().add(txtarrive);

		JLabel lblPrenom = new JLabel("Aeroport Arrive :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(36, 148, 136, 30);
		getContentPane().add(lblPrenom);

		JButton btnmodifier = new JButton("Modifier");
		btnmodifier.setIcon(new ImageIcon(EditTrajet.class.getResource("/img src/edit.png")));
		btnmodifier.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnmodifier.setBackground(new Color(255, 255, 255));
		btnmodifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ActiveButtn(true);

			}
		});
		btnmodifier.setBounds(375, 113, 127, 34);
		getContentPane().add(btnmodifier);

		JButton btnclear = new JButton("Initialisair");
		btnclear.setIcon(new ImageIcon(EditTrajet.class.getResource("/img src/eraser.png")));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclear.setBackground(new Color(255, 255, 255));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClearForum();

			}
		});
		btnclear.setBounds(375, 203, 127, 34);
		getContentPane().add(btnclear);

		JButton btnclose = new JButton("Fermer");
		btnclose.setIcon(new ImageIcon(EditTrajet.class.getResource("/img src/close.png")));
		btnclose.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclose.setBackground(new Color(255, 255, 255));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnclose.setBounds(375, 248, 127, 34);
		getContentPane().add(btnclose);

		JLabel lblDuree = new JLabel("Duree Vol :");
		lblDuree.setForeground(new Color(255, 255, 255));
		lblDuree.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuree.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDuree.setBounds(36, 188, 136, 30);
		getContentPane().add(lblDuree);

		comboBoxTrajet = new JComboBox();
		comboBoxTrajet.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxTrajet.setBackground(new Color(255, 255, 255));
		comboBoxTrajet.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				int id = Integer.parseInt(comboBoxTrajet.getSelectedItem().toString());
				Trajet t ;
				try {
				t= DaoTrajet.getOneTrajet(id);

					txtdepart.setText(t.getAeroportDepart());
					txtarrive.setText(t.getAeroportArrivee());
					comboBoxduree.setSelectedItem(t.getDuree_vol());

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		comboBoxTrajet.setBounds(181, 68, 150, 30);
		getContentPane().add(comboBoxTrajet);

		try {
			model = new DefaultComboBoxModel<>(DaoTrajet.getAllidTrajet().toArray());
			comboBoxTrajet.setModel(model);

			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setIcon(new ImageIcon(EditTrajet.class.getResource("/img src/delete.png")));
			btnSupprimer.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
			btnSupprimer.setBackground(new Color(255, 255, 255));
			btnSupprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int id = Integer.parseInt(comboBoxTrajet.getSelectedItem().toString());
					if (id != 0) {

						int choix = JOptionPane.showConfirmDialog(null, "Vous-Voulez Vraiment supprimer ce Avion ?",
								"Suprission", JOptionPane.YES_NO_OPTION);

						if (JOptionPane.YES_OPTION == choix) {

							try {
								int a=DaoTrajet.RemoveTrajet(id);
								
								if(a!=0){
									JOptionPane.showMessageDialog(null, "Supprimer avec succès");

									model.removeElement(id);
									modelduree.removeElement(id);
								}
								

							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} else
						JOptionPane.showMessageDialog(null, "Select id vous voulez supprimer");

				}
			});
			btnSupprimer.setBounds(375, 68, 127, 34);
			getContentPane().add(btnSupprimer);

			comboBoxduree = new JComboBox();
			comboBoxduree.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			comboBoxduree.setBackground(new Color(255, 255, 255));
			comboBoxduree.setBounds(181, 188, 150, 30);
			getContentPane().add(comboBoxduree);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			modelduree = new DefaultComboBoxModel<>(DaoTrajet.getAlldureeTrajet().toArray());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBoxduree.setModel(modelduree);

		JButton btnEnregestre = new JButton("Enregistrer");
		btnEnregestre.setIcon(new ImageIcon(EditTrajet.class.getResource("/img src/save.png")));
		btnEnregestre.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnEnregestre.setBackground(new Color(255, 255, 255));
		btnEnregestre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtdepart.getText().isEmpty() || txtarrive.getText().isEmpty()
						|| comboBoxduree.getSelectedItem().toString().toString().isEmpty()) {
					chekingforumisEmpty();

				} else {

					try {
						Trajet t = new Trajet();

						// SimpleDateFormat format = new
						// SimpleDateFormat("yyyy-MM-dd");

						t.setIdTrajet(Integer.parseInt(comboBoxTrajet.getSelectedItem().toString()));
						t.setAeroportDepart(txtdepart.getText());
						t.setAeroportArrivee(txtarrive.getText());
						t.setDuree_vol(Integer.valueOf(comboBoxduree.getSelectedItem().toString()));

						int a = DaoTrajet.UpdateTrajet(t);

						if (a != 0)
							ActiveButtn(false);
						JOptionPane.showMessageDialog(null, "Modifie avec succes");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnEnregestre.setBounds(375, 158, 127, 34);
		getContentPane().add(btnEnregestre);

		JLabel lblModifierTrajet = new JLabel("Modifier Trajet");
		lblModifierTrajet.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifierTrajet.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblModifierTrajet.setForeground(new Color(255, 255, 255));
		lblModifierTrajet.setBounds(145, 11, 245, 46);
		getContentPane().add(lblModifierTrajet);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxTrajet, txtdepart, txtarrive, comboBoxduree, btnSupprimer, btnmodifier, btnEnregestre, btnclear, btnclose}));

		txtarrive.addKeyListener(new validatTextInput());
		txtdepart.addKeyListener(new validatTextInput());

		txtdepart.addFocusListener(new FocusForum());
		txtarrive.addFocusListener(new FocusForum());
		ActiveButtn(false);
		model.addElement("");
		modelduree.addElement("");
		


	}

	public void ClearForum() {
		txtdepart.setText("");
		txtarrive.setText("");
		comboBoxduree.setSelectedIndex(0);
		txtdepart.grabFocus();
	}

	void ActiveButtn(boolean etat) {
		txtdepart.setEditable(etat);
		txtarrive.setEditable(etat);
		comboBoxduree.setEnabled(etat);
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
			JOptionPane.showMessageDialog(null, "Choisee la Duree");
			comboBoxduree.grabFocus();
			return;
		}

	}
}
