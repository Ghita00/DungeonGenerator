import PKDungeon.Dungeon;
import PKDungeon.MyExc.Moreroom;
import PKDungeon.MyExc;
import PKDungeon.Room;
import Player.PG;
import Render.RenderRoom;

import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws MyExc.Moreroom, MyExc.EmptyString {
        Dungeon MyDun = Dungeon.getInstance();
        Room r1 = new Room(7,6);
        Room r2 = new Room(4, 3);
        Collections.addAll(MyDun.getRooms(), r1, r2);
        r1.Union(r2);
        r1.Rename("pippo");

        //MyDun.setPG(new PG());
        RenderRoom.Render(MyDun.getRooms().get(1));
    }
}
