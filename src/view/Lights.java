package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import presenter.Contract;


public class Lights {
	
	private JButton button;
	private boolean status;
	private int positionX;
	private int positionY;
		
	public Lights(boolean status, int posX, int posY, Contract.View view){
		
		button = new JButton();
		button.setBounds(posX, posY, 1, 1);
		button.setPreferredSize(new Dimension(10,10));
		setStatus(status);
		setPositionX(posX);
		setPositionY(posY);		
		addAction(view);
	}
	
	private void addAction(Contract.View view) {
		getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionEventOcurred(getPositionX(), getPositionY(), view);
			}
		});
		
	}
	
	public void actionEventOcurred(int posX, int posY, Contract.View view) {
		//System.out.println(posX + " " + posY);
		view.onButtonClicked(posX, posY);
		
	}

	public void setColor() {
		if(isStatus()) {
			getButton().setBackground(Color.ORANGE);
		}
		else {
			getButton().setBackground(Color.GRAY);
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
		setColor();
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
