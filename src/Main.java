import java.util.Scanner;

public class Main {
    private static final int ROW = 3; // Create a constant variable ROW and set it to 3
    private static final int COL = 3; // Create a constant variable COL and set it to 3
    private static String[][] board = new String[ROW][COL]; // Create a 2D array and set it to a 3 by 3
    public static void main(String[] args) {
        String player = "X"; // Initialize player variable and set it to the value "X"
        int row = 0; // Initialize row variable
        int col = 0; // Initialize row variable
        boolean gameFinished = false; // Initialize gameFinished variable and set it to false
        boolean yesOrNo = false; // Initialize yesOrNo variable and set it to false
        Scanner in = new Scanner(System.in);
        do {
            clearBoard(); // Call the clearBoard method to clear the board
            display(); // Call the display method to display the board
            do {
                do {
                    row = SafeInput.getRangedInt(in, "Enter the row for player " + player + ":", 1, 3); // Prompt the user for a row (between 1 and 3) for the game and use the getRangedInt method to make sure it is in that range, and set their response as a variable
                    row -= 1; // Subtract 1 from the row variable, so we convert the player move coordinates to the array indices (0-2)
                    col = SafeInput.getRangedInt(in, "Enter the column for the player " + player + ":", 1, 3); // Prompt the user for a column (between 1 and 3) for the game and use the getRangedInt method to make sure it is in that range, and set their response as a variable
                    col -= 1; // Subtract 1 from the row variable, so we convert the player move coordinates to the array indices (0-2)
                    if(!isValidMove(row, col)) { // If not a valid move by the player (call the method isValidMove and set the parameters to the user input, and check if it's a valid move),
                        System.out.println("Please enter a valid move that has not been taken already."); // Output that the user should enter a valid move
                    }
                } while(!isValidMove(row, col)); // Loop: While there is not a valid move by the user (Loop until the converted player coordinates are a valid move)
                board[row][col] = player; // Set the user inputted location to the player (so when you display, you see an X or O)
                display(); // Call the display method to display the board
                if(player.equals("X")) { // Condition: If the player is equal to "X",
                    player = "O"; // Set player to "O" (to switch the player)
                } else if(player.equals("O")) { // Condition: If the player is equal to "O",
                    player = "X"; // Set player to "X" (to switch the player)
                }
                if(isWin("X")) { // Condition: If player X won (call the isWin method and set the parameter to player X),
                    System.out.println("\nPlayer X wins!"); // Output that player X wins
                    gameFinished = true; // Set gameFinished variable to true (to end the loop)
                } else if (isWin("O")) { // Condition: If player O won (call the isWin method and set the parameter to player O),
                    System.out.println("\nPlayer O wins!"); // Output that player O wins
                    gameFinished = true; // Set gameFinished variable to true (to end the loop)
                } else if (isTie()) { // Condition: If there is a tie (call the isTie method to check if there is a tie),
                    System.out.println("\nBoth players tied!"); // Output that both players tied
                    gameFinished = true; // Set gameFinished variable to true (to end the loop)
                }
            } while(!gameFinished); // Loop: While gameFinished variable is false (loop will stop when gameFinished is true, or in other words when one player wins or both players tie)
            yesOrNo = SafeInput.getYNConfirm(in,"Would you like to play again?"); // Prompt the user if they would like to play again, and set their response as a boolean variable
            if(yesOrNo) { // Condition: If yesOrNo variable is true (if user says yes)
                if(player.equals("X")) { // Condition: If player equals "X",
                    player = "O"; // Set player to "O" (toggle the player)
                } else if(player.equals("O")) { // Condition: If player equals "O",
                    player = "X"; // Set player to "X" (toggle the player)
                }
            }
        } while(yesOrNo); // Loop: While yesOrNo is true (if user says yes, then that means yesOrNo is true, and the loop will keep going until user says no, which means yesOrNo is false)
    }
    private static void clearBoard() {
        for(int row = 0; row < ROW; row++) { // Loop: Initialize variable row to 0, set it less than the ROW variable (3), repeatedly increase row by 1
            for(int col = 0; col < COL; col++) { // Loop: Initialize variable col to 0, set it less than the COL variable (3), repeatedly increase col by 1
                board[row][col] = " "; // Set each square on the board to a blank space to clear the board
            }
        }
    }
    private static void display() {
        for(int row = 0; row < ROW; row++) { // Loop: Initialize variable row to 0, set it less than the ROW variable (3), repeatedly increase row by 1
            for(int col = 0; col < COL; col++) { // Loop: Initialize variable col to 0, set it less than the COL variable (3), repeatedly increase col by 1
                if(col == 2) { // Condition: If the column is equal to 2 (technically column 3 but in array terms it's 2),
                    System.out.print(" " + board[row][col]); // Print a space with only the board value
                } else {
                    System.out.print(" " + board[row][col] + " |"); // Print a space with the board value with a separator that will be between the columns
                }
            }
            if(row != 2) { // If row is not equal to 2,
                System.out.println("\n-----------"); // Print a separator between the rows
            }
        }
    }
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" "); // Return the boolean value of if the specified board value is equal to a blank space, return true if yes (it's a valid move), return false if no
    }
    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player); // Return the boolean value of if there is a column win OR a row win OR a diagonal win, return true if yes (the user wins), return false if not
    }
    private static boolean isColWin(String player) {
        for(int col = 0; col < COL; col++) { // Loop: Initialize variable col to 0, set it less than the COL variable (3), repeatedly increase col by 1
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) { // Condition: If the first square of a column equals the player's move OR the second square OR the third square,
                return true; // Return true (the user made a column win)
            }
        }
        return false; // Return false
    }
    private static boolean isRowWin(String player) {
        for(int row = 0; row < ROW; row++) { // Loop: Initialize variable row to 0, set it less than the ROW variable (3), repeatedly increase row by 1
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) { // Condition: If the first square of a row equals the player's move OR the second square OR the third square,
                return true; // Return true (the user made a row win)
            }
        }
        return false; // Return false
    }
    private static boolean isDiagonalWin(String player) {
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) { // Condition: If the square with index 0,0 equals the player's index, OR the square with index 1,1 OR the square with index 2,2,
            return true; // Return true (one way to get a diagonal win)
        } else if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) { // Condition: If the square with index 0,2 equals the player's index, OR the square with index 1,1 OR the square with index 2,0,
            return true; // Return true (another way to get a diagonal win)
        } else {
            return false; // Return false if the conditions above aren't true
        }
    }
    private static boolean isTie() {
        for(int row = 0; row < ROW; row++) { // Loop: Initialize variable row to 0, set it less than the ROW variable (3), repeatedly increase row by 1
            for(int col = 0; col < COL; col++) { // Loop: Initialize variable col to 0, set it less than the COL variable (3), repeatedly increase col by 1
                if(board[row][col].equals(" ")) { // Condition: If a square in the board is blank,
                    return false; // Return false (not a tie)
                }
            }
        }
        return true; // Return true
    }
}