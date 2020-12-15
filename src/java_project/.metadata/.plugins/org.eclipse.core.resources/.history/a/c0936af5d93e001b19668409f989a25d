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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import award_m.*;
import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class Winner {

	JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTable table;
	public PreparedStatement stmt; 
	protected Connection connection;
	public int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Winner window = new Winner();
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
	public Winner() {
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
		frame.setTitle("Winner");
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Only for admin");
		lblUsername.setForeground(Color.GREEN);
		lblUsername.setBounds(197, 67, 163, 37);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setText("username");
		txtUsername.setBounds(56, 118, 114, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(56, 168, 114, 19);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nobel prize", "kerala sahithya ", "demo1", "demo2"}));
		comboBox.setBounds(56, 243, 114, 19);
		frame.getContentPane().add(comboBox);
		
		JLabel lblAwards = new JLabel("Awards");
		lblAwards.setBounds(67, 217, 70, 15);
		frame.getContentPane().add(lblAwards);
		
		JButton btnFindWinner = new JButton("Find Winner");
		btnFindWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				winner one= new winner();
				try {
		    		Class.forName("org.postgresql.Driver");
		    		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Awards_", "postgres", "ssbk1830");
		    	} 
		    	catch (Exception e) {
			         e.printStackTrace();
			         System.err.println("Database connectivity error !");
			         System.exit(0);
			    }
				try {
					String Query="select in_id,story,name,recieved_awards,inventor.id from invention join inventor on invention.id=inventor.id where in_id=?";
					PreparedStatement stmt=connection.prepareStatement(Query);
					stmt.setInt(1, one.get_winner());
					System.out.print(stmt);
					ResultSet rs=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next()) {
						id=rs.getInt("id");
						System.out.println("id="+id);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnFindWinner.setBackground(Color.GREEN);
		btnFindWinner.setBounds(329, 268, 163, 25);
		frame.getContentPane().add(btnFindWinner);
		
		table = new JTable();
		table.setBounds(227, 120, 311, 142);
		frame.getContentPane().add(table);
		
		JButton btnAssignAward = new JButton("Assign Award");
		btnAssignAward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				winner two= new winner();
				try {
		    		Class.forName("org.postgresql.Driver");
		    		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Awards_", "postgres", "ssbk1830");
		    	} 
		    	catch (Exception e) {
			         e.printStackTrace();
			         System.err.println("Database connectivity error !");
			         System.exit(0);
			    }
				try {
					String Query="select in_id,story,name,recieved_awards,inventor.id from invention join inventor on invention.id=inventor.id where in_id=?";
					PreparedStatement stmt=connection.prepareStatement(Query);
					stmt.setInt(1, two.get_winner());
					System.out.print(stmt);
					ResultSet rs=stmt.executeQuery();
					while(rs.next()) {
						id=rs.getInt("id");;
					}
					System.out.println("id="+id);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				update_winner two1=new update_winner(txtUsername.getText(),txtPassword.getText(),id);
				final boolean temp=two1.vote(comboBox.getSelectedItem().toString(),id);
				if(temp) {
				JOptionPane.showMessageDialog(frame, "Winner Updated");
				}
				else {
					JOptionPane.showMessageDialog(frame, "only admin can update :P");
				}
			}
		});
		btnAssignAward.setBackground(Color.RED);
		btnAssignAward.setBounds(41, 290, 153, 25);
		frame.getContentPane().add(btnAssignAward);
	}
}
