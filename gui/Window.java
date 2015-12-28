package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gridAutomaton.Grid;
import gridAutomaton.SquareGrid;

/**
 * Frame containing the game.
 * @author rhynes
 *
 */
public class Window extends JFrame {
	Grid grid;

	/**
	 * Constructs a new object Window.
	 * 
	 * @param grid
	 *            the grid to set
	 */
	public Window(Grid grid) {
		this.grid = grid;

		/* Left part, view */
		Board board = new Board(grid);
		
		/* Right part, model-controller */
		JPanel userInterface = new JPanel();
		userInterface.setLayout(new GridLayout(2, 1));
		userInterface.setPreferredSize(new Dimension(500, 500));

		List rules = ((SquareGrid) grid).getRules();
		CommandButton command = new CommandButton(board);
		InfoText info = new InfoText(rules);
		userInterface.add(command);
		userInterface.add(info);
		
			
		/* Window add */
		setLayout(new GridLayout(1, 2));
		add(board);
		add(userInterface);

		/* Window settings */
		setTitle("Cellular Automata");
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

}
