package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gridAutomaton.Cell;

/**
 * Minimal unit.
 * 
 * @author rhynes
 *
 */
public class Square extends JPanel {
	private Cell cell;

	/**
	 * Constructs a new object Square.
	 * 
	 * @param cell
	 *            sell associated to this square
	 */
	public Square(Cell cell) {
		super();
		this.cell = cell;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		color();

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				change();
			}

		});
	}

	/**
	 * Returns the cell
	 * 
	 * @return the cell
	 */
	public Cell getCell() {
		return cell;
	}

	/**
	 * Sets the cell.
	 * 
	 * @param cell
	 *            cell to set
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}

	/**
	 * Changes the state of the cell.
	 */
	public void change() {
		cell.change();
		color();
	}

	/**
	 * Colors the cell. Blue if it's alive, else white.
	 */
	public void color() {
		if (cell.isAlive())
			setBackground(Color.BLUE);
		else if (!cell.isAlive())
			setBackground(Color.WHITE);
	}

}
