package com.algorithmvisualization.panel;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public abstract class VisualPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static final int DIM_WIDTH = 500;
	public static final int DIM_HEIGHT = 500;
	public static final int MARGIN = 5;
	
	private JComboBox<String> optionBar;
	private JButton startButton;
	private JButton resetButton;
	
	public VisualPanel() {
		this.optionBar = new JComboBox<>();
		this.startButton = new JButton("Start");
		this.resetButton = new JButton("Reset");
		this.setUp();
	}
	
	private void setUp() {
		this.setBorder(BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
		this.add(optionBar);
		this.add(startButton);
		this.add(resetButton);
	}

	public JComboBox<String> getOptionBar() {
		return optionBar;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DIM_WIDTH, DIM_HEIGHT);
	}
	
}
