package Externals;
import Application.*;
import Databases.*;
import Entities.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckIfDouble {

public static Boolean checkInt(String s) {
		
		try {
			double num = Float.parseFloat(s);
			return true;
		}
		
		catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	// s is the user input choice can be adults or children (for printing)
	public static double getInput(String s,String choice) {
		
		Scanner sc = new Scanner(System.in);
		Boolean end = checkInt(s);
		String newInput = null;
		
		if (end)
			return Float.parseFloat(s);
		
		while(!end) {
			System.out.println("Invalid input. Enter " + choice + ":");
			newInput = sc.nextLine();
			end = checkInt (newInput);
		}
		
		return Float.parseFloat(newInput);
		
	}
	
}
