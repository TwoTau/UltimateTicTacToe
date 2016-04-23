import java.util.Scanner;

public class Driver {
	
	// X's turn is true, O's turn is false
	public static boolean xTurn = true;
	
	// initialize the 9x9 array (which is actually a (3x3)x(3x3) array)
	public static int[][] board =
		   {{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0},
			{0, 0, 0,  0, 0, 0,  0, 0, 0}};
	
	public static char getLetter(int bigRow, int bigColumn, int row, int column) {
		int number = board[3*bigRow + row][3*bigColumn + column];
		if(number == 1) {
			return 'X';
		} else if(number == -1) {
			return 'O';
		}
		return ' ';
	}
	
	public static void drawSubBoard(int row, int column) {
		System.out.println("|---|---|---|");
		System.out.println("| " + getLetter(row, column, 0, 0) + " | " + getLetter(row, column, 0, 1) + " | " + getLetter(row, column, 0, 2) + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + getLetter(row, column, 1, 0) + " | " + getLetter(row, column, 1, 1) + " | " + getLetter(row, column, 1, 2) + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + getLetter(row, column, 2, 0) + " | " + getLetter(row, column, 2, 1) + " | " + getLetter(row, column, 2, 2) + " |");
		System.out.println("|---|---|---|");
	}
	
	public static void drawBoard() {
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
	
	public static void main(String[] args) {
		drawBoard();

		Scanner reader = new Scanner(System.in);
		
		while(true) {
			
			if(xTurn) System.out.print("Place an X on the board: ");
			else System.out.print("Place an O on the board: ");
			
			int boardId = reader.nextInt();
			int bigRowNum = boardId  / 10;
			int bigColNum = boardId % 10;
			
			drawSubBoard(bigRowNum, bigColNum);
			System.out.print("Which position? ");
			int cellId = reader.nextInt();
			int rowNum = cellId / 10;
			int colNum = cellId % 10;
			
			board[bigRowNum*3 + rowNum][bigColNum*3 + colNum] = (xTurn) ? 1 : -1;
			
			xTurn = !xTurn; // switch turns
			
			drawBoard();
		}
	}

}
