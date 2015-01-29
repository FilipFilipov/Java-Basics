import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _2_ThreeLargestNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		BigDecimal[] numbers = new BigDecimal[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = new BigDecimal(input.next());
		}
		
		Arrays.sort(numbers, Collections.reverseOrder());
		
		for (int i = 0; i < 3 && i < numbers.length; i++) {
			System.out.println(numbers[i].toPlainString());
		}
	}
}
