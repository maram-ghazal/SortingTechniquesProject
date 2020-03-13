package sortingProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SortingTechniques {

	public static void main(String[] args) throws NumberFormatException, IOException {

		FileReading fileReading = new FileReading();
		HeapSort heapS = new HeapSort();
		SelectionSort selectionS = new SelectionSort();
		MergeSort mergeS = new MergeSort();

		ArrayList<Integer> first_file = new ArrayList<>();
		ArrayList<Integer> second_file = new ArrayList<>();

		fileReading.fileReader(new File("file1.txt"), first_file);
		fileReading.fileReader(new File("file2.txt"), second_file);

		System.out.println("****Heap Sort Algorithm****");
		long startTime1 = System.currentTimeMillis();
		heapS.heapSort(first_file, first_file.size());
		long endTime1 = System.currentTimeMillis();
		long executionTime = endTime1 - startTime1;
		System.out.println("-Sorted Array: " + first_file);
		System.out.println("-Number of elements= " + first_file.size());
		System.out.println("-The running time of Heap Sort is " + executionTime + " " + "ms");
		System.out.println("----------------------------------------------------------------");

		System.out.println("****Selection Sort Algorithm****");
		long startTime2 = System.currentTimeMillis();
		selectionS.selectionSort(first_file);
		long endTime2 = System.currentTimeMillis();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("-Sorted Array: " + first_file);
		System.out.println("-Number of elements= " + first_file.size());
		System.out.println("----------------------------------------------------------------");

		System.out.println("****Merge Sort Algorithm****");
		long startTime3 = System.currentTimeMillis();
		mergeS.mergeSort(second_file, 0, second_file.size() - 1);
		long endTime3 = System.currentTimeMillis();
		long executionTime3 = endTime3 - startTime3;
		System.out.println("-Sorted Array: " + second_file);
		System.out.println("-Number of elements= " + second_file.size());
		System.out.println("----------------------------------------------------------------");

		if (first_file.equals(second_file) == true) {
			System.out.println("-Files are identical");
		} else {
			System.out.println("-Files are not identical");
		}

		System.out
				.println("-The running time of O(n^2) algorithm - Selection Sort - is " + executionTime2 + " " + "ms");
		System.out.println("-The running time of O(nlogn) algorithm - Merge Sort - is " + executionTime3 + " " + "ms");

	}

}
