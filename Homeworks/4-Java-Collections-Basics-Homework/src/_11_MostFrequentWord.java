import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _11_MostFrequentWord {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some text:");
		String[] words = input.nextLine().toLowerCase().split("\\W+");
		
		int maxCount = 0;
		TreeMap<String, Integer> wordCounters = new TreeMap<>();
		for (String word : words) {
			int count = wordCounters.containsKey(word) ? wordCounters.get(word) : 0;
			wordCounters.put(word, ++count);
			maxCount = Math.max(count, maxCount);
		}
		
		System.out.println("Most frequent word(s) in your text:");
		for (Map.Entry<String, Integer> wordCounter : wordCounters.entrySet()) {
			if (wordCounter.getValue() == maxCount) {
				System.out.println(wordCounter.getKey() + " -> " +
			wordCounter.getValue() + " time(s)");
			}
		}		
	}
}
