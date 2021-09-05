package presenter;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;

import model.LightsOutGame;
import view.Lights;

public class BoardTools {
		
	
	public static void initializeFrame(JFrame frame, GridLayout grid, Panel panel) {
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setResizable(false);	
		//frame.setVisible(true);
		//frame.getContentPane().setLayout(grid);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);
		panel.setLayout(grid);
		//panel.setB
		frame.getContentPane().add(panel);
		
	}
	

	public static void addLights(JFrame frame, LightsOutGame board, GridLayout grid, Panel panel) {
		for (int i = 0; i<board.getBoardSize(); i++){
			for (int j = 0; j<board.getBoardSize(); j++) {
				if(board.giveMeLight(i, j)) {
					Lights light = new Lights(true, i , j);
					//button.setBounds(i, j, 30, 30);
					//grid.addLayoutComponent("", light.getButton());
					panel.add(light.getButton());
				}
				else {
					Lights light = new Lights(false, i, j);				
					panel.add(light.getButton());
					//grid.addLayoutComponent("", light.getButton());
				}
				
			}
		}
	}

	public static void boardDimension(JFrame frame, LightsOutGame board) {
		
		int size = board.getBoardSize();
		
		if (size == 4) {
			frame.setBounds(100, 100, 800, 600);
		}
		if (size == 5) {
			frame.setBounds(100, 100, 800, 700);
		}
		if (size == 6) {
			frame.setBounds(100, 100, 900, 700);
		}
		else {
			throw new RuntimeException("Error while is building the frame dimensions");
		}
	}

	public static GridLayout setGridSize(GridLayout grid2, LightsOutGame board, Panel panel) {
		
		return new GridLayout(board.getBoardSize(), board.getBoardSize(), 5, 5);
		
	}

	
}
