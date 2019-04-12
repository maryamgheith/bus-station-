package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JFormattedTextField;
import java.awt.GridBagConstraints;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ManagerGUII extends JFrame {
	ReadFile reader = new ReadFile();
	private String username;
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Launch the application.
	 */
	public void scene() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUII frame = new ManagerGUII(username);
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
	public ManagerGUII(String name) {
	
		reader.Readfile(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 438);
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(39, 54, 520, 207);
		getContentPane().add(list);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnLogout.setBounds(473, 311, 97, 25);
		getContentPane().add(btnLogout);
		
		JLabel lblTrips = new JLabel("Trips");
		lblTrips.setBounds(39, 30, 56, 16);
		getContentPane().add(lblTrips);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(473, 274, 97, 25);
		getContentPane().add(btnSave);
	}
}
