package Entities;
import Application.*;
import Databases.*;
import Externals.*;
public class VIPSuite extends Room{

    public VIPSuite (String roomNum, Boolean wifi, Boolean smoking, Boolean view) {

        super(roomNum,wifi,smoking,view);
        this.bedtype = BedType.MASTER;
        this.roomtype = RoomType.VIPSUITE;
        this.setWeekendRate(250.0);
        this.setWeekdayRate(200.0);
    }
}
