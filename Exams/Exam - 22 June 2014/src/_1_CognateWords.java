import java.util.HashSet;
import java.util.Scanner;

public class _1_CognateWords {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] words = input.nextLine().split("[^a-zA-Z]+");
		HashSet<String> uniqueWords = new HashSet<>();
		
		for (String wordA : words) {
			for (String wordB : words) {
				if (wordA != wordB) {
					for (String wordC : words) {
						if ((wordA + wordB).equals(wordC) && (!uniqueWords.contains(wordC))) {
								System.out.println(wordA + "|" + wordB + "=" + wordC);
								uniqueWords.add(wordC);				
						}
					}
				}				
			}
		}
		
		if (uniqueWords.size() == 0) {
			System.out.println("No");
		}
	}
}
