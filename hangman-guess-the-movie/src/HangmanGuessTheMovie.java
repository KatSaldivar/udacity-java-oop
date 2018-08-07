import java.util.*;
import java.io.*;

public class HangmanGuessTheMovie {
    public static void main (String [] args) {
        System.out.println("I have randomly chosen a movie title.  Try to guess without reaching 10 incorrect guesses.");
        String movieTitle = null;
        StringBuilder correctGuessTitleOutput =new StringBuilder();
        ArrayList <String> incorrectGuesses = new ArrayList <>(0);
        Scanner scanner = new Scanner(System.in);
        boolean hasWon = false;

        try{
             movieTitle = selectMovieTitle();
             correctGuessTitleOutput = initialOutput(movieTitle, correctGuessTitleOutput);
             System.out.println(correctGuessTitleOutput);
        }catch (Exception exception){
            System.out.println("Oops! Looks like the movie file is missing. Please try again.");
            System.exit(0);
        }

        while (hasWon==false) {
            System.out.println("You have guessed these wrong letters: " + incorrectGuesses);
            System.out.println("You have " + (10 - incorrectGuesses.size()) + " guesses left. What is your next guess? ");
            String currentLetterGuess = inacceptableGuessHandler(scanner.nextLine(), incorrectGuesses);
            System.out.println("Your guess was: " + currentLetterGuess);
            letterChecker(currentLetterGuess, incorrectGuesses, movieTitle, correctGuessTitleOutput);
            hasWon = winChecker(movieTitle, correctGuessTitleOutput, incorrectGuesses, hasWon);
            System.out.println(correctGuessTitleOutput);
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
        int randomline = (int) (Math.random() * lines);
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
                correctGuessTitleOutput = correctGuessTitleOutput.insert(i, '_');
            }else {
               correctGuessTitleOutput = correctGuessTitleOutput.insert(i, ' ');
            }
        }
        return correctGuessTitleOutput;
        //TODO add space between the _ to see how many char to guess
        //StringBuilder newcorrectGuessTitleOutput = correctGuessTitleOutput.replaceAll(".(?=.)", "$0 ");//correctGuessTitleOutput.replace("", " ").trim()//correctGuessTitleOutput.replaceAll(".(?=.)", "$0 ");
        //correctGuessTitleOutput.replace(i,i,"_ ");//correctGuessTitleOutput.insert(i, '_');
    }

    private static void letterChecker(String currentLetterGuess, ArrayList <String> incorrectGuess, String movieTitle, StringBuilder correctGuessTitleOutput ) {
        if(movieTitle.contains(currentLetterGuess)){
            letterReplacer(movieTitle, correctGuessTitleOutput, currentLetterGuess);
        }else {
            incorrectGuess.add(currentLetterGuess);
        }
    }

    private static void letterReplacer(String movieTitle, StringBuilder correctGuessTitleOutput, String currentLetterGuess) {
        for (int i=0; i < movieTitle.length(); i++ ){
            if (movieTitle.charAt(i)== currentLetterGuess.toCharArray()[0]) {
                correctGuessTitleOutput = correctGuessTitleOutput.replace(i, i+1, currentLetterGuess);
            }
        }
    }

    private static boolean winChecker(String movieTitle, StringBuilder correctGuessTitleOutput,  ArrayList incorrectGuesses, boolean hasWon) {
        if (correctGuessTitleOutput.toString().equals(movieTitle)) {
            hasWon=true;
            System.out.println("Correct! The movie title was: " + movieTitle + " You win!");
        }
        if (incorrectGuesses.size()==10) {
            System.out.println("Game over! You lose.  The movie title was " + movieTitle + ".");
            System.exit(0);
        }
        return hasWon;
    }

    private static String inacceptableGuessHandler(String guess, ArrayList incorrectGuesses) {
        Scanner scanner = new Scanner(System.in);
        while((guess.length() != 1) || (Character.isUpperCase(guess.toCharArray()[0]) || incorrectGuesses.contains(guess))){
            if(guess.length() == 0){
                System.out.println("Please enter a guess.");
            }else if(guess.length() > 1){
                System.out.println("Please enter a single guess.");
            }else if(Character.isUpperCase(guess.toCharArray()[0])){
                System.out.println("Please enter a lowercase guess.");
            }else if(incorrectGuesses.contains(guess)){
                System.out.println("Please enter a guess you have not already guessed.");
            }
            guess = scanner.nextLine();
        }
        return guess;
    }
}
