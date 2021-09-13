package presenter;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
		frame.setTitle("Lights out ");
		
		//Adds an Icon to the frame
		try {
			frame.setIconImage(ImageIO.read(new File("src/images/light-bulb-icon.png"))
					.getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.getContentPane().add(panel);
		
	}
	

	public static Lights[][] addLights(JFrame frame, MainPresenter board, GridLayout grid, Panel panel, Contract.View view) {
		Lights[][] lights = new Lights[board.boardSize()][board.boardSize()];
		for (int i = 0; i< board.boardSize(); i++){
			for (int j = 0; j<board.boardSize(); j++) {
				if(board.hasLight(i, j)) {
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
			frame.setBounds(400, 200, 800, 650);
		}
		else {
			throw new RuntimeException("Error while the frame dimensions was building ");
		}
	}

	public static GridLayout setGridSize(GridLayout grid2, int size) {
		
		return new GridLayout(size,size, 5, 5);
		
	}

	
}
