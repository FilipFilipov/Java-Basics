import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class _06_RandomHandsOf5Cards {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rnd = new Random();
		System.out.print("How many hands do you want to draw? ");
		int hands = input.nextInt();
		String[] faces = { "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "J", "Q", "K", "A" };
		char[] suits = { '♣', '♥', '♠', '♦' };
		ArrayList<String> deck = new ArrayList<>();
		for (String face : faces) {
			for (char suit : suits) {
				deck.add(face + suit);
			}
		}
		for (int hand = 0; hand < hands; hand++) {
			for (int card = 0; card < 5; card++) {
				int currentCard = rnd.nextInt(deck.size());				
				System.out.printf("%-3s ", deck.get(currentCard));
				deck.remove(currentCard);
			}
			System.out.printf("\n");
		}
	}
}
