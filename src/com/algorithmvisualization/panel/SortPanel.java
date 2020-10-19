package com.algorithmvisualization.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

import com.algorithmvisualization.utility.SortUtils;

public class SortPanel extends BasePanel {

	private static final long serialVersionUID = 1L;	
	private static final List<String> sorts = Arrays.asList("Bubble Sort", "Insertion Sort", "Selection Sort", "Merge Sort", "Quick Sort", "Heap Sort");	
	
	private SortUtils sortUtils;
	
	public SortPanel(int arraySize) {
		super();
		this.sortUtils = new SortUtils(arraySize);
		this.initializeOptionBar();
		this.initializeStartButton();
		this.initializeResetButton();
	}
	
	private void initializeOptionBar() {
		((JLabel) this.getOptionBar().getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		for (String sort: sorts) {
			this.getOptionBar().addItem(sort);
		}
	}

	private void initializeStartButton() {
		this.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				startSort();
			}
		});
	}
	
	private void initializeResetButton() {
		this.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				resetSort();
			}
		});
	}
	
	private void startSort() {
		new Thread(() -> {
			this.getStartButton().setEnabled(false);
			this.getOptionBar().setEnabled(false);
			this.getResetButton().setEnabled(false);
			String sort = (String) getOptionBar().getSelectedItem();
			sortUtils.sortArray(this, sort);
			this.repaint();
			this.getResetButton().setEnabled(true);
		}).start();
	}
	
	private void resetSort() {
		sortUtils.generateArray();
		this.repaint();
		this.getOptionBar().setEnabled(true);
		this.getStartButton().setEnabled(true);
	}
	
	public void delayRepaint(int rectIndex, int milliseconds) {
		sortUtils.setCurrentIndex(rectIndex);
		this.repaint();
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int[] array = sortUtils.getArray();
		for (int i = 0; i < array.length; i++) {
			this.drawScaledRect(g, i, array[i], array.length);
		}
	}
	
	private void drawScaledRect(Graphics g, int rectIndex, int rectValue, int arrayLength) {
		Rectangle2D.Double rect = this.getScaledRect(rectIndex, rectValue, arrayLength);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(sortUtils.getRectColor(rectIndex));
		g2d.fill(rect);
		g2d.setColor(Color.white);
		g2d.draw(rect);
	}
	
	private Rectangle2D.Double getScaledRect(int rectIndex, int rectValue, int arrayLength){
		double dimensionWidth = this.getWidth();
		double dimensionHeight = this.getHeight();
		
		double rectWidth = (dimensionWidth - (2 * MARGIN)) / arrayLength;
		double rectX = MARGIN + rectWidth * rectIndex;
		double rectHeight = rectValue * (dimensionHeight / DIM_HEIGHT);
		double rectY = dimensionHeight - MARGIN - rectHeight;
		return new Rectangle2D.Double(rectX, rectY, rectWidth, rectHeight);
	}
	
}
