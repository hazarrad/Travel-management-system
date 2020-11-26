package com.atelier16.Interfaces;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import javafx.scene.layout.Background;
//import javafx.scene.web.HTMLEditor;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.border.LineBorder;

import com.database.utils.ConnectionManager;

import javax.swing.DebugGraphics;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.MatteBorder;
import javax.swing.text.html.HTML;

public class MainClass extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	ConsultationPL cp = new ConsultationPL();
	AddPilote ap = new AddPilote();
	EditPilote ep = new EditPilote();
	AddAvion aa = new AddAvion();
	EditAvion ea = new EditAvion();
	AddTrajet at = new AddTrajet();
	EditTrajet et = new EditTrajet();
	AddVol av = new AddVol();
	EditVol ev = new EditVol();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainClass() {
		setUndecorated(true);
		setBackground(Color.YELLOW);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 255, 153));
		contentPane.setBackground(new Color(102, 102, 204));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);

		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(755, 0, 50, 35);
		desktopPane.add(btnNewButton);

		JLabel lblWelcomeToThe = new JLabel("Bienvenu A Vols");
		lblWelcomeToThe.setForeground(new Color(154, 205, 50));
		lblWelcomeToThe.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 72));
		lblWelcomeToThe.setBounds(100, 34, 608, 123);
		desktopPane.add(lblWelcomeToThe);

		JTextPane txtpnMesdamesEtMessieurs = new JTextPane();
		txtpnMesdamesEtMessieurs.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		txtpnMesdamesEtMessieurs.setText("Mesdames et Messieurs, Nous vous souhaitons un bon voyage.");
		txtpnMesdamesEtMessieurs.setBounds(521, 264, 236, 186);
		desktopPane.add(txtpnMesdamesEtMessieurs);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainClass.class.getResource("/img src/trips.png")));
		label.setBounds(-44, 205, 512, 411);
		desktopPane.add(label);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 35);
		desktopPane.add(menuBar);
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		menuBar.setBackground(new Color(154, 205, 50));
		menuBar.setBorderPainted(false);

		JMenu mnNewMenu = new JMenu("Pilote");
		mnNewMenu.setIcon(new ImageIcon(MainClass.class.getResource("/img src/hat.png")));
		mnNewMenu.setBorderPainted(true);
		mnNewMenu.setBackground(new Color(255, 255, 255));
		mnNewMenu.setForeground(new Color(255, 255, 255));

		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnNewMenu);

		JMenuItem mntmConsultationpl = new JMenuItem("Consultation Pilote");
		mntmConsultationpl.setIcon(new ImageIcon(MainClass.class.getResource("/img src/hat.png")));
		mntmConsultationpl.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmConsultationpl.setHorizontalAlignment(SwingConstants.LEFT);
		mntmConsultationpl.setForeground(new Color(255, 255, 255));
		mntmConsultationpl.setBackground(new Color(154, 205, 50));
		mntmConsultationpl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cp.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {

					cp = new ConsultationPL();
					desktopPane.add(cp, 1);
					cp.setTitle("Consultation des pilotes");
					cp.setClosable(true);
					cp.setBounds(0, 35, 800, 565);
					DisplayPopup(cp, ap, ep, ev, ea, at, et, av, aa);

				}

			}
		});
		mnNewMenu.add(mntmConsultationpl);

		JMenuItem mntmAddPilote = new JMenuItem("Ajouter Pilote");
		mntmAddPilote.setIcon(new ImageIcon(MainClass.class.getResource("/img src/add.png")));
		mntmAddPilote.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmAddPilote.setHorizontalAlignment(SwingConstants.LEFT);
		mntmAddPilote.setForeground(new Color(255, 255, 255));
		mntmAddPilote.setBackground(new Color(154, 205, 50));
		mntmAddPilote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ap.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {
					ap = new AddPilote();
					desktopPane.add(ap, 1);
					ap.setTitle("Ajouter pilote");
					ap.setClosable(true);
					ap.setBounds(115, 110, 569, 407);
					DisplayPopup(ap, ev, ep, cp, ea, at, et, av, aa);

				}
			}
		});
		mnNewMenu.add(mntmAddPilote);

		JMenuItem mntmEditPilote = new JMenuItem("Modifier un Pilote");
		mntmEditPilote.setIcon(new ImageIcon(MainClass.class.getResource("/img src/edit.png")));
		mntmEditPilote.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmEditPilote.setHorizontalAlignment(SwingConstants.LEFT);
		mntmEditPilote.setForeground(new Color(255, 255, 255));
		mntmEditPilote.setBackground(new Color(154, 205, 50));
		mntmEditPilote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ep.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {

					ep = new EditPilote();
					desktopPane.add(ep, 1);
					ep.setTitle("Modifier des pilotes");
					ep.setClosable(true);
					ep.setBounds(115, 110, 569, 407);
					DisplayPopup(ep, ap, ev, cp, ea, at, et, av, aa);

				}

			}
		});
		mnNewMenu.add(mntmEditPilote);

		JMenu mnAvion = new JMenu("Avion");
		mnAvion.setIcon(new ImageIcon(MainClass.class.getResource("/img src/airplane.png")));
		mnAvion.setForeground(new Color(255, 255, 255));
		mnAvion.setHorizontalAlignment(SwingConstants.CENTER);
		mnAvion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAvion);

		JMenuItem mntmAddAvion = new JMenuItem("Ajouter Avion");
		mntmAddAvion.setForeground(new Color(255, 255, 255));
		mntmAddAvion.setBackground(new Color(154, 205, 50));
		mntmAddAvion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmAddAvion.setIcon(new ImageIcon(MainClass.class.getResource("/img src/add.png")));
		mntmAddAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (aa.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {
					aa = new AddAvion();
					desktopPane.add(aa, 1);
					aa.setTitle("Ajouter des Avion");
					aa.setClosable(true);
					aa.setBounds(115, 140, 569, 340);
					DisplayPopup(aa, ap, ep, cp, ea, at, et, av, ev);

				}

			}
		});
		mnAvion.add(mntmAddAvion);

		JMenuItem mntmEditAvion = new JMenuItem("Modifier Avion");
		mntmEditAvion.setForeground(new Color(255, 255, 255));
		mntmEditAvion.setBackground(new Color(154, 205, 50));
		mntmEditAvion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmEditAvion.setIcon(new ImageIcon(MainClass.class.getResource("/img src/edit.png")));
		mntmEditAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ea.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {
					ea = new EditAvion();
					desktopPane.add(ea, 1);
					ea.setTitle("Modifier des Avion");
					ea.setClosable(true);
					ea.setBounds(115, 140, 569, 340);
					DisplayPopup(ea, ap, ep, cp, ev, at, et, av, aa);

				}

			}
		});
		mnAvion.add(mntmEditAvion);

		JMenu mnNewMenu_1 = new JMenu("Trajet");
		mnNewMenu_1.setIcon(new ImageIcon(MainClass.class.getResource("/img src/position.png")));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmAddTrajet = new JMenuItem("Ajouter Trajet");
		mntmAddTrajet.setForeground(new Color(255, 255, 255));
		mntmAddTrajet.setBackground(new Color(154, 205, 50));
		mntmAddTrajet.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmAddTrajet.setIcon(new ImageIcon(MainClass.class.getResource("/img src/add.png")));
		mntmAddTrajet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (at.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {

					at = new AddTrajet();
					desktopPane.add(at, 1);
					at.setTitle("Ajouter des Trajet");
					at.setClosable(true);
					at.setBounds(115, 140, 569, 340);
					DisplayPopup(at, ap, ep, cp, ea, ev, et, av, aa);

				}

			}
		});
		mnNewMenu_1.add(mntmAddTrajet);

		JMenuItem mntmEditTrajet = new JMenuItem("Modifier Trajet");
		mntmEditTrajet.setForeground(new Color(255, 255, 255));
		mntmEditTrajet.setBackground(new Color(154, 205, 50));
		mntmEditTrajet.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmEditTrajet.setIcon(new ImageIcon(MainClass.class.getResource("/img src/edit.png")));
		mntmEditTrajet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (et.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {
					et = new EditTrajet();
					desktopPane.add(et, 1);
					et.setTitle("Modifier des Trajet");
					et.setClosable(true);
					et.setBounds(115, 140, 569, 340);
					DisplayPopup(et, ap, ep, cp, ea, at, ev, av, aa);

				}

			}
		});
		mnNewMenu_1.add(mntmEditTrajet);

		JMenu mnPropose = new JMenu("Vol");
		mnPropose.setIcon(new ImageIcon(MainClass.class.getResource("/img src/world.png")));
		mnPropose.setForeground(new Color(255, 255, 255));
		mnPropose.setHorizontalAlignment(SwingConstants.CENTER);
		mnPropose.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnPropose);

		JMenuItem mntmAddVol = new JMenuItem("Ajouter Vol");
		mntmAddVol.setIcon(new ImageIcon(MainClass.class.getResource("/img src/add.png")));
		mntmAddVol.setForeground(new Color(255, 255, 255));
		mntmAddVol.setBackground(new Color(154, 205, 50));
		mntmAddVol.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmAddVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				if (av.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {
					av = new AddVol();
					desktopPane.add(av, 1);
					av.setTitle("Ajouter des Vol");
					av.setClosable(true);
					av.setBounds(115, 110, 569, 407);
					DisplayPopup(av, ap, ep, cp, ea, at, et, ev, aa);

				}

			}
		});
		mnPropose.add(mntmAddVol);

		JMenuItem mntmEditVol = new JMenuItem("Modifier Vol");
		mntmEditVol.setIcon(new ImageIcon(MainClass.class.getResource("/img src/edit.png")));
		mntmEditVol.setForeground(new Color(255, 255, 255));
		mntmEditVol.setBackground(new Color(154, 205, 50));
		mntmEditVol.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmEditVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ev.isVisible() == true) {
					JOptionPane.showMessageDialog(null, "Est Une Visible");
				} else {

					ev = new EditVol();
					desktopPane.add(ev);
					ev.setTitle("Modifier des Vol");
					ev.setClosable(true);
					ev.setBounds(115, 110, 569, 407);
					DisplayPopup(ev, ap, ep, cp, ea, at, et, av, aa);

				}

			}
		});
		mnPropose.add(mntmEditVol);

	}

	public void DisplayPopup(JInternalFrame c1, JInternalFrame c2, JInternalFrame c3, JInternalFrame c4,
			JInternalFrame c5, JInternalFrame c6, JInternalFrame c7, JInternalFrame c8, JInternalFrame c9) {
		c1.setVisible(true);
		c2.dispose();
		c3.dispose();
		c4.dispose();
		c5.dispose();
		c6.dispose();
		c7.dispose();
		c8.dispose();
		c9.dispose();

	}
}
