package assignment5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author admin TestNQueenProblem tests the method of class NQueenProblem
 */
public class TestNQueenProblem {
	NQueenProblem Queen = new NQueenProblem();

	/**
	 * solveNQueenTestzero method tests the solveNQueen method by passing the value
	 * of N=0
	 */
	@Test
	public void solveNQueenTestzero() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int N = 0;
		assertEquals(false, Queen.solveNQueen(board, 0, N));
	}

	/**
	 * solveNQueenTestNullArray method tests the solveNQueen method by passing the
	 * null array
	 */
	@Test
	public void solveNQueenTestNullArray() {
		int board[][] = {};
		int N = 0;
		assertEquals(false, Queen.solveNQueen(board, 0, N));
	}

	/**
	 * solveNQueenTestNegative method tests the solveNQueen method by passing
	 * negative value of N
	 */
	@Test
	public void solveNQueenTestNegative() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int N = -1;
		assertEquals(false, Queen.solveNQueen(board, 0, N));
	}

	/**
	 * solveNQueenTestNotExist method tests the solveNQueen method by passing board
	 * such that its solution is not possible
	 */
	@Test
	public void solveNQueenTestNotExist() {
		int board[][] = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 } };
		int N = 6;
		assertEquals(false, Queen.solveNQueen(board, 0, N));
	}

	/**
	 * solveNQueenTestUnequalBoardLengthAndN method tests the solveNQueen method by
	 * passing board length and N different
	 */
	@Test
	public void solveNQueenTestUnequalBoardLengthAndN() {
		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int N = 6;
		assertEquals(false, Queen.solveNQueen(board, 0, N));
	}

	/**
	 * solveNQueenTestPositive1 method tests the solveNQueen method by passing the
	 * parameter values for which the solution exists
	 */
	@Test
	public void solveNQueenTestPositive1() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int N = 4;
		assertEquals(true, Queen.solveNQueen(board, 0, N));
	}

	/**
	 * solveNQueenTestPositive2 method tests the solveNQueen method by passing the
	 * parameter values for which the solution exists
	 */
	@Test
	public void solveNQueenTestPositive2() {
		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int N = 5;
		assertEquals(true, Queen.solveNQueen(board, 0, N));
	}

}
