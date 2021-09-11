package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import presenter.BoardTools;
import presenter.Contract;
import presenter.MainPresenter;

import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class GameBoard implements Contract.View{

	private JFrame frame;
	private GridLayout grid;
	private Panel panel;
	private MainPresenter presenter;
	private Lights[][] lightsOnBoard;
	private JLabel numberMovements;
	private JButton reset;
	private JButton exit;
	private JComboBox<String> comboBox;
	private WinnerDialog winnerDialog;
	String item;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/**
		 ** This main, runs all the program, in MVP maybe is not a good practice.
		**/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					GameBoard window = new GameBoard();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					System.out.println("CRITICAL ERROR: " + e.toString());
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
		//Basic constructors
		comboBox = new JComboBox<>(new String[] {"Beginner","Medium", "Advanced", "Extreme", "Very Sick"});
		item = "Beginner";
		frame = new JFrame();
		panel = new Panel();
		numberMovements = new JLabel("0");
		reset = new JButton();
		exit = new JButton();
		presenter = new MainPresenter(4, this);
		try {
			winnerDialog = new WinnerDialog();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		winnerDialog.setVisible(false);
		
		
		reset.setText("RESET");
		reset.setHorizontalAlignment(SwingConstants.CENTER);
		reset.setBounds(590, 380, 100, 30);				
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				if(event.getSource().equals(reset)) {
					System.out.println("INFO: Action performed... RESET");
					onButtonResetClicked();
				}									
			}			
		});		
		//Button close
		exit.setText("EXIT");
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setBounds(590, 480, 100, 30);				
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(e.getSource().equals(exit)) {
					System.out.println("INFO: Action performed... EXIT");
					//Delete all in the frame, and then close operations
					winnerDialog.dispose();
					frame.dispose();
				}								
			}			
		});			
		//Updates view 				
		updateView();  
	}
	
		private void initializeComponents() {
		//Adding components	
		
		//Tittle
		JLabel tittle = new JLabel("Lights Out, the game");
		tittle.setFont(new Font("Tahoma", Font.BOLD, 30));
		tittle.setHorizontalAlignment(SwingConstants.CENTER);
		tittle.setBounds(10, 20, 500, 60);		
		frame.getContentPane().add(tittle);
		
		//Label movements
		JLabel movements = new JLabel("Movements");
		movements.setFont(new Font("Tahoma", Font.BOLD, 12));
		movements.setHorizontalAlignment(SwingConstants.CENTER);
		movements.setBounds(590, 100, 100, 220);		
		frame.getContentPane().add(movements);
		
		//Label with number of movements
		numberMovements.setText("0");
		numberMovements.setFont(new Font("Tahoma", Font.BOLD, 12));
		numberMovements.setHorizontalAlignment(SwingConstants.CENTER);
		numberMovements.setBounds(590, 100, 100, 280);		
		frame.getContentPane().add(numberMovements);		
				
		//Combo Box that show and changes the levels		
		comboBox.setBounds(590, 300, 100, 20);
		comboBox.setVisible(true);
				
		ActionListener comboListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String itemOfCombo = (String) comboBox.getSelectedItem();
			comboItem(itemOfCombo);
			}					
		};
		
		//ActionListener for the comboBox
		comboBox.addActionListener(comboListener);	
		
		//Adding all the elements to the main frame
		frame.getContentPane().add(comboBox);		
		frame.getContentPane().add(exit);
		frame.getContentPane().add(reset);		
		
	}
	@Override
	public void onButtonClicked(int posX, int posY) {
		presenter.generateLights(posX, posY);
		presenter.oneMovement();
	}

	@Override
	public void onButtonResetClicked() {	
		presenter.selectedCombo(getItem());
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
		numberMovements.setText(movement+"");
	}
	@Override
	public void updateView() {
		//Remove components in the frame and in the panel
		frame.getContentPane().removeAll();
		panel.removeAll();
		lightsOnBoard = null;
		
		//Setting up basics
		panel.setBounds(10, 100, 500, 500);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
			    
		//Board Tools
		grid = BoardTools.setGridSize(grid, presenter.boardSize());		
		BoardTools.boardDimension(frame, presenter.boardSize());		
		lightsOnBoard = BoardTools.addLights(frame, presenter, grid, panel, this);
		BoardTools.initializeFrame(frame, grid, panel);		
		
		//Add all the components after the initialization
		initializeComponents();
		panel.validate();
		frame.validate();
		frame.getContentPane().add(panel);
	}
	@Override
	public void comboItem(String itemOfCombo) {
		if(!itemOfCombo.equals(item)) {
			setItem(itemOfCombo);
			numberMovements.setText("0");
			presenter.selectedCombo(itemOfCombo);	
		}			
	}
	@Override
	public void isWinner() {
		winnerDialog.setBounds(frame.getX()*2, frame.getY()*2, 250, 200);
		winnerDialog.setVisible(true);		
		onButtonResetClicked();				
	}
	public void setItem(String itemOfCombo) {
		this.item = itemOfCombo;		
	}
	public String getItem() {
		// TODO Auto-generated method stub
		return this.item;
	}

}
