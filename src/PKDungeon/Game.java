package PKDungeon;

import PKDungeon.Dungeon;
import PKDungeon.Room;
import Player.PG;
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
        return PG.getInstage().getStay().getID() == Room.getSeed();
    }

    public void startGame(){
        //System.out.println(Dungeon.getInstance().getRooms().size());
        Dungeon.getInstance().getRooms().get(1).setPresente(PG.getInstage());
        //while(!finish()){
            int index = PG.getInstage().getStay().getID();
            RenderRoom.Render(Dungeon.getInstance().getRooms().get(index));
            Dungeon.getInstance().nextRoom();
        //}
    }
}
