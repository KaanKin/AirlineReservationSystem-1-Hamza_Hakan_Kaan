package ars;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(37, 11, 46, 14);
		contentPane.add(lblFlight);
		
		String[] petStrings = { "Ankara", "Çemiþgezek", "Nazilli", "New York", "Ýzmir" };

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox petList = new JComboBox(petStrings);
		petList.setSelectedIndex(4);
		petList.setBounds(37, 82, 85, 30);
		contentPane.add(petList);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(37, 36, 75, 20);
		contentPane.add(comboBox);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(122, 40, 46, 14);
		contentPane.add(lblTo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(142, 37, 75, 20);
		contentPane.add(comboBox_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(250, 35, 89, 23);
		contentPane.add(btnSearch);
	}
}
