/*
 * Author: Juan David Montana
 * Date: 20/07/2023
 * Date of presentation: August 10th of 2023.
 * Description: This class is where we call the methods from the Board Class in order to be able to play the game.
 */
import java.util.Scanner;
// Main class that controls the flow of the game.
public class TicTacToe {
    
 public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);
    //We instantiate the blueprint class Board with all the structure to run and play the code.
    Board board =  new Board();
    //We assign the player who start the game with the value of 1.
    int currentPlayer = 1;

    // This a cycle that controls the turns between players until there's a winner or draw.
    while(true)
    {
        //We display the board. 

        board.viewBoard();
        //We ask the player to realize a movement.
        System.out.println("Player Turn: " + currentPlayer);

        //Validate the entered value of the row.
        int row = integerValue(scanner, "Enter row 0-2");

         //Validate the entered value of the Columns.
        int column = integerValue(scanner, "Enter column 0-2");

        // We verify the player movements, if there's an invalid value the board will ask again.
        if(!board.Movements(row, column, currentPlayer))
        {
            System.out.println("Invalid Movements, please try again.");
            continue;
        }
        // Verification if we got a winner or the board is full, with all the possible characters.
        if(board.winner(currentPlayer))
        {
            System.out.println("Congratulations Player " + currentPlayer + " has won ");
            board.viewBoard();
            break;
        } else if (board.fullBoard()){
            System.out.println("Draw");
            board.viewBoard();
            break;
        }
        // We alternate the players after entering a movements.
        currentPlayer = 3 - currentPlayer;
    }
    
    }
    /**
     * Verifies that information entered is an integer, nothing different than it.
     * @param scanner User Input
     * @param message It is the message that will be displayed an error if it is invalid movement.
     * @return Value entered.
     */
    public static int integerValue(Scanner scanner, String message)
    {
        int value;
        while(true)
        {
            System.out.println(message);
            if(scanner.hasNextInt())
            {
                value = scanner.nextInt();
                break; 
            } else {
                System.out.println("Invalid Value, You should enter a valid int");
                scanner.next();
            }
        }
        return value;
    }
}
