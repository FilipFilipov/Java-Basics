import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _1_Pyramid {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		ArrayList<Integer> sequence = new ArrayList<>();
		int currentNum = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			boolean change = false;
			String[] line = input.nextLine().trim().split("\\s+");
			int[] numbers = new int[line.length];
			for (int index = 0; index < line.length; index++) {
				numbers[index] = Integer.parseInt(line[index]);
			}
			
			Arrays.sort(numbers);
			for (int num : numbers) {
				if (!change && num > currentNum) {
					currentNum = num;
					change = true;
				}				
			}
			
			if (change) {
				sequence.add(currentNum);
			}
			else {
				currentNum++;
			}
		}
		
		System.out.println(sequence.toString().replaceAll("\\[|]", ""));
	}
}
