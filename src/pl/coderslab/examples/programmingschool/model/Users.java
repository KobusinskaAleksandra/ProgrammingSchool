package pl.coderslab.examples.programmingschool.model;

import org.mindrot.jbcrypt.BCrypt;

public class Users {
	
	private	int	id;
	private	String	username;
	private	String	password;
	private	String	email;
	private int person_group_id;
	
	
	public	Users(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.setPassword(password);		
}
	public	Users()	{}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPerson_group_id() {
		return person_group_id;
	}

	public void setPerson_group_id(int person_group_id) {
		this.person_group_id = person_group_id;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	private void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	
}
