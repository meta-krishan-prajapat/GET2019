package assignment5;

/**
 * @author krishan Implement N Queens Problem using Recursion
 * 
 *         The N Queen is the problem of placing N chess queens on an N×N
 *         chessboard so that no two queens attack each other.
 * 
 */
public class NQueenProblem {

	/**
	 * @param board
	 * @param N     is the no. of Queens to be placed on N*N matrix printSolution is
	 *              a function to print solution
	 */
	void printSolution(int board[][], int N) {
		try {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					System.out.print(" " + board[i][j] + " ");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param board
	 * @param row
	 * @param column
	 * @param N      is the no. of Queens to be placed on N*N matrix
	 * @return true if queen can be placed in the given row and column else return
	 *         false
	 */
	boolean CheckSafePosition(int board[][], int row, int column, int N) {
		int i, j;
		try {

			/* Check this row on left side */
			for (i = 0; i < column; i++)
				if (board[row][i] == 1)
					return false;

			/* Check upper diagonal on left side */
			for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
				if (board[i][j] == 1)
					return false;

			/* Check lower diagonal on left side */
			for (i = row, j = column; j >= 0 && i < N; i++, j--)
				if (board[i][j] == 1)
					return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @param board
	 * @param column
	 * @param N      is the no. of Queens to be placed on N*N matrix
	 * @return true if queens are placed at their required position
	 */
	boolean solveNQueen(int board[][], int column, int N) {
		try {
			if (N > 0 && board.length == N) {

				/*
				 * base case: If all queens are placed then return true
				 */
				if (column >= N)
					return true;

				/*
				 * Consider this column and try placing this queen in all rows one by one
				 */
				for (int i = 0; i < N; i++) {
					/*
					 * Check if the queen can be placed on board[i][column]
					 */
					if (CheckSafePosition(board, i, column, N)) {
						/* Place this queen in board[i][col] */
						board[i][column] = 1;

						/* recur to place rest of the queens */
						if (solveNQueen(board, column + 1, N) == true)
							return true;

						/*
						 * If placing queen in board[i][column] doesn't lead to a solution then remove
						 * queen from board[i][column]
						 */
						board[i][column] = 0; // BACKTRACK
					}
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * If the queen can not be placed in any row in this column 'column', then
		 * return false
		 */
		return false;
	}

	public static void main(String args[]) throws Exception {
		NQueenProblem Queen = new NQueenProblem();
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int N = 4;
		if (Queen.solveNQueen(board, 0, N) == true) {

			Queen.printSolution(board, N);
			System.out.println();
		} else {
			System.out.print("Solution does not exist");
		}

	}
}