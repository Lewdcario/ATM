package lecture;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	private String DIR = "";
	
	private FileHandler(String path) {
		this.readFile(path);
	}

	private void setDir(String path) {
		this.DIR = path;
	}
	
	public String getDir() {
		return this.DIR;
	}
	
	// Initializes file location
	private void readFile(String path) {
		File f = new File(path);
		if (!f.exists() || f.isDirectory()) throw new Error("File not Found");
		this.setDir(f.getPath());
	}
	
	// Returns every line in a string in form of an array of strings
	private String[] getLines() {
		System.out.println(this.getDir());
		Scanner in = null;

		try { in = new Scanner(new FileReader(this.getDir())); } catch (Exception ignored) {}
		
		// https://stackoverflow.com/questions/16100175/store-text-file-content-line-by-line-into-array
		ArrayList<String> list = new ArrayList<String>();
		
		while(in.hasNextLine()) list.add(in.nextLine()); // Add each line to the array
		in.close(); // Make sure to close the scanner
		
		String[] stringArr = list.toArray(new String[0]);

		return stringArr;
	}
	
	void updateFile(String content) {
		try {
			String toWrite = "\n" + content;
			Files.write(Paths.get(this.getDir()), toWrite.getBytes(), StandardOpenOption.APPEND);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void printFile() {
		String[] lines = this.getLines();

		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
	}

	public static void main(String[] args) {
		FileHandler file = new FileHandler("./src/lecture/test.txt");
		System.out.println("Before: ");
		file.printFile();
		file.updateFile("new stuff here!!");
		
		System.out.println("After: ");
		file.printFile();		
	}
}
