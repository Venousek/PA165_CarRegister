/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.entities;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 *
 * @author blahut
 */
@Entity
public class ServiceInterval {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "carId")
    private Car car;
    
    @NotNull
    @Column(name = "intervalBegin")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime begin;
    
    @NotNull
    @Column(name = "intervalEnd")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime end;
    
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime visited;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
    
    @Transient
    public Date getBeginDate() {
        return begin == null ? null : new Date(begin.getMillis());
    }

    public void setBeginDate(Date begin) {
        if (begin != null)
            this.begin = new DateTime(begin);
        else
            this.begin = null;
    }        

    @Transient
    public Date getEndDate() {
        return end == null ? null : new Date(end.getMillis());
    }

    public void setEndDate(Date end) {
        if (end != null)
            this.end = new DateTime(end);
        else
            this.end = null;
    }

    @Transient
    public Date getVisitedDate() {
        return visited == null ? null : new Date(visited.getMillis());
    }

    public void setVisitedDate(Date visited) {
        if (visited != null)
            this.visited = new DateTime(visited);
        else
            this.visited = null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.car);
        hash = 83 * hash + Objects.hashCode(this.begin);
        hash = 83 * hash + Objects.hashCode(this.end);
        hash = 83 * hash + Objects.hashCode(this.visited);
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
        if (!(obj instanceof ServiceInterval)) {
            return false;
        }
        final ServiceInterval other = (ServiceInterval) obj;
        if (!Objects.equals(this.car, other.car)) {
            return false;
        }
        if (!Objects.equals(this.begin, other.begin)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        return true;
    }
    
    
}
