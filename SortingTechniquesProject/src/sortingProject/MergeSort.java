package sortingProject;

import java.util.ArrayList;

public class MergeSort {

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

}
