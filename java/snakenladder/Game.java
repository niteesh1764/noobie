package snakenladder;

import snakenladder.entities.*;
import snakenladder.enums.*;

import java.util.*;

public class Game{
	private final Dice dice;
	private final Board board;
	private GameStatus status;
	private final Queue<Player> players;
	private Player winner;

	public Game(Builder builder){
		this.board = builder.board;
		this.players = new LinkedList<>(builder.players);
		this.dice = builder.dice;
		this.status = GameStatus.NOT_STARTED;

	}
	
	public static class Builder{
		private Board board;
		private Queue<Player> players;
		private Dice dice;

		public Builder setBoard(int boardSize , List<BoardEntity> boardEntities){
			this.board = new Board(boardSize , boardEntities);
			return this;
		}

		public Builder setDice(Dice dice){
			this.dice = dice;
			return this;
		}
		public Builder setPlayers(List<String> playerNames){
			this.players = new LinkedList<>();
			for (String player : playerNames){
				players.add(new Player(player));
			}
			return this;
		}
		public Game build(){
			if(board == null || players == null || dice == null) {
				throw new IllegalArgumentException("Board, Players and Dice must be set");
			}
			return new Game(this);
		}
	}

	public void play(){
		if(players.size() < 2) {
			System.out.println("Cannot Start Game without atleast 2 PLayers");
			return;
		}
		this.status  = GameStatus.RUNNING;
		System.out.println("Game Started");
		while(status == GameStatus.RUNNING){
			Player currentPlayer = players.poll();
			takeTurn(currentPlayer);

			if (status == GameStatus.RUNNING){
				players.add(currentPlayer);
			}
		}
		System.out.println("Game Finished");
		if(winner!=null){
			System.out.printf("The Winner is %s \n" , winner.getName());
		}
	}

	public void takeTurn(Player player){
		int roll = dice.roll();
		System.out.printf("\n%s's turn. Rolled a %d.\n", player.getName(), roll);

		int currentPosition = player.getPosition();
		int nextPosition = currentPosition + roll;

		if(nextPosition > board.getSize()){
			System.out.printf("Ooops, %s needs to land exactly on %d. Turn Skipped.\n" , player.getName(), board.getSize());
		}
		if(nextPosition == board.getSize()){
			player.setPosition(nextPosition);
			this.status = GameStatus.FINISHED;
			this.winner = player;
			System.out.printf("Hooray!! You are the Winner %s", player.getName());
			return;
		}
		int finalPosition = board.getFinalPosition(nextPosition);

		if(finalPosition < nextPosition){
			System.out.printf("Wow! %s found a ladder 🪜 at %d and climbed to %d.\n", player.getName(), nextPosition, finalPosition);
		}else if (finalPosition > nextPosition){
			System.out.printf("Oh no! %s was bitten by a snake 🐍 at %d and slid down to %d.\n", player.getName(), nextPosition, finalPosition);
		}else{
			System.out.printf("%s moved from %d to %d.\n", player.getName(), currentPosition, finalPosition);
		}
		player.setPosition(finalPosition);

		if(roll == 6){
			System.out.print("You rolled a 6 so you will be going again");
			takeTurn(player);
		}
	}
}
