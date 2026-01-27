package chess;
import chess.pieces.Piece;
public class Cell{
	public final int row;
	public final int col;
	public Piece piece;

	public Cell(int row, int col){
		this.row = row;
		this.col = col;
	}

	public Piece getPiece(){
		return piece;
	}
	public void setPiece(Piece piece){
		this.piece = piece;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	public boolean isOccupied(){
		return piece!=null;
	}

}
