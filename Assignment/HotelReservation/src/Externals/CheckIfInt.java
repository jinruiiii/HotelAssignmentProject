package Externals;
import Application.*;
import Databases.*;
import Entities.*;
import java.util.Scanner;

public class CheckIfInt {

	
	public static Boolean checkInt(String s) {
		
		try {
			int num = Integer.parseInt(s);
			return true;
		}
		
		catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	// s is the user input choice can be adults or children (for printing)
	public static int getInput(String s,String choice) {
		
		Scanner sc = new Scanner(System.in);
		Boolean end = checkInt(s);
		String newInput = null;
		
		if (end)
			return Integer.parseInt(s);
		
		while(!end) {
			System.out.println("Invalid input. Enter " + choice + ":");
			newInput = sc.nextLine();
			end = checkInt (newInput);
		}
		
		return Integer.parseInt(newInput);
		
	}
}
