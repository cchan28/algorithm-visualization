package com.algorithmvisualization.algorithm;

import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.panel.VisualPanel;

public class MergeSort {

	public static void mergeSort(VisualPanel visualPanel, int[] array) {
		mergeSortUtils(visualPanel, array, 0, array.length - 1);
	}
	
	private static void mergeSortUtils(VisualPanel visualPanel, int[] array, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSortUtils(visualPanel, array, start, mid);
			mergeSortUtils(visualPanel, array, mid + 1, end);
			merge(visualPanel, array, start, mid, end);
		}
	}
	
	private static void merge(VisualPanel visualPanel, int[] array, int start, int mid, int end) {
		int[] temp = new int[end-start+1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		
		while (i <= mid && j <= end) {
			if (array[i] <= array[j]) {
				temp[k] = array[i];
				i++;
			} else {
				temp[k] = array[j];
				j++;
			}
			k++;
		}
		
		while (i <= mid) {
			temp[k] = array[i];
			i++;
			k++;
		}
		
		while (j <= end) {
			temp[k] = array[j];
			j++;
			k++;
		}
		
		for (int l = start; l <= end; l++) {
			array[l] = temp[l-start];
			((SortPanel) visualPanel).delayRepaint(l, 15);
		}
	}
	
}
