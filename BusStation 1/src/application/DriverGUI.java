package application;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;

public class DriverGUI extends JFrame {
	ReadFile reader = new ReadFile();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignedTrips = new JLabel("Assigned Trips:");
		lblAssignedTrips.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAssignedTrips.setBounds(25, 34, 96, 41);
		contentPane.add(lblAssignedTrips);
		
		JList list = new JList();
		list.setBounds(300, 175, -138, -100);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(25, 72, 363, 105);
		contentPane.add(list_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(291, 197, 97, 25);
		contentPane.add(btnLogout);
	}

}
