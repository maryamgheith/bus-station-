package application;

import java.awt.EventQueue;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class PassengerGUII extends JFrame {
	
	private static final long serialVersionUID = 1L;
	FileMethods reader = new FileMethods();
	private JPanel contentPane;
	private String username;
	private JTextField textField;
   private double p;
	public void setUsername(String username) {
		this.username = username;
	}

	
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

	
	public PassengerGUII(String username) {
		setUsername(username);
		int i;
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		ArrayList<String> trips = new ArrayList<String>();
		trips = reader.Readfile(username);
		for (i = 0; i < trips.size(); i++) {
			listModel.addElement(trips.get(i));
		}
		
		JScrollPane listScroller2 = new JScrollPane();
		listScroller2.setSize(380, 70);
		listScroller2.setLocation(20, 10);
		JPanel panel_2 = new JPanel();
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
		panel.setBounds(0, 59, 422, 127);
		Passengerpanel.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JPanel panelofnoreserved = new JPanel();
		panel.add(panelofnoreserved, "name_86513948264900");
		panelofnoreserved.setVisible(true);
		panelofnoreserved.setLayout(null);
		reservepanel.setVisible(false);
		JButton btnReserveTicket = new JButton("Reserve Ticket");
		btnReserveTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservepanel.setVisible(true);
				Passengerpanel.setVisible(false);
				panel_2.setVisible(true);
				listScroller2.setVisible(false);
				
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
		
		JButton btnEditTicket = new JButton("Cancel Ticket");
		btnEditTicket.setBounds(269, 88, 141, 27);
		panelofreserved.add(btnEditTicket);
		
		JButton button = new JButton("Reserve Ticket");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservepanel.setVisible(true);
				Passengerpanel.setVisible(false);
				panel_2.setVisible(true);
				listScroller2.setVisible(false);
				
			}
		});
		button.setBounds(140, 89, 117, 25);
		panelofreserved.add(button);
		
		JButton btnSave = new JButton("Save");
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					for (int i=0;i<listModel.size();i++) {
				try {
					
					reader.overwriteToFile(username, listModel.get(i));
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}}
		});
		btnSave.setBounds(22, 89, 97, 25);
		panelofreserved.add(btnSave);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setSize(380, 70);
		listScroller.setLocation(20, 10);
		trips = reader.Readfile(username);
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(String s:trips){
		    model.addElement(s);
		}
		JList<String> list = new JList<String>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(22, 0, 368, 75);
		panelofreserved.add(listScroller);
		
		
        listScroller.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        

		btnEditTicket.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				listModel.remove(list.getSelectedIndex());
				if (list.isSelectionEmpty())
					btnEditTicket.setEnabled(false);
				btnSave.setVisible(true);
				

			}
		});
		i=reader.reservation(username);
		if (i == 1) {
			panelofreserved.setVisible(true);
			panelofnoreserved.setVisible(false);
		} else {
			panelofreserved.setVisible(false);
			panelofnoreserved.setVisible(true);
		}
		DefaultListModel<String> listModel2 = new DefaultListModel<String>();
		JList<String> list_1 = new JList<String>(listModel2);
		contentPane.add(reservepanel, "name_86120203560700");
		reservepanel.setLayout(null);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
        
		

		JLabel lblReserveATicket = new JLabel("Reserve a ticket:");
		lblReserveATicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReserveATicket.setBounds(12, 13, 129, 40);
		reservepanel.add(lblReserveATicket);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 scenetwo();
				 
				

			}
		});
		btnBack.setBounds(313, 172, 97, 25);
		reservepanel.add(btnBack);

		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedTrip = list_1.getSelectedValue();
				try {
					reader.writeToFile(username, selectedTrip);
				
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnSave_1.setBounds(313, 205, 97, 25);
		reservepanel.add(btnSave_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 54, 372, 115);
		reservepanel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JLabel lblTickets = new JLabel("Tickets:");
		lblTickets.setBounds(211, 51, 56, 16);
		panel_2.add(lblTickets);
		lblTickets.setVisible(false);
		textField = new JTextField();
		textField.setBounds(263, 48, 97, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select vehicle", "Bus", "Car", "Limo"}));
		String vehicle=(String) comboBox.getSelectedItem();
		if (vehicle.equalsIgnoreCase("bus"));
		{lblTickets.setVisible(false);
		textField.setVisible(false);
		}
		
		comboBox.setToolTipText("");
		comboBox.setBounds(211, 13, 149, 22);
		panel_2.add(comboBox);
		
		
		
		panel_1.add(panel_2, "name_135892225643100");
		panel_2.setLayout(null);

		JComboBox<String> comboBoxType = new JComboBox<String>();
		comboBoxType.setModel(new DefaultComboBoxModel<String>(new String[] { "Select type of trip", "Internal", "External" }));
		comboBoxType.setBounds(26, 13, 173, 22);
		panel_2.add(comboBoxType);
		JLabel lblPrice = new JLabel("Price:"+p);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(32, 181, 91, 49);
		reservepanel.add(lblPrice);

		JComboBox<String> comboBoxNStops = new JComboBox<String>();
		comboBoxNStops.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Number of Stops", "Nonstop", "One-Stop", "Many Stops" }));
		comboBoxNStops.setBounds(26, 48, 173, 22);
		panel_2.add(comboBoxNStops);

		JComboBox<String> comboBoxTicket = new JComboBox<String>();
		comboBoxTicket.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Type of ticket", "Single Ticket", "Round Trip Ticket" }));
		comboBoxTicket.setBounds(22, 80, 177, 22);
		panel_2.add(comboBoxTicket);
		listScroller2.setVisible(false);
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s = (String) comboBoxType.getSelectedItem();
				String N = (String) comboBoxNStops.getSelectedItem();
				String T = (String) comboBoxTicket.getSelectedItem();
				  if (s.equalsIgnoreCase("Select type of trip")||N.equalsIgnoreCase("Number of Stops")||T.equalsIgnoreCase("Type of ticket"))
		            		JOptionPane.showMessageDialog(null, "Make Sure you Select all Info"); 
				  else {
					  if (vehicle.equalsIgnoreCase("bus"))
			          {
			            	int x=Integer.parseInt(textField.getText());
			            			Bus veh= new Bus(x);
			            			p=veh.price(s,T,N);
			            			 System.out.println(p);
			            			
			          }
			            else if (vehicle.equalsIgnoreCase("car"))
			            {
			            	Car veh = new Car();
			            	p=veh.price(s,T,N);
			            	 System.out.println(p);
			            	
			            }
			            else if (vehicle.equalsIgnoreCase("Limo")) 
			            {
			            	Limo veh = new Limo();
			            	 p=veh.price(s,T,N);
			            	 System.out.println(p);
			            }
			            lblPrice.setText( Double.toString(p) );
				panel_2.setVisible(false);
				listScroller2.setVisible(true);
				ArrayList<String> trips2 = new ArrayList<String>();
				trips2 = reader.Readfile(s);
				for (int i = 0; i < trips2.size(); i++) {
					listModel2.addElement(trips2.get(i));
				}
            
				 System.out.println(p);
				  }
			
			}});
		btnNext.setBounds(240, 79, 97, 25);
		panel_2.add(btnNext);
		

		
		
		panelofreserved.add(listScroller);
		
		
        listScroller2.setViewportView(list_1);
        list.setLayoutOrientation(JList.VERTICAL);
		panel_1.add(listScroller2);
		

		list_1.setBounds(23, 13, 337, 89);
		

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LogIn frame2 = new LogIn();
				frame2.setVisible(true);
			}
		});
	}
}
