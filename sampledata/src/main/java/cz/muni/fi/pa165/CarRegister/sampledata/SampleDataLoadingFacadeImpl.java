/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.sampledata;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import cz.muni.fi.pa165.CarRegister.entities.User;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.enums.Role;
import cz.muni.fi.pa165.CarRegister.service.CarService;
import cz.muni.fi.pa165.CarRegister.service.DriveService;
import cz.muni.fi.pa165.CarRegister.service.ServiceIntervalService;
import cz.muni.fi.pa165.CarRegister.service.UserService;
import java.io.IOException;
import javax.inject.Inject;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author robha
 */
@Component
@Transactional 
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {

    final static Logger log = LoggerFactory.getLogger(SampleDataLoadingFacadeImpl.class);
    
    @Inject
    private CarService carService;
    @Inject
    private UserService userService;
    @Inject
    private DriveService driveService;
    @Inject
    private ServiceIntervalService serviceIntervalService;
    @Override
    @SuppressWarnings("unused")
    public void loadData() throws IOException {
        Car car1 = car("123","Nissan","GTR",2016,"ASDADA",0,Fuel.GASOLINE);
        Car car2 = car("254","SKODA","SUPERB",2015,"rulez322",5465,Fuel.DIESEL);
        Car car3 = car("666","SKODA","OCTAVIE",2010,"srot22",545444,Fuel.GASOLINE);
        Car car4 = car("547","SKODA","FABIE",2012,"BlAzE420",88465,Fuel.DIESEL);
        User user1 = user("heslo","Admin","František","Vedoucí","frantisek.vedouci@admin.com",Role.ADMIN);
        User user2 = user("heslo","drak","Josef","Rychly","josef.rychly@fast.com",Role.USER);
        User user3 = user("heslo","snek","Radim","Pomaly","radim.pomaly@slow.com",Role.USER);
        User user4 = user("heslo","lady92","Aneta","Krásná","aneta.krasna@cmuk.com",Role.USER);
        Drive drive1 = drive(car1, user2,daysFromNow(0),daysFromNow(1),50);
        Drive drive2 = drive(car2, user3,daysFromNow(0),daysFromNow(4),250);
        Drive drive3 = drive(car4, user4,daysFromNow(0),daysFromNow(8),550);
        ServiceInterval s1 = interval(car1,daysFromNow(0),daysFromNow(50),daysFromNow(51));
        ServiceInterval s2 = interval(car2,daysFromNow(50),daysFromNow(70),daysFromNow(71));
        ServiceInterval s3 = interval(car3,daysFromNow(100),daysFromNow(170),daysFromNow(172));
        ServiceInterval s4 = interval(car4,daysFromNow(150),daysFromNow(250),daysFromNow(255));
    }
   private ServiceInterval interval(Car car,DateTime visited,DateTime begin, DateTime end) {
        ServiceInterval si = new ServiceInterval();
        si.setCar(car);
        si.setVisited(visited);
        si.setBegin(begin);
        si.setEnd(end);
        serviceIntervalService.create(si);
        return si;
    }
    
    private Drive drive(Car car,User user, DateTime begin, DateTime end, int distance) {
        Drive d = new Drive();
        d.setCar(car);
        d.setUser(user);
        d.setBegin(begin);
        d.setEnd(end);
        d.setDistance(distance);
        driveService.create(d);
        return d;
    }
    private User user(String password,String login, String firstName, String lastName, String email, Role role) {
        User u = new User();
        u.setLogin(login);
        u.setFirstname(firstName);
        u.setLastname(lastName);
        u.setEmail(email);
        u.setRole(role);
        //tady je treba vymyslet ukladni hesla do hashe
        u.setPassword(password);
        userService.create(u);
        return u;
    }
    
    private Car car(String vin, String manufacture, String model, int year, String register, int mileage, Fuel fuel) {
        Car c = new Car();
        c.setVin(vin);
        c.setManufacturer(manufacture);
        c.setModel(model);
        c.setYear(year);
        c.setRegister_number(register);
        c.setMileage(mileage);
        c.setFuel(fuel);
        carService.create(c);
        return c;
    }
    private static DateTime daysFromNow(int days) {
        DateTime dtOrg = DateTime.now();
        DateTime dtPlus = dtOrg.plusDays(days);
        return dtPlus;
    }

}