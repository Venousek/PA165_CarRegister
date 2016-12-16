package cz.muni.fi.pa165.CarRegister.dto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author blahut
 */
public class ServiceIntervalDTO {
        
        private Long id;
   
        private CarDTO car;

        private Date beginDate;
        
        private Date endDate;
        
        private Date visitedDate;

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

        public Date getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Date begin) {
            this.beginDate = begin;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date end) {
            this.endDate = end;
        }

        public Date getVisitedDate() {
            return visitedDate;
        }

        public void setVisitedDate(Date visited) {
            this.visitedDate = visited;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + Objects.hashCode(this.car);
            hash = 83 * hash + Objects.hashCode(this.beginDate);
            hash = 83 * hash + Objects.hashCode(this.endDate);
            hash = 83 * hash + Objects.hashCode(this.visitedDate);
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
            if (!Objects.equals(this.beginDate, other.beginDate)) {
                return false;
            }
            if (!Objects.equals(this.endDate, other.endDate)) {
                return false;
            }
            if (!Objects.equals(this.visitedDate, other.visitedDate)) {
                return false;
            }
            return true;
        }
}
