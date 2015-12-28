package gridAutomaton;

import java.util.ArrayList;
import java.util.Scanner;

import gui.Window;

/**
 * The main is here. Execute it from here.
 * 
 * @author rhynes
 *
 */
public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		/*
		 * Console or GUI. Set console to true to display the cellular automata
		 * in the console or false to display it in a window (GUI).
		 */
		boolean console = false;

		/*
		 * Initializing rules --- Make sure that, for a set of rules and a given
		 * cell's state, one and only one of these rules can be true for that
		 * cell. Here's a set of models : Conway's and Highlife's. By using one,
		 * make sure to comment the other.
		 */
		GoldenRule lifeRule = new LifeRule();
		GoldenRule deathRule = new DeathRule();

		/* Conway's rules */
		// lifeRule.add(3);
		// deathRule.add(2);
		// deathRule.add(3);

		/* Highlife's rules */
		lifeRule.add(3);
		lifeRule.add(6);
		deathRule.add(2);
		deathRule.add(3);

		/* My rules */
		// lifeRule.add(number);
		// lifeRule.add(number);
		// lifeRule.add(number);
		//
		// deathRule.add(number);
		// deathRule.add(number);
		// deathRule.add(number);

		ArrayList<Rule> rules = new ArrayList<Rule>();
		rules.add(lifeRule);
		rules.add(deathRule);

		/*
		 * Initializing the grid --- Modify rows (respectively columns or
		 * liveCells) to change the numbers of rows (respectively columns or
		 * live cells). Don't put more than authorized live cells meaning no
		 * more than rows * columns. Note that location of the live cells
		 * generated are randomly chosen.
		 * 
		 * If ever you want to select which cell is alive (respectively dead),
		 * note that in the GUI, you only need to click on that cell to switch
		 * it on a dead state (respectively live state). To do it in the
		 * console, assuming you're using a SquareGrid type, type the following
		 * command line : squareGrid.cell[i][j].change() where (i,j) is the
		 * index of the cell.
		 */
		int rows = 18;
		int columns = 18;
		int liveCells = 37;
		SquareGrid grid = new SquareGrid(rows, columns, rules);
		grid.initialize(liveCells);

		if (console) {
			int turn = 0;

			/* Scanner input */
			Scanner scanner = new Scanner(System.in);
			String readString = "";

			/* Displays initial state */
			System.out.println("Rules :");
			for (int i = 0; i < rules.size(); i++)
				System.out.println(rules.get(i).toString());
			System.out.println("--------------------------");
			System.out.println();
			System.out.println("Turn : " + turn);
			grid.showGrid();
			System.out.println("[ Live cells : " + grid.getLiveCell() + " ]");

			while (readString.equals("")) {

				/* Scanner tests */
				System.out.println("Press enter to continue or type any key to stop.");
				readString = scanner.nextLine();
				if (!readString.equals("")) {
					System.out.println("The end.");
					break;
				}

				/* Grid */
				grid.update();
				turn++;
				System.out.println("Turn : " + turn);
				grid.showGrid();
				System.out.println("[ Live cells : " + grid.getLiveCell() + " ]");

				if (grid.areAllCellsDead()) {
					System.out.println("All cells are dead, R.I.P.");
					break;
				}
			}

			scanner.close();
		} else {
			Window window = new Window(grid);
		}
	}

	// /*
	// * Debug. Only to test the clone method.
	// */
	// public static void main(String[] args) throws CloneNotSupportedException
	// {
	// SquareGrid grid = new SquareGrid(5, 5);
	//
	// Cell original = grid.cell[0][0];
	// Cell cloned = original.deepCopy();
	//
	// System.out.println("Initial state");
	//
	// System.out.println();
	// System.out.println("ORIGINAL : " + original.isAlive());
	// System.out.println("ORIGINAL 0 : " + original.getNeighbor(0).isAlive());
	//
	// System.out.println();
	// System.out.println("CLONE : " + cloned.isAlive());
	// System.out.println("CLONE 0 : " + cloned.getNeighbor(0).isAlive());
	//
	// System.out.println();
	// System.out.println("----");
	//
	// System.out.println("Clone cell dies");
	// System.out.println("Neighbor 0 of clone dies");
	// cloned.change();
	// cloned.getNeighbor(0).getCell().change();
	//
	// System.out.println("----");
	// System.out.println();
	//
	// System.out.println("ORIGINAL : " + original.isAlive());
	// System.out.println("ORIGINAL 0 : " + original.getNeighbor(0).isAlive());
	// System.out.println();
	// System.out.println("CLONE : " + cloned.isAlive());
	// System.out.println("CLONE 0 : " + cloned.getNeighbor(0).isAlive());
	//
	// }

	// /* Test for a random rule */
	// public static void main(String[] args) {
	// /* Initializing the grid. */
	// SquareGrid original = new SquareGrid(5, 5);
	// original.initRandomAlive(7);
	//
	// /* Scanner input */
	// Scanner scanner = new Scanner(System.in);
	// String readString = "";
	//
	// int turn = 0;
	//
	// System.out.println("Turn : " + turn);
	// original.showGrid();
	//
	//
	// while (readString.equals("")) {
	// System.out.println("Press enter to continue or type any key to stop.");
	// readString = scanner.nextLine();
	//
	// Backup[] backUp = new Backup[original.rows * original.columns];
	//
	// for (int i = 0; i < original.rows; i++)
	// for (int j = 0; j < original.columns; j++) {
	// backUp[original.columns * i + j] = new Backup(i, j,
	// original.cell[i][j].neighborsAlive(),
	// original.cell[i][j].isAlive());
	//// System.out.println(backUp[original.columns * i + j].toString());
	// }
	//
	// for (int i = 0; i < original.rows; i++)
	// for (int j = 0; j < original.columns; j++) {
	// if ((backUp[original.columns * i + j].aliveNeighbors == 2)
	// && (!backUp[original.columns * i + j].alive))
	// original.cell[i][j].change();
	// else if (backUp[original.columns * i + j].alive
	// && (backUp[original.columns * i + j].aliveNeighbors != 2))
	// original.cell[i][j].change();
	// }
	//
	//
	// turn++;
	// System.out.println("Turn : " + turn);
	// original.showGrid();
	//
	// }
	// }

	/**
	 * Debug. Use it to print neighbor of the given cell.
	 * 
	 * @param test
	 *            the cell to test
	 */
	public static void display(Cell test) {
		System.out.println("[" + go(test, Orientation.NORTH_WEST) + "] [" + go(test, Orientation.NORTH) + "] ["
				+ go(test, Orientation.NORTH_EAST) + "]");

		System.out.println(
				"[" + go(test, Orientation.WEST) + "] [" + test.getId() + "] [" + go(test, Orientation.EAST) + "]");

		System.out.println("[" + go(test, Orientation.SOUTH_WEST) + "] [" + go(test, Orientation.SOUTH) + "] ["
				+ go(test, Orientation.SOUTH_EAST) + "]");
	}

	/**
	 * Debug.
	 */
	private static String go(Cell cell, int orientation) {
		if (cell.getNeighbor(orientation).getCell().getId() < 10)
			return "0" + cell.getNeighbor(orientation).getCell().getId();
		return "" + cell.getNeighbor(orientation).getCell().getId();
	}
}
