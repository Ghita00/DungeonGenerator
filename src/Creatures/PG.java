package Creatures;

import Items.Item;
import PKDungeon.Dungeon;
import PKDungeon.MyExc;
import PKDungeon.Room;

import java.util.ArrayList;

public class PG extends Creature{
    static private PG instance = null;
    private Room stay;
    private ArrayList<Item> inventary;

    private PG(String s, int pv, int atk, int def, int vel){
        super(s, pv, atk, def, vel);
        inventary = new ArrayList<>();
        stay = Dungeon.getInstance().getRooms().get(0);
    }

    public static PG getInstage(String s, int pv, int atk, int def, int vel){
        if(instance == null){
            instance = new PG(s, pv, atk, def, vel);
        }
        return instance;
    }

    public void setStay(Room stay) {
        this.stay = stay;
    }

    public Room getStay() {
        return stay;
    }

    public void addItems(Item it) throws MyExc.MoreItems {
        if(inventary.size() < 3){
            inventary.add(it);
        }else{
            throw new MyExc.MoreItems();
        }
    }

    @Override
    public String toString() {
        String s = "[ ";
        for(int i = 0; i < inventary.size(); i++){
            if(inventary.size() != i+1)
                s += inventary.get(i).getName() + ", ";
            else{
                s += inventary.get(i).getName();
            }
        }
        return s+" ]";
    }
}
