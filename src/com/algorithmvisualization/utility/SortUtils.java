package com.algorithmvisualization.utility;

import java.awt.Color;
import java.util.Random;

import com.algorithmvisualization.algorithm.*;
import com.algorithmvisualization.panel.VisualPanel;

public class SortUtils {

	private static final Random RANDOM = new Random();
	
	private int[] array;
	private int currentIndex;
	private boolean isSorted;
	private boolean isSorting;
	
	public SortUtils(int arraySize) {
		this.array = new int[arraySize];
		this.generateArray();
	}
	
	public static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	public void generateArray() {
		this.isSorted = false;
		for(int i = 0; i < array.length; i++) {
			this.array[i] = RANDOM.nextInt(VisualPanel.DIM_HEIGHT - 100) + 51;
		}
	}
	
	public void sortArray(VisualPanel visualPanel, String sort) {
		this.isSorting = true;
		switch (sort) {
			case "Bubble Sort":
				BubbleSort.bubbleSort(visualPanel, array);
				break;
			case "Insertion Sort":
				InsertionSort.insertionSort(visualPanel, array);
				break;
			case "Selection Sort":
				SelectionSort.selectionSort(visualPanel, array);
				break;
			case "Merge Sort":
				MergeSort.mergeSort(visualPanel, array);
				break;
			case "Quick Sort":
				QuickSort.quickSort(visualPanel, array);
				break;
			case "Heap Sort":
				HeapSort.heapSort(visualPanel, array);
		}
		this.isSorting = false;
		this.isSorted = true;
	}

	public Color getRectColor(int rectIndex) {
		if (this.isSorted) {
			return Color.green;
		} else if (this.isSorting && this.currentIndex == rectIndex){
			return Color.yellow;
		} else {
			return Color.black;
		}
	}
	
}
