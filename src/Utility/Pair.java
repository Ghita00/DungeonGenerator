package Utility;

public class Pair<E, T>{
    E first;
    T second;

    public Pair(E first, T second){
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}

