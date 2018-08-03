import java.util.Scanner;

public class NumberGame {
    public static void main (String [] args){

        int randomNumber = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;
        System.out.println("I have randomly  chosen  number between 1 and 100.  Try to guess it.");
        Scanner scanner = new Scanner(System.in);

        for (int i = 10; i > 0; i--) {
            System.out.println("You have " + i + " guess(es) left.");
            int guess = scanner.nextInt();
            System.out.println("Your guess was " + guess + ". Choose again.");

            if (randomNumber < guess){
                System.out.println("It's smaller than " + guess + ". Choose again.");
            }
            else if (randomNumber > guess) {
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
            System.out.println("Game over! You lose.  The number was " + randomNumber + ".");
        }

    }
}
