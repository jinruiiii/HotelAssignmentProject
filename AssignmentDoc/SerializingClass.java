package Assignment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Contains all the methods to serialise the details in the main program.
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class SerializingClass implements Serializable {

	/**
	 * Constructs a class for serializing code.
	 */
	SerializingClass(){}
	
	/**
	 * Reads the file.
	 * @param name			the filename.
	 * @return				the file being read.
	 * @throws IOException	if the IO operation fails.
	 */
	public static Object readFile(String name) throws IOException {
		Object myObj = null;
	      try {
	         FileInputStream fileIn = new FileInputStream(name);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         myObj = in.readObject();
	         in.close();
	         fileIn.close();
	      } 
//	      catch (IOException i) {
//		         i.printStackTrace();
//		         DataBase = new ReservationsDB(); // creating a new DataBase of Reservations
//		         return;
//		  } 
	      catch (ClassNotFoundException c) {
	         System.out.println(name + " class not found");
	         c.printStackTrace();
	         return null;
	      } 
	      catch (FileNotFoundException s) {
	    	  System.out.println(name + " was not found. Creating new object...");
	    	  return null;
	      }
	      return myObj;

	}
	
	/**
	 * Writes the file and saves it before shutting down the Hotel Reservation System.
	 * @param name			the filename.
	 * @param myObj			the object to be saved in the file.
	 * @throws IOException	if the IO operation fails.
	 */
	public static void writeFile(String name, Object myObj) throws IOException {
		try {
  	         FileOutputStream fileOut = new FileOutputStream(name);
  	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
  	         out.writeObject(myObj);
  	         out.close();
  	         fileOut.close();
  	         System.out.printf("Serialized data is saved in " + name);
  	      } catch (IOException i) {
  	         i.printStackTrace();
  	      }
	}

 
//	   public static void main(String [] args) {
//		  //Invoke this part to read an existing CSV file
//		   Rooms rooms = new Rooms();
//		    String file = "RoomsInformation.csv";
//		    BufferedReader reader = null;
//		    String line = "";
//		    try{
//		        reader = new BufferedReader(new FileReader(file));
//		        // room number is from 1-48 but array is zero indexed
//		        line = reader.readLine();
//		        while((line = reader.readLine()) != null){
//		            String[] row = line.split(",");
//		            rooms.addRoom(Integer.parseInt(row[0]), row[1], row[2], Boolean.parseBoolean(row[3]), Boolean.parseBoolean(row[4]), Boolean.parseBoolean(row[5]));
//		        }
//		    }
//		    catch(Exception e){
//		        e.printStackTrace();
//		    }
//		    finally{
//		        try{
//		            reader.close();
//		        }catch(IOException e){
//		            e.printStackTrace();
//		        }
//		    }
//	      
	
		    
		    //Invoke this part to create new ser file
		    
//	      try {
//	         FileOutputStream fileOut = new FileOutputStream("employee.ser");
//	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
//	         out.writeObject(rooms);
//	         out.close();
//	         fileOut.close();
//	         System.out.printf("Serialized data is saved in employee.ser");
//	      } catch (IOException i) {
//	         i.printStackTrace();
//	      }
//	   }
//	
//
		   
		   	//Invoke to read ser  file
//		   Rooms rooms = null;
//		      try {
//		         FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
//		         ObjectInputStream in = new ObjectInputStream(fileIn);
//		         rooms = (Rooms) in.readObject();
//		         in.close();
//		         fileIn.close();
//		      } catch (IOException i) {
//		         i.printStackTrace();
//		         return;
//		      } catch (ClassNotFoundException c) {
//		         System.out.println("Employee class not found");
//		         c.printStackTrace();
//		         return;
//		      }
//		      System.out.println(rooms);
		   
		   
//}
	   
}
