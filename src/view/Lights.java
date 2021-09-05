package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class Lights {
	
	private JButton button;
	private boolean status;
	private int positionX;
	private int positionY;
	private Dimension dimension;
	
	
	public Lights(boolean status, int posX, int posY){
		button = new JButton(status+"");
		button.setBounds(posX, posY, 1, 1);
		dimension = new Dimension(10,10);
		button.setPreferredSize(dimension);
		setStatus(status);
		setPositionX(posX);
		setPositionY(posY);		
		System.out.println("Row " + posX + "; Column " + posY);
		setColor();
	}
	
	public void setColor() {
		if(isStatus()) {
			getButton().setBackground(Color.ORANGE);
		}
		else {
			getButton().setBackground(Color.WHITE);
		}
	}


	public JButton getButton() {
		return button;
	}


	public void setButton(JButton button) {
		this.button = button;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public int getPositionX() {
		return positionX;
	}


	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}


	public int getPositionY() {
		return positionY;
	}


	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	
	

}
