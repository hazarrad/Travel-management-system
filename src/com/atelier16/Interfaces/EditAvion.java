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
import java.util.Locale;
import java.awt.event.ActionEvent;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerBeanInfo;
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

public class EditAvion extends JInternalFrame {
	private JTextField txtcomp;
	private JTextField txttype;
	private DatePicker datePicker;
	private JComboBox comboBoxavion;
	DefaultComboBoxModel<Object> model;
	private JButton btnSuppri;
	private JButton btnadd;
	private JButton btnEnregistrer;
	private JButton btnclear;
	private JButton btnclose;
	private JLabel lblModifierAvion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAvion frame = new EditAvion();
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
	public EditAvion() {
		setFrameIcon(new ImageIcon(EditAvion.class.getResource("/img src/edit.png")));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));
		getContentPane().setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 569, 340);
		getContentPane().setLayout(null);
		
		JLabel lblIdpilote = new JLabel("IdAvion :");
		lblIdpilote.setForeground(new Color(255, 255, 255));
		lblIdpilote.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilote.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilote.setBounds(38, 77, 156, 30);
		getContentPane().add(lblIdpilote);
		
		txtcomp = new JTextField();
		txtcomp.setBackground(new Color(154, 205, 50));
		txtcomp.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtcomp.setColumns(10);
		txtcomp.setBounds(188, 117, 160, 30);
		getContentPane().add(txtcomp);
		
		JLabel lblIdpilot = new JLabel("Compagnie :");
		lblIdpilot.setForeground(new Color(255, 255, 255));
		lblIdpilot.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilot.setBounds(38, 117, 156, 30);
		getContentPane().add(lblIdpilot);
		
		txttype = new JTextField();
		txttype.setBackground(new Color(154, 205, 50));
		txttype.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txttype.setColumns(10);
		txttype.setBounds(188, 157, 160, 30);
		getContentPane().add(txttype);
		
		JLabel lblPrenom = new JLabel("Type :");
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(38, 157, 156, 30);
		getContentPane().add(lblPrenom);
		
		JLabel lblDateNaissance = new JLabel("Date Mise Marche :");
		lblDateNaissance.setForeground(new Color(255, 255, 255));
		lblDateNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateNaissance.setBounds(38, 197, 156, 30);
		getContentPane().add(lblDateNaissance);
		
		btnadd = new JButton("Modifier");
		btnadd.setIcon(new ImageIcon(EditAvion.class.getResource("/img src/edit.png")));
		btnadd.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				ActiveButtn(true);
				setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtcomp, txttype, datePicker.getComponentDateTextField(), btnSuppri, btnadd, btnEnregistrer, btnclear, btnclose}));

				
				
			}
		});
		btnadd.setBounds(409, 122, 127, 34);
		getContentPane().add(btnadd);
		
		btnclear = new JButton("Initialisair");
		btnclear.setIcon(new ImageIcon(EditAvion.class.getResource("/img src/eraser.png")));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclear.setBackground(new Color(255, 255, 255));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClearForum();
				
			}
		});
		btnclear.setBounds(409, 212, 127, 34);
		getContentPane().add(btnclear);
		
		btnclose = new JButton("Fermer");
		btnclose.setIcon(new ImageIcon(EditAvion.class.getResource("/img src/close.png")));
		btnclose.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclose.setBackground(new Color(255, 255, 255));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnclose.setBounds(409, 254, 127, 34);
		getContentPane().add(btnclose);
		
		datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setIcon(new ImageIcon(EditAvion.class.getResource("/img src/calend2.png")));
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.getComponentDateTextField().setOpaque(false);
		datePicker.setBackground(new Color(154, 205, 50));
		datePicker.getComponentDateTextField().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		datePicker.getComponentToggleCalendarButton().setText("");
		
		datePicker.setBounds(188, 197, 185, 30);
		getContentPane().add(datePicker);
		
		comboBoxavion = new JComboBox();
		comboBoxavion.setBackground(new Color(255, 255, 255));
		comboBoxavion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		comboBoxavion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				
				int id=Integer.parseInt(comboBoxavion.getSelectedItem().toString());
				
				Avion a;
				try {
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Locale locale = new Locale("fr", "FR");
					Locale locale2 = new Locale("en", "US");
					DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
					DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.DEFAULT, locale2);
					String date = dateFormat.format(new Date());
					String date2 = dateFormat2.format(new Date());

					//System.out.print(date);
					
					a=DaoAvion.getOneAvion(id);
					txtcomp.setText(a.getCompagnie());
					txttype.setText(a.getType());	
					datePicker.setText(dateFormat.format(a.getDateMiseMarche()));
					datePicker.setText(dateFormat2.format(a.getDateMiseMarche()));

					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBoxavion.setBounds(188, 77, 160, 30);
		getContentPane().add(comboBoxavion);
		
		try {
			model=new DefaultComboBoxModel<>(DaoAvion.getAllidAvion().toArray());
			comboBoxavion.setModel(model);
			
			btnSuppri = new JButton("Supprimer");
			btnSuppri.setIcon(new ImageIcon(EditAvion.class.getResource("/img src/delete.png")));
			btnSuppri.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
			btnSuppri.setBackground(new Color(255, 255, 255));
			btnSuppri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					int id=Integer.parseInt(comboBoxavion.getSelectedItem().toString());
					if(id!=0){

					
					int choix=	JOptionPane.showConfirmDialog(null, "Vous-Voulez Vraiment supprimer ce Avion ?","Suprission",JOptionPane.YES_NO_OPTION);
						
						if(JOptionPane.YES_OPTION==choix){
							
							try {
								DaoAvion.RemoveAvion(id);
								model.removeElement(id);

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
			btnSuppri.setBounds(409, 77, 127, 34);
			getContentPane().add(btnSuppri);
			
			btnEnregistrer = new JButton("Enregistrer");
			btnEnregistrer.setIcon(new ImageIcon(EditAvion.class.getResource("/img src/save.png")));
			btnEnregistrer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					ActiveButtn(false);
					
					if (txtcomp.getText().isEmpty() || txttype.getText().isEmpty() ||  datePicker.getComponentDateTextField().getText().isEmpty()) {
						chekingforumisEmpty();
					
				} else{
				
				try {
					

					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					//Date date =format.parse(datePicker.getDate().toString());
					

					Avion a=new Avion();
					a.setIdAvion(Integer.parseInt(comboBoxavion.getSelectedItem().toString()));
					a.setCompagnie(txtcomp.getText());
					a.setType(txttype.getText());
					a.setDateMiseMarche(format.parse(datePicker.getDate().toString()));
					DaoAvion.UpdateAvion(a);
					JOptionPane.showMessageDialog(null, "Avion Modifie avec succes");

					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
				}
			});
			btnEnregistrer.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
			btnEnregistrer.setBackground(Color.WHITE);
			btnEnregistrer.setBounds(409, 167, 127, 34);
			getContentPane().add(btnEnregistrer);
			
			lblModifierAvion = new JLabel("Modifier Avion");
			lblModifierAvion.setForeground(new Color(255, 255, 255));
			lblModifierAvion.setHorizontalAlignment(SwingConstants.CENTER);
			lblModifierAvion.setFont(new Font("Segoe Print", Font.BOLD, 25));
			lblModifierAvion.setBounds(160, 11, 248, 55);
			getContentPane().add(lblModifierAvion);
			setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtcomp, txttype, datePicker.getComponentDateTextField(), btnSuppri, btnadd, btnEnregistrer, btnclear, btnclose}));
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		txtcomp.addKeyListener(new validatTextInput());
		txttype.addKeyListener(new validatTextInput());
		

		txtcomp.addFocusListener(new FocusForum());
		txttype.addFocusListener(new FocusForum());
		datePicker.getComponentDateTextField().addFocusListener(new FocusForum());
		ActiveButtn(false);

	}
	
	
	public void ClearForum(){
		txtcomp.setText("");
		txttype.setText("");
		datePicker.setText("");
		txtcomp.grabFocus();
	}
	
	
	void ActiveButtn(boolean etat) {

		txtcomp.setEditable(etat);
		txttype.setEditable(etat);
		datePicker.setEnabled(etat);
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
