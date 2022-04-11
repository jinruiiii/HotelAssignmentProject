package Assignment;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * 
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class ReservationsDB implements Serializable{
	private static final long serialVersionUID = 1L;
    private ArrayList<Object> ReservationDataBase = new ArrayList<Object>();
    //Index		Variable
    //0			Reservation Code
    //1			Reservation
    
    /**
     * Constructs an empty reservations database that stores the reservation codes and the reservation details whenever a guest creates a reservation or books one or more of the hotel rooms.
     * Index		Variable
     * 0			Reservation Code
     * 1			Reservation
     */
    ReservationsDB(){}
    
    /**
     * When a new reservation is made, the reservation code and the reservation's associated details will be added into the reservations database.
     * @param reservationCode the reservation code to be added into the reservations database.
     * @param reservation the reservation to be added into the reservations database.
     */
    public void appendRow(String reservationCode, Reservation reservation) {
        ArrayList<Object> newRow = new ArrayList<Object>();
        newRow.add(reservationCode);
        newRow.add(reservation);

        ReservationDataBase.add(newRow);
    }
    
    /**
     * Gets the current reservation database with its stored reservations, if any.
     * @return the current reservation database with its stored reservations.
     */
    public ArrayList<Object> getReservationDataBase() {
        return ReservationDataBase;
    }

    /**
     * Gets reservation stored in the reservations database, using the associated reservation code. If reservation cannot be found, the method returns 0.
     * @param reservationCode the reservation code to be searched for in the reservations database.
     * @return the reservation stored in the reservations database.
     */
    public Reservation getReservationFromReservationCode(String reservationCode){
        for(int i = 0; i<ReservationDataBase.size(); i++) {
            if(((String)((ArrayList<Object>)ReservationDataBase.get(i)).get(0)).equals(reservationCode)) {
                return (Reservation)((ArrayList<Object>) ReservationDataBase.get(i)).get(1);
            }
        }
        return null;
    }
    
    /**
     * Gets the index of the reservation stored in the reservations database, using the associated reservation code. If reservation cannot be found, the method returns 0.
     * @param reservationCode the reservation code to be searched for in the reservations database.
     * @return the index of the reservation stored in the reservations database.
     */
    public int getReservationIndexFromReservationCode(String reservationCode){
        for(int i = 0; i<ReservationDataBase.size(); i++) {
            if(((String)((ArrayList<Object>)ReservationDataBase.get(i)).get(0)).equals(reservationCode)) {
                return i;
            }
        }
        return 0;
    }
    
    /**
     * Checks out the guest from their associated room, using their reservation code. 
     * The method also deletes the reservation associated with the reservation code and updates the room status to become vacant.
     * @param reservationCode	the reservation code to be searched for in the reservations database.
     */
    public void checkOut(String reservationCode) {
    	getReservationFromReservationCode(reservationCode).getRoom().setStatus(Room.RoomStatus.VACANT);
        ReservationDataBase.remove(getReservationIndexFromReservationCode(reservationCode));
        System.out.println("Successfully Checked Out! Reservation has been deleted");
    }
    
    /**
     * Deletes a reservation associated with the reservation code and updates the room status to become vacant.
     * @param reservationCode	the reservation code to be searched for in the reservations database.
     */
    public void removeReservation(String reservationCode) {
    	getReservationFromReservationCode(reservationCode).getRoom().setStatus(Room.RoomStatus.VACANT);
        ReservationDataBase.remove(getReservationIndexFromReservationCode(reservationCode));
        System.out.println("Successfully Removed Reservation! Reservation has been deleted");
    }

    /**
     * Displays the details of all the reservations stored in the reservations database.
     * The reservation details include the reservation code, check-in date, check-out date, number of adults and children, and room type.
     */
    public void displayAllReservations(){
        String format = "%-20s%-20s%-20s%-20s%-20s%-20s%n";
        System.out.printf(format, "Reservation Code", "Check-In Date", "Check-Out Date", "# of Adults", "# of Children", "Room Type" );
        System.out.printf(format, "================", "==================", "==================", "==================", "==================",  "==================");

        for(int i = 0; i<ReservationDataBase.size(); i++) {
            System.out.printf(format, ((ArrayList<Object>)ReservationDataBase.get(i)).get(0), ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getCheckInDate(),  ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getCheckOutDate(),  ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getAdults(),  ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getChildren(),  ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getRoom().getRoomType());
        }
    }
    
    /**
     * Displays the details of a reservation stored in the reservations database using the associated reservation code.
     * The reservation details include the reservation code, check-in date, check-out date, number of adults and children, and room type.
     * @param ReservationCode	the reservation code to be searched for in the reservations database.
     */
    public void printReservationFromReservationCode(String ReservationCode) {
    	String format = "%-20s%-20s%-20s%-20s%-20s%-20s%n";
        System.out.printf(format, "Reservation Code", "Check-In Date", "Check-Out Date", "# of Adults", "# of Children", "Room Type" );
        System.out.printf(format, "================", "==================", "==================", "==================", "==================",  "==================");
        for(int i = 0; i<ReservationDataBase.size(); i++) {
            if(((String)((ArrayList<Object>)ReservationDataBase.get(i)).get(0)).equals(ReservationCode)) {
            	System.out.printf(format, ((ArrayList<Object>)ReservationDataBase.get(i)).get(0), ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getCheckInDate(),  ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getCheckOutDate(),  ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getAdults(),  ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getChildren(),  ((Reservation)((ArrayList<Object>)ReservationDataBase.get(i)).get(1)).getRoom().getRoomType());
            }
        }
    }

    /**
     * Displays the details of a guest stored in the reservations database, including guest name, guest country, guest gender, guest nationality, guest address and address contact.
     * @param guestName	the name of the guest to be searched for in the reservations database.
     */
    public void displayGuest(String guestName) {

        String format = "%-20s%-20s%-20s%-20s%-20s%-20s%n";
        boolean found = false;
        
        for(int i=0;i<ReservationDataBase.size();i++) {
        	if (((Reservation) ((ArrayList<Object>) ReservationDataBase.get(i)).get(1)).getGuest().getIc().getName().equals(guestName)) {
        		System.out.printf(format, "Guest name", "Guest country", "Guest gender", "Guest nationality", "Guest address", "Address contact" );
                System.out.printf(format, "================", "==================", "==================", "==================", "==================",  "==================");
        		System.out.printf(format, (((Reservation)((ArrayList<Object>) ReservationDataBase.get(i)).get(1)).getGuest().getIc().getName()), ((Reservation)((ArrayList<Object>) ReservationDataBase.get(i)).get(1)).getGuest().getIc().getCountry(), ((Reservation)((ArrayList<Object>) ReservationDataBase.get(i)).get(1)).getGuest().getIc().getGender(), ((Reservation)((ArrayList<Object>) ReservationDataBase.get(i)).get(1)).getGuest().getIc().getNationality(), ((Reservation)((ArrayList<Object>) ReservationDataBase.get(i)).get(1)).getGuest().getIc().getAddress(), ((Reservation)((ArrayList<Object>) ReservationDataBase.get(i)).get(1)).getGuest().getIc().getContact());
        		found = true;
        	}
        	
        }
        if (!found) System.out.println("Sorry, we cannot find the Guest Name in our Guest List!");
    }
    
    /**
     * Displays all the details of the associated guests stored in the reservations database, including guest name, guest country, guest gender, guest nationality, guest address and address contact.
     */
    public void displayAllGuests() {

        ArrayList<Object> retrievDB = this.ReservationDataBase;

        String format = "%-20s%-20s%-20s%-20s%-20s%-20s%n";
        System.out.printf(format, "Guest name:", "Guest country", "Guest gender", "Guest nationality", "Guest address", "Address contact" );
        System.out.printf(format, "================", "==================", "==================", "==================", "==================",  "==================");

        for(int i=0;i<retrievDB.size();i++) {

            ArrayList<Object> row = (ArrayList<Object>) retrievDB.get(i);

            System.out.printf(format, ( ((Reservation)row.get(1)).getGuest().getIc().getName()), ((Reservation)row.get(1)).getGuest().getIc().getCountry(),  ((Reservation)row.get(1)).getGuest().getIc().getGender(), ((Reservation)row.get(1)).getGuest().getIc().getNationality(), ((Reservation)row.get(1)).getGuest().getIc().getAddress(), ((Reservation)row.get(1)).getGuest().getIc().getContact());
        }
    }
    
    /**
     * Checks if the reservation code parameter passed in has been stored in the reservations database.
     * @param ReservationCode	the reservation code to be searched for in the reservations database.
     * @return returns true if the reservation code is stored in the reservations database.
     */
    public boolean isValidCode(String ReservationCode){
        for(int i = 0; i<ReservationDataBase.size(); i++) {
            if(((String)((ArrayList<Object>)ReservationDataBase.get(i)).get(0)).equals(ReservationCode)) {
                return true;
            }
        }
        return false;
    }

}
