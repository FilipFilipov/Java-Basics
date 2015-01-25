import java.util.Scanner;

public class _07_CountSubstringOccurrences {	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some text:");
		String text = input.nextLine().toLowerCase();
		System.out.print("Enter target substring: ");
		String target = input.nextLine().toLowerCase();
		int count = 0;
		int index = 0;
		while (text.indexOf(target, index) != -1) {
			count++;
			index = text.indexOf(target, index) + 1;
		}
		System.out.println("Target substring appears " + count + " time(s).");
	}
}