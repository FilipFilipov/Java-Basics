import java.util.Scanner;

public class _01_RectangleArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the sides of the rectangle:");
		int a = input.nextInt();
		int b = input.nextInt();
		System.out.println("Area = " + (a * b));
	}
}
