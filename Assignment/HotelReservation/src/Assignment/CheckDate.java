package Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CheckDate {

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
