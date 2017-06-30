package bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends FileManager {
	private String accountString;
	private String accNum;
	private int balance;
	private String firstName;
	private String lastName;
	private FileManager credentials = new FileManager("./src/bank/Password.txt");

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public Account(String id) throws Exception {
		super("./src/bank/AccountInformation.txt");
		this.initUser(id);
	}
	
	/**
	 * @return the accNum
	 */
	public String getAccNum() {
		return this.accNum;
	}
	
	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return this.balance;
	}
	
	/**
	 * @param accountString the accountString to set
	 */
	private void setAccountString(String accountString) {
		this.accountString = accountString;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Takes an account ID and initializes the account's balance,
	 * full name and account number.
	 * @param id The ID to initiate the account with.
	 */
	private void initUser(String id) throws Exception {
		final Pattern pattern = Pattern.compile("(?<=" + id + ").*", Pattern.DOTALL);
		final Matcher matcher = pattern.matcher(super.content);

		if (matcher.find()) {
			this.setAccountString(matcher.group(0).trim());
			final String[] contents = this.accountString.split("\\r?\\n", -1);

			this.setAccNum(id);
			this.setLastName(contents[0]);
			this.setFirstName(contents[1]);
			this.setBalance(Integer.parseInt(contents[2]));
		}
		else throw new Exception();// Error.print(Thread.currentThread().getStackTrace()[1], 3);
	}
	
	/**
	 * Updates the file contents with the new balance.
	 * @param amount the amount to set
	 */
	private void changeBalance(int amount) {
		super.replace(Integer.toString(this.balance), Integer.toString(amount));
		this.setBalance(amount);
	}
	
	/**
	 * Adds money to the user's current balance.
	 * @param amount the amount to set
	 */
	public void addMoney(int amount) {
		this.changeBalance(this.balance + amount);
	}
	
	/**
	 * Removes money from the user's current balance.
	 * @param amount the amount to set
	 * @throws INSUFFICIENT_FUNDS if provided amount is greater than the user's balance.
	 */
	public void removeMoney(int amount) throws Exception {
		if (this.getBalance() < amount) throw new Exception();
		this.changeBalance(this.balance - amount);
	}
	
	/**
	 * Withdraws amount from the current user and adds it to the target user.
	 * @param amount the amount to transfer
	 * @throws INSUFFICIENT_FUNDS if provided amount is greater than the user's balance.
	 */
	public void transferMoney(Account target, int amount) {
		try {
			this.removeMoney(amount);
			target.addMoney(amount);
		} catch(Exception e) {
			Error.print(Thread.currentThread().getStackTrace()[1], 4);
		}
	}

	public String toString() {
		return "Account [accNum=" + accNum + ", balance=" + balance
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	// Testing purposes
	public static void main(String[] args) {
		/*
		new Account("3333");

		Account Isabella = new Account("1118596242"); // Called when login is pressed
		Account Islam = new Account("111859620");
		
		System.out.println("Isabella balance: " + Isabella.getBalance());
		System.out.println("Islam balance: " + Islam.getBalance());
		Isabella.transferMoney(Islam, 999999);
		System.out.println("After transfer");
		System.out.println("Isabella balance: " + Isabella.getBalance());
		System.out.println("Islam balance: " + Islam.getBalance());
		*/
	}
}
