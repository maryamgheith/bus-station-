package application;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class ManagerGUI {

	private JFrame frame;
	private ReadFile reader;
	private JList tripsJList;
	LogIn log = new LogIn();
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public void Tripslist() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUI window = new ManagerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 595, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Show List Of Available Trips");
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList tripslist = new JList(listModel);
		tripslist.setVisible(false);
		tripslist.setBounds(41, 117, 390, 172);
		frame.getContentPane().add(tripslist);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadFile reader = new ReadFile();
				tripslist.setVisible(true);
				ArrayList<String> trips = new ArrayList<String>();
				trips = reader.Readfile("trips");
				for (int i=0;i<trips.size();i++)
					{
					listModel.addElement(trips.get(i));
					}
			}

		});
		btnNewButton.setBounds(12, 64, 193, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblWelcomeMohamed = new JLabel("Welcome Mohamed");
		lblWelcomeMohamed.setForeground(Color.BLUE);
		lblWelcomeMohamed.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblWelcomeMohamed.setBounds(27, 13, 228, 49);
		frame.getContentPane().add(lblWelcomeMohamed);
		
		JButton btnLogout = new JButton("logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn log = new LogIn();
				log.setVisible(true);
				
			}
		});
		btnLogout.setBounds(443, 232, 115, 25);
		frame.getContentPane().add(btnLogout);
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(443, 151, 114, 25);
		frame.getContentPane().add(btnSaveChanges);
		JButton btnDone = new JButton("Done");
		textField = new JTextField();
		textField.setBounds(41, 310, 390, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(443, 309, 97, 25);
		frame.getContentPane().add(btnAdd);
		btnAdd.setVisible(false);
		JButton btnAddNewTrip = new JButton("Add New Trip");
		btnAddNewTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd.setVisible(true);
				textField.setVisible(true);
				btnDone.setVisible(true);
			}
		});
		btnAddNewTrip.setBounds(443, 194, 115, 25);
		frame.getContentPane().add(btnAddNewTrip);
		
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAdd.setVisible(false);
				textField.setVisible(false);
				btnDone.setVisible(false);
			}
		});
		btnDone.setBounds(443, 340, 97, 25);
		frame.getContentPane().add(btnDone);
		
		
	}
}
