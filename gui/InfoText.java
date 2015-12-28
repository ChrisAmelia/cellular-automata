package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoText extends JPanel {
	private JLabel[] text;
	private List rules;

	/**
	 * Constructs a new object InfoText.
	 * 
	 * @param rules
	 *            the rules
	 */
	public InfoText(List rules) {
		super();
		this.rules = rules;
		text = new JLabel[rules.size()];

		setPreferredSize(new Dimension(100, 200));
		initialize();
	}

	/**
	 * Returns the text of rules in a JLabel array.
	 * 
	 * @return the text
	 */
	public JLabel[] getText() {
		return text;
	}

	/**
	 * Returns a list of the rules.
	 * 
	 * @return the rules
	 */
	public List getRules() {
		return rules;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the text to set
	 */
	public void setText(JLabel[] text) {
		this.text = text;
	}

	/**
	 * Sets the rules.
	 * 
	 * @param rules
	 *            the rules to set
	 */
	public void setRules(List rules) {
		this.rules = rules;
	}

	/**
	 * Initializes the text of the rules.
	 */
	public void initialize() {
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 2, 2);
		setLayout(fl);

		JLabel click = new JLabel("Click on a square to switch it from dead to live and from live to dead.");
		click.setForeground(Color.RED);
		add(click);

		JLabel ruleText = new JLabel("<html><br /><br />Rules to pass on to the next generation :</html>");
		ruleText.setForeground(Color.BLUE);
		add(ruleText);

		/* Rules */
		for (int i = 0; i < rules.size(); i++) {
			text[i] = new JLabel(rules.get(i).toString());
			add(text[i]);
		}

	}

}
