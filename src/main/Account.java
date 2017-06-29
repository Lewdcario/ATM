package main;

public class Account {
	private int accNum;
	private int balance;
	private String firstName;
	private String lastName;
	private FileHandler accountInformation;
	
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public Account() {
		this.setAccountInformation(new FileHandler("./src/lecture/AccountInformation.txt"));
	}
	
	/**
	 * @return the accNum
	 */
	public int getAccNum() {
		return this.accNum;
	}	

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return this.balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the accountInformation
	 */
	public FileHandler getAccountInformation() {
		return this.accountInformation;
	}

	/**
	 * @param accountInformation the accountInformation to set
	 */
	private void setAccountInformation(FileHandler accountInformation) {
		this.accountInformation = accountInformation;
	}

	private void changeBalance(int amount) {
		this.accountInformation.replace(Integer.toString(this.balance), Integer.toString(amount));
		this.setBalance(amount);
	}
	
	public void addMoney(int amount) {
		
	}
	public void removeMoney(int amount) {
		
	}
}
