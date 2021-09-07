package presenter;

import model.LightsOutGame;

public class MainPresenter implements Contract.Presenter{
	
	//private LightsOutGame board;
	private Contract.Model model;
	private Contract.View view;
	
	public MainPresenter(int sizeOfBoard, Contract.View view){
		
		this.view = view;
		model = new LightsOutGame(sizeOfBoard, this);
		//board = new LightsOutGame(sizeOfBoard, this);		
	}

	@Override
	public void onButtonLight(int posX, int posY) {
		// TODO Auto-generated method stub
		generateLights(posX, posY);
		
	}

	public void generateLights(int posX, int posY) {
		// TODO Auto-generated method stub
		model.generateLights(posX, posY);
	}

	@Override
	public int boardSize() {
		// TODO Auto-generated method stub
		return model.getBoardSize();
	}

	@Override
	public LightsOutGame board() {
		// TODO Auto-generated method stub
		return model.getAll();
	}

	@Override
	public boolean haveLight(int x, int y) {
		// TODO Auto-generated method stub
		return model.giveMeLight(x, y);
	}

	@Override
	public void updateLights(int posX, int posY, boolean status) {
		// TODO Auto-generated method stub
		view.changeLight(posX, posY, status);
	}

	@Override
	public void updateMovements(int movements) {
		// TODO Auto-generated method stub
		view.updateMovements(movements);
		
	}

	@Override
	public void oneMovement() {
		// TODO Auto-generated method stub
		model.oneMovement();
	}


	

}
