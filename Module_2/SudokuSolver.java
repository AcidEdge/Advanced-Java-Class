import java.util.Scanner;

public class SudokuSolver {
    
    private static final int Grid_Size = 9;

    public static void main(String[] args){
        
        int[][] board = setupBoard();

        if (solveBoard(board)){
            System.out.println("\n\nSolved Successfully!\n");
            
        }
        else {
            System.out.println("Unsolvable Board.");
        }
        printBoard(board);
    }

    private static int[][] setupBoard(){
        int[][] board = new int[9][9];
        Scanner input = new Scanner(System.in);
        for(int row = 0; row < Grid_Size; row++){
            System.out.println("Enter row " + (row+1) + ": ");
            for (int column = 0; column < Grid_Size; column++){
                board[row][column] = input.nextInt();
            }
        }
        return board;
    }

    private static void printBoard(int[][] board){
        for (int row = 0; row <Grid_Size; row++){
            if (row % 3 == 0 && row != 0){
                System.out.println("---------------------");
            }
            for (int column = 0; column < Grid_Size; column++){
                if (column % 3 == 0 && column !=0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isNumberInRow(int[][] board, int number, int row){
        for(int i = 0; i < Grid_Size; i++){
            if (board[row][i] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column){
        for(int i = 0; i < Grid_Size; i++){
            if (board[i][column] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column){
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++){
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int column){
        return !isNumberInRow(board, number, row) && 
            !isNumberInColumn(board, number, column) && 
            !isNumberInBox(board, number, row, column);
    }

    private static boolean solveBoard(int[][] board){
        for (int row = 0; row < Grid_Size; row++){
            for(int column = 0; column < Grid_Size; column++){
                if (board[row][column] == 0){
                    for (int numberToTry = 1; numberToTry <= Grid_Size; numberToTry++){
                        if (isValidPlacement(board, numberToTry, row, column)){
                            board[row][column] = numberToTry;

                            if(solveBoard(board)){
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
