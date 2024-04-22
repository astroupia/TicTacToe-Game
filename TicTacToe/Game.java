package TicTacToe;

public interface Game {
    void initializeBoard();
    void printBoard();
    boolean makeMove(int row, int col);
    boolean isGameFinished(int row, int col);
    boolean isBoardFull();
    void switchPlayer();
    char getCurrentPlayer();
}
