import java.util.Scanner;

public class Driver {
	
	// X's turn is true, O's turn is false
	public static boolean xTurn = true;
	public static Board board = new Board();
	
	public static void main(String[] args) {
		board.drawBoard();

		Scanner reader = new Scanner(System.in);
		
		while(true) {
			
			if(xTurn) System.out.print("Place an X on the board: ");
			else System.out.print("Place an O on the board: ");
			
			int boardId = reader.nextInt();
			int bigRowNum = boardId  / 10;
			int bigColNum = boardId % 10;
			
			board.drawSubBoard(bigRowNum, bigColNum);
			System.out.print("Which position? ");
			int cellId = reader.nextInt();
			int rowNum = cellId / 10;
			int colNum = cellId % 10;
			
			if(xTurn) {
				board.setX(bigRowNum, bigColNum, rowNum, colNum);
			} else {
				board.setO(bigRowNum, bigColNum, rowNum, colNum);
			}
			
			xTurn = !xTurn; // switch turns
			
			board.drawBoard();
		}
	}

}
