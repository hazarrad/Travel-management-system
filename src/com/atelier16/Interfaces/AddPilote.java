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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddPilote extends JInternalFrame {
	private JTextField txtnom;
	private JTextField txtaddr;
	private JTextField txtprenom;
	private JTextField txttele;
	private DatePicker datePicker;
	private DatePicker datePicker2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPilote frame = new AddPilote();
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
	public AddPilote() {
		setFrameIcon(new ImageIcon(AddPilote.class.getResource("/img src/add.png")));
		getContentPane().setForeground(new Color(154, 205, 50));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));
		setBackground(new Color(255, 255, 0));
		getContentPane().setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 569, 407);
		getContentPane().setLayout(null);

		txtnom = new JTextField();
		txtnom.setBackground(new Color(154, 205, 50));

		txtnom.setToolTipText("Saisie le Nom");
		txtnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtnom.addKeyListener(new validatTextInput());
		txtnom.setForeground(new Color(0, 0, 0));
		txtnom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtnom.setColumns(10);
		txtnom.setBounds(194, 80, 156, 27);

		getContentPane().add(txtnom);

		JLabel lblIdpilot = new JLabel("Nom :");
		lblIdpilot.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdpilot.setHorizontalTextPosition(SwingConstants.LEADING);
		lblIdpilot.setForeground(new Color(255, 255, 255));
		lblIdpilot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpilot.setBounds(43, 80, 141, 34);
		getContentPane().add(lblIdpilot);

		txtaddr = new JTextField();
		txtaddr.setBackground(new Color(154, 205, 50));
		txtaddr.setToolTipText("Saisie l'adresse");
		txtaddr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtaddr.addKeyListener(new validatTextInput());
		txtaddr.setForeground(new Color(0, 0, 0));
		txtaddr.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtaddr.setColumns(10);
		txtaddr.setBounds(194, 160, 156, 27);
		getContentPane().add(txtaddr);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdresse.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblAdresse.setForeground(new Color(255, 255, 255));
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdresse.setBounds(43, 158, 141, 27);
		getContentPane().add(lblAdresse);

		txtprenom = new JTextField();
		txtprenom.setBackground(new Color(154, 205, 50));
		txtprenom.setToolTipText("Saisie le Prenom");
		txtprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtprenom.addKeyListener(new validatTextInput());
		txtprenom.setForeground(new Color(0, 0, 0));
		txtprenom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtprenom.setColumns(10);
		txtprenom.setBounds(194, 120, 156, 27);
		getContentPane().add(txtprenom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrenom.setBounds(43, 120, 141, 27);
		getContentPane().add(lblPrenom);

		JLabel lblDateNaissance = new JLabel("Date naissance :");
		lblDateNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateNaissance.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblDateNaissance.setForeground(new Color(255, 255, 255));
		lblDateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateNaissance.setBounds(43, 239, 141, 27);
		getContentPane().add(lblDateNaissance);

		txttele = new JTextField();
		txttele.setBackground(new Color(154, 205, 50));
		txttele.setToolTipText("Saisie le Telephone");
		txttele.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttele.addKeyListener(new validnumberinput());
		txttele.setForeground(new Color(0, 0, 0));
		txttele.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txttele.setColumns(10);
		txttele.setBounds(194, 200, 156, 27);
		getContentPane().add(txttele);

		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelephone.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblTelephone.setForeground(new Color(255, 255, 255));
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelephone.setBounds(43, 201, 141, 27);
		getContentPane().add(lblTelephone);

		JLabel lblDateEmbauche = new JLabel("Date Embauche :");
		lblDateEmbauche.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateEmbauche.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblDateEmbauche.setForeground(new Color(255, 255, 255));
		lblDateEmbauche.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateEmbauche.setBounds(43, 277, 141, 34);
		getContentPane().add(lblDateEmbauche);

		JButton btnadd = new JButton("Ajouter Pilote");
		btnadd.setIcon(new ImageIcon(AddPilote.class.getResource("/img src/add.png")));
		btnadd.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnadd.setForeground(new Color(0, 0, 0));
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (txtnom.getText().isEmpty() || txtprenom.getText().isEmpty() || txtaddr.getText().isEmpty()
							|| txttele.getText().isEmpty() || datePicker.getComponentDateTextField().getText().isEmpty()
							|| datePicker2.getComponentDateTextField().getText().isEmpty()) {
						chekingforumisEmpty();
					} else {

						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						// Date date
						// =format.parse(datePicker.getDate().toString());

						Pilote p = new Pilote();
						p.setNom(txtnom.getText());
						p.setPrenom(txtprenom.getText());
						p.setAdresse(txtaddr.getText());
						p.setTel(txttele.getText());
						p.setDateNaissance(format.parse(datePicker.getDate().toString()));
						p.setDateEmbauche(format.parse(datePicker2.getDate().toString()));
						DaoPilote.AddPilote(p);

						JOptionPane.showMessageDialog(null, "Ajouter avec succès");
						ClearForum();
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnadd.setBounds(409, 134, 127, 34);
		getContentPane().add(btnadd);

		JButton btnclear = new JButton("Initialisair");
		btnclear.setIcon(new ImageIcon(AddPilote.class.getResource("/img src/eraser.png")));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclear.setForeground(new Color(0, 0, 0));
		btnclear.setBackground(new Color(255, 255, 255));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClearForum();

			}
		});
		btnclear.setBounds(409, 179, 127, 34);
		getContentPane().add(btnclear);

		JButton btnclose = new JButton("Fermer");
		btnclose.setIcon(new ImageIcon(AddPilote.class.getResource("/img src/close.png")));
		btnclose.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnclose.setForeground(new Color(0, 0, 0));
		btnclose.setBackground(new Color(255, 255, 255));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnclose.setBounds(409, 224, 127, 34);
		getContentPane().add(btnclose);

		datePicker = new DatePicker();
		datePicker.getComponentDateTextField().setOpaque(false);
		datePicker.getComponentToggleCalendarButton().setOpaque(false);
		datePicker.setBackground(new Color(154, 205, 50));
		datePicker.getComponentDateTextField().setDisabledTextColor(new Color(154, 205, 50));
		datePicker.getComponentDateTextField().setBackground(new Color(154, 205, 50));
		datePicker.getComponentDateTextField().setToolTipText("Choisie la date de Naissance");
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePicker.getComponentToggleCalendarButton().setForeground(new Color(154, 205, 50));
		datePicker.getComponentDateTextField().setForeground(new Color(255, 255, 255));
		datePicker.setForeground(new Color(255, 255, 255));
		datePicker.getComponentToggleCalendarButton()
				.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(AddPilote.class.getResource("/img src/calend2.png")));

		datePicker.getComponentToggleCalendarButton().setText("");

		datePicker.setBounds(194, 240, 180, 27);
		getContentPane().add(datePicker);

		datePicker2 = new DatePicker();
		datePicker2.getComponentDateTextField().setOpaque(false);
		datePicker2.getComponentToggleCalendarButton().setForeground(new Color(255, 255, 255));
		datePicker2.setBackground(new Color(154, 205, 50));
		datePicker2.getComponentDateTextField().setDisabledTextColor(new Color(154, 205, 50));
		datePicker2.getComponentDateTextField().setBackground(new Color(154, 205, 50));
		datePicker2.getComponentDateTextField().setToolTipText("Choisie la date D'embauche");
		datePicker2.getComponentDateTextField().setEditable(false);
		datePicker2.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePicker2.getComponentDateTextField().setForeground(new Color(255, 255, 255));
		datePicker2.setForeground(new Color(255, 255, 255));
		datePicker2.getComponentToggleCalendarButton()
				.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker2.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		datePicker2.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		datePicker2.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(AddPilote.class.getResource("/img src/calend2.png")));
		datePicker2.getComponentToggleCalendarButton().setText("");
		datePicker2.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker2.setBounds(194, 280, 180, 27);
		getContentPane().add(datePicker2);

		JLabel lblAjouterUnPilote = new JLabel("Ajouter un Pilote");
		lblAjouterUnPilote.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterUnPilote.setForeground(new Color(255, 255, 255));
		lblAjouterUnPilote.setFont(new Font("Segoe Print", Font.BOLD, 24));
		lblAjouterUnPilote.setBounds(149, 11, 265, 44);
		getContentPane().add(lblAjouterUnPilote);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtnom, txtprenom, txtaddr, txttele, datePicker.getComponentDateTextField(), datePicker2.getComponentDateTextField(), btnadd, btnclear, btnclose}));
		
		

		

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

	public void chekingforumisEmpty() {

		if (txtnom.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Nom");
			return;
		}
		if (txtprenom.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Prenom");
			return;
		}
		if (txtaddr.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie Adresse");
			return;
		}
		if (txttele.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie le Telephone");
			return;
		}
		if (datePicker.getComponentDateTextField().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie la Date de Naissace");
			return;
		}
		if (datePicker2.getComponentDateTextField().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saisie la Date Embauche");
			return;
		}
	}
}
