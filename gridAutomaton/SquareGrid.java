package gridAutomaton;

import java.util.List;

/**
 * This grid is squared and toric. Basically, any cell has exactly eight
 * neighbors given by the eight directions.
 * 
 * @author rhynes
 */
public class SquareGrid implements Grid, Cloneable {
	public final int rows, columns;
	Cell[][] cell;
	List<Rule> rules;

	/**
	 * Constructs a new object SquareGrid.
	 * 
	 * @param n
	 *            rows of the grid
	 * @param m
	 *            columns of the grid
	 * @param rules
	 *            rules of the grid
	 */
	public SquareGrid(int n, int m, List<Rule> rules) {
		rows = n;
		columns = m;
		cell = new Cell[n][m];
		this.rules = rules;

		/* Initializes all the cells. */
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				cell[i][j] = new Cell(columns * i + j);

		/* Sets the neighbors. */
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {

				/* Sets NORTH */
				cell[i][j].setNeighbor(Orientation.NORTH, ((i == 0) ? cell[rows - 1][j] : cell[i - 1][j]));

				/* Sets EAST */
				cell[i][j].setNeighbor(Orientation.EAST, ((j == columns - 1) ? cell[i][0] : cell[i][j + 1]));

				/* Sets SOUTH */
				cell[i][j].setNeighbor(Orientation.SOUTH, ((i == rows - 1) ? cell[0][j] : cell[i + 1][j]));

				/* Sets WEST */
				cell[i][j].setNeighbor(Orientation.WEST, ((j == 0) ? cell[i][columns - 1] : cell[i][j - 1]));

				/* Sets NORTH_EAST */
				if (i == 0) {
					if (j == columns - 1)
						cell[i][j].setNeighbor(Orientation.NORTH_EAST, cell[rows - 1][0]);
					else
						cell[i][j].setNeighbor(Orientation.NORTH_EAST, cell[rows - 1][j + 1]);
				} else if (j == columns - 1)
					cell[i][j].setNeighbor(Orientation.NORTH_EAST, cell[i - 1][0]);
				else
					cell[i][j].setNeighbor(Orientation.NORTH_EAST, cell[i - 1][j + 1]);

				/* Sets NORTH_WEST */
				if (i == 0) {
					if (j == 0)
						cell[i][j].setNeighbor(Orientation.NORTH_WEST, cell[rows - 1][columns - 1]);
					else
						cell[i][j].setNeighbor(Orientation.NORTH_WEST, cell[rows - 1][j - 1]);
				} else if (j == 0)
					cell[i][j].setNeighbor(Orientation.NORTH_WEST, cell[i - 1][columns - 1]);
				else
					cell[i][j].setNeighbor(Orientation.NORTH_WEST, cell[i - 1][j - 1]);

				/* Sets SOUTH_EAST */
				if (i == rows - 1) {
					if (j == columns - 1)
						cell[i][j].setNeighbor(Orientation.SOUTH_EAST, cell[0][0]);
					else
						cell[i][j].setNeighbor(Orientation.SOUTH_EAST, cell[0][j + 1]);
				} else if (j == columns - 1)
					cell[i][j].setNeighbor(Orientation.SOUTH_EAST, cell[i + 1][0]);
				else
					cell[i][j].setNeighbor(Orientation.SOUTH_EAST, cell[i + 1][j + 1]);

				/* Sets SOUTH_WEST */
				if (i == rows - 1) {
					if (j == 0)
						cell[i][j].setNeighbor(Orientation.SOUTH_WEST, cell[0][columns - 1]);
					else
						cell[i][j].setNeighbor(Orientation.SOUTH_WEST, cell[0][j - 1]);
				} else if (j == 0)
					cell[i][j].setNeighbor(Orientation.SOUTH_WEST, cell[i + 1][columns - 1]);
				else
					cell[i][j].setNeighbor(Orientation.SOUTH_WEST, cell[i + 1][j - 1]);
			}
	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public int getCols() {
		return columns;
	}

	/**
	 * Returns the cells.
	 * 
	 * @return the list of cells
	 */
	public Cell[][] getCell() {
		return cell;
	}

	/**
	 * Returns the number of live cells.
	 * 
	 * @return the number of live cells
	 */
	public int getLiveCell() {
		int liveCell = 0;

		for (int i = 0; i < cell.length; i++)
			for (int j = 0; j < cell[i].length; j++)
				if (cell[i][j].isAlive())
					liveCell++;

		return liveCell;
	}

	/**
	 * Returns the rules.
	 * 
	 * @return the rules
	 */
	public List<Rule> getRules() {
		return rules;
	}

	/**
	 * Sets the cell.
	 * 
	 * @param cell
	 *            cells to set
	 */
	public void setCell(Cell[][] cell) {
		this.cell = cell;
	}

	/**
	 * Sets the rules.
	 * 
	 * @param rules
	 *            the rules to set
	 */
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	/**
	 * Initializes randomly the grid with alive cells.
	 * 
	 * @param number
	 *            the number of live cells to initialize
	 */
	public void initialize(int number) {
		if (number > (rows * columns)) {
			System.out.println("Enter a valid number between 0 and " + (rows * columns));
			return;
		}
		while (number > 0) {
			int random = (int) (Math.random() * (rows * columns));
			if (!cell[random / rows][random % columns].isAlive()) {
				cell[random / rows][random % columns].change();
				number--;
			}
		}
	}

	/**
	 * Displays id.
	 * 
	 * @param show
	 *            true to show the id
	 * @param i
	 *            index on the rows
	 * @param j
	 *            index on the columns
	 * @return a string
	 */
	public String showIdContent(boolean show, int i, int j) {
		if (show) {
			if (cell[i][j].getId() < 10)
				return "0" + cell[i][j].getId();
			else
				return "" + cell[i][j].getId();
		} else
			return " ";
	}

	/**
	 * Displays the state.
	 * 
	 * @param show
	 *            true to show the state
	 * @param i
	 *            index on the rows
	 * @param j
	 *            index on the columns
	 * @return a string
	 */
	public String showStateContent(boolean show, int i, int j) {
		if (show) {
			if (cell[i][j].getState().isAlive())
				return "*";
			else
				return " ";
		} else
			return " ";
	}

	@Override
	public void clear() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++) {
				if (cell[i][j].isAlive())
					cell[i][j].change();
			}
	}

	@Override
	public void update() {
		SquareGrid cloned = this;
		try {
			cloned = (SquareGrid) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++) {
				for (int k = 0; k < rules.size(); k++)
					if (rules.get(k).isTrue(cloned.cell[i][j])) {
						cell[i][j].change();
						break;
					}
			}

	}

	@Override
	public void showGrid() {
		// showId();
		showState();
	}

	@Override
	public boolean areAllCellsDead() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				if (cell[i][j].isAlive())
					return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		SquareGrid cloned = (SquareGrid) super.clone();
		Cell[][] clonedCell = new Cell[rows][columns];

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				clonedCell[i][j] = cloned.cell[i][j].deepCopy();

		cloned.setCell(clonedCell);

		return cloned;
	}

	/**
	 * Displays the board with the state of the cell : if it's alive then an
	 * asterisk is displayed.
	 */
	private void showState() {
		for (int j = 0; j < columns; j++)
			System.out.print("--");
		System.out.println();
		for (int i = 0; i < rows; i++) {
			System.out.print("|");
			for (int j = 0; j < columns; j++) {
				System.out.print(showStateContent(true, i, j) + "|");
				if (j == columns - 1) {
					System.out.println();
					for (int k = 0; k < columns; k++) {
						System.out.print("--");
						if (k == columns - 1)
							System.out.println();
					}
				}
			}
		}
	}

}
