package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import award_m.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;

public class main_java {
	
	JFrame frame;
	JFrame frame1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_java window = new main_java();
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
	public main_java() {
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("L M Roman10", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(211, 36, 100, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JInternalFrame internalFrame = new JInternalFrame("Select Options");
		internalFrame.getContentPane().setBackground(Color.MAGENTA);
		internalFrame.getContentPane().setLayout(null);
		
		JButton btnRegistrationForAward = new JButton("Register for Award");
		btnRegistrationForAward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration window = new Registration();
				window.frame.setVisible(true);
			}
		});
		btnRegistrationForAward.setBackground(Color.CYAN);
		btnRegistrationForAward.setBounds(22, 12, 260, 25);
		internalFrame.getContentPane().add(btnRegistrationForAward);
		
		JButton btnNewButton = new JButton("Login and Vote");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voting window = new Voting();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(22, 83, 260, 25);
		internalFrame.getContentPane().add(btnNewButton);
		
		JButton btnFindWinner = new JButton("Find winner");
		btnFindWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Winner window = new Winner();
				window.frame.setVisible(true);
			}
		});
		btnFindWinner.setBackground(Color.RED);
		btnFindWinner.setBounds(22, 121, 260, 25);
		internalFrame.getContentPane().add(btnFindWinner);
		internalFrame.setBounds(34, 101, 373, 190);
		frame.getContentPane().add(internalFrame);
		
		JLabel lblImperva = new JLabel("Imperva");
		lblImperva.setForeground(Color.ORANGE);
		lblImperva.setFont(new Font("Karumbi", Font.BOLD | Font.ITALIC, 40));
		lblImperva.setBounds(425, 184, 113, 15);
		frame.getContentPane().add(lblImperva);
		internalFrame.setVisible(true);
		frame.setTitle("IMPERVA Award Management System");
	}
}
