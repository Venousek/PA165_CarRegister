package cz.muni.fi.pa165.CarRegister.entities;

/**
 *
 * @author Frantisek Cernak
 */
 
public class User
{
	
	private Long id;
	
	private String login;
	
	private String password;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private int role;
	


  //Methods

	public Long getId()
  	{
    		return id;
  	}
		
	public void setId(Long id)
  	{
		this.id = id;
	}

	public String getLogin()
  	{
		return login;
	}

	public void setLogin(String login)
  	{
		this.login = login;
	}

	public String getPassword()
  	{
		return password;
	}
  
	public void setPassword(String password)
  	{
		this.password = password;
	}
  
  	public String getFirstname()
  	{
		return firstname;
	}
  
  	public void setFirstname(String firstname)
  	{
		this.firstname = firstname;
	}
  
 	public String getLastname()
	{
		return lastname;
	}
  
  	public void setLastname(String lastname)
  	{
		this.lastname = lastname;
	}
  
  	public String getEmail()
  	{
		return email;
	}
  
  	public void setEmail(String email)
  	{
		this.email = email;
	}
  
  	public int getRole()
  	{
		return role;
	}
  
  	public void setRole(int role)
  	{
		this.role = role;
	}

}
