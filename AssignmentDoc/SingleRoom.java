package Assignment;

/**
 * 
 * @author joell
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class SingleRoom extends Room{
	
	/**
	 * Constructs an empty hotel <code>Room</code> with a <code>SingleRoom</code> room type and a Single bed type.
	 * @param roomNum	the unique room number for this specific type of <code>Room</code>
	 * @param wifi		the availability of a Wifi feature for this specific type of <code>Room</code>
	 * @param smoking	the allowance of smoking in this specific type of <code>Room</code>
	 * @param view		the presence or absence of a balcony for this specific type of <code>Room</code>
	 */
    public SingleRoom(String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        super(roomNum,wifi,smoking,view);
        this.bedtype = BedType.SINGLE;
        this.roomtype = RoomType.SINGLE;
        this.weekendRate = 100.0;
        this.weekdayRate = 50.0;
    }
}
