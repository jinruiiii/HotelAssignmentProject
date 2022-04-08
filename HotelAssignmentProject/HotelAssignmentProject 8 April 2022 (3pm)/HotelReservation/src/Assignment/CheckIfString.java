package Assignment;

import java.util.*;
import java.lang.*;


public class CheckIfString {
	
	public static Boolean isItString(String str) {
		
		//Check if it is all string using string wrapper class
				for (int k =0; k<str.length();k++) {
					if (Character.isDigit(str.charAt(k))) {
						return false;
					}
				}
				return true;
	}
	
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
