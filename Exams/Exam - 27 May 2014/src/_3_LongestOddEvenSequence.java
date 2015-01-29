import java.util.Scanner;

public class _3_LongestOddEvenSequence {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] numStrings = input.nextLine().split("[) (]+");
		int[] numbers = new int[numStrings.length - 1];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numStrings[i + 1]);
		}
		
		int maxSequence = 0;
		int sequence = 0;
		boolean targetOdd = numbers[0] % 2 != 0;
		
		for (int num : numbers) {
			boolean oddNum = num % 2 != 0;
			if (oddNum == targetOdd || num == 0) {
				sequence++;	
				maxSequence = Math.max(sequence, maxSequence);
				targetOdd = !targetOdd;
			}
			else {				
				sequence = 1;
			}			
		}
		
		System.out.println(maxSequence);
	}
}
