package trial;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

public class helloWorld {
	int max;
//public static void readFile (File f) throws IOException{
//	FileReader fr=new FileReader(f);
//	BufferedReader br=new BufferedReader(fr);
//	String line;
//	while((line= br.readLine())!=null) {
//		
//		System.out.println(line);
//	}
//	br.close();
//	fr.close();
//}

	public static void readFile(File f) throws IOException {
//		FileReader fr = new FileReader(f);
//		BufferedReader br = new BufferedReader(fr);
//		String line;
//		int[] array = new int[100000];
//		while ((line = br.readLine()) != null) {
//			int i = 0;
//			array[i] = Integer.parseInt(line);
//			System.out.println(array[i]);
//			line = br.readLine();
//
//		}
//		br.close();
//		fr.close();
		
		File fil = new File("trial.txt");
		FileReader inputFil = new FileReader(fil);
		BufferedReader in = new BufferedReader(inputFil);

		int [] tall = new int [100];

		String s =in.readLine();

		while(s!=null)
		{
		    int i = 0;
		    tall[i] = Integer.parseInt(s); //this is line 19
		    System.out.println(tall[i]);
		    s = in.readLine();
		}

		in.close();
	}
	
	public void swap(int i, int j) {
		int temp;

		temp = i;
		i = j;
		j = temp;
// alt+shift R

	}

	public void buildHeap(File f) {
//		public void buildHeap(File f, int[] arr, int n) 
		int []arr=null;
	
		for (int i = arr.length; i >= 0; i--) {
			maxHeapify(arr, arr.length, i);
		}

	}

	public void maxHeapify(int[] arr, int n, int i) {
		int leftChild = (2 * i) + 1;
		int rightChild = (2 * i) + 2;
		max = i;

		if (leftChild < n && arr[leftChild] > arr[max]) {
			max = leftChild;
		}
		if (rightChild < n && arr[rightChild] > arr[max]) {
			max = rightChild;
		}
		if (max != i) {
			swap(i, max);

			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;

			maxHeapify(arr, n, max);
		}
	}

	public static void main(String[] args) {
		File f = new File("trial.txt");
		helloWorld heap=new helloWorld();
		try {
			readFile(f);
		} catch (IOException e) {

			e.printStackTrace();

		}
		heap.buildHeap(f);
		
		

	}
	
	
	package trial;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Random;

	public class maxHeap {

//		public void swap(int i, int j) {
	//
//			int temp = i;
//			i = j;
//			j = temp;
	//// alt+shift R
//		}
	// public void readFile(File f){
//		FileReader fr = new FileReader(f);
//		BufferedReader br = new BufferedReader(fr);
//		int[] array = new int[9];
//		String line;
//		int i = 0;
////		ArrayList<Integer> lines = new ArrayList<>();
	//
//		while (br.ready()) {
//			line = br.readLine();
	//
////			array[i] = Integer.parseInt(line);
//			array[i] = Integer.parseInt(line);
//			i++;
//		}

//			System.out.println("original array: " + array[i]);
//			heap.buildHeap(array, 100);
//			System.out.println("sorted array: " + array[i]);
	//	
//		br.close();
//		System.out.println("original array: ");
//		for (int j = 0; j < i; j++) {
	//
//			System.out.println(array[j]);
	//
//		}
	//}
		public void buildHeap(int[] arr, int n) {
			for (int i = n; i >= 0; i--)
				maxHeapify(arr, n, i);
		}

		public void maxHeapify(int[] arr, int n, int i) {
			int leftChild = (2 * i) + 1;
			int rightChild = (2 * i) + 2;
			int max = i;

			if (leftChild < n && arr[leftChild] > arr[max]) {
				max = leftChild;
			}
			if (rightChild < n && arr[rightChild] > arr[max]) {
				max = rightChild;
			}
			if (max != i) {
//				swap(i, max);
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;

				maxHeapify(arr, n, max);
			}
		}

		void sort(int arr[]) {

			int n = arr.length;

			for (int i = 0; i < n - 1; i++) {
				int min = i;
				for (int k = i + 1; k < n; k++) {
					if (arr[k] < arr[min])
						min = k;
				}

				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;

			}
		}

		// Merges two subarrays of arr[].
		// First subarray is arr[l..m]
		// Second subarray is arr[m+1..r]

		void merge(int arr[], int l, int m, int r) {
			int n1 = m - l + 1;
			int n2 = r - m;

			int L[] = new int[n1];
			int R[] = new int[n2];

			for (int i = 0; i < n1; ++i)
				L[i] = arr[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = arr[m + 1 + j];

			int i = 0, j = 0;

			int k = l;
			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}

		void sort2(int arr[], int l, int r) {
			if (l < r) {
				// Find the middle point
				int m = (l + r) / 2;

				// Sort first and second halves
				sort2(arr, l, m);
				sort2(arr, m + 1, r);

				// Merge the sorted halves
				merge(arr, l, m, r);
			}
		}

		static void printArray(int arr[]) {
			int n = arr.length;
			for (int i = 0; i < n; ++i)
				System.out.print(arr[i] + " ");
			System.out.println();
		}

		public static void main(String[] args) throws NumberFormatException, IOException {
			// TODO Auto-generated method stubFile f=new File("trial.txt");
//			File f = new File("trial.txt");
			maxHeap heap = new maxHeap();

//			heap.buildHeap(array, array.length);
//			System.out.println("Sorted array(heap sort)");
//			System.out.println(Arrays.toString(array));

//			heap.sort(array);
//			System.out.println("Sorted array(insertion)");
//			System.out.println(Arrays.toString(array));
//			
//			

			System.out.println("original array");

			Random rd = new Random(); // creating Random object
			int[] arr = new int[1500000];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) (Math.random() * 5500);

				//System.out.println(arr[i]);
			}
//			int array[] = { 9, 10, 5, 3, 1, 2, 6, 4, 11 };
			long startTime = System.currentTimeMillis();
//			long start = System.nanoTime();
			heap.sort(arr);
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken: " + (endTime - startTime) + " ms");
			//System.out.println("Sorted array is (Selection Sort): " + Arrays.toString(arr));
//			long end = System.nanoTime();
//			System.out.println("Took (in ns)" + (end - start));
			long startTime2 = System.currentTimeMillis();
//			long start = System.nanoTime();
			heap.buildHeap(arr, arr.length);
			long endTime2 = System.currentTimeMillis();
			System.out.println("Time taken: " + (endTime2 - startTime2) + " ms");

			//System.out.println("sorted array is(heap sort): " + Arrays.toString(arr));
	//
//			maxHeap heap = new maxHeap();
//			heap.buildHeap(array, array.length);
//			System.out.println("Sorted array is (Heap Sort): " + Arrays.toString(array));
	//

//			maxHeap heap = new maxHeap();
//			heap.buildHeap(array, array.length);

		}

	}

}