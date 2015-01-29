import java.util.Scanner;

public class _2_PythagoreanNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] numbers = new int[n];
		boolean match = false;
		
		for (int i = 0; i < n; i++) {
			numbers[i] = input.nextInt();
		}
		
		for (int a : numbers) {
			for (int b : numbers) {
				if (a <= b) {
					for (int c : numbers) {
						if (a * a + b * b == c * c) {
							match = true;
							System.out.printf("%1$s*%1$s + %2$s*%2$s = %3$s*%3$s\n", a, b, c);
						}
					}
				}
			}
		}
		
		if (!match) {
			System.out.println("No");
		}
	}
}
