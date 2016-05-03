package ars;

import java.sql.*;
import javax.swing.*;

public class SQLiteConn {
	Connection conn = null;
	public static Connection dbConnector(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn= DriverManager.getConnection("jdbc:sqlite:F:\\FireSerpent\\Workspace\\Mars\\Airline Reservation System\\database\\Flight.sqlite");
			return conn;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
