package cz.muni.fi.pa165.CarRegister.entities;

import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author henrich
 */
public class Car
{
	// Fields

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
        @NotNull
        @Column(unique = true)
	private String vin;
	
        @NotNull
	private String manufacturer;
	
        @NotNull
	private String model;
	
        @Min(1900)
	private int year;
	
        @NotNull
        @Column(unique = true)
	private String register_number;	
        
        @Min(0)
	private int mileage;
	
        @NotNull
	private Fuel fuel;

	// Gets and Sets

        public Long getId() {
            return id;
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
	
}
