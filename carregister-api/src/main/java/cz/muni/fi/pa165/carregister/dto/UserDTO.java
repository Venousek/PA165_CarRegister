package cz.muni.fi.pa165.CarRegister.dto;

import cz.muni.fi.pa165.CarRegister.enums.Role;
import java.util.Objects;

/**
 *
 * @author blahut
 */
public class UserDTO {
    
	private Long id;
        
	private String login;
	
	private String password;
	
	private String firstname;
	
	private String lastname;
	
        private String email;
	
        private Role role;
	
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
        
        public boolean isAdmin() {
            return role == Role.ADMIN;
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
            if (!(obj instanceof UserDTO)) {
                return false;
            }
            final UserDTO other = (UserDTO) obj;
            if (!Objects.equals(this.login, other.login)) {
                return false;
            }
            return true;
        }
}
