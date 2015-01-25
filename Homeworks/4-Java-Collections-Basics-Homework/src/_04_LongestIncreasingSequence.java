import java.util.Scanner;

public class _04_LongestIncreasingSequence {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integers:");
		String[] numbers = input.nextLine().split(" ");
		int count = 1;
		int maxCount = 1;
		int seqStarter = 0;
		int current = Integer.parseInt(numbers[0]);
		System.out.print(current + " ");
		for (int i = 1; i < numbers.length; i++) {
			int next = Integer.parseInt(numbers[i]);
			if (next > current) {
				count++;
				if (count > maxCount) {
					maxCount = count;
					seqStarter = i + 1 - count;
				}
			}
			else {
				count = 1;
				System.out.println();
			}
			System.out.print(next + " ");
			current = next;
		}
		System.out.printf("%nLongest: ");
		for (int i = seqStarter; i < seqStarter + maxCount; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}