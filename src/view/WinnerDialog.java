package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinnerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static final String IMAGE_URL = "/images/assetWinGame.png";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinnerDialog dialog = new WinnerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	
	public WinnerDialog() throws IOException {
		setBounds(100, 100, 250, 200);
		this.setResizable(false);
		this.setTitle("Congratulations!");
		getContentPane().setLayout(new BorderLayout());
		
		//Image you win
		JLabel image = new JLabel();
		//First line takes the image resource, and second gets the image scaled
		ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream(IMAGE_URL))
				.getScaledInstance(250, 250, Image.SCALE_DEFAULT));		
		image.setIcon(icon);
		image.setBounds(0, 0, 200, 150);
		getContentPane().add(image);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Continue");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comunicateToView();
						
					}
				});				
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public void setPosition(int heigth, int width) {
		this.contentPanel.setBounds(heigth, width, 250, 200);
	}
	
	public void comunicateToView() {
		this.setVisible(false);
	}

}
