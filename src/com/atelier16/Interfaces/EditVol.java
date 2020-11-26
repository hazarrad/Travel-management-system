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
import com.atelier16.entities.Trajet;
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

public class EditVol extends JInternalFrame {
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
	private JComboBox comboBoxvol;

	DefaultComboBoxModel<Object> modelvol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditVol frame = new EditVol();
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
	public EditVol() {
		setFrameIcon(new ImageIcon(EditVol.class.getResource("/img src/edit.png")));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));
		setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 569, 406);
		getContentPane().setLayout(null);

		JLabel lblIdpilote = new JLabel("Id Vol :");
		lblIdpilote.setForeground(new Color(255, 255, 255));
		lblIdpilote.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilote.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilote.setBounds(44, 65, 140, 30);
		getContentPane().add(lblIdpilote);

		JLabel lblIdpilot = new JLabel("Minute Decalage :");
		lblIdpilot.setForeground(new Color(255, 255, 255));
		lblIdpilot.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilot.setBounds(44, 185, 140, 30);
		getContentPane().add(lblIdpilot);

		JLabel lblPrenom = new JLabel("Heure Decalage :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(44, 145, 140, 30);
		getContentPane().add(lblPrenom);

		JLabel lblDateNaissance = new JLabel("Date vol");
		lblDateNaissance.setForeground(new Color(255, 255, 255));
		lblDateNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateNaissance.setBounds(44, 105, 140, 30);
		getContentPane().add(lblDateNaissance);

		JButton btnedit = new JButton("Modifier");
		btnedit.setIcon(new ImageIcon(EditVol.class.getResource("/img src/edit.png")));
		btnedit.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnedit.setBackground(new Color(255, 255, 255));
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				ActiveButtn(true);
				
			}
		});
		btnedit.setBounds(394, 145, 127, 34);
		getContentPane().add(btnedit);

		JButton btnclear = new JButton("Initialisair");
		btnclear.setIcon(new ImageIcon(EditVol.class.getResource("/img src/eraser.png")));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclear.setBackground(new Color(255, 255, 255));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClearForum();

			}
		});
		btnclear.setBounds(394, 234, 127, 34);
		getContentPane().add(btnclear);

		JButton btnclose = new JButton("Fermer");
		btnclose.setIcon(new ImageIcon(EditVol.class.getResource("/img src/close.png")));
		btnclose.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclose.setBackground(new Color(255, 255, 255));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnclose.setBounds(394, 282, 127, 34);
		getContentPane().add(btnclose);

		datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setIcon(new ImageIcon(EditVol.class.getResource("/img src/calend2.png")));
		datePicker.getComponentDateTextField().setOpaque(false);
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker.getComponentDateTextField().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		
		datePicker.getComponentToggleCalendarButton().setText("");

		datePicker.setBounds(181, 105, 180, 30);
		getContentPane().add(datePicker);

		JLabel lblIdPilote = new JLabel("Id Pilote :");
		lblIdPilote.setForeground(new Color(255, 255, 255));
		lblIdPilote.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdPilote.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdPilote.setBounds(44, 225, 140, 30);
		getContentPane().add(lblIdPilote);

		JLabel lblIdAvion = new JLabel("Id Avion :");
		lblIdAvion.setForeground(new Color(255, 255, 255));
		lblIdAvion.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdAvion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdAvion.setBounds(44, 265, 140, 30);
		getContentPane().add(lblIdAvion);

		JLabel lblIdTrajet = new JLabel("Id Trajet :");
		lblIdTrajet.setForeground(new Color(255, 255, 255));
		lblIdTrajet.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdTrajet.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdTrajet.setBounds(44, 305, 140, 30);
		getContentPane().add(lblIdTrajet);

		comboBoxheure = new JComboBox();
		comboBoxheure.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxheure.setBackground(new Color(255, 255, 255));

		comboBoxheure.setBounds(181, 145, 157, 30);
		getContentPane().add(comboBoxheure);

		comboBoxmin = new JComboBox();
		comboBoxmin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxmin.setBackground(new Color(255, 255, 255));
		comboBoxmin.setBounds(181, 185, 157, 30);
		getContentPane().add(comboBoxmin);

		comboBoxpilote = new JComboBox();
		comboBoxpilote.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxpilote.setBackground(new Color(255, 255, 255));
		
		comboBoxpilote.setBounds(181, 225, 157, 30);
		getContentPane().add(comboBoxpilote);

		comboBoxavion = new JComboBox();
		comboBoxavion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxavion.setBackground(new Color(255, 255, 255));
		comboBoxavion.setBounds(181, 265, 157, 30);
		getContentPane().add(comboBoxavion);

		comboBoxTrajet = new JComboBox();
		comboBoxTrajet.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxTrajet.setBackground(new Color(255, 255, 255));
		comboBoxTrajet.setBounds(181, 305, 157, 30);
		getContentPane().add(comboBoxTrajet);

		modelHeure = new DefaultComboBoxModel();
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

		modelMinute = new DefaultComboBoxModel();
		comboBoxmin.setModel(modelMinute);
		modelMinute.addElement("00");
		modelMinute.addElement("15");
		modelMinute.addElement("30");
		modelMinute.addElement("45");
		modelMinute.addElement("55");

			comboBoxvol = new JComboBox();
			comboBoxvol.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			comboBoxvol.setBackground(new Color(255, 255, 255));
			comboBoxvol.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
					
					int id=Integer.parseInt(comboBoxvol.getSelectedItem().toString());
					
					try {
						VOL t=DaoVol.getOneVol(id);
						
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Locale locale = new Locale("fr", "FR");
						Locale locale2 = new Locale("en", "US");
						DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
						DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.DEFAULT, locale2);
						
						
						datePicker.setText(dateFormat.format(t.getDatevol()));
						datePicker.setText(dateFormat2.format(t.getDatevol()));
						modelHeure.setSelectedItem(t.getHeureDecalage());
						modelMinute.setSelectedItem(t.getMinuteDecalage());
						modelpilote.setSelectedItem(t.getIdPilote());
						modelavion.setSelectedItem(t.getIdAvion());
						modelTrajet.setSelectedItem(t.getIdTrajet());
						

						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			comboBoxvol.setBounds(181, 65, 157, 30);
			getContentPane().add(comboBoxvol);

		
		
		
		JButton btnSupprimeVol = new JButton("Supprimer");
		btnSupprimeVol.setIcon(new ImageIcon(EditVol.class.getResource("/img src/delete.png")));
		btnSupprimeVol.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnSupprimeVol.setBackground(new Color(255, 255, 255));
		btnSupprimeVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int id=Integer.parseInt(comboBoxvol.getSelectedItem().toString());
				if(id!=0){

				
				int choix=	JOptionPane.showConfirmDialog(null, "Vous-Voulez Vraiment supprimer ce Vol ?","Suprission",JOptionPane.YES_NO_OPTION);
					
					if(JOptionPane.YES_OPTION==choix){
						
						try {
							DaoVol.RemoveVol(id);
							modelvol.removeElement(id);
							modelHeure.removeElement(id);
							modelMinute.removeElement(id);
							modelpilote.removeElement(id);
							modelavion.removeElement(id);
							modelTrajet.removeElement(id);

							
							JOptionPane.showMessageDialog(null, "Supprimer avec succès");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Select id vous voulez supprimer");
			}
			
		});
		btnSupprimeVol.setBounds(394, 100, 127, 34);
		getContentPane().add(btnSupprimeVol);
		
		
		try {
			modelvol = new DefaultComboBoxModel<>(DaoVol.getAllidVol().toArray());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBoxvol.setModel(modelvol);
		
		
		
		try {
			modelpilote = new DefaultComboBoxModel<>(DaoPilote.getAllidPilote().toArray());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		comboBoxpilote.setModel(modelpilote);
		
		
		try {
			modelavion = new DefaultComboBoxModel<>(DaoAvion.getAllidAvion().toArray());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBoxavion.setModel(modelavion);

		try {
			modelTrajet = new DefaultComboBoxModel<>(DaoTrajet.getAllidTrajet().toArray());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBoxTrajet.setModel(modelTrajet);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setIcon(new ImageIcon(EditVol.class.getResource("/img src/save.png")));
		btnEnregistrer.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnEnregistrer.setBackground(new Color(255, 255, 255));
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (  datePicker.getComponentDateTextField().getText().isEmpty() || comboBoxheure.getSelectedItem().toString().trim().isEmpty() || comboBoxmin.getSelectedItem().toString().trim().isEmpty() || comboBoxpilote.getSelectedItem().toString().trim().isEmpty() || comboBoxavion.getSelectedItem().toString().trim().isEmpty() || comboBoxTrajet.getSelectedItem().toString().trim().isEmpty()) {
						chekingforumisEmpty();
					
				} else{
				

				
				
				try {
					VOL v = new VOL();

					ActiveButtn(false);
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					// Date date =format.parse(datePicker.getDate().toString());
					Locale locale = new Locale("fr", "FR");
					DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

					VOL v1=new VOL();
					v1.setIdVol(Integer.parseInt(comboBoxvol.getSelectedItem().toString()));
					v1.setDatevol(format.parse(datePicker.getDate().toString()));
					v1.setHeureDecalage(Integer.parseInt(comboBoxheure.getSelectedItem().toString()));
					v1.setMinuteDecalage(Integer.parseInt(comboBoxmin.getSelectedItem().toString()));
					v1.setIdPilote(Integer.parseInt(comboBoxpilote.getSelectedItem().toString()));
					v1.setIdAvion(Integer.parseInt(comboBoxavion.getSelectedItem().toString()));
					v1.setIdTrajet(Integer.parseInt(comboBoxTrajet.getSelectedItem().toString()));
					
						int a=DaoVol.UpdateVols(v1);
						if(a!=0)
							JOptionPane.showMessageDialog(null, "Ajouter avec succès");

						
					
					
						
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				}
			}
		});
		btnEnregistrer.setBounds(394, 190, 127, 34);
		getContentPane().add(btnEnregistrer);
		
		JLabel lblModifierVol = new JLabel("Modifier Vol");
		lblModifierVol.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifierVol.setForeground(new Color(255, 255, 255));
		lblModifierVol.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblModifierVol.setBounds(126, 11, 316, 43);
		getContentPane().add(lblModifierVol);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxvol, datePicker.getComponentDateTextField(), comboBoxheure, comboBoxmin, comboBoxpilote, comboBoxavion, comboBoxTrajet, btnSupprimeVol, btnedit, btnEnregistrer, btnclear, btnclose}));
		
		datePicker.getComponentDateTextField().addFocusListener(new FocusForum());

		ActiveButtn(false);
	}


	public void ClearForum(){
		
		datePicker.setText("");
	}
	
	void ActiveButtn(boolean etat) {

		
		datePicker.setEnabled(etat);
		comboBoxheure.setEnabled(etat);
		comboBoxmin.setEnabled(etat);
		comboBoxpilote.setEnabled(etat);
		comboBoxavion.setEnabled(etat);
		comboBoxTrajet.setEnabled(etat);
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
