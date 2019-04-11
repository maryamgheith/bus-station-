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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnEditTicket = new JButton("Edit Ticket");
		GridBagConstraints gbc_btnEditTicket = new GridBagConstraints();
		gbc_btnEditTicket.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditTicket.gridx = 10;
		gbc_btnEditTicket.gridy = 3;
		contentPane.add(btnEditTicket, gbc_btnEditTicket);
		
		JButton btnReserveTicket = new JButton("Reserve Ticket");
		GridBagConstraints gbc_btnReserveTicket = new GridBagConstraints();
		gbc_btnReserveTicket.insets = new Insets(0, 0, 5, 0);
		gbc_btnReserveTicket.gridx = 10;
		gbc_btnReserveTicket.gridy = 4;
		contentPane.add(btnReserveTicket, gbc_btnReserveTicket);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogIn frame2 = new LogIn();
				frame2.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogout.gridx = 10;
		gbc_btnLogout.gridy = 5;
		contentPane.add(btnLogout, gbc_btnLogout);
	}


}
