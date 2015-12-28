package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gridAutomaton.Grid;
import gridAutomaton.SquareGrid;

/**
 * A board contains the grid.
 * 
 * @author rhynes
 *
 */
public class Board extends JPanel {
	private Grid grid;
	private Square[][] square;

	/**
	 * Constructs a new object Board.
	 * 
	 * @param grid
	 *            the grid to set
	 */
	public Board(Grid grid) {
		super();
		this.grid = grid;

		setPreferredSize(new Dimension(400, 400));
		initialize();
	}

	/**
	 * Constructs a new object Board.
	 * 
	 * @param grid
	 *            the grid to set
	 * @param d
	 *            the dimension to set
	 */
	public Board(Grid grid, Dimension d) {
		super();
		this.grid = grid;

		setPreferredSize(d);
		initialize();
	}

	/**
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * @return the square
	 */
	public Square[][] getSquare() {
		return square;
	}

	/**
	 * @param grid
	 *            the grid to set
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * @param square
	 *            the square to set
	 */
	public void setSquare(Square[][] square) {
		this.square = square;
	}

	/**
	 * Initializes the board.
	 */
	public void initialize() {
		if (grid instanceof SquareGrid) {
			int rows = grid.getRows();
			int cols = grid.getCols();

			GridLayout gl = new GridLayout(rows, cols, 0, 0);
			setLayout(gl);

			square = new Square[rows][cols];
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++) {
					square[i][j] = new Square(((SquareGrid) grid).getCell()[i][j]);
					square[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
					add(square[i][j]);
				}

			return;
		}
	}

	/**
	 * Initializes the board with live cells.
	 * 
	 * @param liveCell
	 *            the number of live cells
	 */
	public void initialize(int liveCell) {
		if (grid instanceof SquareGrid) {
			((SquareGrid) grid).initialize(liveCell);
			
		}
		color();
	}

	/**
	 * Sets all cells to dead.
	 */
	public void clear() {
		grid.clear();
		color();
	}

	/**
	 * Colors all the cells.
	 */
	public void color() {
		for (int i = 0; i < square.length; i++)
			for (int j = 0; j < square[i].length; j++)
				square[i][j].color();
	}

	/**
	 * Updates the grid.
	 */
	public void update() {
		grid.update();
		color();
	}

}
