package Creatures;

public class Creature {
    private String name;
    private int pv;
    private int atk;
    private int def;
    private int vel;

    public Creature(String s, int pv, int atk, int def, int vel){
        this.name = s;
        this.pv = 10;
        this.atk = 5;
        this.def = 5;
        this.vel = 3;
    }

    public String getName() {
        return name;
    }

    public int getPv() {
        return pv;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getVel() {
        return vel;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }
}
