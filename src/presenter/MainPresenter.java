package presenter;

import model.LightsOutGame;


public class MainPresenter implements Contract.Presenter{
	
	private Contract.Model model;
	private Contract.View view;
	
	public MainPresenter(int sizeOfBoard, Contract.View view){		
		this.view = view;
		model = new LightsOutGame(sizeOfBoard, this);
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

	@Override
	public void selectedCombo(String item) {
		System.out.println("INFO: Selected item: "+ item);
		
		switch (item){
			case "Beginner": updateAll(4);
			break;
			
			case "Medium": updateAll(5);
			break;
			
			case "Advanced": updateAll(6);
			break;
			
			case "Extreme": updateAll(8);
			break;
			
			default: throw new RuntimeException("Level Invalid");		
		}
	}

	private void updateAll(int i) {
		
		MainPresenter other = new MainPresenter(i, this.view);
		try {
			this.model = other.board();
		} catch (Exception e){
			System.out.println("Error creating a new board. ");
		}
		view.updateView();		
	}

	@Override
	public void comunicateBuilding() {
		// TODO Auto-generated method stub
		model.setBuildBoard();
	}
}
