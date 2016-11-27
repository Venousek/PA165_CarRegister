package cz.muni.fi.pa165.CarRegister.dto;

import java.util.Objects;

/**
 *
 * @author blahut
 */
public class ServiceIntervalDTO {
        
        private Long id;
   
        private CarDTO car;

        private Long beginLong;
        
        private Long endLong;
        
        private Long visitedLong;

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

        public Long getVisitedLong() {
            return visitedLong;
        }

        public void setVisitedLong(Long visited) {
            this.visitedLong = visited;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + Objects.hashCode(this.car);
            hash = 83 * hash + Objects.hashCode(this.beginLong);
            hash = 83 * hash + Objects.hashCode(this.endLong);
            hash = 83 * hash + Objects.hashCode(this.visitedLong);
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
            if (!(obj instanceof ServiceIntervalDTO)) {
                return false;
            }
            final ServiceIntervalDTO other = (ServiceIntervalDTO) obj;
            if (!Objects.equals(this.car, other.car)) {
                return false;
            }
            if (!Objects.equals(this.beginLong, other.beginLong)) {
                return false;
            }
            if (!Objects.equals(this.endLong, other.endLong)) {
                return false;
            }
            if (!Objects.equals(this.visitedLong, other.visitedLong)) {
                return false;
            }
            return true;
        }
}
