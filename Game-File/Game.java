import java.util.Scanner;

public class Game {
    Board board;
    Player player1, player2;

    //! Constructor initializes the game
    public Game() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
    }

    //! Method to play the game
    public void play() {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;

        while (true) {
            board.displayBoard();
            System.out.println("Player " + currentPlayer.symbol + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.placeSymbol(row, col, currentPlayer.symbol)) {
                if (board.checkWin(currentPlayer.symbol)) {
                    board.displayBoard();
                    System.out.println("Player " + currentPlayer.symbol + " wins!");
                    break;
                } else if (board.isFull()) {
                    board.displayBoard();
                    System.out.println("It's a tie!");
                    break;
                }

                //! Switch player
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }
}