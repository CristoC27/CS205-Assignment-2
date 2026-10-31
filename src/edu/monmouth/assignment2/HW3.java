package edu.monmouth.assignment2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

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
		System.out.println(strings.toString());
		}
		catch(FileNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
ArrayList <String> vehicles = new ArrayList<>();
		
		File vehiclesFile = new File(args[2]);
		try {
		Scanner reader = new Scanner(stringsFile);
		
		while(reader.hasNextLine()) {
			strings.add(reader.nextLine());
		}
		System.out.println(strings.toString());
		}
		catch(FileNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
		
		
		
		
	}
}
