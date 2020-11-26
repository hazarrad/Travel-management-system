package com.atelier16.Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.atelier16.Dao.DaoPilote;
import com.atelier16.entities.Pilote;
import com.database.utils.ConnectionManager;
import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class jasper extends JFrame {

	private JPanel contentPane;
	ArrayList<Pilote> pilotes;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jasper frame = new jasper();
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
	public jasper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FileInputStream in=new FileInputStream(new File("C:\\Users\\Studio\\Documents\\Developement JAVA\\JAVA-J2EE\\workspace\\workspace Swing\\Atelier16\\src\\ReportPilotes.jrxml"));

					JasperDesign jd=JRXmlLoader.load(in);
					String sql="select*from pilote";
					JRDesignQuery jq=new JRDesignQuery();
					jq.setText(sql);
					jd.setQuery(jq);
					
					
					JasperReport report=JasperCompileManager.compileReport(jd);
					HashMap para=new HashMap<>();
					JasperPrint print=JasperFillManager.fillReport(report,para,ConnectionManager.getInstance());
					JasperViewer.viewReport(print,false);
					FileOutputStream os=new FileOutputStream(new File(""));
					JasperExportManager.exportReportToPdfStream(print, os);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(118, 107, 164, 49);
		contentPane.add(btnNewButton);
		
		
		
		}

}

