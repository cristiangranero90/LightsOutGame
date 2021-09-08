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
import javax.swing.UIManager;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class GameBoard implements Contract.View{

	private  JFrame frame;
	private  GridLayout grid;
	private Panel panel;
	private MainPresenter presenter;
	private Lights[][] lightsOnBoard;
	private JLabel numberMovements;
	private JComboBox<String> comboBox;
	String item;

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
		comboBox = new JComboBox<>(new String[] {"Principiate","Medium", "Advanced", "Extreme"});
		item = "Principiate";
		frame = new JFrame();
		panel = new Panel();
		//String itemOfCombo = (String) comboBox.getSelectedItem();
		//System.out.println(itemOfCombo);
		
		//Basic
		presenter = new MainPresenter(4, this);
		//lightsOnBoard = new Lights[10][10];
		
				
		updateView();
		//initializeComponents();	  
	}
	
	public void initializeComponents() {
		//Adding components		
		
				JLabel tittle = new JLabel("Lights Out, the game");
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
				
				
				comboBox.setBounds(590, 300, 100, 20);
				comboBox.setVisible(true);
				
				ActionListener comboListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String itemOfCombo = (String) comboBox.getSelectedItem();
						comboItem(itemOfCombo);
					}
					
				};
				
				comboBox.addActionListener(comboListener);
				
				
				frame.getContentPane().add(comboBox);
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

	@Override
	public void comboItem(String itemOfCombo) {
		//System.out.println(itemOfCombo);
		if(!itemOfCombo.equals(item)) {
			item = itemOfCombo;
			presenter.selectedCombo(itemOfCombo);	
		}
			
	}

	@Override
	public void updateView() {
		
		
		
		//System.out.println("Enter");
		frame.getContentPane().removeAll();
		//frame.revalidate();
	
		panel.removeAll();
		//panel.repaint();
		//panel.validate();
		
		//frame.repaint();
		
		
		
		//frame.revalidate();
		//frame.setBounds(0, 0, 0, 0);
		//panel.setBounds(0, 0, 0, 0);
		//frame.revalidate();
		//panel.validate();
		//System.out.println(frame.toString());
		//panel.removeAll();
		//panel.repaint();
		//panel.revalidate();
		//frame.removeAll();
		//panel.removeAll();
		//panel.rem
		//panel.remove(frame);
		//panel.repaint();
		//panel.invalidate();
		//panel.revalidate();
		
		
		panel.setBounds(10, 100, 500, 500);
		//panel.repaint();
		//panel.validate();
		
		
		
		
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
			    
		//Board Tools
		grid = BoardTools.setGridSize(grid, presenter.boardSize());		
		BoardTools.boardDimension(frame, presenter.boardSize());		
		lightsOnBoard = BoardTools.addLights(frame, presenter, grid, panel, this);
		BoardTools.initializeFrame(frame, grid, panel);
		
		initializeComponents();
		panel.validate();
		frame.validate();
		frame.getContentPane().add(panel);
				//Set panel	 
		
		
	}

	@Override
	public void building() {
		presenter.comunicateBuilding();		
	}

}
