package Render;

import PKDungeon.Room;

public class RenderRoom {
    public static void Render(Room r){
        for(int i = 0; i < r.getSize_x(); i++){
            for(int j = 0; j < r.getSize_y(); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("\n+stanze connesse");
        for(int i = 0; i < r.getAnother_rooms().size(); i++){
            System.out.println(i+1 +"-"+ r.getAnother_rooms().get(i).getStart());
        }
    }
}
