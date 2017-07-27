package pl.coderslab.examples.programmingschool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	Connection connect = connect(); 
	
	public static Connection connect() {
		Connection connect = null;
		try {
		connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warsztaty?autoReconnect=true&useSSL=false", "root", "coderslab");
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return connect;
	}

}
