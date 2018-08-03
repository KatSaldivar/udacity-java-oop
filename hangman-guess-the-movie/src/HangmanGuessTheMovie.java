import java.util.*;
import java.io.*;

public class HangmanGuessTheMovie {
    public static void main (String [] args) throws Exception {
        boolean hasWon = false;
        System.out.println("I have randomly  chosen a movie title.  Try to guess it.");

        String movieTitle = selectMovieTitle();
        System.out.println(movieTitle);

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


        int randomline = (int) (Math.random() * lines) + 1;
        FileInputStream fs = new FileInputStream("movies.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        for (int i = 0; i < randomline; ++i)
            br.readLine();
         randomMovie = br.readLine();
        return randomMovie;

    }



}
