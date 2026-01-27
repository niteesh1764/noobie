package chess;
import chess.pieces.Piece;
import java.util.Scanner;

public class ChessGame{
	private final Board board;
	public Player whitePlayer, blackPlayer;
	public Player currentPlayer;

	public ChessGame(){
		board = new Board();
	}

	public void setPlayers(String whitePlayerName , String blackPlayerName){
		this.whitePlayer = new Player(whitePlayerName , Color.WHITE);
		this.blackPlayer = new Player(blackPlayerName, Color.BLACK);
		this.currentPlayer = whitePlayer;
	}
	public void switchTurn(){
		currentPlayer = currentPlayer == whitePlayer? blackPlayer : whitePlayer;
	}
	public boolean isGameOver(){
		return board.isStalemate(whitePlayer.getColor()) || board.isStalemate(blackPlayer.getColor()) || board.isCheckmate(whitePlayer.getColor()) || board.isCheckmate(blackPlayer.getColor());
	}
	public void start(){
		while(!isGameOver()){
			Player player = currentPlayer;
			System.out.println(player.getName() + "'s Turn");
			Move move = getPlayerMove(player);
			try{
				board.movePiece(move);
			}catch(InvalidMoveException e){
				System.out.println(e.getMessage() + "Try Again");
				continue;
			}
			switchTurn();
		}
		displayResult();
	}
	private void displayResult() {
		if (board.isCheckmate(Color.WHITE)) {
		    System.out.println("Black wins by checkmate!");
		} else if (board.isCheckmate(Color.BLACK)) {
		    System.out.println("White wins by checkmate!");
		} else if (board.isStalemate(Color.WHITE) || board.isStalemate(Color.BLACK)) {
		    System.out.println("The game ends in a stalemate!");
		}
	}
	private Move getPlayerMove(Player player) {
		// For simplicity, let's assume the player enters the move via console input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter source row: ");
		int sourceRow = scanner.nextInt();
		System.out.print("Enter source column: ");
		int sourceCol = scanner.nextInt();
		System.out.print("Enter destination row: ");
		int destRow = scanner.nextInt();
		System.out.print("Enter destination column: ");
		int destCol = scanner.nextInt();

		Piece piece = board.getPiece(sourceRow, sourceCol);
		if (piece == null || piece.getColor() != player.getColor()) {
		    throw new IllegalArgumentException("Invalid piece selection!");
		}

		return new Move(board.getCell(sourceRow, sourceCol), board.getCell(destRow, destCol));
	}
}
