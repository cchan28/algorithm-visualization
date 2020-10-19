package com.algorithmvisualization.setup;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.algorithmvisualization.panel.BasePanel;
import com.algorithmvisualization.panel.SortPanel;

public class Application {

	public static void main(String[] args) {
		JFrame screen = new JFrame("Algorithm Visualization");
		JTabbedPane tabbedPane = new JTabbedPane();
		BasePanel sortPanel = new SortPanel(100);
		tabbedPane.add("Sorting Visualization", sortPanel);
		screen.add(tabbedPane);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.pack();
		screen.setMinimumSize(sortPanel.getPreferredSize());
		screen.setVisible(true);
	}
	
}
