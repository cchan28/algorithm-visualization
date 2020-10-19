package com.algorithmvisualization.algorithm;

import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.panel.BasePanel;
import com.algorithmvisualization.utility.SortUtils;

public class HeapSort {
	
	public static void heapSort(BasePanel basePanel, int[] array) {	
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			maxHeapify(basePanel, array, array.length, i);
		}
		
		for (int i = array.length - 1; i > 0; i--) {
			SortUtils.swap(array, i, 0);
			((SortPanel) basePanel).delayRepaint(i, 15);
			maxHeapify(basePanel, array, i, 0);
		}
		
    }
	
	private static void maxHeapify(BasePanel basePanel, int[] array, int arraySize, int index) {
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		
		if (left < arraySize && array[left] > array[largest]) {
			largest = left;
		}
		
		if (right < arraySize && array[right] > array[largest]) {
			largest = right;
		}
		
		if (largest != index) {
			SortUtils.swap(array, largest, index);
			((SortPanel) basePanel).delayRepaint(index, 15);
			maxHeapify(basePanel, array, arraySize, largest);
		}	
	}
	
}
