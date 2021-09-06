package presenter;

public interface Contract {
	
	interface View{
		public void onButtonClicked();
		public void onButtonResetClicked();
		public void updateGrid();		
	}
	
	interface Presenter{
		public void onButtonLight(int posX, int posY);
		public void updateMovements();
				
	}

	interface Model{
		
		public boolean giveMeLight(int posX, int posY);
		public void generateLights(int row, int column);
		public void oneMovement();
		public int getBoardSize();
		public void setWinner(boolean winner);
		public boolean isWinner();
	}
}
