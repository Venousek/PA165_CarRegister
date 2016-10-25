package cz.muni.fi.pa165.CarRegister.entities;

import cz.muni.fi.pa165.CarRegister.enums.Fuel;

public class Car
{
	// Fields
	
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
