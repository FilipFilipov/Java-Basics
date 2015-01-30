import java.util.Scanner;

public class _06_CountSpecifiedWord {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some text:");
		String[] words = input.nextLine().split("\\W+");
		System.out.print("Enter target word: ");
		String target = input.next();
		
		int count = 0;
		for (String word : words) {
			count += word.equalsIgnoreCase(target) ? 1 : 0;
		}
		
		System.out.println("Target word appears " + count + " time(s).");
	}
}
