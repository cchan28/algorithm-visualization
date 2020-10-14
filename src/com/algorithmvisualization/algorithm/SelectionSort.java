package com.algorithmvisualization.algorithm;

import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.panel.VisualPanel;
import com.algorithmvisualization.utility.SortUtils;

public class SelectionSort {

	public static void selectionSort(VisualPanel visualPanel, int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
				((SortPanel) visualPanel).delayRepaint(min, 7);
			}
			SortUtils.swap(array, i, min);
		}
	}
	
}
