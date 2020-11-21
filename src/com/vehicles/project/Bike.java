package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) throws Exception{
		super(plate, brand, color);
	}
	
	public void addWheels(List<Wheel> Wheels) throws Exception {
		addTwoWheels(Wheels);
	}

}
