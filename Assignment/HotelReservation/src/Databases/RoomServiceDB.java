package Databases;
import Application.*;
import Entities.*;
import Externals.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

import Entities.RoomService;

public class RoomServiceDB implements Serializable{
	private static final long serialVersionUID = 1L;

    private Hashtable<String, ArrayList<RoomService>> rsDB = new Hashtable<String, ArrayList<RoomService>>();
    public RoomServiceDB(){};

    public Boolean append(String reservationCode, RoomService roomService){
        ArrayList<RoomService> temp;
        if (getRsDB().containsKey(reservationCode)){
            temp = getRsDB().get(reservationCode);
            temp.add(roomService);
        }
        else{
            temp = new ArrayList<>();
            temp.add(roomService);
            getRsDB().put(reservationCode, temp);
        } 
        return true;
    }

    public void displayDB(){
        getRsDB().forEach((key, value)-> System.out.println(key + " = " + value));
    }
 
    public RoomService.RoomServiceStatus checkStatus(String reservationCode){
        if (!getRsDB().containsKey(reservationCode)){
            return null;
        }
        ArrayList<RoomService> cell = getRsDB().get(reservationCode);
        return cell.get(cell.size() - 1).getStatus();
    }
    
    public RoomService getRoomService(String reservationCode){
        if (!getRsDB().containsKey(reservationCode)){
            return null;
        }
        ArrayList<RoomService> cell = getRsDB().get(reservationCode);
        return cell.get(cell.size() - 1);
    }

	public Hashtable<String, ArrayList<RoomService>> getRsDB() {
		return rsDB;
	}

	public void setRsDB(Hashtable<String, ArrayList<RoomService>> rsDB) {
		this.rsDB = rsDB;
	}

}
