package edu.monmouth.assignment2;
import edu.monmouth.vehicle.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Iterator;

public class HW3 {
	public static void main(String args[]) {
	final int REQUIREDARGS=3, BADARGS=1, BADREDIRECT=2;
		
		// check for 1 command line argument
		if(args.length != REQUIREDARGS) {
			System.err.println("Give the name of a log file and two input files");
			System.exit(BADARGS);
		}
		// redirect STDOUT & STDERR to file name given in args[0]
		try {
			PrintStream redirectStream = new PrintStream(args[0]);
			System.setOut(redirectStream);
			System.setErr(redirectStream);
		} catch(FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(BADREDIRECT);
		}
		
		ArrayList <String> strings = new ArrayList<>();
		
		File stringsFile = new File(args[1]);
		try {
			Scanner reader = new Scanner(stringsFile);
		
			while(reader.hasNextLine()) {
				strings.add(reader.nextLine());
			}
		}
		catch(FileNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
		System.out.println(strings.toString());
		System.out.println("Is string ArrayList empty: " + strings.isEmpty());
		strings.remove(1);
		System.out.println("After removing second item in ArrayList: \n"+ strings.toString());
		System.out.println("Does the ArrayList contain the string 'Great Hall': "+ strings.contains("Great Hall"));
		System.out.println("Does the ArrayList contain the string 'Monmouth': "+ strings.contains("Monmouth"));
		Iterator<String> iter = strings.iterator();
		System.out.println("List iterator values: ");
		while (iter.hasNext()) {
			System.out.println(iter.next());
	}		
		System.out.println("\n");
		
		
		
		
		
		ArrayList <Vehicle> vehicles = new ArrayList<>();
		
		File vehiclesFile = new File(args[2]);
		try {
			Scanner reader = new Scanner(vehiclesFile);
		
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				if (line.length() == 0 || line.split(",").length != 3) {
					continue;
				}
				else{
					String[] vehicleData = line.split(",");
					if (vehicleData[0].equals("c")) {
						PowerTypes source = findSource(vehicleData);
						int engineSize;
						try {
						engineSize = Integer.valueOf(vehicleData[2]);
						}
						catch (NumberFormatException e) {
							System.err.println(e.getMessage());
							continue;
						}
						try {
							Car c = new Car(source,engineSize);
							vehicles.add(c);

						}
						catch(CarException e) {
							System.err.println(e.getMessage());
						}
					}
					else if(vehicleData[0].equals("b")) {
						PowerTypes source = findSource(vehicleData);
						int boatLength;
						try {
							boatLength = Integer.valueOf(vehicleData[2]);
						}
						catch (NumberFormatException e) {
							System.err.println(e.getMessage());
							continue;
						}
						try {
							Boat b = new Boat(source,boatLength);
							vehicles.add(b);
						}
						catch(BoatException e) {
							System.err.println(e.getMessage());
						}
					}
					else {
						continue;
					}
				}

			}
			System.out.println(vehicles.toString());

		}
		catch(FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		Vehicle v1 = null;
		Vehicle v2 = null;

		try {
		 v1 = new Car(PowerTypes.GASOLINE, 4);
		 v2 = new Car(PowerTypes.DIESEL, 1);
		}
		catch(CarException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println(vehicles.toString());
		System.out.println("Is vehicle ArrayList empty: " + vehicles.isEmpty());
		vehicles.remove(2);
		System.out.println("After removing third item in ArrayList: \n"+ vehicles.toString());
		System.out.println("Does the ArrayList contain the object 'v1': "+ vehicles.contains(v1));
		System.out.println("Does the ArrayList contain the string 'v2': "+ vehicles.contains(v2));
		Iterator<Vehicle> it = vehicles.iterator();
		System.out.println("List iterator values: ");
		while (it.hasNext()) {
				System.out.println(it.next());
		}		
		
		

	
}
	public static PowerTypes findSource(String[] vehicleData) {
		PowerTypes source = null;
		if(vehicleData[1].equals("GASOLINE")) {
			 source = PowerTypes.GASOLINE;
		}
		else if(vehicleData[1].equals("DEISEL")) {
			 source = PowerTypes.DIESEL;
		}
		else if(vehicleData[1].equals("FUELOIL")) {
			 source = PowerTypes.FUELOIL;
		}
		else if(vehicleData[1].equals("ELECTRICITY")) {
			 source = PowerTypes.ELECTRICITY;
		}
		return source;
	}
	
	
}
