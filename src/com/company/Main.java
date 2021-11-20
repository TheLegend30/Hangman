package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1 or 2 players?");
        String word;
        if(keyboard.nextLine().equals("1")){
            Scanner scanner = new Scanner(new File("C:\\Users\\Rocket\\Downloads\\words.txt"));
            List<String> words = new ArrayList<>();

            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            Random rand = new Random();
            word = words.get(rand.nextInt(words.size()));

        }
        else{
            System.out.println("Player 1 please enter your word");
            word = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Player 2, get ready!");
        }

        List<Character> playerGuesses = new ArrayList<>();
       // System.out.println(word);
        int wrongCount=0;
        while (true) {
            System.out.println(" --------");
            System.out.println(" |      |");
            if(wrongCount>=1){
                System.out.println(" 0");
                if(wrongCount>=2){
                    System.out.println("\\ /");
                    if(wrongCount>=3){
                        System.out.println(" | ");
                        if(wrongCount>=4){
                            System.out.println("/ \\");
                        }
                    }
                }
            }

            if(wrongCount>=4){
                System.out.println("You lose!");
                System.out.println("The word was " + word);
                break;
            }

            printWordState(word, playerGuesses);
            if(!getPlayerGuess(keyboard, word, playerGuesses)){
                wrongCount++;
            }
            if (printWordState(word, playerGuesses)) {
                System.out.println("You win!");
                break;
            }
            System.out.println("Please enter your guess for the word:");
            if (keyboard.nextLine().equals(word)) {
                System.out.println("You win!");
                break;
            }
            else{
                System.out.println("Nope! Try again.");
            }
        }


    }


    private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Please enter a letter");
        String letterGuess;
        while(true){
            letterGuess =  keyboard.nextLine();
            if(playerGuesses.contains(letterGuess.charAt(0))){
                System.out.println("This letter has already been in the guesses");
                continue;
            }
            break;
        }
        playerGuesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.toLowerCase(Locale.ROOT).charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == correctCount);
    }

}
