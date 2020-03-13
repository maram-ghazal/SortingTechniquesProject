package sortingProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HeapSort {

	public void buildHeap(ArrayList<Integer> array) {

		for (int i = array.size(); i >= 0; i--)
			maxHeapify(array, array.size(), i);
	}

	public void maxHeapify(ArrayList<Integer> array, int n, int i) {
		int leftChild = (2 * i) + 1;
		int rightChild = (2 * i) + 2;
		int max = i;

		if (leftChild < n && array.get(leftChild) > array.get(max)) {
			max = leftChild;
		}
		if (rightChild < n && array.get(rightChild) > array.get(max)) {
			max = rightChild;
		}
		if (max != i) {

			int temp = array.get(i);
			array.set(i, array.get(max));
			array.set(max, temp);
//			Collections.swap(array, i, max);
			maxHeapify(array, n, max);
		}
	}

	public void heapSort(ArrayList<Integer> array, int n) {

		buildHeap(array);

		for (int i = n - 1; i >= 0; i--) {
			int temp = array.get(0);
			array.set(0, array.get(i));
			array.set(i, temp);
//			Collections.swap(array, 0, i);
			maxHeapify(array, i, 0);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		FileReading fileReading = new FileReading();
		HeapSort heapS = new HeapSort();

		ArrayList<Integer> heap = new ArrayList<>();
		fileReading.fileReader(new File("heapFile.txt"), heap);

		long startTime = System.currentTimeMillis();
		heapS.heapSort(heap, heap.size());
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;

		System.out.println("****Heap Sort Algorithm****");
		System.out.println("-Sorted Array: " + heap);
		System.out.println("-Number of elements= " + heap.size());
		System.out.println("-The running time of Heap Sort is " + executionTime + " " + "ms" + " " + "or" + " "
				+ executionTime / 1000d + " " + "seconds");

	}

}
