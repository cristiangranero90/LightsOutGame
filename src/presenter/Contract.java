package presenter;

public interface Contract {
	
	interface View{
		public void onButtonClicked();
		public void viewIsNotifiying();
		public void viewUpdater();
	}
	
	interface Presenter{
		
	}

	interface Model{
		
	}
}
