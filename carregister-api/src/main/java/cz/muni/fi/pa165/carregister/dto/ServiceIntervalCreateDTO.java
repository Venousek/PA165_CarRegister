package cz.muni.fi.pa165.CarRegister.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


/**
 *
 * @author robha
 */
public class ServiceIntervalCreateDTO {

        private Long id;
        
        private Long carId;
        
        private Date beginDate;
        
        private String beginStringDate;
        
        private Date endDate;
        
        private String endStringDate;
        
        private Date visitedDate;
        
        private String visitedStringDate;

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

        public String getBeginStringDate() {
            return beginStringDate;
        }

        public void setBeginStringDate(String begin) throws ParseException {
            this.beginStringDate = begin;
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            this.beginDate = format.parse(begin);
        }
        
        public String getEndStringDate() {
            return endStringDate;
        }

        public void setEndStringDate(String end) throws ParseException {
            this.endStringDate = end;
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            this.endDate = format.parse(end);
        }
        public String getVisitedStringDate() {
            return visitedStringDate;
        }

        public void setVisitedStringDate(String visited) throws ParseException {
            this.visitedStringDate = visited;
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            this.visitedDate = format.parse(visited);
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
            hash = 83 * hash + Objects.hashCode(this.carId);
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
            if (!(obj instanceof ServiceIntervalCreateDTO)) {
                return false;
            }
            final ServiceIntervalCreateDTO other = (ServiceIntervalCreateDTO) obj;
            if (!Objects.equals(this.carId, other.carId)) {
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
