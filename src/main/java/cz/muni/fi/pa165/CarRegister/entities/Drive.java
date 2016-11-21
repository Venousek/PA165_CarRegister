/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.entities;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.joda.time.DateTime;
/**
 *
 * @author robha
 */
public class Drive {
    	// Fields

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
        @OneToOne
	private Long carId;
        
        @OneToOne
        private Long userId;
	
        @NotNull
        @Temporal(TemporalType.TIMESTAMP)
        DateTime begin;

        @NotNull
        @Temporal(TemporalType.TIMESTAMP)
        DateTime end;

        @Min(0)
        int distance;

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

        public Long getUserId() {
            return userId;
        }
        
        public void setUserId(Long userId) {
            this.userId = userId;
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
        hash = 47 * hash + Objects.hashCode(this.carId);
        hash = 47 * hash + Objects.hashCode(this.userId);
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
        if (!Objects.equals(this.carId, other.carId)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
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
