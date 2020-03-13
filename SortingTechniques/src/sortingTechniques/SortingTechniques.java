package sortingTechniques;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortingTechniques {

//	void swap(ArrayList<Integer> array,int i, int j) {
//	
//	int temp=array.get(i);
//	array.set(i, array.get(j));
//	array.set(j, temp);
//}

	void fileReader(File f, ArrayList<Integer> array) throws NumberFormatException, IOException {
		FileReader fileReader = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {

			array.add(Integer.parseInt(line));
		}
		bufferedReader.close();

	}

	public void buildHeap(ArrayList<Integer> array) {

		for (int i = array.size(); i >= 0; i--)
			maxHeapify(array, array.size(), i);
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

	public void selectionSort(ArrayList<Integer> array) {
		int n = array.size();
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int k = i + 1; k < n; k++) {
				if (array.get(k) < array.get(min))
					min = k;
			}
			int temp = array.get(i);
			array.set(i, array.get(min));
			array.set(min, temp);
//			Collections.swap(array, min, i);
		}

	}

	public void merge(ArrayList<Integer> array, int left, int middle, int right) {
		int leftArr_size = middle - left + 1;
		int rightArr_size = right - middle;

		ArrayList<Integer> leftArr = new ArrayList<Integer>(leftArr_size);
		ArrayList<Integer> rightArr = new ArrayList<Integer>(rightArr_size);

		for (int i = 0; i < leftArr_size; i++)
			leftArr.add(array.get(left + i));
		for (int j = 0; j < rightArr_size; j++)
			rightArr.add(array.get(middle + 1 + j));

		int i = 0, j = 0;
		int k = left;
		while (i < leftArr_size && j < rightArr_size) {
			if (leftArr.get(i) <= rightArr.get(j)) {

				array.set(k, leftArr.get(i));
				i++;

			} else {
				array.set(k, rightArr.get(j));
				j++;
			}

			k++;
		}

		while (i < leftArr_size) {
			array.set(k, leftArr.get(i));
			i++;
			k++;

		}

		while (j < rightArr_size) {
			array.set(k, rightArr.get(j));
			j++;
			k++;
		}

	}

	public void mergeSort(ArrayList<Integer> array, int left, int right) {

		if (left < right) {

			int middle = (left + right) / 2;

			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);

			merge(array, left, middle, right);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		SortingTechniques st = new SortingTechniques();

		ArrayList<Integer> first_file = new ArrayList<>();
		ArrayList<Integer> second_file = new ArrayList<>();

		st.fileReader(new File("file1.txt"), first_file);
		st.fileReader(new File("file2.txt"), second_file);

		System.out.println("****Heap Sort Algorithm****");
		long startTime1 = System.currentTimeMillis();
		st.heapSort(first_file, first_file.size());
		long endTime1 = System.currentTimeMillis();
		long executionTime = endTime1 - startTime1;
		System.out.println("-Sorted Array: " + first_file);
		System.out.println("-Number of elements= " + first_file.size());
		System.out.println("-The running time of Heap Sort is " + executionTime + " " + "ms");
		System.out.println("----------------------------------------------------------------");

		System.out.println("****Selection Sort Algorithm****");
		long startTime2 = System.currentTimeMillis();
		st.selectionSort(first_file);
		long endTime2 = System.currentTimeMillis();
		long executionTime2 = endTime2 - startTime2;
		System.out.println("-Sorted Array: " + first_file);
		System.out.println("-Number of elements= " + first_file.size());
		System.out.println("----------------------------------------------------------------");

		System.out.println("****Merge Sort Algorithm****");
		long startTime3 = System.currentTimeMillis();
		st.mergeSort(second_file, 0, second_file.size() - 1);
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

//		ArrayList<Integer> arr = new ArrayList<Integer>(500000);
//		Random rd = new Random();
//
//		for (int i = 0; i <500000; i++) {
//
//			int r = rd.nextInt(90)+10;
//			arr.add(r);
//
//		}

	}
}
