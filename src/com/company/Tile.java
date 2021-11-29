package com.company;

public class Tile {
    private final Soft_Toy toy;
    private final int position;
    Tile(Soft_Toy toy, int position){
        this.toy = toy;
        this.position = position;
    }

    public Soft_Toy getToy() {
        return toy;
    }

    public int getPosition() {
        return position;
    }

    public Soft_Toy land(){
        System.out.println("You landed on tile " + position);
        return toy.clone();
    }
}
