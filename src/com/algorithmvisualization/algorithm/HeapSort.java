package com.algorithmvisualization.algorithm;

import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.panel.BasePanel;
import com.algorithmvisualization.utility.SortUtils;

public class HeapSort {
	
	public static void heapSort(BasePanel visualPanel, int[] array) {	
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			maxHeapify(visualPanel, array, array.length, i);
		}
		
		for (int i = array.length - 1; i > 0; i--) {
			SortUtils.swap(array, i, 0);
			((SortPanel) visualPanel).delayRepaint(i, 15);
			maxHeapify(visualPanel, array, i, 0);
		}
		
    }
	
	private static void maxHeapify(BasePanel visualPanel, int[] array, int arraySize, int index) {
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
			((SortPanel) visualPanel).delayRepaint(index, 15);
			maxHeapify(visualPanel, array, arraySize, largest);
		}	
	}
	
}
