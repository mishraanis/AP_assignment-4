package com.company;

import java.io.BufferedReader;
import java.io.IOException;

public class Player {
    private Bucket bucket;
    Player(){
        bucket = new Bucket();
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void hop(int hop_size, Carpet carpet, Game game, BufferedReader br) throws ArrayIndexOutOfBoundsException, NullPointerException, InputMismatchException, IOException {
        try{
            Soft_Toy clone_soft_toy = carpet.getTiles()[hop_size-1].land();
            if(hop_size % 2 == 0){
                game.addToBucket(clone_soft_toy, bucket);
                System.out.println("You won a " + clone_soft_toy.getName() + " soft toy\n");
            }
            else{
                boolean done = false;
                boolean check_ans = false;
                while(!done){
                    try{
                        System.out.println("Question answer round. Integer or strings?(Type integer or string)");
                        String choice = br.readLine();
                        if (choice.equals("integer")) {
                            Pair<Integer, Integer> question = game.generate_question("integer");
                            done = true;
                            System.out.println("Calculate the result of " + question.getFirst() + " divided by " + question.getSecond());
                            check_ans = game.check_answer(question,"integer", br);
                        } else if (choice.equals("string")) {
                            Pair<String, String> question = game.generate_question("string");
                            done = true;
                            System.out.println("Calculate the concatenation of " + question.getFirst() + " and " + question.getSecond());
                            check_ans = game.check_answer(question,"string", br);
                        } else{
                            throw new InputMismatchException("Invalid input. Expected: ''integer'' or ''string''");
                        }
                    }
                    catch (InputMismatchException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    finally {
                        if(!done){
                            System.out.println("Please try again");
                        }
                        else{
                            if(check_ans){
                                System.out.println("Correct answer");
                                game.addToBucket(clone_soft_toy, bucket);
                                System.out.println("You won a " + clone_soft_toy.getName() + " soft toy\n");

                            }
                            else{
                                System.out.println("Incorrect answer");
                                System.out.println("You did not win any soft toy\n");
                            }
                        }
                    }
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
        }
        catch(NullPointerException e){
            throw new NullPointerException("Null Pointer Exception");
        }
        catch (IOException e){
            throw new IOException("IO Exception");
        }
    }
}
