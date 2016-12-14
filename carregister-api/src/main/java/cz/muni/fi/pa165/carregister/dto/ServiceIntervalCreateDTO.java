package cz.muni.fi.pa165.CarRegister.dto;

import java.util.Objects;

/**
 *
 * @author robha
 */
public class ServiceIntervalCreateDTO {

        private Long id;
   
        private Long carId;

        private Long beginLong;
        
        private Long endLong;
        
        private Long visitedLong;

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
            hash = 83 * hash + Objects.hashCode(this.carId);
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
            if (!(obj instanceof ServiceIntervalCreateDTO)) {
                return false;
            }
            final ServiceIntervalCreateDTO other = (ServiceIntervalCreateDTO) obj;
            if (!Objects.equals(this.carId, other.carId)) {
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
