package cz.muni.fi.pa165.CarRegister.dto;

import java.util.Objects;

/**
 *
 * @author blahut
 */
public class DriveDTO {
    
        private Long id;
	
        private CarDTO car;
        
        private UserDTO user;
	
        private Long beginLong;

        private Long endLong;

        int distance;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public CarDTO getCar() {
            return car;
        }

        public void setCar(CarDTO car) {
            this.car = car;
        }

        public UserDTO getUser() {
            return user;
        }

        public void setUser(UserDTO user) {
            this.user = user;
        }
        
        public Long getBeginLong() {
            return beginLong;
        }

        public void setBeginLong(Long begin) {
            this.beginLong = begin;
        }

        public Long getEndLong() {
            return endLong;
        }

        public void setEndLong(Long end) {
            this.endLong = end;
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
            hash = 47 * hash + Objects.hashCode(this.beginLong);
            hash = 47 * hash + Objects.hashCode(this.endLong);
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
            if (!(obj instanceof DriveDTO)) {
                return false;
            }
            final DriveDTO other = (DriveDTO) obj;
            if (!Objects.equals(this.car, other.car)) {
                return false;
            }
            if (!Objects.equals(this.user, other.user)) {
                return false;
            }
            if (!Objects.equals(this.beginLong, other.beginLong)) {
                return false;
            }
            if (!Objects.equals(this.endLong, other.endLong)) {
                return false;
            }
            return true;
        }
}
