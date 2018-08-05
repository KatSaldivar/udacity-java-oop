import java.awt.*;
import java.util.*;
import java.io.*;

public class HangmanGuessTheMovie {
    public static void main (String [] args) throws Exception {
        boolean hasWon = false;
        System.out.println("I have randomly chosen a movie title.  Try to guess without reaching 10 incorrect guesses.");
        String movieTitle = null;
        StringBuilder correctGuessTitleOutput =new StringBuilder();
        StringBuilder [] incorrectGuesses = new StringBuilder[10];
        Scanner scanner = new Scanner(System.in);

        try{
             movieTitle = selectMovieTitle();
        }catch (Exception exception){
            System.out.println("Oops! Looks like the movie file is missing.");
        }

        //SETS INITIAL TITLE OUTPUT TO BE BLANK
        for (int i=0; i < movieTitle.length(); i++ ){
            if (movieTitle.charAt(i)!= ' '){
                correctGuessTitleOutput.insert(i, '_').append(" ");
            }else {
                correctGuessTitleOutput.insert(i, ' ');
            }
        }
        //TODO add space between the _ to see how many char to guess
        //StringBuilder newcorrectGuessTitleOutput = correctGuessTitleOutput.replaceAll(".(?=.)", "$0 ");//correctGuessTitleOutput.replace("", " ").trim()//correctGuessTitleOutput.replaceAll(".(?=.)", "$0 ");
        //correctGuessTitleOutput.replace(i,i,"_ ");//correctGuessTitleOutput.insert(i, '_');

        System.out.println(movieTitle + correctGuessTitleOutput);
        for (int i = 10; i > 0; i--) {
            System.out.println("You have guessed these wrong letters: " + incorrectGuesses);
            System.out.println("You have " + i + " guesses left. What is your next guess? ");
            String currentLetterGuess = scanner.nextLine();
            System.out.println("Your guess was: " + currentLetterGuess);
        }
        if (hasWon) {
            System.out.println("Correct! The movie title was: " + movieTitle + " You win!");
        }else{
            System.out.println("Game over! You lose.  The movie title was " + movieTitle + ".");
        }

        /*for (int i = 10; i > 0; i--) {
            System.out.println("You are guessing:" + );
            int guess;
            System.out.println("Your guess was " + guess + ". Choose again.");

            if (movieTitle < guess){
                System.out.println("It's smaller than " + guess + ". Choose again.");
            }
            else if (movieTitle > guess) {
                System.out.println("It's greater than " + guess + ". Choose again.");
            }
            else {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            System.out.println("Correct! You win!");
        }else{
            System.out.println("Game over! You lose.  The movie title was " + movieTitle + ".");
        }*/

    }


    public static String selectMovieTitle() throws Exception {
        String randomMovie;

        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        //COUNTS LINES IN FILE
        int lines = 0;
        while (scanner.hasNextLine() == true) {
            lines++;
            scanner.nextLine();
        }

        //SELECTS A RANDOM LINE FROM FILE
        int randomline = (int) (Math.random() * lines) + 1;
        FileInputStream fs = new FileInputStream("movies.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        for (int i = 0; i < randomline; ++i)
            br.readLine();
         randomMovie = br.readLine();
        return randomMovie;

    }



}
