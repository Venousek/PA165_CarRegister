package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.joda.time.DateTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sevo001
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
@Transactional

public class UserFacadeTest {
    @Inject
    private UserFacade userFacade;
    
    private UserDTO user1DTO;
    private UserDTO user2DTO;

    @Before
     public void setup() {
       user1DTO = new UserDTO();
       user1DTO.setFirstname("Ferda");
       user1DTO.setLastname("Mravenec");
       user1DTO.setLogin("mravenec");
       user1DTO.setPassword("123456");
       user1DTO.setEmail("mravenec@gmail.com");
       user1DTO.setRole(Role.USER);
       
       user2DTO = new UserDTO();  
       user2DTO.setFirstname("Peter");
       user2DTO.setLastname("Novak");
       user2DTO.setLogin("novak1");
       user2DTO.setPassword("abcdef");
       user2DTO.setEmail("novak1@gmail.com");
       user2DTO.setRole(Role.ADMIN);
    
    }

    @Test
    public void findUserTest() {
        user1DTO = userFacade.createUser(user1DTO);
        user2DTO = userFacade.createUser(user2DTO); 
        UserDTO usr1 = userFacade.findById(user1DTO.getId());
        UserDTO usr2 = userFacade.findById(user2DTO.getId());
        assertTrue(user1DTO.equals(usr1));
        assertTrue(user2DTO.equals(usr2));
    }
    @Test
    public void findAllUserTest() {
        user1DTO = userFacade.createUser(user1DTO);
        user2DTO = userFacade.createUser(user2DTO); 
        List<UserDTO> users= new ArrayList<UserDTO>();
        users.add(user1DTO);
        users.add(user2DTO);
        assertTrue(users.equals(userFacade.findAll()));
    }

    @Test
    public void updateUser() {
    	user1DTO = userFacade.createUser(user1DTO);                       
        user1DTO.setFirstname("Peter");
        
        userFacade.update(user1DTO);
        
        UserDTO user2DTO = userFacade.findById(user1DTO.getId());
                
        assertEquals(user1DTO.getId(), user2DTO.getId());
        assertEquals(user2DTO.getFirstname(), "Peter");   
    }
    
    
}
