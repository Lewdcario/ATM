package testPackage;

import static java.lang.System.out;

public class Time {
	private int hour;
	private int minute;
	private int second;

	public Time(long elapsedTime) {
		long totalSeconds = elapsedTime / 1000;
		this.second = (int)(totalSeconds % 60);
		
		long totalMinutes = totalSeconds / 60;
		this.minute = (int)(totalMinutes % 60);
		
		int totalHours = (int)(totalMinutes / 60);
		this.hour = (int)(totalHours % 24);
	}

	public int getSecond() {
		return this.minute;
	}

	public int getMinute() {
		return this.minute;
	}

	public int getHour() {
		return this.hour;
	}
}
