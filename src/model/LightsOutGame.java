package model;

import java.util.Random;

import presenter.Contract;

public class LightsOutGame implements Contract.Model {

	private boolean board[][] ;
	private int movements;
	private boolean winner;	
	private int winCount;
	private Contract.Presenter presenter;
	private boolean buildBoard;

	public LightsOutGame(int size, Contract.Presenter presenter) {
		
		this.presenter = presenter;
		this.buildBoard = false;
		this.winCount = size * size;
		checkSizeValue(size);
		board = new boolean[size][size];
		random();	
		setMovements(0);
		setWinner(false);		
	}
	
	//The best way for iterators
	public void generateLights(int row, int column) {		
								
			addLight(row-1, column);
		
			addLight(row+1, column);
		
			addLight(row, column+1);
		
			addLight(row, column-1);
			
			addLight(row, column);	
			
			viewWin();
	}
	
	//Returns the light boolean of the specified values 
	public boolean giveMeLight(int row, int column) {
		if (!checkNumbers(row, column)) {
			return getBoard()[row][column];
		}
		else {
			throw new RuntimeException("Error with numbers. ");
		}		
	}
	
	public void oneMovement() {
		setMovements(getMovements()+1);
		presenter.updateMovements(getMovements());
	}
	
	public int getBoardSize() {
		return getBoard().length;
	}
	
	//Privates methods for a simple checks and others functions	
	private void random() {		
		setBuildBoard(); //Its a flag to not warn changes to the view (Like a Mutex)
		
		int posX = 0;
		int posY = 0;
		Random ran = new Random();
		for(int i = 0; i<getBoardSize(); i++) {
			posX = ran.nextInt(getBoard().length);
			posY = ran.nextInt(getBoard().length);
			//generateLights(posX,posY);
			addLight(posX, posY);
		}
		setBuildBoard();
	}

	private void addLight(int row, int column) {		
		if (!checkNumbers(row, column)) {			
			if (!giveMeLight(row,column)) {				
				getBoard()[row][column] = true;
				publishCount(1);
				if (!isBuildBoard()) {					
					presenter.updateLights(row, column, true);
				}				
			}
			else {				
				getBoard()[row][column] = false;	
				publishCount(-1);				
				if (!isBuildBoard()) {					
					presenter.updateLights(row, column, false);
				}				
			}
		}		
	}

	private void publishCount(int num) {		
		setWinCount(getWinCount() + num);
	}
	
	private void viewWin() {
		int boardComplete = getBoardSize() * getBoardSize();
		if (getWinCount() == boardComplete && allFalses()) {
			setWinner(true);
			comunicateWinner();
		}
	}

	private boolean checkNumbers(int numberOne, int numberTwo) {		
		return numberOne < 0 || numberTwo < 0 || 
				numberOne > getBoardSize() - 1|| 
				numberTwo > getBoardSize() - 1;
	}

	private void checkSizeValue(int size) {
		if(size < 4 || size > 10) {
			throw new IllegalArgumentException("The board size, it cant be less than four. ");
		}		
	}
		
	//Getters and Setters
	
	private boolean allFalses() {
		boolean falseContainer = false;
		for (int i = 0; i<getBoardSize(); i++) {
			for (int j = 0; j<getBoardSize(); j++) {
				falseContainer = falseContainer || giveMeLight(i,j);
			}
		}
		//System.out.println("All falses count: " + falseContainer);
		return !falseContainer;
	}

	//Some Contract methods
	
	private boolean isBuildBoard() {
		return buildBoard;
	}

	private int getWinCount() {
		return this.winCount;
	}

	private void setWinCount(int num) {
		this.winCount = num;
	}

	@Override
	public void comunicateWinner() {
		presenter.winnerEncounter();		
	}

	//Some Contract methods
	
	@Override
	public LightsOutGame getAll() {
		// TODO Auto-generated method stub
		return this;
	}

	//Some Contract methods

	public void setBuildBoard() {
		if (this.buildBoard) {
			this.buildBoard = false;
		}else {
			this.buildBoard = true;
		}
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

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
			throw new RuntimeException("The value of movements cannot be less than zero. ");
		}
		this.movements = movements;
	}
	
	
	//Some Contract methods

	@Override
	public String toString() {
		StringBuilder stringTable = new StringBuilder();
		for (int i=0; i<getBoardSize(); i++) {
			for (int j=0; j<getBoardSize(); j++) {
				if(j == getBoardSize()) {
					stringTable.append(giveMeLight(i, j) + "\n");
				}else {
					stringTable.append(giveMeLight(i,j) +" ");
				}				
			}
		}		
		return stringTable.toString();
	}	
}
