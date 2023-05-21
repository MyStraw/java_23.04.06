
package Chap5_재귀알고리즘;

import java.awt.Point;
import java.util.Stack;

public class Chap5_Test_QueenEight_revised3 {

    final int N = 4;
    int count = 0;

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            	
            System.out.println();
        }count++;
        System.out.println(count);
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col, Stack<Point> stack) {
        //if (col >= N)
    	//return true;
    	if (col == N) {
            printSolution(board);
            System.out.println("\n");
            return false;
    	}
            

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                stack.push(new Point(i, col));

                if (solveNQUtil(board, col + 1, stack))
                    return true;

                board[i][col] = 0; //BACKTRACK
                stack.pop();
            }
        }
        return false;
    }

    boolean solveNQ() {
        int board[][] = new int[N][N];
        Stack<Point> stack = new Stack<>();

        if (!solveNQUtil(board, 0, stack)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String args[]) {
        Chap5_Test_QueenEight_revised3 Queen = new Chap5_Test_QueenEight_revised3();
        Queen.solveNQ();
    }
}
