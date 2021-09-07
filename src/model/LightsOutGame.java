package model;

import java.util.Random;

import presenter.Contract;

public class LightsOutGame implements Contract.Model {

	private boolean board[][] ;
	private int movements;
	private boolean winner;	
	private Contract.Presenter presenter;

	public LightsOutGame(int size, Contract.Presenter presenter) {
		
		this.presenter = presenter;
		checkSizeValue(size);
		board = new boolean[size][size];
		setMovements(0);
		setWinner(false);
		random();
	}
	
	//The best way for iterators
	public void generateLights(int row, int column) {
		
		if(!checkNumbers(row, column)) {
			addLight(row, column);			
		}
		if(!checkNumbers(row-1, column)) {
			addLight(row-1, column);
		}
		if(!checkNumbers(row+1, column)) {
			addLight(row+1, column);
		}
		if(!checkNumbers(row, column+1)) {
			addLight(row, column+1);
		}
		if(!checkNumbers(row, column-1)) {
			addLight(row, column-1);
		}		
				
	}
	//Returns the light boolean of the values specificated  
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
		
		Random ran = new Random();
		for(int i = 0; i<getBoardSize()-3; i++) {
			int posX = ran.nextInt(getBoard().length);
			int posY = ran.nextInt(getBoard().length);
			generateLights(posX, posY);
		}		
	}

	private void addLight(int row, int column) {
				
		if (!checkNumbers(row, column)) {
			if (giveMeLight(row,column)) {
				getBoard()[row][column] = false;
				presenter.updateLights(row, column, false);
			}
			else {
				getBoard()[row][column] = true;
				presenter.updateLights(row, column, true);
			}			
		}
		
	}

	private boolean checkNumbers(int numberOne, int numberTwo) {		
		return numberOne < 0 || numberTwo < 0 || 
				numberOne > getBoardSize()-1 || numberTwo > getBoardSize()-1;
	}

	private void checkSizeValue(int size) {
		if(size < 4) {
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

	@Override
	public LightsOutGame getAll() {
		// TODO Auto-generated method stub
		return this;
	}
	
}
