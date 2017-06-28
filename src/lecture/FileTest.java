package lecture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileTest {
	private static String DIR = "";

	public static void main(String[] args) {
		try {
			// https://stackoverflow.com/questions/1131500/using-relative-directory-path-in-java

			DIR = new File("./src/lecture/test.txt").getCanonicalPath();
			System.out.println(DIR);
			
			// https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java

			Scanner in = new Scanner(new FileReader(DIR));
			
			// Add each line to the StringBuilder
			StringBuilder sb = new StringBuilder();
			while(in.hasNextLine()) sb.append(in.nextLine() + "\n");

			in.close(); // Make sure to close the scanner
			String outString = sb.toString(); // StringBuilders *aren't* strings themselves

			System.out.println(outString);

		} catch (FileNotFoundException notFound) {
			// https://stackoverflow.com/questions/21197737/how-to-print-an-error-message-to-standard-error
			
			System.err.println("Could not find the file specified.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
