import java.util.Scanner;

public class _03_LargestSequenceOfEqualStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter strings:");
		String[] allStrings = input.nextLine().split(" ");
		int count = 1;
		int maxCount = 1;
		
		String result = allStrings[0];
		String current = allStrings[0];
		for (int i = 1; i < allStrings.length; i++) {
			String next = allStrings[i];
			
			if (next.equals(current)) {
				count++;
				if (count > maxCount) {
					maxCount = count;
					result = next;
				}
			}
			
			else {
				count = 1;
			}
			current = next;
		}
		
		System.out.println("Longest sequence:");
		for (int i = 0; i < maxCount; i++) {
			System.out.print(result + " ");
		}
	}
}
