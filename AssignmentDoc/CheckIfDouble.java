package Assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Check if the user input is a double value. If input is an integer, it will automatically be returned as a double. 
 * Numeric inputs with data types other than integers or double will be considered invalid.
 * If invalid, user will be prompted to input until a double value is detected.
 * @author joel
 * @author jin rui
 * @author jamie
 * @author tan yu
 */

public class CheckIfDouble {
	
	/**
	 * Check if input is a double or integer.
	 * Input is valid if it is of integer or double data type 
	 * @param s The input from the user.
	 * @return A boolean value as to whether the input is valid.
	 */

	public static Boolean checkInt(String s) {
			
			try {
				double num = Float.parseFloat(s);
				return true;
			}
			
			catch (NumberFormatException e) {
				return false;
			}
			
		}
	
	/**
	 * Repeatedly get input from user until the input is valid.
	 * If the input is invalid, user will be continuously prompted to input until a valid input is entered.
	 * @param s The input from the user.
	 * @param choice The string to indicate the error to the user so as to guide them to enter a valid input.
	 * @return A Double value specified by the user will be returned.
	 */
	
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
