package Render;

import PKDungeon.Dungeon;
import PKDungeon.Room;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;

public class AllMap {
    /*
    ASCII art grafic ideaù
    must be instance when in main make <Dungeon>.addStart()
    *******
    *r = x* *******
    *c = y* ******* ...
    *******
    */
    private char[][] mymatrix;

    public AllMap(){
        int Xlen = MaxHeightDungeon();
        int Ylen ;
    }

    static int MaxHeightDungeon(){
        int max = 0;
        int count = 0;
        ArrayList<Room> AllRoom = Dungeon.getInstance().getRooms();
        for(int i = 0; i < AllRoom.size(); i++){
            count++;
            Room sopra = AllRoom.get(i).getAnother_rooms().get(0);
            Room sotto = AllRoom.get(i).getAnother_rooms().get(2);
            while(sopra != null){
                count++;
                sopra = AllRoom.get(i).getAnother_rooms().get(0);
            }
            while(sotto != null){
                count++;
                sotto = AllRoom.get(i).getAnother_rooms().get(0);
            }
            if(max < count)
                max = count;
        }
        return max;
    }

}





