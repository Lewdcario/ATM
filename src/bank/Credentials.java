package bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Credentials extends FileManager {
	private String accNum;
	private String passwordString;
	private char[] password;
 
	public Credentials(String id) throws Exception {
		super("./src/bank/Password.txt");
		this.initCredentials(id);
	}

	/**
	 * @return the accNum
	 */
	public String getAccNum() {
		return accNum;
	}

	/**
	 * @param accNum the accNum to set
	 */
	private void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	/**
	 * @return the passwordString
	 */
	public String getPasswordString() {
		return passwordString;
	}

	/**
	 * @param passwordString the passwordString to set
	 */
	private void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	private void setPassword(char[] password) {
		this.password = password;
	}
	
	/**
	 * Replaces some content in the file with new content.
	 * @param content The content to update the file with.
	 */
	public void replace(String updated) {
		super.content = super.content.replaceAll("(?s)(?<=" + this.accNum + " ).*", updated);
		super.rewrite(super.content);
	}
	
	public void changePassword(char[] password) {
		this.replace(new String(password));
		this.setPassword(password);
	}
	
	private void initCredentials(String id) throws Exception {
		final Pattern pattern = Pattern.compile("(?<=" + id + ").*");
		final Matcher matcher = pattern.matcher(super.content);

		if (matcher.find()) {
			this.setPasswordString(matcher.group(0).trim());
			this.setPassword(this.passwordString.toCharArray());
			this.setAccNum(id);
		}
		else throw new Exception();
	}
	
	public String toString() {
		return "Account [accNum=" + accNum + ", passwordString=" + passwordString + "]";
	}

}
