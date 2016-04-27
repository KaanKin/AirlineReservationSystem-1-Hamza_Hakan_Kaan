import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MainScreen {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnLogin = new JButton("Login");
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogin, -74, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogin, -89, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnLogin);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, btnLogin, 70, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField, 259, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnLogin, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -167, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		springLayout.putConstraint(SpringLayout.NORTH, btnRegister, 0, SpringLayout.NORTH, btnLogin);
		springLayout.putConstraint(SpringLayout.WEST, btnRegister, 44, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnRegister, -304, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnRegister);
		
		JLabel lblUsername = new JLabel("USERNAME");
		springLayout.putConstraint(SpringLayout.NORTH, lblUsername, 3, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, lblUsername, -22, SpringLayout.WEST, textField);
		frame.getContentPane().add(lblUsername);
		
		pwdPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, pwdPassword, 24, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, pwdPassword, 0, SpringLayout.WEST, btnLogin);
		springLayout.putConstraint(SpringLayout.EAST, pwdPassword, 0, SpringLayout.EAST, btnLogin);
		pwdPassword.setText("Password");
		frame.getContentPane().add(pwdPassword);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 0, SpringLayout.NORTH, pwdPassword);
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblUsername);
		frame.getContentPane().add(lblPassword);
		
		JLabel label = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, label, 29, SpringLayout.NORTH, pwdPassword);
		springLayout.putConstraint(SpringLayout.EAST, label, 14, SpringLayout.EAST, btnRegister);
		Image img = new ImageIcon(this.getClass().getResource("/plane.png")).getImage();
		label.setIcon(new ImageIcon(img));
		springLayout.putConstraint(SpringLayout.WEST, label, 44, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label, -108, SpringLayout.NORTH, btnRegister);
		frame.getContentPane().add(label);
		
	}
}
