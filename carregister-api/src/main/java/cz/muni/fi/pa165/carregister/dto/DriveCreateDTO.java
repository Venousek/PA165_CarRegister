package cz.muni.fi.pa165.CarRegister.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author Cernak
 */
public class DriveCreateDTO {
    
        private Long id;
	
        private Long carId;
        
        private Long userId;
	
        private Date beginDate;
        
        private Date endDate;

        private String beginStringDate;
        
        private String endStringDate;

        int distance;

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
        
        public void setDistance(int distance) {
            this.distance = distance;
        }
        
        public int getDistance() {
            return this.distance;
        }

       @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + Objects.hashCode(this.carId);
            hash = 83 * hash + Objects.hashCode(this.userId);
            hash = 83 * hash + Objects.hashCode(this.beginDate);
            hash = 83 * hash + Objects.hashCode(this.endDate);
            hash = 83 * hash + Objects.hashCode(this.distance);
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
            if (!(obj instanceof DriveCreateDTO)) {
                return false;
            }
            final DriveCreateDTO other = (DriveCreateDTO) obj;
            if (!Objects.equals(this.carId, other.carId)) {
                return false;
            }
            if (!Objects.equals(this.userId, other.userId)) {
                return false;
            }
            if (!Objects.equals(this.beginDate, other.beginDate)) {
                return false;
            }
            if (!Objects.equals(this.endDate, other.endDate)) {
                return false;
            }
            if (!Objects.equals(this.distance, other.distance)) {
                return false;
            }
            return true;
        }

}
