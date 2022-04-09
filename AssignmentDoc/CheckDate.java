package Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Check if date inputed by user is in the correct format.
 * @author joell
 * @author jin rui
 * @author jamie 
 * @author tan yu
 */

public class CheckDate {
	
	/**
	 * Checks the format of the date based on the YYYY-MM-DD format.
	 * @param date The user input date read in as string.
	 * @return A boolean value as to whether the date format is correct.
	 */

	//check format
	public static Boolean checkFormat(String date) {
		
		try {
			new SimpleDateFormat("YYYY-MM-DD").parse(date);
			return true;
		}
		
		catch(ParseException e) {
			return false;
		}
		
		
	}
	
	/**
	 * Checks the format of the date based on the length of the date. 
	 * The length of the date should be 10.
	 * @param date The user input date read in as string.
	 * @return A boolean value as to whether the length of the string is 10.
	 */
	
	//check length example 2022-03-4 will pass the parsing but cannot access index
	
	public static Boolean lengthCheck(String date) {
		
		//try to slice string in different format
		try {
			date.substring(0,4);
			date.substring(5,7);;
			date.substring(8,10);
			return true;
		}
		
		catch (StringIndexOutOfBoundsException e) {
			return false;
		}
		
	}
	
	/**
	 * Checks the format of the date based on the year of the date inputed.
	 * As the current year is 2022, only years (YYYY) greater than or equals to 2022 is considered valid.
	 * @param date The user input date read in as string.
	 * @return A boolean value as to whether the year of the date is greater than or equals to 2022.
	 */
	
	//Check year
	public static Boolean checkYear(String date) {
		
		//Slice the year from string  - catch exception
		String year = date.substring(0,4);
		
		try {
			int year_input = Integer.parseInt(year);
			
			if(year_input >= 2022)
				return true;
			else
				return false;
		}

		catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	/**
	 * Checks the format of the date based on the month of the date inputed.
	 * As there is only 12 months in a year, the month (MM) values should be between 1 and 12 inclusive.
	 * @param date The user input date read in as string.
	 * @return A boolean value as to whether the month of the date is between 1 and 12 inclusive.
	 */
	
	
	//check month 
	public static Boolean checkMonth(String date) {
		
		//Slice the month from string
		String month = date.substring(5,7);
		try {
			int month_input = Integer.parseInt(month);
			
			if(month_input<=12 && month_input>=1)
				return true;
			
			else
				return false;
		}
		
		catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Checks the format of the date based on the day of the date inputed.
	 * Here we assume that there are only dates (DD) from 1 to 30 inclusive. Dates out of that range are considered invalid.
	 * @param date The user input date read in as string.
	 * @return A boolean value as to whether the month of the date is between 1 and 30 inclusive.
	 */
	
	
	public static Boolean checkDate(String date) {
		
		//Slice the date from string 
		String date_input = date.substring(8,10);
		
		try {
			int datee = Integer.parseInt(date_input);
			
			//Note that we assume the months have dates from 1 to 30 so our test case cannot include months like Feb, Jan etc!
			if(datee>=1 && datee<=30)
				return true;
			else
				return false;
		}
		
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Checks the format of the date based on 5 conditions: 
	 * 1. Correct YYYY-MM-DD format, 
	 * 2. Correct length of the date in string (length of 10)
	 * 3. Correct year 
	 * 4. Correct month
	 * 5. Correct date
	 * @param date The user input date read in as string.
	 * @return A boolean value as to whether the check-in date or check-out date provided by user is acceptable.
	 */
	
	public static String getInput(String date) {
		
		Scanner sc = new Scanner(System.in);
		Boolean end = checkFormat(date) && lengthCheck(date) && checkYear(date) && checkMonth(date) && checkDate(date);

		
		
		while(!end) {
			
			System.out.println("Invalid Date. Enter Date:");
			date = sc.nextLine();
			end = checkFormat(date) && lengthCheck(date) && checkYear(date) && checkMonth(date) && checkDate(date);

		}
		
		return date;
	}
	
	
}
