package chess.pieces;

import chess.*;

public class King extends Piece{
	public King(Color color){
		super(color);
	}
	
	@Override
	public boolean canMove(Board board , Cell from , Cell to){
		int rowDiff = Math.abs(from.getRow() - to.getRow());
		int colDiff = Math.abs(from.getCol() - to.getCol());
		return (rowDiff <=1 && colDiff <=1);
	}


}
