package Assignment;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Stores all the information of a particular guest.
 * @author joell
 * @author jin rui
 * @author jamie
 * @author tan yu
 */

public class IdentityCard implements Serializable{
	
    private String name;
    private String country;
    private String gender;
    private String nationality;
    private String address;
    private String contact;
    
    /**
     * Constructor for <code>IdentityCard</code> class.
     * Name,Country,Gender,Nationality,Address and contact attributes are all initialized via user input.
     */

    IdentityCard(){
    	
        Scanner sc = new Scanner(System.in);
        
        //No error for name - no exception throw but check if no numbers present
        System.out.println("Input name");
        String name_input = sc.nextLine();
        name_input = CheckIfString.getInput(name_input, "name");
        this.name = name_input; 
        
        //No error for country - no exception throw but check if no numbers present
        System.out.println("Input country");
        String country_input = sc.nextLine();
        country_input = CheckCountry.getInput(country_input);
        this.country = country_input; 
        
        //No error for gender - no exception thrown but check validity
        System.out.println("Input gender");
        String gender = sc.nextLine();
        while(gender.toLowerCase().equals("f") == false && gender.toLowerCase().equals("m") == false && gender.toLowerCase().equals("female") == false && gender.toLowerCase().equals("male") == false) {
            System.out.println("Invalid input. Input gender");
            gender = sc.nextLine();
        }
        
        this.gender = gender;
        
        //No error for nationality - no exception throw but check if no numbers present
        System.out.println("Input nationality");
        String nation_input = sc.nextLine();
        nation_input = CheckIfString.getInput(nation_input, "nationality");
        this.nationality = nation_input; 
       
        //No error for address - no exception throw OK to have numbers and string!
        System.out.println("Input address");
        this.address =  sc.nextLine();
               
        //Convert into integers and throw exception if unable to do so & check length of number
        System.out.println("Input contact");
        String strnum = sc.nextLine();
        Boolean end = true;
        while (end) {
	        try {
	        	//Try Converting to integer + check length of string
	        	int phonenum = Integer.parseInt(strnum);
	        	
	        }
	        
	        //Catch exceptions 
	        catch(NumberFormatException n) {
	            System.out.println("Invalid input. Alphabets should not be in phone number. Input contact:");
	            strnum = sc.nextLine();
	            continue;
	        }
	        
	        finally {
	        	
	        	//Check the length of the phone number if its all numbers
	        	if(strnum.length() != 8) {
	                System.out.println("Invalid input. The length of the phone number should be 8. Input contact:");
	                strnum = sc.nextLine();
	                continue;
	        	}
	        	
	            this.contact = strnum;
	            end = false;
	        }
        }
    }
    
    /**
     * Getter to retrieve name attribute.
     * @return A string denoting guest's name is returned.
     */

    public String getName(){
        return name;
    }
    
    /**
     * Setter to set name attribute.
     * @param name Guest's name is passed as a parameter. This string cannot contain digits.
     */

    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Getter to retrieve country attribute.
     * @return A string denoting guest's country is return. This string cannot contain digits.
     */

    public String getCountry(){
        return country;
    }
    
    /**
     * Setter to set country attribute.
     * @param country Guest's country is passed as a parameter.
     */

    public void setCountry(String country){
        this.country = country;
    }
    
    /**
     * Getter to get guest's gender.
     * @return A string denoting guest's gender is returned. This string cannot contain digits.
     */

    public String getGender(){
        return gender;
    }
    
    /**
     * Setter to set guest's gender.
     * @param gender Guest's gender is passed as a parameter.
     */

    public void setGender(String gender){
        this.gender = gender;
    }
    
    /**
     * Getter to get guest's nationality.
     * @return A string denoting guest's nationality is returned. This string does not contain any digits.
     */

    public String getNationality(){
        return nationality;
    }
    
    /**
     * Setter to set guest's nationality.
     * @param nationality Guest's nationality is passed as a parameter.
     */

    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    
    /**
     * Getter to get guest's address.
     * @return A string denoting guest's address. This string is alphanumeric and can contain both digits and alphabets.
     */

    public String getAddress(){
        return address;
    }
    
    /**
     * Setter to set guest's address
     * @param address Guest's address is passed as a parameter.
     */

    public void setAddress(String address){
        this.address = address;
    }
    
    /**
     * Getter to get guest's contact.
     * @return A string denoting a guest's contact.
     */

    public String getContact(){
        return contact;
    }
    
    /**
     * Setter to set guest's contact.
     * @param contact Guest's contact is passed as a parameter.
     */

    public void setContact(String contact){
        this.contact = contact;
    }
}
