package Entities;
import Application.*;
import Databases.*;
import Externals.*;
public class DoubleRoom extends Room{


    public DoubleRoom (String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        super(roomNum,wifi,smoking,view);
        this.bedtype = BedType.DOUBLE;
        this.roomtype = RoomType.DOUBLE;
        this.setWeekendRate(150.0);
        this.setWeekdayRate(100.0);

    }
}
