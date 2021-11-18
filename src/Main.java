import PKDungeon.Dungeon;
import PKDungeon.Game;
import PKDungeon.MyExc;
import PKDungeon.Room;
import Player.PG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Room r1 = new Room(2,2);
        Room r2 = new Room(1, 1);
        Room r3 = new Room(7,6);
        Room r4 = new Room(4, 3);
        Room r5 = new Room(7,6);
        Room r6 = new Room(4, 3);

        //Union the room
        ArrayList<Room> Near_r1 = new ArrayList<>();
        Collections.addAll(Near_r1, r2, r3, r4);
        r1.setAnother_rooms(Near_r1);
        for (Room room : Near_r1) {
            room.getAnother_rooms().add(r1);
        }

        Collection<Room> allRooms = new ArrayList<>();
        Collections.addAll(allRooms, r1, r2, r3, r4, r5, r6);
        Game r = new Game(allRooms);

        r.startGame();
    }
}
