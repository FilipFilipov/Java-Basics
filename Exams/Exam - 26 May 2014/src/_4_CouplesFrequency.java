import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class _4_CouplesFrequency {	
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		String[] numbers = input.nextLine().split(" ");
		LinkedHashMap<String, Integer> coupleCounters = new LinkedHashMap<>();
		
		for (int i = 0; i < numbers.length - 1; i++) {
			String couple = numbers[i] + " " + numbers[i + 1];
			int counter = (coupleCounters.containsKey(couple)) ? (coupleCounters.get(couple)) : 0;
			coupleCounters.put(couple, ++counter);
		}
		
		for (Map.Entry<String, Integer> coupleCounter : coupleCounters.entrySet()) {
			double freq = coupleCounter.getValue() * 100.0 / (numbers.length - 1);
			System.out.printf("%s -> %.2f%%\n", coupleCounter.getKey(), freq);
		}		
	}
}
