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
		checkSizeValue(size);
		board = new boolean[size][size];
		setMovements(0);
		setWinner(false);
		setWinCount(1);
		random();		
	}
	
	//The best way for iterators
	public void generateLights(int row, int column) {		
		
			addLight(row, column);			
		
			addLight(row-1, column);
		
			addLight(row+1, column);
		
			addLight(row, column+1);
		
			addLight(row, column-1);					
	}
	
	//Returns the light boolean of the specified values 
	public boolean giveMeLight(int row, int column) {
		checkNumbers(row, column);
		return getBoard()[row][column];
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
		Random ran = new Random();
		for(int i = 0; i<getBoardSize()-3; i++) {
			int posX = ran.nextInt(getBoard().length);
			int posY = ran.nextInt(getBoard().length);
			generateLights(posX, posY);
		}
		setBuildBoard();
	}

	private void addLight(int row, int column) {				
		
		if (!checkNumbers(row, column)) {
			if (giveMeLight(row,column)) {
				getBoard()[row][column] = false;
				publishCount(-1);					
				if (!isBuildBoard()) {						
					presenter.updateLights(row, column, false);
				}				
			}
			else {
				publishCount(1);
				getBoard()[row][column] = true;				
				if (!isBuildBoard()) {					
					presenter.updateLights(row, column, true);
				}				
			}
		}
	}

	private void publishCount(int num) {
		int boardComplete = getBoardSize() * getBoardSize();
		setWinCount(getWinCount() + num);
		if (getWinCount() == boardComplete) {
			System.out.print(toString());
			System.out.println("Winner");
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
	private boolean allTrues() {
		boolean acum = true;
		for (int i = 0; i<getBoardSize(); i++) {
			for (int j = 0; j<getBoardSize(); j++) {
				acum = acum && giveMeLight(i,j);
			}
		}
		return acum;
	}

	private boolean isBuildBoard() {
		return buildBoard;
	}
	
	//Some Contract methods

	@Override
	public void setBuildBoard() {
		if (this.buildBoard) {
			this.buildBoard = false;
		}else {
			this.buildBoard = true;
		}
	}

	@Override
	public LightsOutGame getAll() {
		// TODO Auto-generated method stub
		return this;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}
	
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
