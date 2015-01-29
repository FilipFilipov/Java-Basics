import java.util.Scanner;

public class _3_WeirdStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] words = input.nextLine().replaceAll("[\\\\/()|\\s]+", "").split("[^a-zA-Z]+");
		
		String output = "";
		int maxWeight = Integer.MIN_VALUE;
		for (int i = 0; i < words.length - 1; i++) {
			int weight = getWeight(words[i]) + getWeight(words[i + 1]);
			if (weight >= maxWeight) {
				maxWeight = weight;
				output = words[i] + "\n" + words[i + 1];
			}
		}
		
		System.out.println(output.equals("") ? "No" : output);
	}

	private static int getWeight(String word) {
		int weight = 0;
		char[] letters = word.toLowerCase().toCharArray();
		for (char letter : letters) {
			weight += letter - 'a' + 1;
		}
		return weight;
	}
}
