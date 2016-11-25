/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.entities;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
/**
 *
 * @author robha
 */
@Entity
public class Drive {
    	// Fields

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
        @NotNull
        @ManyToOne(fetch = FetchType.EAGER)
        @Fetch(FetchMode.JOIN)
        @JoinColumn(name = "carId")
        private Car car;
        
        @NotNull
        @ManyToOne(fetch = FetchType.EAGER)
        @Fetch(FetchMode.JOIN)
        @JoinColumn(name = "userId")
        private User user;
	
        @NotNull
        @Column(name = "driveBegin")
        @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
        DateTime begin;

        @NotNull
        @Column(name = "driveEnd")
        @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
        DateTime end;

        @Min(0)
        int distance;

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

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
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
        
        public void setDistance(int distance) {
            this.distance = distance;
        }
        
        public int getDistance() {
            return this.distance;
        }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.car);
        hash = 47 * hash + Objects.hashCode(this.user);
        hash = 47 * hash + Objects.hashCode(this.begin);
        hash = 47 * hash + Objects.hashCode(this.end);
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
        if (!(obj instanceof Drive)) {
            return false;
        }
        final Drive other = (Drive) obj;
        if (!Objects.equals(this.car, other.car)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.begin, other.begin)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
    }

        
}
