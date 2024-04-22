package TicTacToe;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Game ticTacToe = new TicTacToe();
        ticTacToe.initializeBoard();
        ticTacToe.printBoard();

        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            try {
                System.out.println("Player " + ticTacToe.getCurrentPlayer() + ", enter your move (row[1-3] column[1-3]): ");
                int row = scanner.nextInt() - 1;
                scanner.nextLine(); 
                int col = scanner.nextInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (ticTacToe.makeMove(row, col)) {
                        ticTacToe.printBoard();

                        if (ticTacToe.isGameFinished(row, col)) {
                            System.out.println("Player " + ticTacToe.getCurrentPlayer() + " wins!");
                            gameEnded = true;
                        } else if (ticTacToe.isBoardFull()) {
                            System.out.println("It's a draw!");
                            gameEnded = true;
                        } else {
                            ticTacToe.switchPlayer();
                        }
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter row and column numbers between 1 and 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format. Please enter numeric values.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        scanner.close();
    }
}
