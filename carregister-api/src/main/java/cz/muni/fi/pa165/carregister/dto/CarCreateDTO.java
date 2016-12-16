/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dto;

import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import java.util.Objects;

/**
 *
 * @author Henrich
 */
public class CarCreateDTO
{
    private Long id;
	
	private String vin;
	
	private String manufacturer;
	
	private String model;
	
	private int year;
	
	private String register_number;	
        
	private int mileage;
	
	private Fuel fuel;

	// Gets and Sets

        public Long getId() {
            return id;
        }
	public void setId(Long id) {
            this.id = id;
        }	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRegister_number() {
		return register_number;
	}

	public void setRegister_number(String register_number) {
		this.register_number = register_number;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

        public Fuel getFuel() {
            return fuel;
        }

        public void setFuel(Fuel fuel) {
            this.fuel = fuel;
        }	
        @Override
        public String toString() {
            return getManufacturer()+" "+ getModel();
        }
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 53 * hash + Objects.hashCode(this.vin);
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
            if (!(obj instanceof CarCreateDTO)) {
                return false;
            }
            
            final CarCreateDTO other = (CarCreateDTO) obj;

            if (!Objects.equals(this.vin, other.vin)) {
                return false;
            }

            return true;
        }
}
