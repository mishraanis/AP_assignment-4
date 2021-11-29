package com.company;

import java.io.BufferedReader;
import java.io.IOException;

public class Game {
    private final Carpet carpet;
    private final Player player;
    Game(){
        carpet = new Carpet();
        player = new Player();
    }
    public void Initialise(){
        carpet.Initialise();
    }

    public String display_hop_num(int num_hops){
        switch (num_hops){
            case 0:
                return " first";
            case 1:
                return " second";
            case 2:
                return " third";
            case 3:
                return " fourth";
            case 4:
                return " fifth";
            default:
                return "";
        }
    }

    public void hit_enter(BufferedReader br) throws InputMismatchException {
        boolean done = false;
        while(!done) {
            try {
                char input = (char) br.read();
                if (input == '\n') {
                    done = true;
                } else {
                    br.read();
                    throw new InputMismatchException("Invalid input. Expected: Enter key");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            finally {
                if(!done) {
                    System.out.println("Hit enter to initialize the game\n");
                }
            }
        }
    }

    public void addToBucket(Object toy, Object bucket) throws ClassCastException, NullPointerException{
        try {
            ((Bucket) bucket).add_toys((Soft_Toy) toy);
        }
        catch (ClassCastException e){
            ClassCastException castException = new ClassCastException("Invalid toy type or bucket type");
            System.out.println("Error: " + castException.getMessage());
        }
        catch (NullPointerException e){
            NullPointerException nullPointerException = new NullPointerException("Cannot add null toy to bucket");
            System.out.println("Error: " + nullPointerException.getMessage());
        }
    }

    public int generate_random_number(int min, int max){
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public String generate_random_string(int length){
        String mem_string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder rand_string = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = generate_random_number(0, mem_string.length());
            rand_string.append(mem_string.charAt(index));
        }
        return rand_string.toString();
    }

    public <T>Pair<T, T> generate_question(String choice) throws IOException{
        if (choice.equals("integer")) {
            Integer operand1 = generate_random_number(Integer.MIN_VALUE/2, Integer.MAX_VALUE/2);
            Integer operand2 = generate_random_number(Integer.MIN_VALUE/2, Integer.MAX_VALUE/2);
            return (Pair<T, T>) new Pair<Integer, Integer>(operand1, operand2);
        }
        else {
            String operand1 = generate_random_string(4);
            String operand2 = generate_random_string(4);
            return (Pair<T, T>) new Pair<String, String>(operand1, operand2);
        }
    }

    <T>boolean check_answer(Pair<T, T> question, String choice, BufferedReader br) throws IOException {
        try{
            if(choice.equals("integer")){
                Integer correct_answer = Generic_Calculator.calculate((Integer) question.getFirst(), (Integer) question.getSecond());
                Integer user_answer = Integer.parseInt(br.readLine());
                return user_answer.equals(correct_answer);
            }
            else {
                String correct_answer = Generic_Calculator.calculate((String) question.getFirst(), (String) question.getSecond());
                String user_answer = br.readLine();
                return user_answer.equals(correct_answer);
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
        return false;
    }

    public void StartGame(BufferedReader br) throws IOException, InputMismatchException, ArrayIndexOutOfBoundsException, NullPointerException {
        System.out.println("Hit enter to initialize the game");
        hit_enter(br);
        System.out.println("Game is ready");
        Initialise();
        int num_hops = 0;
        while (num_hops < 5) {
            try{
                System.out.println("Hit enter for your" + display_hop_num(num_hops) + " hop");
                hit_enter(br);
                int hop_length = generate_random_number(1, 30);
                player.hop(hop_length, carpet, this, br);
                num_hops++;
            }catch (ArrayIndexOutOfBoundsException | InputMismatchException | NullPointerException e){
                if(e instanceof ArrayIndexOutOfBoundsException){
                    num_hops++;
                }
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Game Over\n" + "Soft toys won by you are:");
        player.getBucket().print_toys();
    }
}
