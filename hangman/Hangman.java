import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
// import java.util.*;
public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = words[RandomWords()];
        // char[] wordArr = word.toCharArray();
        String str = "_";
        String repeated = str.repeat(word.length()); //The string showing missing characters and right guesses
        char[] repeatedArr = repeated.toCharArray();
        String misses = ""; //The string showing wrong guesses
        // System.out.println(word);
        int counter = 0;
        while (counter<7){

            //if all guesses run out, game ends

            if (counter == 6){
                System.out.println(gallows[counter]);
                System.out.println("\nRIP");
                System.out.println("\nThe word was: "+word);
                break;
            }
            System.out.println(gallows[counter]);
            System.out.print("\nWord: ");
            System.out.println(repeated);
            System.out.print("\nMisses: ");
            System.out.println(misses);
            System.out.print("\nGuess: ");
            char guess = scan.next().charAt(0);
            System.out.println("\n");

            //updating 'misses' string in case of wrong guess

            if (Checknew(guess,word,repeatedArr).equals(repeated)){
                misses = misses + guess;
                counter++;
            }

            //updating 'repeated' string in case of right guess

            else{
                repeated = Checknew(guess, word, repeatedArr);
            }

            // if the word has been guessed correctly, game ends.

            if (repeated.equals(word)){
                System.out.println(gallows[counter]);
                System.out.println("\nWord: "+word);
                System.out.println("\nGood Work!");
                break;
            }

        }
        scan.close();
    }

//Chooses a random number between zero and array length of words, helps in choosing a random word from the array

    public static int RandomWords(){
        int min = 0;
        int max = words.length;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }


// Checks if the guess character is present in the word, if yes then it updates the 'repeated' string showing the matched letters,
// otherwise returns the same 'repeated' string

    public static String Checknew(char guess, String word, char[] repeatedArr){
        char[] wordArr = word.toCharArray();
        for(int i=0;i<word.length();i++){
            if (guess == wordArr[i]){
                repeatedArr[i]=wordArr[i];
            }
        }
        String repeated = String.valueOf(repeatedArr);
        return repeated;
    }

}