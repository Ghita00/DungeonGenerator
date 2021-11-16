package PKDungeon;

import Player.PG;

import java.util.ArrayList;
import java.util.Collection;

public class Room implements Comparable<Room>{
    /****************** Field *******************/
    //that is aux
    private static int seed = 0;

    //they are the true field
    private final int ID;
    private boolean start;
    private String name;
    private final int size_x;
    private final int size_y;
    private Collection<Item> items;
    private ArrayList<Room> another_rooms;
    private PG presente = null;

    /****************** Costructor *******************/
    public Room(int y, int x){
        name = "stanza-" + seed;
        ID = ++seed;
        size_y = y;
        size_x = x;
        items = new ArrayList<>();
        another_rooms = new ArrayList<>();
        SetFirst();
    }

    public Room(int y, int x, String name){
        ID = ++seed;
        this.name = name;
        size_y = y;
        size_x = x;
        items = new ArrayList<>();
        another_rooms = new ArrayList<>();
        SetFirst();
    }

    public Room(int y, int x, ArrayList<Room> rooms) throws MyExc.MoreRoom {
        name = "stanza-" + seed;
        ID = ++seed;
        size_y = y;
        size_x = x;
        items = new ArrayList<>();

        if(rooms.size() <= 4){
            another_rooms = new ArrayList<>();
            another_rooms.addAll(rooms);
            SetFirst();
        }else{
            throw new MyExc.MoreRoom();
        }
    }

    public Room(int y, int x, String name, ArrayList<Room> rooms) throws MyExc.MoreRoom {
        ID = ++seed;
        this.name = name;
        size_y = y;
        size_x = x;
        items = new ArrayList<>();

        if(rooms.size() <= 4){
            another_rooms = new ArrayList<>();
            another_rooms.addAll(rooms);
            SetFirst();
        }else{
            throw new MyExc.MoreRoom();
        }
    }

    /****************** Method *******************/
    private void SetFirst(){
        if(ID == 1){
            this.start = true;
            this.another_rooms.add(null);
        }else{
            this.start = false;
        }
    }

    public void Rename(String s) throws MyExc.EmptyString {
        if(s.length() <= 0){
            throw new MyExc.EmptyString();
        }else{
            this.name = s;
        }
    }

    private boolean Search(Room r){
        ArrayList<Room> rooms = Dungeon.getInstance().getRooms();
        boolean search_this = false;
        boolean search_r = false;
        int i = 0;
        int j = 0;

        while (i < rooms.size() && !search_this){
            search_this = this.equals(rooms.get(i));
            i++;
        }

        while (j < rooms.size() && !search_r){
            search_r = r.equals(rooms.get(j));
            j++;
        }

        return search_r && search_this;
    }

    private boolean Brige(Room r){
        int i = 0;
        boolean search_room = false;
        while(i < this.another_rooms.size() && !search_room){
            search_room = r.equals(this.another_rooms.get(i));
            i++;
        }
        return search_room;
    }

    public void Union(Room r) throws MyExc.MoreRoom, MyExc.OtherRoom{
        if(Search(r) && !Brige(r)){
            MakeUnion(r);
        }else{
            throw new MyExc.OtherRoom();
        }
    }

    private void MakeUnion(Room r) throws MyExc.MoreRoom {
        if(this.another_rooms.size() < 4 && r.another_rooms.size() < 4){
            this.another_rooms.add(r);
            r.another_rooms.add(this);
        }else{
            throw new MyExc.MoreRoom();
        }
    }
    
    /****************** Getter *******************/
    public void setPresente(PG p){
        this.presente = p;
    }

    public int getSize_x() {
        return size_x;
    }

    public int getSize_y() {
        return size_y;
    }

    public ArrayList<Room> getAnother_rooms() {
        return another_rooms;
    }

    public String getName() {
        return name;
    }

    /****************** For compare  *******************/
    @Override
    public int compareTo(Room o) {
        int n1 = (this.size_x + this.size_y);
        int n2 = (o.size_x + o.size_y);
        return  n1 > n2 ? n1 : 1 < n2 ? -1 : 0;
    }

}