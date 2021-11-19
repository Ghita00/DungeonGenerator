package PKDungeon;

import Player.PG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Dungeon {
    /****************** Field *******************/
    //design pattern of singleton
    static private Dungeon instance;
    private final ArrayList<Room> rooms;

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
        PG.getInstage().setStay(rooms.get(next));
        rooms.get(old).setPresente(null);
        rooms.get(next).setPresente(PG.getInstage());
    }

    public void nextRoom(){
        int index = PG.getInstage().getStay().getID();
        System.out.println("dove vuoi andare?");
        Scanner input = new Scanner(System.in);
        int next = input.nextInt() - 1;
        if(rooms.get(index).getAnother_rooms().get(next) != null &&
            rooms.get(index).getAnother_rooms().get(next).getID() != -1){
            makeWalk(index, next);
        }else{
            nextRoom();
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
