package com.vehicles.project;

import java.util.Arrays;
import java.util.List;

public class Wheel {
	
	private String brand;
	private double diameter;

	
	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	
	// Mètode estàtic per a crear una List<Wheel> a partir de dos objectes Wheel
	public static List<Wheel> twoWheels(Wheel rightWheel, Wheel leftWheel) {
		List<Wheel> twoWheels = Arrays.asList(rightWheel, leftWheel);
		return twoWheels;
	}
	
	// Sobreescriure el mètode equals per tal de poder comparar objectes Wheel
	@Override
	public boolean equals(Object other) {
		// Si el segon objecte no és una instancia de Wheel tornar false
	    if (!(other instanceof Wheel)) {
	        return false;
	    }
	    // Cast el segon objecte a Wheel per poder comparar atributs
	    Wheel that = (Wheel) other;

	    // Comparar els atributs dels dos objectes 
	    return this.brand.equals(that.brand)
	        && this.diameter == that.diameter;
	}
}
