package pl.coderslab.examples.programmingschool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Homepage {

public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	while(true) {
		System.out.println("Witaj w programie do zarządzania bazą danych szkoły programowania. Wybierz, co chcesz teraz zrobić:");
		System.out.println("1. Zarzadzaj uzytkownikami");
		System.out.println("2. Zarzadzaj zadaniami");
		System.out.println("3. Zarzadzaj grupami użytkownikow");
		System.out.println("4. Przypisz zadania");
		int ans=scan.nextInt();
			if(ans==1) {
				while(true) {
				System.out.println("Zarzadzanie uzytkownikami");
				System.out.println("1. Dodaj uzytkownika");
				System.out.println("2. Edytuj uzytkownika");
				System.out.println("3. Usun uzytkownika");
				System.out.println("4. Powrot do menu");
				
					ans=scan.nextInt();
					if(ans==1) {
						MenageUsers.add();
					}
					else if(ans==2) {
						MenageUsers.edit();
					}
					else if(ans==3) {
						MenageUsers.delete();
					}
					else if(ans==4) {
					break;	
					}
				}
			}
			else if(ans==2) {
				while(true) {
					System.out.println("Zarzadzanie zadaniami");
					System.out.println("1. Dodaj zadanie");
					System.out.println("2. Edytuj zadanie");
					System.out.println("3. Usun zadanie");
					System.out.println("4. Powrot do menu");
					ans=scan.nextInt();
					if(ans==1) {
						MenageExercise.add();
					}
					else if(ans==2) {
						MenageExercise.edit();
					}
					else if(ans==3) {
						MenageExercise.delete();
					}
					else if(ans==4) {
					break;	
					}
				}
			}
			else if (ans==3) {
				while(true) {
					System.out.println("Zarzadzanie grupami uzytkownikow");
					System.out.println("1. Dodaj grupe");
					System.out.println("2. Edytuj grupe");
					System.out.println("3. Usun grupe");
					System.out.println("4. Powrot do menu");
					ans=scan.nextInt();
					if(ans==1) {
						MenageGroup.add();
					}
					else if(ans==2) {
						MenageGroup.edit();
					}
					else if(ans==3) {
						MenageGroup.delete();
					}
					else if(ans==4) {
					break;	
					}
				}
			}
			else if (ans==4) {
					System.out.println("Przypisywanie zadan");
					System.out.println("1. Dodaj zadanie do uzytkownika");
					System.out.println("2. Dodaj zadanie do grupy uzytkownikow");
					System.out.println("3. Przeglad rozwiazan");
					System.out.println("6. Usun grupe");
					ans=scan.nextInt();
					if(ans==1) {
						MenageSolution.add();
					}
					else if(ans==2) {
						MenageSolution.edit();
					}
					else if(ans==3) {
						MenageSolution.delete();
					}
					else if(ans==4) {
					break;	
					}
				}
			break;
		}
	scan.close();
	}
}