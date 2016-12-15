package cz.muni.fi.pa165.CarRegister.dto;

import java.util.Date;
import java.util.Objects;


/**
 *
 * @author robha
 */
public class ServiceIntervalCreateDTO {

        private Long id;
        
        private Long carId;
        
        private Date begin;
        
        private Date end;
        
        private Date visited;

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

        public Date getBegin() {
            return begin;
        }

        public void setBegin(Date begin) {
            this.begin = begin;
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            this.end = end;
        }

        public Date getVisited() {
            return visited;
        }

        public void setVisited(Date visited) {
            this.visited = visited;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + Objects.hashCode(this.carId);
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
            if (!(obj instanceof ServiceIntervalCreateDTO)) {
                return false;
            }
            final ServiceIntervalCreateDTO other = (ServiceIntervalCreateDTO) obj;
            if (!Objects.equals(this.carId, other.carId)) {
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
