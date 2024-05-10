package suduko.problemdomain;

import java.io.Serializable;

import suduko.constant.Gamestate;

public class SudukoGame implements Serializable {
	
	
	private final Gamestate gameState;
	private final int[][] gridState;
	private static final int GRID_BOUNDARY = 9;
	public SudukoGame(Gamestate gameState, int[][] gridState) {
		this.gameState = gameState;
		this.gridState = gridState;
	}
	public Gamestate getGameState() {
		return gameState;
	}
	public int[][] getCopyOfGridState() {
		return SudokuUtilities.copyToNewArray(gridState);
	}

}
