package Assignment;

/**
 * 
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class SingleRoom extends Room{
	
	/**
	 * Constructs an empty hotel room with a SingleRoom room type and a single bed type.
	 * @param roomNum	the unique room number for this specific type of room.
	 * @param wifi		the availability of a Wifi feature for this specific type of room.
	 * @param smoking	the allowance of smoking in this specific type of room.
	 * @param view		the presence or absence of a balcony for this specific type of room.
	 */
    public SingleRoom(String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        super(roomNum,wifi,smoking,view);
        this.bedtype = BedType.SINGLE;
        this.roomtype = RoomType.SINGLE;
        this.weekendRate = 100.0;
        this.weekdayRate = 50.0;
    }
}
