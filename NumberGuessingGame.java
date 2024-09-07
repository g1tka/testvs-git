import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("1から100までの数を当ててください!");

        while (!hasGuessedCorrectly) {
            System.out.print("推測した数を入力してください: ");
            int userGuess = scanner.nextInt();
            numberOfTries++;

            if (userGuess < numberToGuess) {
                System.out.println("もっと大きな数です!");
            } else if (userGuess > numberToGuess) {
                System.out.println("もっと小さな数です!");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("正解です! " + numberOfTries + " 回の試行で当てました!");
            }
        }

        scanner.close();
    }
}
