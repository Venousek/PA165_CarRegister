/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.entities;
import org.joda.time.DateTime;
/**
 *
 * @author robha
 */
public class Drive {
    	// Fields

	private Long id;
	
	private Long carId;
        
        private Long userId;
	
        DateTime begin;

        DateTime end;

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

}
