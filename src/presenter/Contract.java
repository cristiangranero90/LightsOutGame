package presenter;

import model.LightsOutGame;

public interface Contract {
		
	interface View{
		public void onButtonClicked(int posX, int posY);
		public void onButtonResetClicked();
		public void updateGrid();	
		public void changeLight(int posX, int posY, boolean status);
		public void updateMovements(int movements);
		public void comboItem(String item);
		public void updateView();
		public void building();		
	}
	
	interface Presenter{
		public void onButtonLight(int posX, int posY);
		public void updateMovements(int movements);
		public void oneMovement();
		public void generateLights(int posX, int posY);
		public int boardSize();
		public boolean hasLight(int posX, int posY);
		public LightsOutGame board();
		public void updateLights(int posX, int posY, boolean status);
		public void selectedCombo(String item);
		public void comunicateBuilding();				
	}

	interface Model{				
		public boolean giveMeLight(int posX, int posY);
		public void generateLights(int row, int column);
		public void oneMovement();
		public int getBoardSize();
		public void setWinner(boolean winner);
		public boolean isWinner();
		public LightsOutGame getAll();
		public void setBuildBoard();		
	}
}
