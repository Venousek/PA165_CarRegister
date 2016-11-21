package cz.muni.fi.pa165.CarRegister.entities;

import cz.muni.fi.pa165.CarRegister.enums.Role;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Frantisek Cernak
 */
@Entity
public class User
{
	
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
        @NotNull
        @Column(unique = true)  
	private String login;
	
        @NotNull    
        @Size(min=4, max=255)
	private String password;
	
        @NotNull
	private String firstname;
	
        @NotNull
	private String lastname;
	
        @NotNull
        @Column(unique = true)
	private String email;
	
        @NotNull
	private Role role;
	

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
  
  	public Role getRole()
  	{
		return role;
	}
  
  	public void setRole(Role role)
  	{
		this.role = role;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }

        
}
