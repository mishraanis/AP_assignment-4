package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InputMismatchException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Game hop_and_win = new Game();
        hop_and_win.StartGame(br);
    }
}
