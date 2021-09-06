package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import model.LightsOutGame;
import presenter.BoardTools;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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
		//Basic
		board = new LightsOutGame(5);
		//board.generateLights(1, 1);	
		frame = new JFrame();
		Panel panel = new Panel();
		
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	    
		//Board Tools
		grid = BoardTools.setGridSize(grid, board, panel);		
		BoardTools.boardDimension(frame, board);		
		BoardTools.addLights(frame, board, grid, panel);
		BoardTools.initializeFrame(frame, grid, panel);
		
		//Set panel	    
		panel.setBounds(10, 100, 500, 500);
		//panel.setPreferredSize(new Dimension(200, 200));
		
		//Adding layouts
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Rare Label ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(100, 11, 300, 57);
		//lblNewLabel.setLocation(20, 600);
		//lblNewLabel.setSize(10,10);
		frame.getContentPane().add(lblNewLabel);
	    
	    
		//frame.getContentPane().add(lblNewLabel, grid.a);
		
		
	}

}
