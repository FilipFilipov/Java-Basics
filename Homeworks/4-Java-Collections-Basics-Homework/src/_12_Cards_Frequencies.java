import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class _12_Cards_Frequencies {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some cards:");
		String[] cardFaces = input.nextLine().split("[ ♠-♦]+");
		
		LinkedHashMap<String, Double> cardCounters = new LinkedHashMap<>();
		for (String cardFace : cardFaces) {
			double count = cardCounters.containsKey(cardFace) ? cardCounters.get(cardFace) : 0;
			cardCounters.put(cardFace, ++count);					
		}
		
		System.out.println("Card face(s) frequency:");
		for (Map.Entry<String, Double> cardCounter : cardCounters.entrySet()) {
			double freq = cardCounter.getValue() * 100 / cardFaces.length;
			System.out.printf("%s -> %.2f%%\n", cardCounter.getKey(), freq);
		}
	}
}
