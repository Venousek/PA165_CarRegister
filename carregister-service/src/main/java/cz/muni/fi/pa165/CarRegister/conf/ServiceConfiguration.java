package cz.muni.fi.pa165.CarRegister.conf;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.dto.DriveDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import cz.muni.fi.pa165.CarRegister.entities.User;
import cz.muni.fi.pa165.CarRegister.service.CarServiceImpl;
import cz.muni.fi.pa165.CarRegister.service.DriveServiceImpl;
import cz.muni.fi.pa165.CarRegister.service.ServiceIntervalServiceImpl;
import cz.muni.fi.pa165.CarRegister.service.UserServiceImpl;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author blahut
 */

@Configuration
@ComponentScan(basePackageClasses={CarServiceImpl.class, DriveServiceImpl.class, ServiceIntervalServiceImpl.class, UserServiceImpl.class})
public class ServiceConfiguration {


    @Bean
    public Mapper dozer(){
        DozerBeanMapper dozer = new DozerBeanMapper();
        dozer.addMapping(new DozerCustomConfig());
        return dozer;
    }

    public class DozerCustomConfig extends BeanMappingBuilder {
        @Override
        protected void configure() {
            mapping(Car.class, CarDTO.class);
            mapping(Drive.class, DriveDTO.class);
            mapping(ServiceInterval.class, ServiceIntervalDTO.class);
            mapping(User.class, UserDTO.class);
        }
    }
}
