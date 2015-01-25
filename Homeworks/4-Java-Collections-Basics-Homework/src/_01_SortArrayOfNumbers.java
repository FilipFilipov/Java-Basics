import java.util.Arrays;
import java.util.Scanner;

public class _01_SortArrayOfNumbers {	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many numbers do you want to sort? ");
		int n = input.nextInt();
		int[] numbers = new int[n];
		System.out.println("Enter numbers:");
		for (int i = 0; i < n; i++) {
			numbers[i] = input.nextInt();
		}
		Arrays.sort(numbers);
		for (int num : numbers) {
			System.out.print(num + " ");
		}
	}
}
