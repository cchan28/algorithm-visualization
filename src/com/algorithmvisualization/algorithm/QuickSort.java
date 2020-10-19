package com.algorithmvisualization.algorithm;

import java.util.Random;

import com.algorithmvisualization.panel.SortPanel;
import com.algorithmvisualization.panel.BasePanel;
import com.algorithmvisualization.utility.SortUtils;

public class QuickSort {

	private static final Random RANDOM = new Random();
	
	public static void quickSort(BasePanel visualPanel, int[] array) {
		quickSortUtils(visualPanel, array, 0, array.length - 1);
	}

	private static void quickSortUtils(BasePanel visualPanel, int[] array, int start, int end) {
		if (start < end) {
			int pivot = partitionArray(visualPanel, array, start, end);
			quickSortUtils(visualPanel, array, start, pivot - 1);
			quickSortUtils(visualPanel, array, pivot + 1, end);
		}
		
	}

	private static int partitionArray(BasePanel visualPanel, int[] array, int start, int end) {
		randomizePivot(array, start, end);
		int value = array[end];
		int pivot = start;
		for (int i = start; i < end; i++) {
			if (array[i] <= value) {
				SortUtils.swap(array, i, pivot);
				pivot++;
			}
			((SortPanel) visualPanel).delayRepaint(pivot, 15);
		}
		SortUtils.swap(array, end, pivot);
		return pivot;
	}
	
	private static void randomizePivot(int[] array, int start, int end) {
		int index = RANDOM.nextInt(end - start + 1) + start;
		SortUtils.swap(array, index, end);
	}
	
}
