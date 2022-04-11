package Entities;
import Application.*;
import Databases.*;
import Externals.*;
public class Deluxe extends Room{

    public Deluxe (String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        super(roomNum,wifi,smoking,view);
        this.bedtype = BedType.MASTER;
        this.roomtype = RoomType.DELUXE;
        this.setWeekendRate(200.0);
        this.setWeekdayRate(150.0);
    }

}
