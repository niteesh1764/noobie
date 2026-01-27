package chess.pieces;

import chess.*;

public class Bishop extends Piece{
	public Bishop(Color color){
		super(color)
	}
	@Override
	public boolean canMove(Board board , Cell from, Cell to){
		int rowDiff = Math.abs(from.getRow() - to.getRow());
		int colDiff = Math.abs(from.getCol() - to.getCol());

		return (rowDiff == colDiff);

	}
}
