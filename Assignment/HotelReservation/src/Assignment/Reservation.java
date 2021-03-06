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

public class Reservation implements Payment, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum ReservationStatus{
		WAITLIST,CONFIRMED,CHECKED_IN,EXPIRED;
	}
	
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

    public Reservation(Guest guest, int walkIn, Date dt){
    	    	//Exception Handling for all the dates inputed
        this.guest = guest;
    	Scanner sc = new Scanner(System.in);

    	String pattern = "yyyy-MM-dd";
    	DateFormat df = new SimpleDateFormat(pattern);
    	Date today = dt;        
    	String todayAsString = df.format(today);
         
        if(walkIn == 1) { 
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        	String strDate = dateFormat.format(dt);  
        	this.checkInDate = todayAsString;
        }
        else {
            System.out.println("Input check in date (YYYY-MM-DD)");
            String dateCheckin = sc.nextLine();
        	this.checkInDate = CheckDate.getInput(dateCheckin);        	
        }
        
        
        
        System.out.println("Input check out date (YYYY-MM-DD)");
        String dateCheckOut = sc.nextLine();
        this.checkOutDate = CheckDate.getInput(dateCheckOut);
        
      //Exception Handling for all number of children and adult inputed
        System.out.println("Input number of adults");
        String numAdults = sc.nextLine();
        this.adults = CheckIfInt.getInput(numAdults,"adults");
        
        System.out.println("Input number of children");
        String numChildren = sc.nextLine();
        this.children = CheckIfInt.getInput(numChildren,"children");
    }

    public String getReservationCode() {
        return code;
    }

    public Room getRoom(){
        return room;
    }

    public Guest getGuest(){
        return guest;
    }

    public String getCheckInDate(){
        return checkInDate;
    }

    public String getCheckOutDate(){
        return checkOutDate;
    }

    public int getAdults(){
        return adults;
    }

    public int getChildren(){
        return children;
    }

    public String getCode(){
        return code;
    }
	
    public double getDiscount(){
	    return discount;
    }
    
    
    public ReservationStatus getStatus() {
    	return status;
    }

    public void generateCode(){
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "0123456789" +
                "abcdefghijklmnopqrs";
        StringBuilder sb = new StringBuilder(12);

        for (int i = 0; i < 6; i++){
            int index = (int)(alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        this.code = sb.toString();
    }
    
    public void setStatus(ReservationStatus rvs) {
    	this.status = rvs;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChildren(int children) {
        this.children = children;
    }

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
    
    public void printBill() {
    	DecimalFormat df = new DecimalFormat("0.00");
    	System.out.println("The subtotal bill for your hotel stay is: SGD" + df.format(this.payment));
    }
    
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
