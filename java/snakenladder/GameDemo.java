package snakenladder;

import snakenladder.entities.*;
import java.util.*;

public class GameDemo{
	public static void main(String[] args){
		List<BoardEntity> boardEntities = List.of(
			new Snake(17,7), new Snake(54,34),
			new Snake(96,63), new Ladder(4,54),
			new Ladder(34,64));
		List<String> players = Arrays.asList("Alice", "Bob");

		Game game = new Game.Builder()
			.setBoard(100, boardEntities)
			.setPlayers(players)
			.setDice(new Dice(1,6))
			.build();

		game.play();
	}
}

