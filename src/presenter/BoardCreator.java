package presenter;

import java.awt.Frame;
import java.awt.GridBagLayout;

public class BoardCreator {

	public static void boardDimension(model.LightsOutGame board, Frame frame, GridBagLayout grid) {
		
		int size = board.boardSize();
		
		if (size == 4) {
			frame.setBounds(100, 100, 800, 600);
		}
		if (size == 5) {
			frame.setBounds(100, 100, 800, 700);
		}
		if (size == 6) {
			frame.setBounds(100, 100, 900, 700);
		}
		//frame.getCon
		gridBoardSize(size, grid);
	}

	private static void gridBoardSize(int size, GridBagLayout grid) {
		// TODO Auto-generated method stub
		grid.columnWidths = new int[size];
		grid.rowHeights = new int[size];
		grid.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		grid.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		
	}
}
