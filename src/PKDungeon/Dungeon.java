package PKDungeon;

import Player.PG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Dungeon {
    /****************** Field *******************/
    //design pattern of singleton
    static private Dungeon instance;
    private ArrayList<Room> rooms;

    /****************** Costructor *******************/
    private Dungeon(){
        rooms = new ArrayList<>();
    }

    private Dungeon(Collection<Room> add){
        rooms = new ArrayList<>();
        rooms.addAll(add);
    }

    static public Dungeon getInstance(){
        if(instance == null){
            instance = new Dungeon();
        }
        return instance;
    }

    static public Dungeon getInstanceCollection(Collection<Room> add){
        if(instance == null){
            instance = new Dungeon(add);
        }
        return instance;
    }

    /****************** Method *******************/
    public void addRoom(Room r){
        rooms.add(r);
    }

    private void makeWalk(int old, int next){
        PG present = rooms.get(old).getPresente();
        rooms.get(old).setPresente(null);
        rooms.get(next).setPresente(present);
    }

    public void nextRoom(){
        Room r = null;
        int i = 0;
        int inputNum = -1;
        boolean trovata = false;

        while(i < rooms.size() && !trovata){
            trovata = rooms.get(i).getPresente() != null;
            r = rooms.get(i);
        }

        /*TODO lettura da input con inputNum*/

        if(inputNum > 0 && inputNum <= 4 && r.getAnother_rooms().get(inputNum) != null){
            makeWalk(i, inputNum-1);
        }
    }


    /****************** Setter *******************/
    public void setPG(PG p){
        rooms.get(0).setPresente(p);
    }

    /****************** Getter *******************/
    public Dungeon getInstance(Collection<Room> add){
        if(instance == null){
            instance = new Dungeon(add);
        }
        return instance;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }


}
