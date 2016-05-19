package ars;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;


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
		connection=SQLiteConn.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(37, 11, 46, 14);
		contentPane.add(lblFlight);
		/*
		String[] petStrings = { "Ankara", "Çemiþgezek", "Nazilli", "New York", "Ýzmir" };

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox petList = new JComboBox(petStrings);
		petList.setSelectedIndex(4);
		petList.setBounds(37, 82, 85, 30);
		contentPane.add(petList);
		
		*/
		
		JComboBox<String> combo1 = new JComboBox<>();
		try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select DestinationFrom from Flights Group By DestinationFrom");
            while (rs.next()) {
            	String destination = rs.getString("DestinationFrom");
            	combo1.addItem(destination);
       		}

			} catch (Exception k) {
				JOptionPane.showMessageDialog(null, k);
			}
		
			combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		}});
		combo1.setEditable(true);
		combo1.setBounds(37, 36, 75, 20);
		contentPane.add(combo1);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(122, 40, 46, 14);
		contentPane.add(lblTo);
		
		JComboBox<String> combo2 = new JComboBox<>();
		try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select DestinationTo from Flights Group By DestinationTo");
            while (rs.next()) {
            	String destination = rs.getString("DestinationTo");
            	combo2.addItem(destination);
       		}

			} catch (Exception k) {
				JOptionPane.showMessageDialog(null, k);
			}
		combo2.setEditable(true);
		combo2.setBounds(142, 37, 89, 20);
		contentPane.add(combo2);
		
		JButton search1 = new JButton("Search");
		search1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				try {
				    String sql = "select * from table1 where ";
				    sql += (String) jComboBox2.getSelectedItem();
				    sql += " like ";
				    sql += txtsearch.getText() + "%";
				    pst = conn.prepareStatement(sql);
				    rs = pst.executeQuery();
				}
				*/
				
				try {
				
					String stmnt = "select EcoPrice from Flights where DestinationFrom=? and DestinationTo=? ";
					PreparedStatement pst2 = connection.prepareStatement(stmnt);
					
					pst2.setString(1, (String)combo1.getSelectedItem());
					pst2.setString(2, (String)combo2.getSelectedItem());
					
					ResultSet rs = pst2.executeQuery();
					System.out.println(rs.getInt(1));
					
					
					
				}catch(Exception es){
					JOptionPane.showMessageDialog(null, es);
				}
				
			}
		});
		search1.setBounds(250, 35, 89, 23);
		contentPane.add(search1);
	}
}
