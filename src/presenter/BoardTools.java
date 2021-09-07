package presenter;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JFrame;
import model.LightsOutGame;
import view.Lights;

public class BoardTools { //It has only statics methods	
	
	public static void initializeFrame(JFrame frame, GridLayout grid, Panel panel) {
		
		//Frame
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setResizable(false);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//Grid
		panel.setLayout(grid);
		
		//Latest settings of the frame		
		frame.setLayout(null);
		frame.setTitle("Lights out, the game");
		frame.getContentPane().add(panel);
		
	}
	

	public static Lights[][] addLights(JFrame frame, MainPresenter board, GridLayout grid, Panel panel, Contract.View view) {
		Lights[][] lights = new Lights[board.boardSize()][board.boardSize()];
		for (int i = 0; i< board.boardSize(); i++){
			for (int j = 0; j<board.boardSize(); j++) {
				if(board.haveLight(i, j)) {
					Lights light = new Lights(true, i , j, view);
					panel.add(light.getButton());
					lights[i][j] = light;					
				}
				else {
					Lights light = new Lights(false, i, j, view);				
					panel.add(light.getButton());
					lights[i][j] = light;
				}				
			}
		}
		return lights;
	}

	public static void boardDimension(JFrame frame, int size) {
						
		if (size >= 4) {
			frame.setBounds(100, 100, 800, 700);
		}
		else {
			throw new RuntimeException("Error while the frame dimensions was building ");
		}
	}

	public static GridLayout setGridSize(GridLayout grid2, int size) {
		
		return new GridLayout(size,size, 5, 5);
		
	}

	
}
