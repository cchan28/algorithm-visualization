package com.algorithmvisualization.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.panel.VisualPanel;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabbedPane;
	
	public UserInterface(String title) {
		this.setTitle(title);
		this.tabbedPane = new JTabbedPane();
		this.add(tabbedPane);
	}
	
	public void addPanel(String tabName, JPanel panel) {
		tabbedPane.addTab(tabName, panel);
	}

	public static void main(String[] args) {
		UserInterface ui = new UserInterface("Algorithm Visualization");
		VisualPanel sortPanel = new SortPanel(100);
		ui.addPanel("Sorting Visualization", sortPanel);
		ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ui.pack();
		ui.setMinimumSize(sortPanel.getPreferredSize());
		ui.setVisible(true);
	}
	
}
