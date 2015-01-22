import java.util.Locale;
import java.util.Scanner;

public class _04_TheSmallestOf3Numbers {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 3 numbers:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double smallest = Math.min(a, b);
		smallest = Math.min(smallest, c);
		System.out.println(Double.toString(smallest).replaceAll("\\.0+", "") + " is the smallest.");
	}
}
