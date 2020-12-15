package Gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import award_m.*;

public class Registration {

	JFrame frame;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtDob;
	private JTextField txtPin;
	private JTextField txtSalary;
	private JTextField txtYearofi;
	private JTextField txtBudget;
	private JTextField txtstory;
	private JTextField txtYearofw;
	private JTextField txtCategeory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(200, 200, 550, 400);
	    frame.getContentPane().setFont(new Font("Helvetica Neue", Font.BOLD, 14));
	    frame.getContentPane().setBackground(new Color(153, 103, 255));
	    frame.getContentPane().setForeground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Register");
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setBounds(58, 12, 90, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setBounds(58, 42, 90, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Street");
		lblNewLabel_2.setBounds(58, 72, 90, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblCity = new JLabel("city");
		lblCity.setBounds(58, 102, 70, 15);
		frame.getContentPane().add(lblCity);
		
		JLabel lblPin = new JLabel("pin");
		lblPin.setBounds(58, 132, 70, 15);
		frame.getContentPane().add(lblPin);
		
		JLabel lblDob = new JLabel("Dob");
		lblDob.setBounds(58, 162, 70, 15);
		frame.getContentPane().add(lblDob);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setBounds(58, 192, 70, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblSalary = new JLabel("salary");
		lblSalary.setBounds(58, 222, 70, 15);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblRecievedAwards = new JLabel("Recieved Awards");
		lblRecievedAwards.setBounds(58, 252, 150, 15);
		frame.getContentPane().add(lblRecievedAwards);
		
		txtFname = new JTextField();
		txtFname.setText("fname");
		txtFname.setBounds(274, 10, 114, 19);
		frame.getContentPane().add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setText("lname");
		txtLname.setBounds(274, 40, 114, 19);
		frame.getContentPane().add(txtLname);
		txtLname.setColumns(10);
		
		txtStreet = new JTextField();
		txtStreet.setText("street");
		txtStreet.setBounds(274, 68, 114, 19);
		frame.getContentPane().add(txtStreet);
		txtStreet.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setText("city");
		txtCity.setBounds(274, 100, 114, 19);
		frame.getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(274, 190, 44, 20);
		frame.getContentPane().add(spinner);
		
		txtDob = new JTextField();
		txtDob.setText("2001-10-10");
		txtDob.setBounds(274, 162, 114, 15);
		frame.getContentPane().add(txtDob);
		txtDob.setColumns(10);
		
		txtPin = new JTextField();
		txtPin.setText("673307");
		txtPin.setBounds(274, 130, 114, 19);
		frame.getContentPane().add(txtPin);
		txtPin.setColumns(10);
		
		txtSalary = new JTextField();
		txtSalary.setText("50000");
		txtSalary.setBounds(274, 220, 114, 19);
		frame.getContentPane().add(txtSalary);
		txtSalary.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(274, 252, 100, 100);
		frame.getContentPane().add(textArea);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register one= new Register(txtFname.getText(),txtLname.getText(),txtStreet.getText(),txtCity.getText(),Integer.parseInt(txtPin.getText()),Integer.parseInt(txtSalary.getText()),txtDob.getText(),(int) spinner.getValue(),textArea.getText());
				boolean next=one.Do_registration();
				if(next) {
					frame.setVisible(false);
					frame = new JFrame();
					frame.getContentPane().setForeground(Color.RED);
					frame.setBounds(200, 200, 550, 400);
				    frame.getContentPane().setFont(new Font("Helvetica Neue", Font.BOLD, 14));
				    frame.getContentPane().setBackground(new Color(153, 103, 255));
				    frame.getContentPane().setForeground(Color.BLACK);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setTitle("Invention");
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
					
					JLabel lblNewLabel_1 = new JLabel("Year of Invention");
					lblNewLabel_1.setBounds(58, 42, 120, 15);
					frame.getContentPane().add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel("Budget");
					lblNewLabel_2.setBounds(58, 72, 120, 15);
					frame.getContentPane().add(lblNewLabel_2);
					
					
					JLabel lblNewLabel_4 = new JLabel("Year of Win");
					lblNewLabel_4.setBounds(58, 132, 120, 15);
					frame.getContentPane().add(lblNewLabel_4);
					
					JLabel lblNewLabel_5 = new JLabel("Categeory");
					lblNewLabel_5.setBounds(58, 162, 120, 15);
					frame.getContentPane().add(lblNewLabel_5);
					
					JLabel lblNewLabel_3 = new JLabel("Story");
					lblNewLabel_3.setBounds(58, 200, 120, 15);
					frame.getContentPane().add(lblNewLabel_3);
					
					
					txtYearofi = new JTextField();
					txtYearofi.setText("2020");
					txtYearofi.setBounds(274, 42, 120, 15);
					frame.getContentPane().add(txtYearofi);
					txtYearofi.setColumns(10);
					
					txtBudget = new JTextField();
					txtBudget.setText("5000");
					txtBudget.setBounds(274, 72, 120, 15);
					frame.getContentPane().add(txtBudget);
					txtBudget.setColumns(10);
					
					JTextArea textArea2 = new JTextArea();
					textArea2.setBounds(274, 252, 100, 100);
					frame.getContentPane().add(textArea2);
					
					txtYearofw = new JTextField();
					txtYearofw.setText("2021");
					txtYearofw.setBounds(274, 132, 120, 15);
					frame.getContentPane().add(txtYearofw);
					txtYearofw.setColumns(10);
					
				    String categeory[]={"Science","Technology","Mathemetics","Literature"};        
				    JComboBox cb=new JComboBox(categeory);
					cb.setBounds(274, 162, 120, 15);
					frame.add(cb);
					
					JButton button2 = new JButton("Add");
					button2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.setVisible(false);
							one.add_invention(Integer.parseInt(txtYearofi.getText()),Integer.parseInt(txtBudget.getText()),textArea2.getText(),Integer.parseInt(txtYearofw.getText()),cb.getSelectedItem().toString());
						}
						});
					button2.setBounds(434, 305, 86, 23);
					frame.getContentPane().add(button2);
					
				}
			}
		});
		button.setBounds(434, 305, 86, 23);
		frame.getContentPane().add(button);
	}
}
