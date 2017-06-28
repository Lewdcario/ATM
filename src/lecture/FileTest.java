package lecture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileTest {
	private static final String DIR = "C:\\Users\\isabe\\Documents\\compsci\\Final\\ATM\\src\\lecture\\test.txt";

	public static void main(String[] args) {
		
		// Attempt to read file
		try {
			Scanner in = new Scanner(new FileReader(DIR));
			
			StringBuilder sb = new StringBuilder();
			while(in.hasNext()) {
			    sb.append(in.next()).append("\n");
			}
			in.close();
			String outString = sb.toString();

			System.out.println(outString);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.print("Could not locate the file specified.");
		}	

	}
}
