import java.util.Scanner;

public class _06_SumTwoNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two number to sum:");
		int a = input.nextInt();
		int b = input.nextInt();
		System.out.println("Sum = " + (a + b));
	}
}
