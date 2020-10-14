package com.algorithmvisualization.algorithm;

import com.algorithmvisualization.panel.VisualPanel;
import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.utility.SortUtils;

public class BubbleSort {
	
	public static void bubbleSort(VisualPanel visualPanel, int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				((SortPanel) visualPanel).delayRepaint(j, 7);
				if (array[j] > array[j+1]) {
					SortUtils.swap(array, j, j + 1);
				}
			}
		}
	}
	
}
