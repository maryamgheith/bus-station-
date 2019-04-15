package application;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class DriverGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileMethods reader = new FileMethods();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private String username;
	public void setUsername(String username) {
		this.username = username;
	}
	public void scene() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverGUI frame = new DriverGUI(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public DriverGUI (String name) {
		setUsername(name);
		FileMethods reader = new FileMethods();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton_1 = new JButton("Assigned Trips:");
		btnNewButton_1.setBounds(25, 43, 139, 25);
		contentPane.add(btnNewButton_1);
		String n;
		n=name;

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(25, 73, 390, 111);
contentPane.add(scrollPane);
DefaultListModel<String> listModel = new DefaultListModel<>();
JList<String> tripslist = new JList<String>(listModel);
scrollPane.setViewportView(tripslist);
tripslist.setVisible(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tripslist.setVisible(true);
				ArrayList<String> trips = new ArrayList<String>();
				trips = reader.Readfile(n);
				for (int i=0;i<trips.size();i++)
					{
					listModel.addElement(trips.get(i));
					}
			}

		});
		
		
    
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn frame2 = new LogIn();
				frame2.setVisible(true);
			}
		});
		btnLogout.setBounds(291, 197, 97, 25);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel(n);
		lblNewLabel.setBounds(42, 13, 139, 32);
		contentPane.add(lblNewLabel);
		
		
	}
}
