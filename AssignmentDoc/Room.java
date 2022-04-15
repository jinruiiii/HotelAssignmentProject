package Assignment;

import java.io.Serializable;

/**
 * Contains the details of each hotel room. 
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class Room implements Serializable{
	
	/**
	 * Contains the different types of bed in each type of hotel room.
	 */
    public enum BedType{
        SINGLE,DOUBLE,MASTER;
    }
    
    /**
     * Contains the different types of hotel rooms.
     */
    public enum RoomType{
        SINGLE, DOUBLE, DELUXE, VIPSUITE;
    }
    
    /**
     * Contains the different statuses of the hotel room. 
     */
    public enum RoomStatus{
        VACANT,OCCUPIED,RESERVED,MAINTENANCE;
    }

    protected BedType bedtype;
    protected RoomType roomtype;
    protected RoomStatus status = RoomStatus.VACANT;
    protected double weekendRate;
    protected double weekdayRate;
    private String roomNum;
    private Boolean wifi;
    private Boolean smoking;
    private Boolean view;

    /**
     * Constructs an empty hotel room with the required features that have been pre-determined when the hotel was first built. 
     * @param roomNum	the room number associated with the room.
     * @param wifi		the availability of a Wifi feature for the hotel room.
     * @param smoking	the allowance of smoking in this hotel room.
     * @param view		the presence or absence of a balcony for the hotel room.
     */
    public Room(String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        this.roomNum = roomNum;
        this.wifi = wifi;
        this.smoking = smoking;
        this.view = view;
    }
    
    /**
     * Gets the room status of the hotel room, particularly if the hotel room selected is vacant.
     * @return	the room status of the hotel room.
     */
    public RoomStatus checkAvail() {
        return this.status;
    }
    
    /**
     * Gets the room number of the associated room. For example, the room number could be 02-07.
     * @return the room number of the associated room.
     */
    public String getRoomNum(){
        return roomNum;
    }
    
    /**
     * Gets the hotel room type of the associated room. 
     * @return	the hotel room type of the associated room. 
     */
    public RoomType getRoomType(){
        return roomtype;
    }
    
    /**
     * Gets the Wifi feature of the hotel room, if installed in the hotel room.
     * @return true if the hotel room has Wifi.
     */
    public Boolean getWifi(){
        return wifi;
    }
    
    /**
     * Gets the permittance from the hotel for smoking in the hotel room, if the hotel allows smoking in the hotel room.
     * @return	true if the hotel permits smoking in the hotel room. 
     */
    public Boolean getSmoking(){
        return smoking;
    }
    
    /**
     * Gets the presence or absence of a balcony of the hotel room, if installed in the hotel room.
     * @return	true if the hotel room has a balcony.
     */
    public Boolean getView(){
        return view;
    }
    
    /**
     * Gets the room status of the hotel room, depending on whether the guest has reserved or checked-in to their room, or if the room is under maintenance
     * @return	the room status of the hotel room.
     */
    public RoomStatus getStatus(){
        return status;
    }
    
    /**
     * Sets the room status of the hotel room, depending on whether the guest has reserved or checked-in to their room, or if the room is under maintenance
     * @param rs	the room status of the hotel room.
     */
    public void setStatus(RoomStatus rs){
        status = rs;
    }

    
    /**
     * Sets the weekday rate for the hotel room. This rate should be lower than the weekend rate for the same hotel room type.
     * @param weekdayRate	the price of hotel stay for each night spent, depending on the hotel room type.
     */
    public void setWeekdayRate(double weekdayRate) {
    	this.weekdayRate  = weekdayRate;
    }
    
    /**
     * Sets the weekend rate for the hotel room. This rate should be higher than the weekday rate for the same hotel room type.
     * @param weekendRate	the price of hotel stay for each night spent, depending on the hotel room type.
     */
    public void setWeekendRate(double weekendRate) {
    	this.weekendRate  = weekendRate;
    }

}
