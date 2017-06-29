package bank;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileManager {
	private String DIR = null;
	private Path PATH = null;
	protected String content = null;
	private String[] stringArray = null;
	
	public FileManager(String path) {
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
	 * @return the content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * @param dir the dir to set
	 */
	public void setDir(String dir) {
		this.DIR = dir;
	}
	
	/**
	 * @param path the path to set
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
	 * @throws Exception 
	 */
	private void readFile(String path) {
		File f = new File(path);
		if (!f.exists() || f.isDirectory()) Error.print(0);
		else {
			this.setDir(f.getPath());
			this.setPath(Paths.get(this.DIR));
			this.update();
		}
	}
	
	/**
	 * Reads the file and updates class variables.
	 * @return Nothing.
	 */
	private void update() {
		try {
			this.setContent(new String(Files.readAllBytes(this.PATH), StandardCharsets.UTF_8));
			this.setStringArray(this.content.split("\\r?\\n", -1));
		} catch (IOException e) {
			Error.print(1);
			e.printStackTrace();
		}
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
			Error.print(1);
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
	 */
	public void replace(String original, String updated) {
		this.content = this.content.replaceAll("(?i)(?<=[\r\n]+)(" + original + ")(?=[\r\n]+)", updated);
		this.rewrite(this.content);
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
}
