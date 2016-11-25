/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.dto.*;
import cz.muni.fi.pa165.CarRegister.entities.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author robha
 */
@Configuration
@ComponentScan(basePackages = "cz.muni.fi.pa165")
public class ServiceConfiguration {


    @Bean
    public Mapper dozer(){
        DozerBeanMapper dozer = new DozerBeanMapper();
        dozer.addMapping(new DozerCustomConfig());
        return dozer;
    }

    public class DozerCustomConfig extends BeanMappingBuilder {
        protected void configure() {
            mapping(Car.class, CarDTO.class);
            mapping(Drive.class, DriveDTO.class);
    
            mapping(ServiceIntervalDTO.class, ServiceInterval.class).exclude("setBegin");
            mapping(User.class, UserDTO.class);
        }
    }
}