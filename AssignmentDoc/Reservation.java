package Assignment;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class Reservation implements Payment, Serializable{
	
	/*
	 * Contains the different types of reservation statuses, depending on the guest's check-in date.
	 * The guest's reservation status is on the waitlist, when the room status of the room that the guest has booked for is under maintenance.
	 * The guest's reservation status is confirmed, when guest does a walk-in or immediate booking of a room or multiple rooms over the hotel counter.
	 * The guest's reservation status is checked-in, when the guest successfully checks in to his or her room between 3:00PM SGT and 4:00PM SGT on their check-in date. 
	 * The guest's reservation status is expired, when guest does not check in to his or her room between 3:00PM SGT and 4:00PM SGT on their check-in date. The reservation for the guest will then be cancelled.
	 */
	public enum ReservationStatus{
		WAITLIST,CONFIRMED,CHECKED_IN,EXPIRED;
	}
	
	private static final long serialVersionUID = 1L;
	protected ReservationStatus status = ReservationStatus.WAITLIST;
    private Room room;
    private Guest guest;
    private String checkInDate;
    private String checkOutDate;
    private int adults;
    private int children;
    private String code;
    private double payment;
    private double discount = 0.10;
    
    /**
     * Constructs an empty reservation requested by the guest, which requires the guest to indicate their check-in date, check-out date, number of adults and children and stores the reservation into the 
     * hotel's reservation database if successful.
     * @param guest		the guest's details. If the guest cannot found, the reservation cannot be made. 
     * @param walkIn	indicates if the Guest is booking a room via walk-in or reservation. Returns 0 if walk-in.
     * @param dt		the date that the Reservation was made.
     */
    public Reservation(Guest guest, int walkIn, Date dt){
    	//Exception Handling for all the dates inputed
        this.guest = guest;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input check in date (YYYY-MM-DD)");
        String date_checkin = sc.nextLine();
        this.checkInDate = CheckDate.getInput(date_checkin);
        
        
        System.out.println("Input check out date (YYYY-MM-DD)");
        String date_checkout = sc.nextLine();
        this.checkOutDate = CheckDate.getInput(date_checkout);
        
      //Exception Handling for all number of children and adult inputed
        System.out.println("Input number of adults");
        String num_adults = sc.nextLine();
        this.adults = CheckIfInt.getInput(num_adults,"adults");
        
        System.out.println("Input number of children");
        String num_children = sc.nextLine();
        this.children = CheckIfInt.getInput(num_children,"children");
    }

	/**
     * Gets the generated reservation code for the guest upon successful reservation.
     * @return the generated reservation code tied to the guest.
     */
    public String getReservationCode() {
        return code;
    }
    
    /**
     * Gets the room that is available to the guest upon successful reservation.
     * @return the room associated with the guest.
     */
    public Room getRoom(){
        return room;
    }
    
    /**
     * Sets the room that is available to the guest upon successful reservation.
     * @param room	the room associated with the guest.
     */
    public void setRoom(Room room) {
        this.room = room;
    }
    
    /**
     * Gets the guest that is associated with the reservation, together with their identification details.
     * @return the guest that is associated with the reservation.
     */
    public Guest getGuest(){
        return guest;
    }
    
    /**
     * Sets the guest that is associated with the reservation, together with their identification details.
     * @param guest	the guest that is associated with the reservation.
     */
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    
    /**
     * Gets the guest's check-in date upon successful reservation.
     * @return the guest's check-in date upon successful reservation. 
     */
    public String getCheckInDate(){
        return checkInDate;
    }
    
    /**
     * Sets the guest's check-in date upon successful reservation.
     * @param checkInDate the guest's check-in date upon successful reservation. 
     */
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }
    
    /**
     * Gets the guest's check-out date upon successful reservation.
     * @return the guest's check-out date upon successful reservation. 
     */
    public String getCheckOutDate(){
        return checkOutDate;
    }
    
    /**
     * Sets the guest's check-out date upon successful reservation.
     * @param checkOutDate	the guest's check-out date upon successful reservation. 
     */
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    /**
     * Gets the declared number of adults checking-in with the guest upon successful reservation.
     * @return the number of adults checking-in with the guest.
     */
    public int getAdults(){
        return adults;
    }
    
    /**
     * Sets the declared number of adults checking-in with the guest upon successful reservation.
     * @param adults	the number of adults checking-in with the guest.
     */
    public void setAdults(int adults) {
        this.adults = adults;
    }
    
    /**
     * Gets the declared number of children checking-in with the guest upon successful reservation.
     * @return the number of children checking-in with the guest.
     */
    public int getChildren(){
        return children;
    }
    
    /**
     * Sets the declared number of children checking-in with the guest upon successful reservation.
     * @param children	the number of children checking-in with the guest.
     */
    public void setChildren(int children) {
        this.children = children;
    }
    
    /**
     * Gets the current status of the reservation requested by the guest upon successful reservation.
     * @return current status of the reservation associated with the guest.
     */
    public ReservationStatus getStatus() {
    	return status;
    }
    
    /**
     * Sets the current status of the reservation requested by the guest upon successful reservation.
     * @param rvs	the reservation status.
     */
    public void setStatus(ReservationStatus rvs) {
    	this.status = rvs;
    }
    
    /**
     * Gets the discount for the guest's total bill of the hotel stay upon checking-out.
     * @return the discount for the guest upon checking-out.
     */
    public double getDiscount() {
		return this.discount;
    }
    
    /**
     * A unique reservation code of six alpha-numeric characters will be generated and associated with the guest upon successful reservation. 
     */
    public void generateCode(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "0123456789" +
                "abcdefghijklmnopqrs";
        StringBuilder sb = new StringBuilder(12);

        for (int i = 0; i < 6; i++){
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        this.code = sb.toString();
    }

    /**
     * Gets the total payment for the guest's room charges. The total payment is calculated based on the number of weekdays and weekends and its associated weekday and weekend rates 
     * during the duration of the guest's hotel stay, depending on the type of room that the guest is staying in as well.
     */
    public double getPayment() {
        // counting the number of weekdays and weekends and add the rates accordingly
        LocalDate parsedCheckInDate = LocalDate.parse(this.checkInDate);
        LocalDate parsedCheckOutDate = LocalDate.parse(this.checkOutDate);
        
        for (LocalDate date = parsedCheckInDate; date.isBefore(parsedCheckOutDate); date = date.plusDays(1)){
            if (date.getDayOfWeek() == DayOfWeek.MONDAY || date.getDayOfWeek() == DayOfWeek.TUESDAY || date.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                    date.getDayOfWeek() == DayOfWeek.THURSDAY || date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                this.payment += room.weekdayRate;
            }
            else if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                this.payment += room.weekendRate;
            }
        }
        return this.payment;
    }
    
    /**
     * Displays the bill for the guest's room charges upon checking-out. The currency for the payment is in SGD. 
     */
    public void printBill() {
    	DecimalFormat df = new DecimalFormat("0.00");
    	System.out.println("The subtotal bill for your hotel stay is: SGD" + df.format(this.payment));
    }
    
    
    
    /**
     * Asks the guest for the mode of payment, either by cash or credit card.
     * @return the credit card number associated with the guest, if the guest indicates payment by credit card. Otherwise, the mode of payment is by cash.
     */
    public CreditCard useCreditCard() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Pay by Credit Card or Cash?");
        String reply = sc.nextLine();
        // verify user input
        if (reply.equals("Credit Card") || reply.equals("credit card")){
            return new CreditCard();
        }
		return null;
    }
}
