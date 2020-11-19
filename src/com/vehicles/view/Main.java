package com.vehicles.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.project.Car;
import com.vehicles.project.Wheel;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Crear e inicialitzar Scanner
		Scanner newVehicle = new Scanner(System.in);
		
		// Crear Array amb les diferents iteracions de la pregunta
		String[] str = {"la matrícula", "la marca", "el color"};
		// Demanar matrícula, marca i color a l'usuari i guardar a l'Array str
		for(int s=0; s<3; s++) {
			System.out.print("Introdueix " + str[s] + " del teu vehicle: ");
			str[s] = newVehicle.nextLine();
		}
		
		// Crear objecte Car amb matrícula, marca i color guardats a l'Array str
		Car newCar = new Car(str[0], str[1], str[2]);

		
		System.out.println();
		
		
		// Crear tres Arrays amb les diferents iteracions de les preguntes
		String[] dd = {"darrera", "davant"}, de = {"dreta", "esquerra"}, md = {"Marca", "Diametre"};
		
		// Crear dos Array i una llista de llistes per guardar les respostes de l'usuari
		String [] newWheel = new String[2];
		Wheel[] newTwoWheels = new Wheel[2];
		List<List<Wheel>> newFourWheels = new ArrayList<List<Wheel>>(2);
		
		// Demanar marca i diametre de cada roda amb tres bucles anidats
		// Primer bucle entre les rodes del davant i del darrera
		for(int z=0; z<2; z++) {
			System.out.println("Introdueix la marca i el diametre de les rodes del " + dd[z]);
			// Segon bucle entre la roda dreta i esquerra
			for(int i=0; i<2; i++) {
				// Tercer bucle entre la marca i el diametre de cada roda
				for(int j=0; j<2; j++) {
					// Preguntar a l'usuari marca i diametre de cada roda
					System.out.print(md[j] + " de la roda " + de[i] + " del " + dd[z] + ": ");
					// Guardar marca i diametre de cada roda a l'Array newWheel
					newWheel[j] = newVehicle.nextLine();
				}
				// Crear objecte Wheel i guardar cada roda (davantera o posterior) en l'Array newTwoWheels
				newTwoWheels[i] = new Wheel(newWheel[0], Double.parseDouble(newWheel[1]));
			}
			System.out.println();
			// Crear llista List<Wheel> i guardar cada llista en la llista newFourWheels
			newFourWheels.add(Wheel.twoWheels(newTwoWheels[0], newTwoWheels[1]));
		}
		
		// Tancar Scanner
		newVehicle.close();
		
		// Afegir rodes a l'objecte Car amb les dos List<Wheel> guardades a newFourWheels
		newCar.addWheels(newFourWheels.get(1), newFourWheels.get(0));

	}

}
