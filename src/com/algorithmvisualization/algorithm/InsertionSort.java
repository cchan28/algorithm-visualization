package com.algorithmvisualization.algorithm;

import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.panel.BasePanel;

public class InsertionSort {

	public static void insertionSort(BasePanel basePanel, int[] array) {
		for (int i = 1; i < array.length; i++) {
			int index = i;
			int value = array[i];
			while (index > 0 && array[index-1] > value) {
				((SortPanel) basePanel).delayRepaint(index, 7);
				array[index] = array[index-1];
				index--;
			}
			array[index] = value;
		}
	}
	
}
