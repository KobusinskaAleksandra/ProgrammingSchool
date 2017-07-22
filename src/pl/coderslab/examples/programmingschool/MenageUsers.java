package pl.coderslab.examples.programmingschool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import pl.coderslab.examples.programmingschool.model.User;

public class MenageUsers {

	protected static void add() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warsztaty", "root", "coderslab");
			System.out.println("Połączenie ustanowione");
			} catch (SQLException e) {
			e.printStackTrace();
			}
		
		Scanner scan= new Scanner(System.in);
		String username = "";
		String email = "";
		String password="";
		while (true) {
		System.out.println("Podaj imie i nazwisko uzytkownika:");
		username=scan.nextLine();
		System.out.println("Podaj email uzytkownika:");
		email=scan.nextLine();
		System.out.println("Podaj haslo dla uzytkownika");
		scan.nextLine();
		User user = new User(username, email, password);
		System.out.println("Czy chcesz dodac uzytkownika " + username + " email: " + email + " do bazy uzytkownikow?");
		String ans=scan.next();
		if(ans.equalsIgnoreCase("tak")) {
			try {
				user.saveToDB(conn);
				break;
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else
			System.out.println("Podaj dane ponownie");
		}
		}
	
	protected static void edit() {
		System.out.println("Test");
	}

	protected static void delete() {
		System.out.println("Test");
	}

}
