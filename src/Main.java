import PKDungeon.Dungeon;
import PKDungeon.MyExc.MoreRoom;
import PKDungeon.MyExc;
import PKDungeon.Room;
import Player.PG;
import Render.RenderRoom;

import java.util.Collections;

public class Main {
    public static void main(String[] args) throws MyExc.MoreRoom, MyExc.EmptyString, MyExc.OtherRoom {
        Dungeon MyDun = Dungeon.getInstance();
        Room r1 = new Room(7,6);
        Room r2 = new Room(4, 3);

        Collections.addAll(MyDun.getRooms(), r1, r2);
        r1.Union(r2);
        //r2.Union(r1);

        MyDun.setPG(new PG());
        RenderRoom.Render(MyDun.getRooms().get(1));
    }
}
