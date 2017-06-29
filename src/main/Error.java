package main;

public enum Error {
	FILE_NOT_FOUND(0, "The specified file was not found."),
	DATABASE(1, "A database error has occured."),
	DUPLICATE_USER(2, "This user already exists."),
	NO_SUCH_USER(3, "User does not exist."),
	INSUFFICIENT_FUNDS(4, "User does not have sufficient funds to perform this operation."),
	INCORRECT_LOGIN_DETAILS(5, "The provided login details are incorrect."),
	UNKNOWN_ERROR_CODE(10, "Unknown Error.");

	private final int code;
	private final String description;

	private Error(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	/**
	 * Looks up enum based on code. If code was not registered as enum, it
	 * returns UNKNOWN_ERROR_CODE
	 * 
	 * @param code
	 * @return
	 */
	public static Error fromCode(int code) {
		Error enumForGivenCode = null;
		try { enumForGivenCode = Error.values()[code]; } catch(Exception e) {}

		if (enumForGivenCode == null) {
			enumForGivenCode = UNKNOWN_ERROR_CODE;
		}

		return enumForGivenCode;
	}

	public String toString() {
		return code + ": " + description;
	}
	
	public static void print(int code) {
		System.err.println(Error.fromCode(code).toString());
	}
}