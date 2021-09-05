package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;

import model.LightsOutGame;
import presenter.BoardTools;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;

public class GameBoard {

	private  JFrame frame;
	private  GridLayout grid;
	private  LightsOutGame board;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameBoard window = new GameBoard();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		board = new LightsOutGame(6);
		board.generateLights(5, 5);
		//grid = new GridLayout();		
		frame = new JFrame();
		Panel panel = new Panel();
		
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	    
	    //Set panel
	    panel.setBounds(100, 600, 400, 400);
	    panel.setPreferredSize(new Dimension(200, 200));
	    
		//Board Tools
		grid = BoardTools.setGridSize(grid, board, panel);		
		BoardTools.boardDimension(frame, board);		
		BoardTools.addLights(frame, board, grid, panel);
		BoardTools.initializeFrame(frame, grid, panel);
		
		//Adding layouts
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    //lblNewLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
	    //lblNewLabel.setBounds(129, 11, 679, 57);
		lblNewLabel.setLocation(20, 20);
		lblNewLabel.setSize(20,460);
	    //frame.getContentPane().add(lblNewLabel);
	    
	    
		//frame.getContentPane().add(lblNewLabel, grid.a);
		
		
	}

}
