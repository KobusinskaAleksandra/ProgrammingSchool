public class Users {
	
	private	int	id;
	private	String	username;
	private	String	password;
	private	String	email;
	
	
	
	public	Users(String	username,	String	email,	String	password)	{
		this.username	=	username;
		this.email	=	email;
		this.setPassword(password);		
}

	public	Users()	{}
	
	public	void	setPassword(String	password)	{
		this.password	=	BCrypt.hashpw(password	,	BCrypt.gensalt());	;
	}
	
	
}
