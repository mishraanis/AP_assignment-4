package com.company;

public class Soft_Toy implements Cloneable{
    private final String name;

    public Soft_Toy(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Soft_Toy clone(){
        try{
            return (Soft_Toy) super.clone();
        }catch(CloneNotSupportedException e){
            System.out.println("Clone not supported");
            return null;
        }
    }
}
