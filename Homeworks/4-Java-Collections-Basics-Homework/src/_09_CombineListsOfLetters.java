import java.util.ArrayList;
import java.util.Scanner;

public class _09_CombineListsOfLetters {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two lists of letters:");
		char[] line1 = input.nextLine().replaceAll(" ", "").toCharArray();
		char[] line2 = input.nextLine().replaceAll(" ", "").toCharArray();
		ArrayList<Character> firstList = new ArrayList<>();
		ArrayList<Character> secondList = new ArrayList<>();
		for (char letter : line1) {
			firstList.add(letter);
		}
		for (char letter : line2) {
			secondList.add(letter);
		}
		ArrayList<Character> result = new ArrayList<>(firstList);
		for (Character letter : secondList) {
			if (!firstList.contains(letter)) {
				result.add(letter);
			}
		}
		System.out.println("The combined list is:");
		for (Character letter : result) {
			System.out.print(letter + " ");
		}		
	}
}
