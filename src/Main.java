import PKDungeon.MyExc;
import PKDungeon.Room;
import Player.PG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws MyExc.MoreRoom, MyExc.EmptyString, MyExc.OtherRoom {
        Room r1 = new Room(7,6);
        Room r2 = new Room(4, 3);
        Collection<Room> allRooms = new ArrayList<>();


        Collections.addAll(allRooms, r1, r2);
        Game r = new Game(allRooms, new PG());
        r.startGame();
    }
}
