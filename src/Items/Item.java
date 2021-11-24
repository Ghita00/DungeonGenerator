package Items;

import Utility.Pair;

public class Item {
    /****************** Field *******************/
    private String name;
    private int number;
    private Pair<Pair, Pair> buffNerf;

    public Item(String name){
        this.name = name;
        buffNerf = new Pair(new Pair<>("atk", +1), new Pair<>("vel", -1));
    }

    public String getName() {
        return name;
    }


}