package cz.muni.fi.pa165.CarRegister.dto;

import java.util.Objects;

/**
 *
 * @author blahut
 */
public class ServiceIntervalDTO {
        
        private Long id;
   
        private CarDTO car;

        private Long begin;
        
        private Long end;
        
        private Long visited;

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

        public Long getBegin() {
            return begin;
        }

        public void setBegin(Long begin) {
            this.begin = begin;
        }

        public Long getEnd() {
            return end;
        }

        public void setEnd(Long end) {
            this.end = end;
        }

        public Long getVisited() {
            return visited;
        }

        public void setVisited(Long visited) {
            this.visited = visited;
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
            if (!(obj instanceof ServiceIntervalDTO)) {
                return false;
            }
            final ServiceIntervalDTO other = (ServiceIntervalDTO) obj;
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
