package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import model.LightsOutGame;
import presenter.BoardTools;
import presenter.Contract;
import presenter.MainPresenter;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Panel;

public class GameBoard implements Contract.View{

	private  JFrame frame;
	private  GridLayout grid;
	private MainPresenter presenter;
	private Lights[][] lightsOnBoard;

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
		presenter = new MainPresenter(10, this);
		//lightsOnBoard = new Lights[10][10];
		
		frame = new JFrame();
		Panel panel = new Panel();
		
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	    
		//Board Tools
		grid = BoardTools.setGridSize(grid, presenter.boardSize());		
		BoardTools.boardDimension(frame, presenter.boardSize());		
		lightsOnBoard = BoardTools.addLights(frame, presenter, grid, panel, this);
		BoardTools.initializeFrame(frame, grid, panel);
		
		//Set panel	    
		panel.setBounds(10, 100, 500, 500);
		
		//Adding layouts
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Rare Label ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(100, 11, 300, 57);		
		frame.getContentPane().add(lblNewLabel);
	    
	}

	@Override
	public void onButtonClicked(int posX, int posY) {
		// TODO Auto-generated method stub
		presenter.generateLights(posX, posY);
	}

	@Override
	public void onButtonResetClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGrid() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void changeLight(int posX, int posY, boolean status) {
		// TODO Auto-generated method stub
		//System.out.println(lightsOnBoard!=null);
		if(lightsOnBoard != null) {
			lightsOnBoard[posX][posY].setStatus(status);
		}
		
	}

}
