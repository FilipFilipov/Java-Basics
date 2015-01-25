import java.util.Scanner;

public class _02_SequencesOfEqualStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter strings:");
		String[] allStrings = input.nextLine().split(" ");
		String current = allStrings[0];
		System.out.print(current + " ");
		for (int i = 1; i < allStrings.length; i++) {
			String next = allStrings[i];
			if (!next.equals(current)) {
				System.out.println();
			}
			System.out.print(next + " ");
			current = next;
		}
	}
}
