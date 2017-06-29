package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileHandler {
	private String DIR = null;
	private Path PATH = null;
	private String content = null;
	private String[] stringArray = null;
	
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
		return this.PATH;
	}
	
	/**
	 * @return the contentString
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * @param path
	 */
	public void setDir(String path) {
		this.DIR = path;
	}
	
	
	/**
	 * @param path
	 */
	public void setPath(Path path) {
		this.PATH = path;
	}	

	/**
	 * @param contentString the contentString to set
	 */
	public void setContent(String contentString) {
		this.content = contentString;
	}
	
	/**
	 * @param contentString the contentString to set
	 */
	public void setStringArray(String[] arr) {
		this.stringArray = arr;
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
		this.update();
	}
	
	
	/**
	 * Reads the file and updates class variables.
	 * @return Nothing.
	 */
	private void update() {
		try {
			this.setContent(new String(Files.readAllBytes(this.PATH), StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setStringArray(this.content.split("\\r?\\n", -1));
	}
	
	/**
	 * Reads file from set DIR and converts it to a string array.
	 * @return String[] file contents.
	 */
	@SuppressWarnings("unused")
	private String[] fileToArray() {
		InputStream is = null;
		try { is = new FileInputStream(this.DIR); } catch(Exception ignored) {}

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		ArrayList<String> list = new ArrayList<String>();
		
		String line;
		try { while ((line = br.readLine()) != null) list.add(line); } catch(Exception ignored) {}
		
		String[] stringArr = list.toArray(new String[0]);

		return stringArr;
	}
	/**
	 * Generic method for updating file.
	 * @param option The type of file operation to perform.
	 * @param content The content to update the file with.
	 */
	private synchronized void editFile(StandardOpenOption option, String content) {
		try {
			Files.write(this.PATH, content.getBytes(), option);
			this.update();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Appends a line to the file.
	 * @param content The content to update the file with.
	 * @return Nothing.
	 */
	public void addLine(String content) {
		this.editFile(StandardOpenOption.APPEND, "\n" + content);
	}
	
	
	/**
	 * Empties the file and replaces with new content.
	 * @param content The content to update the file with.
	 * @return Nothing.
	 */
	public void rewrite(String updated) {
		this.editFile(StandardOpenOption.TRUNCATE_EXISTING, updated);
	}
	
	
	/**
	 * Replaces some content in the file with new content. Synchronized keyword ensures only
	 * one thread can access this method at any given time.
	 * @param content The content to update the file with.
	 * @return Nothing.
	 * @throws IOException 
	 */
	public void replace(String original, String updated) {
		if (this.content == null) throw new Error("Could not parse file to update.");
		this.editFile(StandardOpenOption.WRITE, this.content.replaceAll(Pattern.quote(original), updated));
	}
	
	/**
	 * Prints the contents of the file.
	 * @return Nothing.
	 */
	public void printFile() {
		for (int i = 0; i < this.stringArray.length; i++) {
			System.out.println(this.stringArray[i]);
		}
	}

	// For testing purposes
	public static void main(String[] args) {
		FileHandler file = new FileHandler("./src/lecture/test.txt");
		file.replace("100", "30");
		file.printFile();
	}
}
