package Player;

import PKDungeon.Dungeon;
import PKDungeon.Room;

public class PG {
    static private PG instance = null;
    private final String name;
    private Room stay;

    private PG(){
        name = "TOM";
        stay = Dungeon.getInstance().getRooms().get(0);
    }

    public static PG getInstage(){
        if(instance == null){
            instance = new PG();
        }
        return instance;
    }

    public void setStay(Room stay) {
        this.stay = stay;
    }

    public Room getStay() {
        return stay;
    }
}
