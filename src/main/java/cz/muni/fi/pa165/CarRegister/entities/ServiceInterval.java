/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.entities;

import org.joda.time.DateTime;

/**
 *
 * @author blahut
 */
public class ServiceInterval {
    
    Long id;
    
    Long carId;
    
    DateTime begin;
    
    DateTime end;
    
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
