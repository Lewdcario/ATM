package lecture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileHandler {
	private String DIR = "";
	private Path PATH = null;
	
	public FileHandler(String path) {
		this.readFile(path);
	}
	
	/**
	 * @return Path as a string
	 */
	public String getDir() {
		return this.DIR;
	}
	
	/**
	 * @return the PATH
	 */
	public Path getPath() {
		return PATH;
	}

	/**
	 * @param path
	 */
	public void setPath(Path path) {
		this.PATH = path;
	}
	
	/**
	 * @param path
	 */
	public void setDir(String path) {
		this.DIR = path;
	}
	
	/**
	 * Checks if given path exists and sets the DIR and PATH for the class.
	 * @param path The path to attempt to read a file from.
	 * @return Nothing.
	 */
	private void readFile(String path) {
		File f = new File(path);
		if (!f.exists() || f.isDirectory()) throw new Error("File not Found");
		this.setDir(f.getPath());
		this.setPath(Paths.get(this.DIR));
	}
	
	/**
	 * Reads file from set DIR and converts it to a string array.
	 * @return String[] file contents.
	 */
	private String[] getLines() {
		InputStream is = null;
		try { is = new FileInputStream(this.DIR); } catch(Exception ignored) {}

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		ArrayList<String> list = new ArrayList<String>();
		
		String line;
		try { while ((line = br.readLine()) != null) list.add(line); }
		catch(Exception ignored) {}
		
		String[] stringArr = list.toArray(new String[0]);

		return stringArr;
	}
	
	/**
	 * Updates the file.
	 * @param content The content to update the file with.
	 * @return Nothing.
	 */
	void updateFile(String content) {
		try {
			String toWrite = "\n" + content;
			Files.write(this.PATH, toWrite.getBytes(), StandardOpenOption.APPEND);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints the contents of the file.
	 * @return Nothing.
	 */
	void printFile() {
		String[] lines = new String[10];
		lines = this.getLines();
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
	}

	public static void main(String[] args) {
		FileHandler file = new FileHandler("./src/lecture/test.txt");
		file.printFile();
	}

}
