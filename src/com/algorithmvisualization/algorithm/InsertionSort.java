package com.algorithmvisualization.algorithm;

import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.panel.VisualPanel;

public class InsertionSort {

	public static void insertionSort(VisualPanel visualPanel, int[] array) {
		for (int i = 1; i < array.length; i++) {
			int index = i;
			int value = array[i];
			while (index > 0 && array[index-1] > value) {
				((SortPanel) visualPanel).delayRepaint(index, 7);
				array[index] = array[index-1];
				index--;
			}
			array[index] = value;
		}
	}
	
}
