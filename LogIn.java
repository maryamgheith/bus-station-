package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;

public class LogIn extends JFrame {
	
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private ButtonGroup bg = new ButtonGroup();
	ReadFile reader = new ReadFile();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/*	public void close() {
 *    WindowEvent winClosingEvent = new WindowEvent(this..WINDOW_CLOSING);
 *
*	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
*	}
*/	public LogIn() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 3;
		gbc_lblUsername.gridy = 1;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 6;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 3;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 6;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		
		Box horizontalBox = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox = new GridBagConstraints();
		gbc_horizontalBox.gridwidth = 8;
		gbc_horizontalBox.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalBox.gridx = 3;
		gbc_horizontalBox.gridy = 4;
		contentPane.add(horizontalBox, gbc_horizontalBox);
		
		JRadioButton rdbtnManager = new JRadioButton("Manager");
		horizontalBox.add(rdbtnManager);
		
		JRadioButton rdbtnDriver = new JRadioButton("Driver");
		horizontalBox.add(rdbtnDriver);
		
		JRadioButton rdbtnPassenger = new JRadioButton("Passenger");
		horizontalBox.add(rdbtnPassenger);
		bg.add(rdbtnManager);
		bg.add(rdbtnDriver);
		bg.add(rdbtnPassenger);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				String Name;
				
				if (rdbtnManager.isSelected()==true) {
					
				if(password.equals("hi")==true&& username.equals("mohamed")==true) {
	//		close();
					ManagerGUI manager = new ManagerGUI();
					manager.Tripslist();
				}else
					JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
					
				}
				
				else if (rdbtnDriver.isSelected()==true) {
					Name=("drivers");
					if (reader.validateUsername(username, password, Name)==true)
					{
		//				close();
					DriverGUI driver = new DriverGUI(username);
				 driver.scene();
				}else{
					JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
					
				}
				}
				else if(rdbtnPassenger.isSelected()==true)
					{
		//			close();
					Name=("passengers");
					if (reader.validateUsername(username, password, Name)==true)
					{
					PassengerGUII passenger = new PassengerGUII(username);
					passenger.scenetwo();
				}
					else{
						JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
						
					}
					}
				else 
				{JOptionPane.showMessageDialog(null, "Please select a Radiobutton");
				}
				passwordField.setText(null);
				textField.setText(null);
				}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 10;
		gbc_btnLogin.gridy = 5;
		contentPane.add(btnLogin, gbc_btnLogin);
	}

}
