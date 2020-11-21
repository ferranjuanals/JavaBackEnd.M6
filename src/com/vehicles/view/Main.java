package com.vehicles.view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.project.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Crear nou vehicle newVehicle de valor nul
		Vehicle newVehicle = null;
		
		// Crear e inicialitzar Scanner
		Scanner newScanner = new Scanner(System.in);
		
		// Preguntar si es vol crear cotxe o moto
		System.out.println("Vols crear un cotxe o una moto?");
		String vehicle = newScanner.nextLine().toLowerCase();
		
		// Executar una de les dos opcions del switch
		switch(vehicle) {
		case "cotxe":
			// Mètode newVehicle() per demanar matrícula, marca i color i newCar() per crear Car i afegir rodes
			newVehicle = newCar(newVehicle());
			break;
		case "moto":
			// Mètode newVehicle() per demanar matrícula, marca i color i newBike() per crear Bike i afegir rodes
			newVehicle = newBike(newVehicle());
			break;
		default:
			// Imprimir en cas que no s'introdueixi cotxe o moto
			System.out.println("Només es pot crear un cotxe o una moto");
		}
		
		// Tancar Scanner
		newScanner.close();
		
	}
	

	// Demanar matrícula, marca i color amb el mètode newVehicle()
	private static String[] newVehicle() {
		// Crear e inicialitzar Scanner
		Scanner newScanner = new Scanner(System.in);
				
		// Crear Array amb les diferents iteracions de la pregunta
		String[] str = {"la matrícula", "la marca", "el color"};
		// Demanar matrícula, marca i color a l'usuari i guardar a l'Array str
		for(int s=0; s<3; s++) {
			System.out.print("Introdueix " + str[s] + " del teu vehicle: ");
			str[s] = newScanner.nextLine();
		}
		
		// Tornar Array amb les respostes
		return str;
	}
	
	
	// Crear vehicle Car i afegir-hi dues rodes davanteres i dues posteriors
	private static Car newCar(String[] str) throws Exception{
		
		// Crear objecte Car amb matrícula, marca i color guardats a l'Array str
		Car newVehicle = new Car(str[0], str[1], str[2]);
		
		// Crear e inicialitzar Scanner
		Scanner newScanner = new Scanner(System.in);

				
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
					newWheel[j] = newScanner.nextLine();
				}
				// Crear objecte Wheel i guardar cada roda (davantera o posterior) en l'Array newTwoWheels
				newTwoWheels[i] = new Wheel(newWheel[0], Double.parseDouble(newWheel[1]));
			}
			System.out.println();
			// Crear llista List<Wheel> amb mètode listTwoWheels() i guardar cada llista en una altre llista newFourWheels
			newFourWheels.add(Wheel.listTwoWheels(newTwoWheels[0], newTwoWheels[1]));
		}
		
		// Tancar Scanner
		newScanner.close();
		
		// Afegir rodes a l'objecte Car amb les dos List<Wheel> guardades a newFourWheels
		newVehicle.addWheels(newFourWheels.get(1), newFourWheels.get(0));

		return newVehicle;
	}
	

	// Crear vehicle Car i afegir-hi una roda davantera i una posterior
	private static Bike newBike(String[] str) throws Exception{
				
		// Crear objecte Bike amb matrícula, marca i color guardats a l'Array str
		Bike newBike = new Bike(str[0], str[1], str[2]);
		
		// Crear e inicialitzar Scanner
		Scanner newVehicle = new Scanner(System.in);

				
		System.out.println();
				
				
		// Crear dos Arrays amb les diferents iteracions de les preguntes
		String[] dd = {"darrera", "davant"}, md = {"Marca", "Diametre"};
				
		// Crear dos Array i una llista de llistes per guardar les respostes de l'usuari
		String [] newWheel = new String[2];
		Wheel[] newTwoWheels = new Wheel[2];
				
		// Demanar marca i diametre de cada roda amb tres bucles anidats
		// Primer bucle entre les rodes del davant i del darrera
		for(int i=0; i<2; i++) {
			System.out.println("Introdueix la marca i el diametre de la roda del " + dd[i]);
			// Segon bucle entre la marca i el diametre de cada roda
			for(int j=0; j<2; j++) {
				// Preguntar a l'usuari marca i diametre de cada roda
				System.out.print(md[j] + " de la roda del " + dd[i] + ": ");
				// Guardar marca i diametre de cada roda a l'Array newWheel
				newWheel[j] = newVehicle.nextLine();
			}
			// Crear objecte Wheel i guardar cada roda (davantera o posterior) en l'Array newTwoWheels
			newTwoWheels[i] = new Wheel(newWheel[0], Double.parseDouble(newWheel[1]));
			System.out.println();
		}
				
		// Tancar Scanner
		newVehicle.close();
				
		// Afegir rodes a l'objecte Bike passant l'Array newTwoWheels a List<Wheel> amb el mètode listTwoWheels()
		newBike.addWheels(Wheel.listTwoWheels(newTwoWheels[0], newTwoWheels[1]));

		return newBike;
	}


}
