import java.util.Scanner;

public class _02_Generate3LetterWords {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter letters:");
		char[] letters = input.nextLine().toCharArray();
		for (char c1 : letters) {
			for (char c2 : letters) {
				for (char c3 : letters) {
					System.out.print(Character.toString(c1) + c2 + c3 + " ");
				}
			}
		}
	}
}
