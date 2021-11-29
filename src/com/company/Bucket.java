package com.company;

import java.util.ArrayList;

public class Bucket {
    ArrayList<Soft_Toy> soft_toys;
    Bucket(){
        soft_toys = new ArrayList<>();
    }

    void add_toys(Soft_Toy toy){
        soft_toys.add(toy);
    }
    void print_toys(){
        for(Soft_Toy toy: soft_toys){
            System.out.print(toy.getName() + " ");
        }
    }
    public ArrayList<Soft_Toy> getSoft_toys() {
        return soft_toys;
    }
}
