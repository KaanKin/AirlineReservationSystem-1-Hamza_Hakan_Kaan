package ars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.*;

public class RegisterScreen extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterScreen frame = new RegisterScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	/**
	 * Create the frame.
	 */
	public RegisterScreen() {
		connection=SQLiteConn.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(224, 75, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(122, 78, 74, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(122, 109, 74, 14);
		contentPane.add(lblPassword);
		
		passField = new JPasswordField();
		passField.setBounds(224, 106, 86, 20);
		contentPane.add(passField);
		
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Statement smt = null;
				smt = connection.createStatement();
				
				String sql1 = "INSERT INTO Users (Username,Password) " +
		                   "VALUES ('"+nameField.getText()+"' , '"+passField.getText()+"');";
				 smt.executeUpdate(sql1);
				 smt.close();
			     connection.close();
				 JOptionPane.showMessageDialog(null, "Records created successfully");
				
				}catch ( Exception e ) {
				      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				      System.exit(0);
				    }
			}
		});
		btnCreateUser.setBounds(165, 157, 108, 23);
		contentPane.add(btnCreateUser);
	}
}
