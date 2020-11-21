package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) throws Exception{
		// Llançar excepció si el retorn de checkPlate() és fals
		if(Vehicle.checkPlate(plate) == false) throw new Exception();
		
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	

	protected void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel firstWheel = wheels.get(0);
		Wheel secondWheel = wheels.get(1);

		if (!firstWheel.equals(secondWheel))
			throw new Exception();

		this.wheels.add(firstWheel);
		this.wheels.add(secondWheel);
	}
	
	
	// Crear funció checkPlate per determinar si la matrícula conté 4 números i 2 o 3 lletres
	private static boolean checkPlate(String plate) {
		// Inicialitzar els contadors i la variable retorn com a falsa
		int countDigits = 0;
		int countLetters = 0;
		boolean check = false;
		
		// Iterar per cada char de la matrícula introduida
		for(char p:plate.toCharArray()) {
			// Si el char és un número sumar-ho al contador
			if(Character.isDigit(p)) {
				countDigits++;
			// Si el char és una lletra sumar-ho al contador
			}else if(Character.isLetter(p)) {
				countLetters++;
			}
		}
		
		// Si el contador de números és igual a 4 i el contador de lletres és igual a 2 o 3
		if(countDigits == 4 && (countLetters == 2 || countLetters == 3)) {
			// La matrícula és correcta
			check = true;
		}
		
		return check;
	}
	

}
