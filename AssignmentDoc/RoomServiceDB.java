package Assignment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * 
 * @author joell
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class RoomServiceDB {
    Hashtable<String, ArrayList<RoomService>> rsDB = new Hashtable<String, ArrayList<RoomService>>();
    
    /**
     * Constructs an empty room service database that contains all the room service orders requested by each residing guest. A guest can make multiple room service orders.
     * However, these room service orders will be stored in the room service database and accessed via the guest's unique reservation code. 
     */
    RoomServiceDB(){};

    /**
     * Creates a new room service order requested by the guest and adds it to the guest's list of room service orders via their reservation code.
     * @param reservationCode	the reservation code required to store the new room service order unique to the guest in the room service database.
     * @param roomService		the room service order created by the guest.
     * @return true if the reservation code was found and the room service order was successfully added to the room service database.
     */
    public Boolean append(String reservationCode, RoomService roomService){
        ArrayList<RoomService> temp;
        if (rsDB.containsKey(reservationCode)){
            temp = rsDB.get(reservationCode);
            temp.add(roomService);
        }
        else{
            temp = new ArrayList<>();
            temp.add(roomService);
            rsDB.put(reservationCode, temp);
        }
        return true;
    }
    
    /**
     * Displays all the room service orders in the room service database.
     */
    public void displayDB(){
        rsDB.forEach((key, value)-> System.out.println(key + " = " + value));
    }
    
    /**
     * Checks the status of the room service order using a reservation code. 
     * @param reservationCode	the reservation code required to check the status of the room service order.
     * @return 					the status of the room service order.
     */
    public RoomService.RoomServiceStatus checkStatus(String reservationCode){
        if (!rsDB.containsKey(reservationCode)){
            return null;
        }
        ArrayList<RoomService> cell = rsDB.get(reservationCode);
        return cell.get(cell.size() - 1).getStatus();
    }
    
    /**
     * Gets the room service order using a reservation code.
     * @param reservationCode	the reservation code required to get the room service order.
     * @return					the room service order.
     */
    public RoomService getRoomService(String reservationCode){
        if (!rsDB.containsKey(reservationCode)){
            return null;
        }
        ArrayList<RoomService> cell = rsDB.get(reservationCode);
        return cell.get(cell.size() - 1);
    }

}
