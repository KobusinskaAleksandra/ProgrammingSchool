package pl.coderslab.examples.programmingschool.model;

public class Users {
	
	private	int	id;
	private	String	username;
	private	String	password;
	private	String	email;
	private int person_group_id;
	
	
	public	Users(String	username,	String	email,	String	password)	{
		this.username	=	username;
		this.email	=	email;
		this.setPassword(password);		
}

	public	Users()	{}
	
	
	
	
}
