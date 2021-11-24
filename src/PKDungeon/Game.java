package PKDungeon;

import Creatures.PG;
import Render.RenderRoom;
import java.util.Collection;

public class Game {
    public Game(Collection<Room> allRoom){
        Dungeon.getInstanceCollection(allRoom);
    }

    //TODO costruttore che prende int n e genera Dungeon random di n stanze
    public Game(int n){
        for(int i = 0; i < n; i++){
            Dungeon.getInstance().addRoom(Room.RandomRoom());
        }
    }

    private boolean finish(){
        return PG.getInstage("0", 0, 0, 0, 0).getStay().getID() == Room.getSeed();
    }

    public void startGame(){
        Dungeon.getInstance().getRooms().get(0).setPresente(PG.getInstage("0", 0, 0, 0, 03));
        while(!finish()){
            int index = PG.getInstage("0", 0, 0, 0, 0).getStay().getID();
            RenderRoom.Render(Dungeon.getInstance().getRooms().get(index));
            Dungeon.getInstance().nextRoom();
        }
    }
}
