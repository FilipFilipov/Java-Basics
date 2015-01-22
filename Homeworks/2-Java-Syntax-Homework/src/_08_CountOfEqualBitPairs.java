import java.util.Scanner;

public class _08_CountOfEqualBitPairs {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer:");
		int n = input.nextInt();
		int count = 0;
		while (n != 0) {
			int currentBit = n & 1;
			int nextBit = (n >>> 1) & 1;
			count += (currentBit == nextBit) ? 1 : 0;
			n >>>= 1;
		}
		System.out.printf("Your number has %d equal bit pairs.", count);
	}
}