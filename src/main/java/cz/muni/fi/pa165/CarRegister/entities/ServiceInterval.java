/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.joda.time.DateTime;

/**
 *
 * @author blahut
 */
public class ServiceInterval {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   
    @OneToOne
    Long carId;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    DateTime begin;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    DateTime end;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    DateTime visited;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
    
    public DateTime getBegin() {
        return begin;
    }

    public void setBegin(DateTime begin) {
        this.begin = begin;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public DateTime getVisited() {
        return visited;
    }

    public void setVisited(DateTime visited) {
        this.visited = visited;
    }
    
    
}
