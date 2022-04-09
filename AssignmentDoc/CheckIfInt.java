package Assignment;

import java.util.Scanner;

/**
 * Check if the user input is an integer. 
 * Numeric inputs with data type other than integer will be considered invalid. 
 * If invalid, user will be prompted to input until an integer value is detected.
 * @author joell
 * @author jin rui
 * @author jamie 
 * @author tan yu
 */

public class CheckIfInt {

	/**
	 * Check if input is an integer.
	 * @param s The input from the user.
	 * @return A boolean value as to whether the input is valid.
	 */
	
	public static Boolean checkInt(String s) {
		
		try {
			int num = Integer.parseInt(s);
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
	 * @return An Integer value specified by the user will be returned.
	 */
	
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
