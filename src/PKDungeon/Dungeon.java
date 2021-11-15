package PKDungeon;

import Player.PG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Dungeon {
    //design pattern of singleton
    static private Dungeon instance;
    private ArrayList<Room> rooms;

    private Dungeon(){
        rooms = new ArrayList<>();
    }

    private Dungeon(Collection<Room> add){
        rooms = new ArrayList<>();
        Iterator<Room> i = add.iterator();
        while(i.hasNext()){
            rooms.add(i.next());
        }
    }

    static public Dungeon getInstance(){
        if(instance == null){
            instance = new Dungeon();
        }
        return instance;
    }

    public Dungeon getInstance(Collection<Room> add){
        if(instance == null){
            instance = new Dungeon(add);
        }
        return instance;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room r){
        rooms.add(r);
    }

    public void setPG(PG p){
        rooms.get(0).setPresente(p);
    }
}
