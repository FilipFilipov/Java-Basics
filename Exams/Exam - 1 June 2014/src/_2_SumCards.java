import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _2_SumCards {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] cards = input.nextLine().replaceAll("[SHCD]", "").split(" ");
		
		ArrayList<String> cardArray = new ArrayList<>(Arrays.asList(cards));
		cardArray.add("0");
		cardArray.add(0, "0");
		
		int sum = 0;
			for (int i = 1; i < cardArray.size() - 1; i++) {
				String currentCard = cardArray.get(i);
				String previousCard = cardArray.get(i - 1);
				String nextCard = cardArray.get(i + 1);			
				int weightCurrent = getWeight(currentCard);
				if (currentCard.equals(previousCard) ||
						currentCard.equals(nextCard)) {
					weightCurrent *= 2;
				}				
				sum += weightCurrent;				
			}
			
		System.out.println(sum);
	}

	private static int getWeight(String currentCard) {
		int weight = 0;
		switch (currentCard) {
		case "J":
			weight += 12; break;
		case "Q":
			weight += 13; break;
		case "K":
			weight += 14; break;
		case "A":
			weight += 15; break;
		default:
			weight += Integer.parseInt(currentCard); break;
		}
		return weight;
	}
}