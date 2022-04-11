package Externals;
import Application.*;
import Databases.*;
import Entities.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CheckCountry {

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
