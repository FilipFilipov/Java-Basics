import java.text.Format;
import java.util.ArrayList;
import java.util.Scanner;

public class _2_MagicSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int d = input.nextInt();
		ArrayList<Integer> numbers = new ArrayList<>();
		
		String next = input.next();
		while (!next.equals("End")) {
			numbers.add(Integer.parseInt(next));
			next = input.next();
		}
		
		String output = "";
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = i + 1; j < numbers.size(); j++) {
				for (int k = j + 1; k < numbers.size(); k++) {
					int a = numbers.get(i);
					int b = numbers.get(j);
					int c = numbers.get(k);
					int sum = a + b + c;
					if (sum % d == 0) {						
						if (sum > maxSum) {
							maxSum = sum;
							output = String.format("(%d + %d + %d) %% %d = 0", a, b, c, d);
						}
					}
				}
			}
		}
		
		System.out.println(output.equals("") ? "No" : output);
	}
}
