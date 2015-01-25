import java.util.Scanner;

public class _01_SymmetricNumbersInRange {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number range:");
		int start = input.nextInt();
		int end = input.nextInt();
		int divider;
		for (int i = start; i <= end; i++) {
			divider = (i < 100) ? 10 : 100;
			if (i < 10 || i % 10 == i / divider) {
				System.out.print(i + " ");
			}
		}
	}
}
