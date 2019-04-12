package application;


import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class PassengerGUII extends JFrame {
	ReadFile reader = new ReadFile();
	private JPanel contentPane;
private String username;
public void setUsername(String username) {
	this.username = username;
}

	/**
	 * Launch the application.
	*/ 
	public void scenetwo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerGUII frame = new PassengerGUII(username);
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
	public PassengerGUII(String username) {
		setUsername(username);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		JPanel reservepanel = new JPanel();
		JPanel Passengerpanel = new JPanel();
		contentPane.add(Passengerpanel, "name_86120177704000");
		Passengerpanel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(48, 25, 134, 35);
		Passengerpanel.add(lblWelcome);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(317, 186, 71, 25);
		Passengerpanel.add(btnLogout);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 59, 422, 105);
			Passengerpanel.add(panel);
			panel.setLayout(new CardLayout(0, 0));
			
			JPanel panelofnoreserved = new JPanel();
			panel.add(panelofnoreserved, "name_86513948264900");
			panelofnoreserved.setVisible(true);
			panelofnoreserved.setLayout(null);
			
			JButton btnReserveTicket = new JButton("Reserve Ticket");
			btnReserveTicket.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reservepanel.setVisible(true);
					Passengerpanel.setVisible(false);
				}
			});
			btnReserveTicket.setBounds(274, 56, 117, 25);
			panelofnoreserved.add(btnReserveTicket);
			
			JLabel lblNoReservedTickets = new JLabel("No Reserved Tickets");
			lblNoReservedTickets.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNoReservedTickets.setBounds(12, 13, 255, 48);
			panelofnoreserved.add(lblNoReservedTickets);
			
				JPanel panelofreserved = new JPanel();
				panel.add(panelofreserved, "name_86513975025800");
				panelofreserved.setLayout(null);
				panelofreserved.setVisible(false);
				
				JPanel panel_edit = new JPanel();
				panel_edit.setBounds(22, 55, 382, 27);
				panelofreserved.add(panel_edit);
				panel_edit.setLayout(new CardLayout(0, 0));
				
				JPanel panel_editbtn = new JPanel();
				panel_edit.add(panel_editbtn, "name_84907167223600");
				panel_editbtn.setLayout(null);
				
				panel_editbtn.setVisible(true);
				JPanel panel_save = new JPanel();
				panel_edit.add(panel_save, "name_84972608968700");
				panel_save.setLayout(null);
				
				JButton btnEditTicket = new JButton("Edit Ticket");
				btnEditTicket.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_editbtn.setVisible(false);
						panel_save.setVisible(true);
					}
				});
				btnEditTicket.setBounds(279, 0, 91, 25);
				panel_editbtn.add(btnEditTicket);
				
				
				JButton btnDiscardChanges = new JButton("Discard Changes");
				btnDiscardChanges.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_editbtn.setVisible(true);
						panel_save.setVisible(false);
					}
				});
				btnDiscardChanges.setBounds(173, 0, 127, 25);
				panel_save.add(btnDiscardChanges);
				
				JButton btnSave = new JButton("Save");
				btnSave.setBounds(309, 0, 61, 25);
				panel_save.add(btnSave);
				
				
				JList list = new JList();
				list.setBounds(22, 8, 358, 34);
				panelofreserved.add(list);
			
			
			panelofnoreserved.setVisible(false);
		
		
		contentPane.add(reservepanel, "name_86120203560700");
		reservepanel.setLayout(null);
		
		JLabel lblReserveATicket = new JLabel("Reserve a ticket:");
		lblReserveATicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReserveATicket.setBounds(12, 13, 129, 40);
		reservepanel.add(lblReserveATicket);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservepanel.setVisible(false);
				Passengerpanel.setVisible(true);
				
			}
		});
		btnDiscard.setBounds(313, 172, 97, 25);
		reservepanel.add(btnDiscard);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setBounds(313, 205, 97, 25);
		reservepanel.add(btnSave_1);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogIn frame2 = new LogIn();
				frame2.setVisible(true);
			}
		});
	}
}
