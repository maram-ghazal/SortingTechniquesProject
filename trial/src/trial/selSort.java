package trial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class selSort {
	
//	FileReader fr1 = new FileReader(f1);
//	FileReader fr2 = new FileReader(f2);
//
//	BufferedReader br1 = new BufferedReader(fr1);
//	BufferedReader br2 = new BufferedReader(fr2);
//	String line1, line2;
//	
//
//	while ((line1 = br1.readLine()) != null) {
//		lines1.add(Integer.parseInt(line1));
//
//	}
//
//	while ((line2 = br2.readLine()) != null) {
//
//		lines2.add(Integer.parseInt(line2));
//
//	}
//
//	br1.close();
//	br2.close();
//	st.fileReader(f1, lines1);
	
	
//	void swap(ArrayList<Integer> array,int i, int j) {
//		
//		int temp=array.get(i);
//		array.set(i, array.get(j));
//		array.set(j, temp);
//	}

//	void sort(int arr[]) {
//
//		int n = arr.length;
//
//		for (int i = 0; i < n - 1; i++) {
//			int min = i;
//			for (int k = i + 1; k < n; k++) {
//				if (arr[k] < arr[min])
//					min = k;
//			}
//
//			int temp = arr[min];
//			arr[min] = arr[i];
//			arr[i] = temp;
//
//		}
//	}

//	public void buildHeap(int[] arr, int n) {
//		for (int i = n; i >= 0; i--)
//			maxHeapify(arr, n, i);
//	}

//	public void maxHeapify(int[] arr, int n, int i) {
//		int leftChild = (2 * i) + 1;
//		int rightChild = (2 * i) + 2;
//		int max = i;
//
//		if (leftChild < n && arr[leftChild] > arr[max]) {
//			max = leftChild;
//		}
//		if (rightChild < n && arr[rightChild] > arr[max]) {
//			max = rightChild;
//		}
//		if (max != i) {
////			swap(i, max);
//			int temp = arr[i];
//			arr[i] = arr[max];
//			arr[max] = temp;	
//			maxHeapify(arr, n, max);
//		}
//	}

	public void buildHeap(ArrayList<Integer> array, int n) {

		for (int i = n; i >= 0; i--)
			maxHeapify(array, n, i);
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

			maxHeapify(array, n, max);
		}
	}

	void selectionSort(ArrayList<Integer> array) {
		int n = array.size();
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int k = i + 1; k < n; k++) {
				if (array.get(k) < array.get(min))
					min = k;
			}
			int temp = array.get(i);
			array.set(i, array.get(min));
			array.set(min, temp);

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		File f = new File("trial.txt");
		File f2 = new File("trial2.txt");
		selSort selectionSort = new selSort();
		FileReader fr = new FileReader(f);
		FileReader fr2 = new FileReader(f2);
		BufferedReader br = new BufferedReader(fr);
		BufferedReader br2 = new BufferedReader(fr2);
		String line;
		String line2;
		boolean isIdentical = true;
//		int i = 0;

		ArrayList<Integer> lines1 = new ArrayList<>();
		ArrayList<Integer> lines2 = new ArrayList<>();

		while ((line = br.readLine()) != null) {
			lines1.add(Integer.parseInt(line));
		}

		while ((line2 = br2.readLine()) != null) {

			lines2.add(Integer.parseInt(line2));
		}

//		System.out.println("First array: " + lines1);
//		System.out.println(lines1);
		br.close();
		long startTime = System.currentTimeMillis();

		selectionSort.selectionSort(lines1);
		long endTime = System.currentTimeMillis();

//		System.out.println("1st sorted array: " + lines1);

//		System.out.println("Second array: " + lines2);
//		System.out.println(lines2);
		br2.close();
		long startTime2 = System.currentTimeMillis();
		selectionSort.buildHeap(lines2, lines2.size());
		long endTime2 = System.currentTimeMillis();

		if (lines1.equals(lines2)) {
			System.out.println("The two files are identical");
		} else {
			System.out.println("The two files are not identical");
		}

		long executionTime = endTime - startTime;
		System.out.println("The running time of O(n^2) is " + executionTime + "ms");
		long executionTime2 = endTime2 - startTime2;
		System.out.print("The running time of O(nlogn) is " + executionTime2 + "ms");
//		System.out.println("sorted array: " + lines2);
//		for (int j = 0; j < i; j++) {
//
//			System.out.println(lines.get(j));

//		}

//		System.out.println("original array: " + array[i]);

//		System.out.println("Running time is " + executionTime);

	}

}
