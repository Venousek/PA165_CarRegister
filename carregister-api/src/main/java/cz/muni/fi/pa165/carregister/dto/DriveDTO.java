package cz.muni.fi.pa165.CarRegister.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author blahut
 */
public class DriveDTO {
    
        private Long id;
	
        private CarDTO car;
        
        private UserDTO user;
	
        private Date beginDate;

        private Date endDate;
        
        private String beginStringDate;
        
        private String endStringDate;


        int distance;

        
          public String getBeginStringDate() {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            return format.format(beginDate);
        }

        public void setBeginStringDate(String begin) throws ParseException {
            this.beginStringDate = begin;
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            this.beginDate = format.parse(begin);
        }
        
        public String getEndStringDate() {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            return format.format(endDate);
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

        public Date getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Date beginDate) {
            this.beginDate = beginDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
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
            hash = 47 * hash + Objects.hashCode(this.beginDate);
            hash = 47 * hash + Objects.hashCode(this.endDate);
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
            if (!Objects.equals(this.beginDate, other.beginDate)) {
                return false;
            }
            if (!Objects.equals(this.endDate, other.endDate)) {
                return false;
            }
            return true;
        }
}
