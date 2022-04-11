package Assignment;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter; 

/**
 * 
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class RoomService implements Payment, Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Contains the status of each room service order made.
	 */
    public enum RoomServiceStatus{
        CONFIRMED,
        PREPARING,
        DELIVERED,
    }

    protected RoomServiceStatus roomServiceStatus;
    private LocalDate date;
    private LocalTime time;
    private LocalDateTime orderDateandTime;
    private LocalDateTime pendingDateandTime;
    private LocalDateTime deliveredDateandTime;
    private String remarks = null;
    private Menu menu;
    private String name;
    private double payment;
    
    /**
     * Constructs an empty room service order for each current residing guest that has checked-in to the hotel. If the guest has checked-out of the hotel, the room service order will also be deleted.
     * Each room service order includes a menu of items that the guest can order from during their stay in the hotel. 
     * A guest can make multiple room service orders. 
     * @param menu	the menu that contains different choices of food items or drinks.
     */
    public RoomService(Menu menu) {
        this.menu = menu;
    }
    
    /**
     * Sets the date and time for the room service order created. 
     * @param date	 the date the room service order was created.
     * @param time	 the time the room service order was created.
     */
	public void setDateTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }
	
	/**
	 * Sets the remarks for each room service order created. 
	 * @param remarks	the additional request(s) that the guest makes for their room service order
	 */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    /**
     * Gets the date and time the moment the room service order was created.
     * @return	the date and time the momemt the room service order was created.
     */
    public LocalDateTime getOrderDateandTime() {
		return orderDateandTime;
	}
    
    /**
     * Gets the date and time for the room service order being prepared.
     * @return	the date and time for the room service order being prepared.
     */
	public LocalDateTime getPendingDateandTime() {
		return pendingDateandTime;
	}
	
	/**
	 * Gets the date and time for the room service order when delivered to the guest.
	 * @return	the date and time for the room service order when delivered to the guest.
	 */
	public LocalDateTime getDeliveredDateandTime() {
		return deliveredDateandTime;
	}
	
	/**
	 * Gets the status for each room service order created, depending from the time the order was created to the time the food or drinks are being prepared in the kitchen 
	 * to the time they are delivered to the guest.
	 * @return the status for each room service order created.
	 */
    public RoomServiceStatus getStatus(){
        return roomServiceStatus;
    }
	
	/**
	 * Sets the status for each room service order created, depending from the time the order was created to the time the food or drinks are being prepared in the kitchen 
	 * to the time they are delivered to the guest.
	 * @param roomServiceStatus	the status for each room service order created.
	 */
	public void setRoomServiceStatus(RoomServiceStatus roomServiceStatus) {
		this.roomServiceStatus = roomServiceStatus;
	}

    /**
     * Creates the room service order and takes into account the time that the room service order was created to the time that the food or drinks are being prepared 
     * to the time they are delivered to the guest.
     * @param foodName	the name of the food in the menu. 
     * @param dt		the date the room service order was created.
     * @return true 	if the room service order was created successfully
     */
    public boolean order(String foodName, Date dt) {
    	System.out.println("The time is " + dt);
    	
    	// Set Confirmation Time at Current Time
    	this.orderDateandTime = dt.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
    	
    	// Set Pending Time at 15 Minutes After Confirmation Time
    	Calendar c = Calendar.getInstance();
    	c.setTime(dt);
        c.add(Calendar.MINUTE, 15);
        dt = c.getTime();
        this.pendingDateandTime = dt.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        
        // Set Delivery Time at 60 Minutes After Confirmation Time
    	c = Calendar.getInstance();
    	c.setTime(dt);
        c.add(Calendar.MINUTE, 45);
        dt = c.getTime();
        this.deliveredDateandTime = dt.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    	
//    	System.out.println("The confirmation Date and Time is " + this.orderDateandTime);
//    	System.out.println("The pending Date and Time is " + this.pendingDateandTime);
//    	System.out.println("The delivered Date and Time is " + this.deliveredDateandTime);
    	
    	
        for (int i=0; i<menu.foods.size();i++) {
            if (foodName.equals(menu.foods.get(i).getName())) {
            	this.name = foodName;
                this.payment = menu.foods.get(i).getPrice();
                this.roomServiceStatus = RoomServiceStatus.CONFIRMED;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the total payment for the room service order. The bill increases every time a new item is added to the same room service order.
     */
    public double getPayment() {
    	return this.payment;
    }
    
    /**
     * Displays the total payment for the room service order, billed to the guest staying in the hotel room where the room service was requested.
     */
    public void printBill() {
    	String format = "%-20s%-20s%-20s%-20s%-20s%n";
    	DecimalFormat df = new DecimalFormat("0.00");
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("kk:mm:ss");
        System.out.printf(format, this.date, this.name, this.time.format(formatter), "SGD" + df.format(this.payment), this.remarks);
    }
}
