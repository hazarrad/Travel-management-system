package com.atelier16.Interfaces;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.atelier16.Dao.DaoPilote;
import com.atelier16.Dao.DaoVol;
import com.atelier16.entities.Pilote;
import com.atelier16.entities.VOL;
import com.atelier16.modeltable.modelPilote;
import com.atelier16.modeltable.modelVol;
import com.database.utils.ConnectionManager;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import com.github.lgooddatepicker.components.DatePicker;
import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class ConsultationPL extends JInternalFrame {
	private JTable table;
	private JTable table2;

	modelPilote mymodelpilote;
	modelVol myModelVol;
	private JLabel label;
	private JLabel lblLesPilotesQui;
	private DatePicker datePicker_1;
	private DatePicker datePicker;

	private ArrayList<VOL> vols;
	private JButton btnFilter;
	private JButton btnClear;
	// private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultationPL frame = new ConsultationPL();
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
	public ConsultationPL() {
		setFrameIcon(new ImageIcon(ConsultationPL.class.getResource("/img src/hat.png")));
		setVerifyInputWhenFocusTarget(false);
		setBorder(new LineBorder(Color.WHITE, 2));
		getContentPane().setBackground(new Color(154, 205, 50));
		setBounds(100, 100, 800, 565);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 111, 739, 189);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setGridColor(new Color(154, 205, 50));
		table.setOpaque(false);
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 339, 739, 174);
		getContentPane().add(scrollPane_1);

		table2 = new JTable();
		table2.setGridColor(new Color(154, 205, 50));
		table2.setOpaque(false);
		scrollPane_1.setViewportView(table2);

		JLabel lblNombreDeVol = new JLabel("nombre de vol");
		lblNombreDeVol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreDeVol.setForeground(new Color(255, 255, 255));
		lblNombreDeVol.setBounds(28, 306, 139, 24);
		getContentPane().add(lblNombreDeVol);

		label = new JLabel("0");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(177, 306, 45, 24);
		getContentPane().add(label);

		lblLesPilotesQui = new JLabel("LES PILOTES QUI ONT VOLS");
		lblLesPilotesQui.setForeground(new Color(255, 255, 255));
		lblLesPilotesQui.setFont(new Font("Segoe Print", Font.BOLD, 32));
		lblLesPilotesQui.setBounds(134, 6, 513, 57);
		getContentPane().add(lblLesPilotesQui);

		datePicker = new DatePicker();
		datePicker.getComponentDateTextField().setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.getComponentDateTextField().setForeground(new Color(0, 0, 0));
		datePicker.getComponentToggleCalendarButton()
				.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		datePicker.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		datePicker.setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker.getComponentToggleCalendarButton().setText("");
		datePicker.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(ConsultationPL.class.getResource("/img src/calend2.png")));
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.setBounds(80, 67, 185, 30);
		getContentPane().add(datePicker);

		datePicker_1 = new DatePicker();
		datePicker_1.getComponentDateTextField().setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		datePicker_1.getComponentToggleCalendarButton()
				.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		datePicker_1.getComponentDateTextField().setHorizontalAlignment(SwingConstants.CENTER);
		datePicker_1.setBackground(new Color(154, 205, 50));
		datePicker_1.getComponentToggleCalendarButton().setBackground(new Color(154, 205, 50));
		datePicker_1.getComponentToggleCalendarButton().setText("");
		datePicker_1.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(ConsultationPL.class.getResource("/img src/calend2.png")));
		datePicker_1.getComponentDateTextField().setEditable(false);
		datePicker_1.setBounds(315, 67, 185, 30);
		getContentPane().add(datePicker_1);

		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(Color.WHITE);
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTo.setBounds(265, 67, 54, 30);
		getContentPane().add(lblTo);

		try {
			ArrayList<Pilote> pilotes = DaoPilote.getAllPilote();
			vols = DaoPilote.GetAllVol(0);

			mymodelpilote = new modelPilote(pilotes);
			myModelVol = new modelVol(vols);

			table.setModel(mymodelpilote);
			table2.setModel(myModelVol);

		} catch (Exception e) {
			// TODO: handle exception
		}

		// this is code for display table when the changed values
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub

				try {
					int id = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());

					ArrayList<VOL> vols = DaoPilote.GetAllVol(id);
					label.setText(String.valueOf(vols.size()));
					myModelVol = new modelVol(vols);
					table2.setModel(myModelVol);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnFilter = new JButton("Filtrer");
		btnFilter.setFocusPainted(false);
		btnFilter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFilter.setBackground(new Color(255, 255, 255));
		btnFilter.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				
				ArrayList<Pilote> pilotes;
				try {
					
					if (datePicker.getComponentDateTextField().getText().isEmpty()|| datePicker_1.getComponentDateTextField().getText().isEmpty()) {
						chekingforumisEmpty();
					} else {

					Date dd = Date.valueOf(datePicker.getDate());
					Date df = Date.valueOf(datePicker_1.getDate());
					
					pilotes = DaoPilote.getAllFiltreDateEmbauche(dd, df);
					mymodelpilote = new modelPilote(pilotes);
					table.setModel(mymodelpilote);
				} 
				}catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnFilter.setBounds(531, 67, 113, 30);
		getContentPane().add(btnFilter);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Pilote> pilotes =new ArrayList<>();
				try {
					pilotes = DaoPilote.getAllPilote();
					mymodelpilote=new modelPilote(pilotes);
					
					table.setModel(mymodelpilote);
					
					
					
					datePicker.setText("");
					datePicker_1.setText("");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setFocusPainted(false);
		btnClear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(654, 67, 113, 30);
		getContentPane().add(btnClear);

	}

	public void chekingforumisEmpty() {

		if (datePicker.getComponentDateTextField().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Choisie la Date de Debut");
			return;
		}
		if (datePicker_1.getComponentDateTextField().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Choisie la Date de fin");
			return;
		}
	}
}
