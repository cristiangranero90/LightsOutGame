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
		board.generateLights(4, 3);
		//grid = new GridLayout();		
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel panel = new Panel();
	    frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		grid = BoardTools.setGridSize(grid, board);
		BoardTools.initializeFrame(frame, grid, panel);
		BoardTools.boardDimension(frame, board);
		
		BoardTools.addLights(frame, board, grid, panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(129, 11, 679, 57);
	    //frame.getContentPane().add(lblNewLabel);
	    
	    
		//frame.getContentPane().add(lblNewLabel, grid.a);
		
		
	}

}
