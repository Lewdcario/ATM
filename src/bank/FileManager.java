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
	private void setDir(String dir) {
		this.DIR = dir;
	}
	
	/**
	 * @param path the path to set
	 */
	private void setPath(Path path) {
		this.PATH = path;
	}	

	/**
	 * @param content the content to set
	 */
	private void setContent(String contentString) {
		this.content = contentString;
	}
	
	/**
	 * @param contentString the contentString to set
	 */
	private void setStringArray(String[] arr) {
		this.stringArray = arr;
	}
	
	/**
	 * Checks if given path exists and sets the DIR and PATH for the class.
	 * @param path The path to attempt to read a file from.
	 * @throws FILE_NOT_FOUND if the file was not found. 
	 */
	private void readFile(String path) {
		File f = new File(path);
		if (!f.exists() || f.isDirectory()) Error.print(Thread.currentThread().getStackTrace()[1], 0);
		else {
			this.setDir(f.getPath());
			this.setPath(Paths.get(this.DIR));
			this.update();
		}
	}
	
	/**
	 * Reads the file and updates class variables.
	 * @throws DATABASE if there was an error updating the file.
	 */
	protected void update() {
		try {
			this.setContent(new String(Files.readAllBytes(this.PATH), StandardCharsets.UTF_8));
			this.setStringArray(this.content.split("\\r?\\n", -1));
		} catch (IOException e) {
			Error.print(Thread.currentThread().getStackTrace()[1], 1);
			e.printStackTrace();
		}
	}

	/**
	 * Generic method for updating file.
	 * @param option The type of file operation to perform.
	 * @param content The content to update the file with.
	 * @throws DATABASE if there was an error updating the file.
	 */
	private synchronized void editFile(StandardOpenOption option, String content) {
		try {
			Files.write(this.PATH, content.getBytes(), option);
			this.update();
		} catch (IOException e) {
			Error.print(Thread.currentThread().getStackTrace()[1], 1);
			e.printStackTrace();
		}
	}
	
	/**
	 * Appends a line to the file.
	 * @param content The content to update the file with.
	 */
	public void addLine(String content) {
		this.editFile(StandardOpenOption.APPEND, "\n" + content);
	}
	
	/**
	 * Empties the file and replaces with new content.
	 * @param content The content to update the file with.
	 */
	public void rewrite(String updated) {
		this.editFile(StandardOpenOption.TRUNCATE_EXISTING, updated);
	}
		
	/**
	 * Replaces some content in the file with new content.
	 * @param content The content to update the file with.
	 */
	public void replace(String original, String updated) {
		this.content = this.content.replaceAll("(?i)(?<=[\r\n]+)(" + original + ")(?=[\r\n]+)", updated);
		this.rewrite(this.content);
	}
	
	/**
	 * Prints the contents of the file.
	 */
	public void printFile() {
		for (int i = 0; i < this.stringArray.length; i++) {
			System.out.println(this.stringArray[i]);
		}
	}
}
