package main;

public class Money {
	private int accNum;
	private int balance;
	private FileHandler accountInformation;
	
	public Money() {
		this.setAccountInformation(new FileHandler("./src/lecture/AccountInformation.txt"));
	}
	
	/**
	 * @return the accNum
	 */
	public int getAccNum() {
		return this.accNum;
	}

	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(int accNum) {
		this.accNum = accNum;
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
