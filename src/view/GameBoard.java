package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import model.LightsOutGame;

import java.awt.GridBagLayout;
import java.awt.Color;

public class GameBoard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//look and feel
				try {
					UIManager.setLookAndFeel ( UIManager.getSystemLookAndFeelClassName () );
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Error while look and feel is setting up");
					e1.printStackTrace();
				} 
				
				
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
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		//frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();		
		frame.getContentPane().setLayout(gridBagLayout);
		//Prueba
		LightsOutGame board = new LightsOutGame(5);
		
		presenter.BoardCreator.boardDimension(board, frame, gridBagLayout);
		
	}

}
