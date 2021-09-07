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
	private JLabel numberMovements;

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
		presenter = new MainPresenter(5, this);
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
		
		
		
		JLabel tittle = new JLabel("Lights Out, The Game");
		tittle.setFont(new Font("Tahoma", Font.BOLD, 30));
	    tittle.setHorizontalAlignment(SwingConstants.CENTER);
	    tittle.setBounds(10, 20, 500, 60);		
		frame.getContentPane().add(tittle);
		
		JLabel movements = new JLabel("Movements");
		movements.setFont(new Font("Tahoma", Font.BOLD, 12));
	    movements.setHorizontalAlignment(SwingConstants.CENTER);
	    movements.setBounds(590, 100, 100, 220);		
		frame.getContentPane().add(movements);
		
		numberMovements = new JLabel("0");
		numberMovements.setFont(new Font("Tahoma", Font.BOLD, 12));
	    numberMovements.setHorizontalAlignment(SwingConstants.CENTER);
	    numberMovements.setBounds(590, 100, 100, 280);		
		frame.getContentPane().add(numberMovements);
		
	    
	}

	@Override
	public void onButtonClicked(int posX, int posY) {
		// TODO Auto-generated method stub
		presenter.generateLights(posX, posY);
		presenter.oneMovement();
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
		
		if(lightsOnBoard != null) {
			lightsOnBoard[posX][posY].setStatus(status);			
		}		
	}

	@Override
	public void updateMovements(int movement) {
		// TODO Auto-generated method stub
		numberMovements.setText(movement+"");
	}

}
