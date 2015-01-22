import java.util.Scanner;

public class _07_CountOfBitsOne {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer:");
		int n = input.nextInt();
		int count = Integer.bitCount(n);
		System.out.printf("Your number has %d \"1\" bits.", count);
	}
}
