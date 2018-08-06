import java.awt.*;
import java.util.*;
import java.io.*;

public class HangmanGuessTheMovie {
    public static void main (String [] args) {
        boolean hasWon = false;
        System.out.println("I have randomly chosen a movie title.  Try to guess without reaching 10 incorrect guesses.");
        String movieTitle = null;
        StringBuilder correctGuessTitleOutput =new StringBuilder();
        ArrayList <String> incorrectGuesses = new ArrayList <>(0);
        Scanner scanner = new Scanner(System.in);

        try{
             movieTitle = selectMovieTitle();
        }catch (Exception exception){
            System.out.println("Oops! Looks like the movie file is missing.");
        }

        correctGuessTitleOutput = initialOutput(movieTitle, correctGuessTitleOutput);

        System.out.println(movieTitle + correctGuessTitleOutput);
        for (int i = 10; i > 0; i--) {
            System.out.println("You have guessed these wrong letters: " + incorrectGuesses);
            System.out.println("You have " + i + " guesses left. What is your next guess? ");
            String currentLetterGuess = scanner.nextLine();
            System.out.println("Your guess was: " + currentLetterGuess);
            checker(currentLetterGuess, incorrectGuesses, movieTitle);
            System.out.println(correctGuessTitleOutput);
        }
        if (hasWon) {
            System.out.println("Correct! The movie title was: " + movieTitle + " You win!");
        }else{
            System.out.println("Game over! You lose.  The movie title was " + movieTitle + ".");
        }

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

    //SETS INITIAL TITLE OUTPUT TO BE BLANK
    public static StringBuilder initialOutput(String movieTitle, StringBuilder correctGuessTitleOutput){
        for (int i=0; i < movieTitle.length(); i++ ){
            if (movieTitle.charAt(i)!= ' '){
                correctGuessTitleOutput.insert(i, '_');
            }else {
                correctGuessTitleOutput.insert(i, ' ');
            }
        }
        return correctGuessTitleOutput;
        //TODO add space between the _ to see how many char to guess
        //StringBuilder newcorrectGuessTitleOutput = correctGuessTitleOutput.replaceAll(".(?=.)", "$0 ");//correctGuessTitleOutput.replace("", " ").trim()//correctGuessTitleOutput.replaceAll(".(?=.)", "$0 ");
        //correctGuessTitleOutput.replace(i,i,"_ ");//correctGuessTitleOutput.insert(i, '_');
    }


    private static void checker(String currentLetterGuess, ArrayList <String> incorrectGuess, String movieTitle) {
        if(movieTitle.contains(currentLetterGuess)){
            incorrectGuess.add("*"); //todo add more logic here
        }else {
            incorrectGuess.add(currentLetterGuess);
        }


    }

}
