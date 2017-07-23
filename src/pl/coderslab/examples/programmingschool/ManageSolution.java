package pl.coderslab.examples.programmingschool;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import pl.coderslab.examples.programmingschool.model.Exercise;
import pl.coderslab.examples.programmingschool.model.Groups;
import pl.coderslab.examples.programmingschool.model.Solution;
import pl.coderslab.examples.programmingschool.model.User;

public class ManageSolution {

	protected static void addToUser() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warsztaty", "root", "coderslab");
			System.out.println("Połączenie ustanowione");
			} catch (SQLException e) {
			e.printStackTrace();
			}
		Scanner scan= new Scanner(System.in);
		int nbExc=0;
		int nbUsr=0;
		java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
		while (true) {
		try {
			Exercise [] exc = Exercise.loadAllExercise(conn);
			for(Exercise exercise: exc) System.out.println(exercise.toString());
		System.out.println();
		System.out.println("Podaj numer zadania: ");
		nbExc=scan.nextInt();
		System.out.println("Podaj numer uzytkownika: ");
		User [] user = User.loadAllUsers(conn);
		for(User ur: user) System.out.println(ur.toString());
		nbUsr=scan.nextInt();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Czy chcesz dodac zadanie nr " + nbExc + " do uzytkownika " + nbUsr  +"?");
		String ans=scan.next();
		Solution solution = new Solution (sqlDate, null, "", nbExc, nbUsr);
		if(ans.equalsIgnoreCase("tak")) {
			try {
				solution.saveToDB(conn);
				break;
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else
			System.out.println("Podaj dane ponownie");
			scan.nextLine();
		}
	}

	protected static void addToGroup() {
		Scanner scan = new Scanner (System.in);
		Connection conn = null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Warsztaty", "root", "coderslab");
			System.out.println("Połączenie ustanowione");
			} catch (SQLException e) {
			e.printStackTrace();
			}
		System.out.println("Podaj numer grupy, ktorej chcesz przypisac zadanie");
		int id = scan.nextInt();
		User[] users;
		try {			
			users = User.loadUsersByGroupId(conn, id);
			java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
			int nbExc=0;
			Exercise [] exc = Exercise.loadAllExercise(conn);
			for(Exercise exercise: exc) System.out.println(exercise.toString());
			System.out.println("Podaj numer zadania: ");
			nbExc=scan.nextInt();
			System.out.println("Czy chcesz dodac zadanie nr " + nbExc + " grupy: " + id  +"?");
			String ans=scan.next();
			if(ans.equalsIgnoreCase("tak")) {
			for(User user: users) {
				Solution solution = new Solution (sqlDate, null, "", nbExc, user.getId());
					try {
						solution.saveToDB(conn);
						System.out.println("Dodano zadanie dla grupy");
					} catch (SQLException e) {
						e.printStackTrace();
					}	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

	protected static void selectAllForUser() {
		
	}

	protected static void selectAllForGroup() {
		
	}
}