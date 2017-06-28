package lecture;
/*
 * 	~ Some differences to C++ ~
 * 1. Create project name === outer class (case sensitive)
 * 2. Main is inside outer class
 * 3. Arguments are only String[] args
 * 4. Repeat private/public in front of members
 * 5. toString() method to private data members in a string to print late
 * 6. Constructor of base class is called super
 * 7. class Circle extends Point
 * 8. Dynamic classes only
 * 9. Instead of include, import
 * 10. Packages are like namespace
 * 11. (Eclipse) Source -> Organize Imports adds stuff for you
 */

import java.util.Scanner;
import static java.lang.System.out;

public class Test {
	public static void main(String[] args) {
		out.println(":)");
		
		Scanner input = new Scanner(System.in);
		out.println("Enter an integer: ");
		int integer = input.nextInt();
		
		out.println("Enter a double: ");
		double dub = input.nextDouble();
		
		out.println("Integer: " + integer + "\nDouble: " + dub);
		
		Time time = new Time(555550000);
		out.println("Hour: " + time.getHour() + " Minute: " + time.getMinute() + " Second: " + time.getSecond());
	}
}
