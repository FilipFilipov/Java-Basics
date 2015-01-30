import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class _12_Cards_Frequencies {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some cards:");
		String[] cardFaces = input.nextLine().replaceAll("[♠-♦]", "").split(" ");
		
		LinkedHashMap<String, Integer> cardCounters = new LinkedHashMap<>();
		for (String cardFace : cardFaces) {
			int count = cardCounters.containsKey(cardFace) ? cardCounters.get(cardFace) : 0;
			cardCounters.put(cardFace, ++count);					
		}
		
		System.out.println("Card face(s) frequency:");
		for (Map.Entry<String, Integer> cardCounter : cardCounters.entrySet()) {
			double freq = cardCounter.getValue() * 100.0 / cardFaces.length;
			System.out.printf("%s -> %.2f%%\n", cardCounter.getKey(), freq);
		}
	}
}
