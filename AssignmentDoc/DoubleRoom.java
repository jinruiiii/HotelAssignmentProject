package Assignment;

/**
 * Contains the details of a double room.
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class DoubleRoom extends Room{

	/**
	 * Constructs an empty hotel <code>Room</code> with a <code>DoubleRoom</code> room type and a Double bed type.
	 * @param roomNum	the unique room number for this specific type of <code>Room</code>
	 * @param wifi		the availability of a Wifi feature for this specific type of <code>Room</code>
	 * @param smoking	the allowance of smoking in this specific type of <code>Room</code>
	 * @param view		the presence or absence of a balcony for this specific type of <code>Room</code>
	 */
    public DoubleRoom (String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        super(roomNum,wifi,smoking,view);
        this.bedtype = BedType.DOUBLE;
        this.roomtype = RoomType.DOUBLE;
        this.weekendRate = 150.0;
        this.weekdayRate = 100.0;

    }
}
