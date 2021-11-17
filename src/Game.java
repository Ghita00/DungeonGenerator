import PKDungeon.Dungeon;
import PKDungeon.Room;
import Player.PG;
import Render.RenderRoom;

import java.util.Collection;

public class Game {
    Dungeon MyDun;

    public Game(Collection<Room> allRoom, PG player){
        Dungeon.getInstanceCollection(allRoom);
    }

    public void startGame(){
        RenderRoom.Render(Dungeon.getInstance().getRooms().get(1));
    }
}
