package chess;

import chess.pieces.*;

public class Board{
	public final Cell[][] board;

	public Board(){
		board = new Cell[8][8];
		
		for(int row =0;row<8;row++){
			for(int col=0;col<8;col++){
				board[row][col] = new Cell(row, col);

			}
		}
		setupPieces();
	}
	private void setupPieces(){
		for(int j=0;j<8;j++){
			board[1][j].setPiece(new Pawn(Color.WHITE));
			board[6][j].setPiece(new Pawn(Color.BLACK));
		}
		board[0][0].setPiece(new Rook(Color.WHITE));
		board[0][1].setPiece(new Knight(Color.WHITE));
		board[0][2].setPiece(new Bishop(Color.WHITE));
		board[0][3].setPiece(new Queen(Color.WHITE));
		board[0][4].setPiece(new King(Color.WHITE));
		board[0][5].setPiece(new Bishop(Color.WHITE));
		board[0][6].setPiece(new Knight(Color.WHITE));
		board[0][7].setPiece(new Rook(Color.WHITE));
		

		board[6][0].setPiece(new Rook(Color.BLACK));
		board[6][1].setPiece(new Knight(Color.BLACK));
		board[6][2].setPiece(new Bishop(Color.BLACK));
		board[6][3].setPiece(new Queen(Color.BLACK));
		board[6][4].setPiece(new King(Color.BLACK));
		board[6][5].setPiece(new Bishop(Color.BLACK));
		board[6][6].setPiece(new Knight(Color.BLACK));
		board[6][7].setPiece(new Rook(Color.BLACK));
	}
	public Cell getCell(int row ,int col){
		return board[row][col];
	}
	public Piece getPiece(int row, int col){
		return board[row][col].getPiece();
	}
	public void setPiece(int row, int col, Piece piece){
		board[row][col].setPiece(piece);
	}
	public boolean isCheckmate(Color color){
		return false;
	}
	public boolean isStalemate(Color color){
		return false;
	}
	public synchronized boolean movePiece(Move move){
		Cell from = move.getStart();
		Cell to = move.getEnd();
		Piece piece = from.getPiece();
		if(piece==null || !piece.canMove(this,from,to)) return false;
		to.setPiece(piece);
		from.setPiece(null);
		return true;
	}
}

