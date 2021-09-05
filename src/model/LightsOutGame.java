package model;

public class LightsOutGame {

	private boolean board[][] ;
	private int movements;
	
	public LightsOutGame(int size) {
		
		checkSizeValue(size);
		board = new boolean[size][size];
		this.movements = 0;
	}
	
	public void generateLights(int row, int column) {
		int rowUse = row;
		int columnUse = column; 
		
		addLight(row, column);
		//System.out.println(row + "+" + column);
		
		addLight(row-1, column);
		//System.out.println(row + "+" + column);
		row = rowUse;
		column = columnUse;
		
		addLight(row+1, column);
		//System.out.println(row + "+" + column);
		row = rowUse;
		column = columnUse;
		
		addLight(row, column+1);
		//System.out.println(row + "+" + column);
		row = rowUse;
		column = columnUse;
		
		addLight(row, column-1);
		//System.out.println(row + "+" + column);
		row = rowUse;
		column = columnUse;
				
	}
	
	public void removeLights(int row, int column) {
		if(!checkNumbers(row, column)) {
			removeLight(row, column);
		}
		if(!checkNumbers(row-1, column)) {
			removeLight(row-1, column);
		}
		if(!checkNumbers(row+1, column)) {
			removeLight(row+1, column);
		}
		if(!checkNumbers(row, column+1)) {
			removeLight(row, column+1);
		}
		if(!checkNumbers(row, column-1)) {
			removeLight(row, column-1);
		}		
	}
	
	public boolean giveMeLight(int row, int column) {
		checkNumbers(row, column);
		return getBoard()[row][column];
	}
	
	public void oneMovement() {
		setMovements(getMovements()+1);
	}
	public int getBoardSize() {
		return getBoard().length;
	}
	
	//Privates methods and simple checks
	
	private void removeLight(int row, int column) {
		if (!giveMeLight(row, column)) {
			getBoard()[row][column] = true;
		}
		getBoard()[row][column] = false;
	}

	private void addLight(int row, int column) {
		if (!checkNumbers(row, column)) {
			if (giveMeLight(row,column)) {
				getBoard()[row][column] = false;
			}
			getBoard()[row][column] = true;			
		}
		
	}

	private boolean checkNumbers(int numberOne, int numberTwo) {		
		return numberOne < 0 || numberTwo < 0 || 
				numberOne > getBoard().length || numberTwo > getBoard().length;
	}

	private void checkSizeValue(int size) {
		if(size < 4) {
			throw new IllegalArgumentException("The board size, it cant be less than four. ");
		}		
	}
		
	//Getters and Setters

	public boolean[][] getBoard() {
		return board;
	}

	public void setBoard(boolean[][] board) {
		this.board = board;
	}

	public int getMovements() {
		return movements;
	}

	public void setMovements(int movements) {
		if (movements < 0) {
			throw new RuntimeException("The value of movement cant be less than zero. ");
		}
		this.movements = movements;
	}
	
}
