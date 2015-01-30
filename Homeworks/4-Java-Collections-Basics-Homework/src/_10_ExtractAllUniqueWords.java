import java.util.Scanner;
import java.util.TreeSet;

public class _10_ExtractAllUniqueWords {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some text:");
		String[] words = input.nextLine().toLowerCase().split("\\W+");
		
		TreeSet<String> uniqueWords = new TreeSet<>();
		for (String word : words) {
			uniqueWords.add(word);
		}
		
		System.out.println("Unique word(s) in your text:");
		for (String word : uniqueWords) {
			System.out.print(word + " ");
		}
	}
}