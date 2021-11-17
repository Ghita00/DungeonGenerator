import PKDungeon.Dungeon;
import PKDungeon.Room;
import Player.PG;
import Render.RenderRoom;

import java.util.Collection;

public class Game {
    public Game(Collection<Room> allRoom, PG player){
        Dungeon.getInstanceCollection(allRoom);
        Dungeon.getInstance().getRooms().get(0).setPresente(player);
    }

    public void startGame(){
        RenderRoom.Render(Dungeon.getInstance().getRooms().get(1));
    }
}
