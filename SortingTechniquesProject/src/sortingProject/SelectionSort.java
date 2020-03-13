package sortingProject;

import java.util.ArrayList;

public class SelectionSort {
	
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

}
