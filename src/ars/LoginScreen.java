package ars;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		connection=SQLiteConn.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="select * from Users where username=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()){
						count++;
					}
					if(count == 1){
						JOptionPane.showMessageDialog(null, "Login Successful");
						dispose();
						MainScreen main1 = new MainScreen();
						main1.setVisible(true);
					}
					else if(count>1){
						JOptionPane.showMessageDialog(null, "Duplicate username and password");
		
					}
					else{
						JOptionPane.showMessageDialog(null, "Username or password is not correct!");
					}
					rs.close();
					pst.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
					
				}
				
				
				
			}
		});
		btnLogin.setBounds(162, 172, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(162, 206, 89, 23);
		contentPane.add(btnRegister);
		
		textField = new JTextField();
		textField.setBounds(162, 110, 89, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 141, 89, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(86, 113, 75, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(86, 144, 89, 14);
		contentPane.add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\FireSerpent\\Workspace\\airline\\AirlineReservationSystem-1-Hamza_Hakan_Kaan\\img\\plane.png"));
		label.setBounds(172, 23, 133, 69);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Hamza\\Desktop\\plane.png"));
		label_1.setBounds(162, 11, 116, 69);
		contentPane.add(label_1);
	}
}
