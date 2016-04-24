public class Board {
	// initialize the 9x9 array (which is actually a (3x3)x(3x3) array)
	// 1 is X, -1 is O
	private int[][] board = {
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0}
	};
	
	public Board() {
		
	}
	
	public Board(int[][] startBoard) {
		board = startBoard;
	}
	
	public void setX(int bigRow, int bigCol, int row, int col) {
		changeCell(bigRow, bigCol, row, col, 1);
	}
	
	public void setO(int bigRow, int bigCol, int row, int col) {
		changeCell(bigRow, bigCol, row, col, -1);
	}
	
	private void changeCell(int bigRow, int bigCol, int row, int col, int newVal) {
		if(getVal(bigRow, bigCol, row, col) != 0) { // if it is filled
			System.out.println("Something went wrong");
		}
		board[3*bigRow + row][3*bigCol + col] = newVal;
	}
	
	private int getVal(int bigRow, int bigCol, int row, int col) {
		return board[3*bigRow + row][3*bigCol + col];
	}
	
	public char getLetter(int bigRow, int bigCol, int row, int col) {
		int number = getVal(bigRow, bigCol, row, col);
		if(number == 1) {
			return 'X';
		} else if(number == -1) {
			return 'O';
		}
		return ' ';
	}
	
	public void drawSubBoard(int row, int column) {
		System.out.println("|---|---|---|");
		System.out.println("| " + getLetter(row, column, 0, 0) + " | " + getLetter(row, column, 0, 1) + " | " + getLetter(row, column, 0, 2) + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + getLetter(row, column, 1, 0) + " | " + getLetter(row, column, 1, 1) + " | " + getLetter(row, column, 1, 2) + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + getLetter(row, column, 2, 0) + " | " + getLetter(row, column, 2, 1) + " | " + getLetter(row, column, 2, 2) + " |");
		System.out.println("|---|---|---|");
	}
	
	public void drawBoard() {
		for(int bigRow = 0; bigRow < 3; bigRow++) {
			System.out.println(bigRow + "0--|---|---| " + bigRow + "1--|---|---| " + bigRow + "2--|---|---|");
			
			for(int row = 0; row < 3; row++) {
				for(int col = 0; col < 3; col++) {
					System.out.print("| " + getLetter(bigRow, col, row, 0) + " | " + getLetter(bigRow, col, row, 1) + " | " + getLetter(bigRow, col, row, 2) + " | ");
				}
				System.out.println("\n|---|---|---| |---|---|---| |---|---|---|");
			}
				
			System.out.println();
		}
	}
}
