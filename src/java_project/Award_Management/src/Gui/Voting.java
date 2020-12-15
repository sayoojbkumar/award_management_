package Gui;

import java.awt.EventQueue;

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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSpinner;

import award_m.*;

import net.proteanit.sql.DbUtils;

public class Voting {
	public PreparedStatement stmt; 
	protected Connection connection;
	public JFrame frame;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voting window = new Voting();
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
	public Voting() {
		
		initialize();
		display_table();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */ 
	public void display_table() {
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
			String Query="select in_id,budget,story,category_id from invention";
			PreparedStatement stmt=connection.prepareStatement(Query);
			ResultSet rs=stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 600, 800, 400);
		frame.setTitle("Voting");
		frame.getContentPane().setBackground(new Color(153, 0, 255));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inventions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(180, 50, 600, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 17, 600, 173);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtUsername = new JTextField();
		txtUsername.setText("username");
		txtUsername.setBounds(26, 66, 114, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(26, 114, 114, 19);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(88, 158, 29, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblInid = new JLabel("in_id");
		lblInid.setForeground(new Color(255, 0, 0));
		lblInid.setBounds(28, 160, 70, 15);
		frame.getContentPane().add(lblInid);
		
		JButton btnVote = new JButton("Vote");
		btnVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voting one = new voting(txtUsername.getText(),txtPassword.getText(),Integer.parseInt(spinner.getValue().toString()));
				if(!one.vote()) {
					one.register(txtUsername.getText(),txtPassword.getText(),Integer.parseInt(spinner.getValue().toString()));
				}
				JOptionPane.showMessageDialog(frame, "thank you for voting");
			}
		});
		btnVote.setBackground(new Color(0, 204, 0));
		btnVote.setBounds(23, 211, 117, 25);
		frame.getContentPane().add(btnVote);
	}
}
