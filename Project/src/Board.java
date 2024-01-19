/*
 * Author: Juan David Montana
 * Date: 20/07/2023
 * Date of presentation: August 10th of 2023.
 * Description: This the creation of the Board for the game TIC-TAC-TOE.
 */
public class Board {
    
    //We declare two instances variables with one array and the other one which is data type INT as well as the matrix-.

    private int matrix[][];
    private int plays;

// We made a constructor here which does not take parameters, we initialized the board from 0 and makes the matrix of the board of the game.
    public Board()
    {
        matrix = new int[3][3]; //Array 3 x 3
        plays = 0;
        for(int i = 0; i < 3; i++) //ROWS
        {
            for(int j = 0; j < 3; j++) // COLUMNS
            {
                matrix[i][j] = 0; // Fill the positions with I and J
            }
        }
     }
     // Getter for Plays Variable, we obtain the numbers of plays that players will realize on the board.
     public int getplays()
     {
        return plays;// Starts the number of plays from 0
     }
    
     /**  We obtain the value stored in the matrix.
      *  @param row row of the cells
      *  @param column columns of the cells
      *  @return It will return the storaged value.
      */ 
     public int getValueOfCell(int row, int column)
     {
        return matrix[row][column]; //Filling the squares on the board
     }

    /**This method will realize count and show the movements made by a player on the board.
     *  @param row row of the cells.
     *  @param column column of the cells.
     * @param player It represents the player that has done the movement.
     * @return  It will return a true value.
    */
     public boolean Movements(int row, int column, int player)
     {
        if(row < 0 || row >= 3 || column < 0 || column >= 3 || matrix[row][column]!= 0)
        {
            return false;
        }
        matrix[row][column] = player; //Catch the row,column and the player who has done the movement.
            return true;
     }
    // This method display the dimensions of the Board.
     public void viewBoard()
     {
        System.out.println("BOARD: ");
        for(int i = 0; i < 3; i++) //ROW
        {
            for(int j= 0; j < 3; j++) //COLUMN
            {
                if(matrix[i][j] == 0)
                {
                    System.out.print(" - "); //When matrix[i][j] is equal to 0 this happens.
                } else if(matrix[i][j]==1) {
                    System.out.print(" X "); //Player 1 will be represent by X.
                } else if(matrix[i][j] == 2){
                    System.out.print(" O "); //Player 2 will be represented by O.
                } 
                if(j < 2) //Why 2? Because we just want to display to columns of | this to make the separation
                { // of the board vertically.
                    System.out.print("|");
                }
            }
                System.out.println();
            if(i < 2) //Why 2? Because we just want to display to columns of ---+--- this to make the separation
            { // of the board Horizontally.
                System.out.println("---+---+---");
            }
        }
     }
     /**
      * This method will decide who's the winner based on some conditions.
      * @param player This represent the movement of the player.
      * @return True Boolean Value if there is a winner or false if the game still goes on.
      */
     public boolean winner(int player)
     {
        //This for verifies the rows on the board.
        for(int i = 0; i < 3 ;i++)
        {
            if(matrix[i][0] == player && matrix[i][1]==player && matrix[i][2] == player)
            {
                return true;
            }
        }
        //This for verifies the columns on the board.
        for(int j = 0; j < 3; j++)
        {
            if(matrix[0][j] == player && matrix[1][j]==player && matrix[2][j]== player)
            {
                return true;
            }
        }
        
        //This IF verifies the diagonal on the board.
        if(matrix[0][0] == player && matrix[1][1]==player && matrix[2][2]== player)
        {
            return true;
        }
        //This IF verifies the diagonal on the board.
        if(matrix[0][2] == player && matrix[1][1] == player && matrix[2][0]== player)
        {
            return true;
        }
        return false;
     }

     //If the game is over and there's no winner it will end the game.
     public boolean fullBoard()
     {
        for(int i = 0; i < 3; i++) //ROW
        {
            for(int j = 0; j < 3; j++) // COLUMNS
            {
                if(matrix[i][j] == 0)
                {
                    return false;
                }
                
            }
        }
        return false;
     }
     
     
}
