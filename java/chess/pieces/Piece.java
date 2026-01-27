package chess.pieces;

import chess.*;

public abstract class Piece{
	public Color color;

	public Piece(Color color){
		this.color = color;
	}
	public abstract boolean canMove(Board board , Cell from , Cell to);

	public Color getColor(){
		return color;
	}
}

