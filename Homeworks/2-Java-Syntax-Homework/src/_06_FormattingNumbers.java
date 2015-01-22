import java.util.Locale;
import java.util.Scanner;

public class _06_FormattingNumbers {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your 3 numbers:");
		int a = input.nextInt();
		double b = input.nextDouble();
		double c = input.nextDouble();
		int binary = Integer.parseInt(Integer.toBinaryString(a));
		System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|", a, binary, b, c);
	}
}
