package Render;

import Creatures.PG;
import PKDungeon.Room;

public class RenderRoom {
    public static void Render(Room r){
        for(int i = 0; i < r.getSize_x(); i++){
            for(int j = 0; j < r.getSize_y(); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("\nconnect rooms");

        for(int i = 0; i < r.getAnother_rooms().size(); i++){
            if(r.getAnother_rooms().get(i) != null && r.getAnother_rooms().get(i).getID() != -1){
                System.out.println(i+1 +" - "+ r.getAnother_rooms().get(i).getName());
            }
        }

        System.out.println(PG.getInstage("0", 0, 0, 0, 0).toString());
        System.out.println();
    }
}
