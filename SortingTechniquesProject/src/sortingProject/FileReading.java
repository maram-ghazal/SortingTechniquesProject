package sortingProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading {

	void fileReader(File f, ArrayList<Integer> array) throws NumberFormatException, IOException {
		FileReader fileReader = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {

			array.add(Integer.parseInt(line));
		}
		bufferedReader.close();

	}
}
