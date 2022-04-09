package Assignment;

import java.util.*;
import java.lang.*;

/**
 * Check if the user input is a string.
 * Any inputs with numbers are considered as invalid input.
 * @author joel
 * @author jin rui
 * @author jamie
 * @author tan yu
 */


public class CheckIfString {
	
	/**
	 * Check if the input is a string.
	 * @param str The input from the user.
	 * @return A boolean value as to whether the input is valid.
	 */
	
	public static Boolean isItString(String str) {
		
		//Check if it is all string using string wrapper class
				for (int k =0; k<str.length();k++) {
					if (Character.isDigit(str.charAt(k))) {
						return false;
					}
				}
				return true;
	}
	
	/**
	 * Repeatedly get input from user until the input is valid.
	 * If the input is invalid, user will be continuously prompted to input until a valid input is entered.
	 * @param s The input from the user.
	 * @param choice The string to indicate the error to the user so as to guide them to enter a valid input.
	 * @return A string specified by the user will be returned.
	 */
	
	//The string s is the previous input and the string choice is the TYPE of input - contact, address etc
	public static String getInput(String s, String choice) {
		
		Scanner sc = new Scanner(System.in);
		Boolean end = isItString(s);
		
		while(!end) {
			
			System.out.println("Invalid input. Enter " + choice +":");
			s = sc.nextLine();
			end = isItString(s);
		
		}
		return s;
	}
}
