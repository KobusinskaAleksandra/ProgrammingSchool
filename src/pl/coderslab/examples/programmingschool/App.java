package pl.coderslab.examples.programmingschool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import pl.coderslab.examples.programmingschool.model.User;

public class App {
	
	static Connection conn = null;
	
	public App() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warsztaty", "root", "coderslab");
			System.out.println("Połączenie ustanowione");
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}	

	public void run() {
//		User user = new User("marian", "marian@gmail.com", "haslo");
//		try {
//			user.saveToDB(conn);
//		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		user.setPassword("test");
//		System.out.println(user.getPassword());
	
		try {
			System.out.println(User.loadUserById(conn, 5).toString());
		System.out.println(Arrays.toString(User.loadAllUsers(conn)));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { 
		App app = new App();
		app.run();	
	} 
	
}
