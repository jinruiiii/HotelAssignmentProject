package Assignment;

/**
 * 
 * @author joell
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class VIPSuite extends Room{
	
	/**
	 * Constructs an empty hotel room with a VIPSuite room type and a Master bed type.
	 * @param roomNum	the unique room number for this specific type of room.
	 * @param wifi		the availability of a Wifi feature for this specific type of room.
	 * @param smoking	the allowance of smoking in this specific type of room.
	 * @param view		the presence or absence of a balcony for this specific type of room.
	 */
    public VIPSuite (String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        super(roomNum,wifi,smoking,view);
        this.bedtype = BedType.MASTER;
        this.roomtype = RoomType.VIPSUITE;
        this.weekendRate = 250.0;
        this.weekdayRate = 200.0;
    }
}
