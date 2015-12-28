package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.InsetsUIResource;

/**
 * Operation center.
 * 
 * @author rhynes
 *
 */
public class CommandButton extends JPanel {
	private Board board;
	final JButton run = new JButton("Run");
	final JButton clear = new JButton("Clear");
	final JButton random = new JButton("Random");

	/**
	 * Constructs a new object Board.
	 * 
	 * @param board
	 *            the board to set
	 */
	public CommandButton(Board board) {
		super();
		this.board = board;

		setPreferredSize(new Dimension(100, 100));
		initialize();
	}

	/**
	 * Constructs a new object Board.
	 * 
	 * @param board
	 *            the board to set
	 * @param d
	 *            the dimension to set
	 */
	public CommandButton(Board board, Dimension d) {
		super();
		this.board = board;

		setPreferredSize(d);
		initialize();
	}

	/**
	 * Returns the board.
	 * 
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Sets the board.
	 * 
	 * @param board
	 *            the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Initializes the buttons.
	 */
	public void initialize() {
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 2, 2);
		run.setMargin(new InsetsUIResource(0, 0, 0, 0));
		clear.setMargin(new InsetsUIResource(0, 0, 0, 0));
		random.setMargin(new InsetsUIResource(0, 0, 0, 0));

		setLayout(fl);

		run.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				board.update();
			}

		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				board.clear();
			}
		});

		random.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				board.clear();
				int liveCell = 0;
				int rows = board.getGrid().getRows();
				int columns = board.getGrid().getRows();
				liveCell = (int) (Math.sqrt(Math.random() * (rows * columns)) + Math.sqrt(rows + columns));

				board.initialize(liveCell);
			}

		});

		add(run);
		add(clear);
		add(random);
	}

}
