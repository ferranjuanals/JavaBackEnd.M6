package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) throws Exception{
		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}
	

}
