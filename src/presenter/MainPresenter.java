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
		generateLights(posX, posY);		
	}

	public void generateLights(int posX, int posY) {
		model.generateLights(posX, posY);
	}

	@Override
	public int boardSize() {
		return model.getBoardSize();
	}

	@Override
	public LightsOutGame board() {
		return model.getAll();
	}

	@Override
	public boolean hasLight(int x, int y) {
		return model.giveMeLight(x, y);
	}

	@Override
	public void updateLights(int posX, int posY, boolean status) {
		view.changeLight(posX, posY, status);
	}

	@Override
	public void updateMovements(int movements) {
		view.updateMovements(movements);		
	}

	@Override
	public void oneMovement() {
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
			
			case "Very Sick": updateAll(10);
			break;
			
			default: throw new RuntimeException("Level Invalid");		
		}
	}

	private void updateAll(int i) {		
			
		try {
			MainPresenter other = new MainPresenter(i, this.view);	
			this.model = other.board();
		} catch (Exception e){
			System.err.println(e.toString());
		}
		view.updateView();		
	}

	@Override
	public void comunicateBuilding() {
		model.setBuildBoard();
	}
}
