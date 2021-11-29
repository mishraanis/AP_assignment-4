package com.company;

public class Carpet {
    Tile tiles[];
    Carpet(){
        tiles = new Tile[20];
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public void Initialise(){
        tiles[0] = new Tile(new Soft_Toy("Caramel"), 1);
        tiles[1] = new Tile(new Soft_Toy("Cherry"), 2);
        tiles[2] = new Tile(new Soft_Toy("Choco"), 3);
        tiles[3] = new Tile(new Soft_Toy("Honey"), 4);
        tiles[4] = new Tile(new Soft_Toy("Oscar"), 5);
        tiles[5] = new Tile(new Soft_Toy("Teddy"), 6);
        tiles[6] = new Tile(new Soft_Toy("Nancy"), 7);
        tiles[7] = new Tile(new Soft_Toy("Walter"), 8);
        tiles[8] = new Tile(new Soft_Toy("Ralph"), 9);
        tiles[9] = new Tile(new Soft_Toy("Walter"), 10);
        tiles[10] = new Tile(new Soft_Toy("Bobby"), 11);
        tiles[11] = new Tile(new Soft_Toy("Brownie"), 12);
        tiles[12] = new Tile(new Soft_Toy("Waffle"), 13);
        tiles[13] = new Tile(new Soft_Toy("Mr.Bear"), 14);
        tiles[14] = new Tile(new Soft_Toy("Grizzly"), 15);
        tiles[15] = new Tile(new Soft_Toy("Mr.Fluffles"), 16);
        tiles[16] = new Tile(new Soft_Toy("Rocky"), 17);
        tiles[17] = new Tile(new Soft_Toy("FuzzyWuzzy"), 18);
        tiles[18] = new Tile(new Soft_Toy("Sunshine"), 19);
        tiles[19] = new Tile(new Soft_Toy("Snowbell"), 20);
    }

    public void setTileAt(Tile tile, int index) {
        tiles[index] = tile;
    }
}
