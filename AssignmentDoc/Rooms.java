package Assignment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Contains all the details for every hotel room.
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class Rooms implements Serializable {
    protected Room[] rooms;
    
    /** 
     * number of rooms in the hotel
     */
    private int numRooms = 48;
    
    /**
     * Constructs 48 rooms for the entire hotel. Contains all the details of each individual room in the hotel, such as the room number, room type, Wifi, smoking and view.
     */
    Rooms(){
        rooms = new Room[numRooms];
    }
    
    /**
     * Creating a room among the 48 rooms, containing details such as room number, room type, Wifi, smoking and view.
     * @param num		the index of the room number unique to a particular hotel room.
     * @param roomNum	the room number unique to a particular hotel room.
     * @param roomType	the type of hotel room: <code>SINGLE</code>, <code>DOUBLE</code>, <code>DELUXE</code>, <code>VIPSUITE</code>.
     * @param wifi		the availability of a Wifi feature for the hotel room.
     * @param smoking	the allowance of smoking in this hotel room.
     * @param view		the presence or absence of a balcony for the hotel room.
     */
    public void addRoom(int num, String roomNum, String roomType, Boolean wifi, Boolean smoking, Boolean view){
        switch(roomType){
            case "SingleRoom":
                rooms[num - 1] = new SingleRoom(roomNum, wifi, smoking, view);
                break;
            case "DoubleRoom":
                rooms[num - 1] = new DoubleRoom(roomNum, wifi, smoking, view);
                break;
            case "Deluxe":
                rooms[num - 1] = new Deluxe(roomNum, wifi, smoking, view);
                break;
            case "VIPSuite":
                rooms[num - 1] = new VIPSuite(roomNum, wifi, smoking, view);
                break;

        }
    }

    /**
     * Displays all the rooms in the hotel by their room number, room type, Wifi, smoking and view.
     */
    public void displayRooms(){
        System.out.println("Room Number, Room Type, Wifi, Smoking, View");
        for (int i = 0; i < 48; i++){
            System.out.printf("%d, %s, %b, %b, %b", rooms[i].getRoomNum(), rooms[i].getRoomType(), rooms[i].getWifi(), rooms[i].getSmoking(), rooms[i].getView());
            System.out.println();
        }
    }
    
    /**
     * Gets the particular room with its associated room number.
     * @param roomNum	the index of the room number unique to a particular hotel room.
     * @return			the room with its associated room number.
     */
    public Room getRoom(int roomNum){
        return rooms[roomNum - 1];
    }
    
    /**
     * Displays all the rooms that are vacant, ordered by their room type: <code>SINGLE</code>, <code>DOUBLE</code>, <code>DELUXE</code>, <code>VIPSUITE</code>.
     * @param rt	the room type of each individual room.
     * @return		a list of rooms that are vacant.
     */
    public ArrayList<String> printVacantRoomsByType(Room.RoomType rt){
        ArrayList<String> roomNums = new ArrayList<String>();
        double totalVacant = 0;
        double total = 0;
        for (int i = 0; i < 48; i++){
            if (rooms[i].getRoomType() == rt){
                total += 1;
                if (rooms[i].getStatus() == Room.RoomStatus.valueOf("VACANT")){
                    roomNums.add(formatRoomNum(i));
                    totalVacant += 1;
                }
            }
        }
        double vacancyRate = totalVacant/total;
        System.out.printf("| %s Room | ", rt.toString());
        for (int i = 0; i < roomNums.size(); i++){
            System.out.printf("%s ", roomNums.get(i));
        }
        System.out.printf("| Vacancy Rate | %.2f |\n", vacancyRate);
        return roomNums;
    }
    
    /**
     * Displays all the rooms that are vacant and their room details, ordered by their room type: <code>SINGLE</code>, <code>DOUBLE</code>, <code>DELUXE</code>, <code>VIPSUITE</code>.
     * Room details include room number, Wifi, smoking and view.
     * @param rt	the room type of each individual room.
     * @return		a list of rooms that are vacant, with their room details.
     */
    public ArrayList<String> printVacantRoomWithInfo(Room.RoomType rt){
        ArrayList<String> toReturn = printVacantRoomsByType(rt);
        System.out.println();
        String format = "%-20s%-20s%-20s%-20s%n";
        System.out.printf(format, "Room Number", "WIFI", "Smoking", "View");
        System.out.printf(format, "================", "==================", "==================", "==================");
        Room room;
        for (int i = 0; i < toReturn.size(); i++){
            room = rooms[deformatRoomNum(toReturn.get(i)) - 1];
            System.out.printf(format, toReturn.get(i), room.getWifi(),  room.getSmoking(),  room.getView());
        }
        return toReturn;
    }
    
    /**
     * Displays all the rooms that are vacant, ordered by their room type: <code>SINGLE</code>, <code>DOUBLE</code>, <code>DELUXE</code>, <code>VIPSUITE</code>.
     */
    public void printVacantRooms(){
        printVacantRoomsByType(Room.RoomType.valueOf("SINGLE"));
        printVacantRoomsByType(Room.RoomType.valueOf("DOUBLE"));
        printVacantRoomsByType(Room.RoomType.valueOf("DELUXE"));
        printVacantRoomsByType(Room.RoomType.valueOf("VIPSUITE"));
    }
    
    /**
     * A helper function that enables the method printRoomsByStatusMain to display all the rooms in order of their statuses.
     * @param rs	the room status of each individual room.
     */
    private void printRoomsByStatusSub(Room.RoomStatus rs){
        ArrayList<String> roomNums = new ArrayList<String>();
        for (int i = 0; i < 48; i++){
            if (rooms[i].getStatus() == rs){
                roomNums.add(formatRoomNum(i));
            }
        }
        System.out.printf("| %s |", rs.toString());
        if (roomNums.size() == 0){
            System.out.println();
            return;
        }
        for (int i = 0; i < roomNums.size(); i++){
            System.out.printf("%s ", roomNums.get(i));
        }
        System.out.println("|");
    }
    
    /**
     * 	Displays all the rooms in order of their statuses: <code>VACANT</code>, <code>RESERVED</code>, <code>OCCUPIED</code>, <code>MAINTENANCE</code>.
     */
    public void printRoomsByStatusMain(){
        printRoomsByStatusSub(Room.RoomStatus.valueOf("VACANT"));
        printRoomsByStatusSub(Room.RoomStatus.valueOf("RESERVED"));
        printRoomsByStatusSub(Room.RoomStatus.valueOf("OCCUPIED"));
        printRoomsByStatusSub(Room.RoomStatus.valueOf("MAINTENANCE"));
    }
    
    /**
     * Formatting the given hotel room number into a string.
     * @param roomNum	the room number stored as an integer.
     * @return			a string containing the given hotel room number.
     */
    public String formatRoomNum(int roomNum){
        return "0" + Integer.toString(roomNum/8 + 1) + "0" + Integer.toString(roomNum%8 + 1);
    }
    
    /**
     * Formatting the given hotel room number into an integer.
     * @param roomNum	the room number stored as a string.
     * @return			an integer containing the given hotel room number.
     */
    public int deformatRoomNum(String roomNum){
        return ((Character.getNumericValue(roomNum.charAt(1)) - 1) * 8) + (Character.getNumericValue(roomNum.charAt(3)));
    }

}
