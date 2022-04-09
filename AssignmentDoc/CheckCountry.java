package Assignment;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Check if a user input of a country is a valid country. 
 * If invalid, user will be prompted to input until a valid country is detected.
 * @author matchajam
 *
 */

public class CheckCountry {
	
	/**
	 * Check if input is a valid country.
	 * @param input The input from the user.
	 * @return A boolean value as to whether the input is a valid country is returned.
	 */
	

	public static Boolean check(String input) {
		
		//ArrayList containing list of countries
		ArrayList <String> countryList = new ArrayList<String>();
		String [] countryCodes = Locale.getISOCountries();
		for(String x: countryCodes) {
			
			Locale country = new Locale(" ",x);
			countryList.add(country.getDisplayCountry().toLowerCase());

		}
		

		//Check if input in countries
		if (countryList.contains(input.toLowerCase()) )
				return true;
		else
			return false;

	}
	
	/**
	 * Repeatedly get input from user until the input is valid.
	 * If the input is not a valid country, user will be continuously prompted to input until a valid country is entered.
	 * @param s The input from the user.
	 * @return A String denoting the country of user will be returned.
	 */
	
	
	// s is the input of the user when asked for country
	public static String getInput(String s) {
		
		Scanner sc = new Scanner(System.in);
		Boolean end = check(s);

		while(!end) {
			System.out.println("Invalid country. Enter country:");
			s = sc.nextLine();
			end = check(s);
		}
		
		return s;
	}
	
}