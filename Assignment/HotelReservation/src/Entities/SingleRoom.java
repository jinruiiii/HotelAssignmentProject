package Entities;
import Application.*;
import Databases.*;
import Externals.*;
public class SingleRoom extends Room{

    public SingleRoom(String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        super(roomNum,wifi,smoking,view);
        this.bedtype = BedType.SINGLE;
        this.roomtype = RoomType.SINGLE;
        this.setWeekendRate(100.0);
        this.setWeekdayRate(50.0);
    }
}
