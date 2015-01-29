import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class _4_StraightFlush {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		String[] cards = input.nextLine().split("\\W+");		
		HashSet<String> hand = new HashSet<>();
		hand.addAll(Arrays.asList(cards));	
		boolean flush = false;
		
		for (String card : cards) {
			String face = card.substring(0, card.length() - 1);
			String suit = card.substring(card.length() - 1);
			if (face.compareTo("A") < 0) {
				ArrayList<String> straightFlush = new ArrayList<>();
				straightFlush.add(card);
				
				for (int i = 0; i < 4; i++) {				
					face = GetNextCard(face);
					if (!hand.contains(face + suit)) {
						break;
					}
					straightFlush.add(face + suit);
				}
				
				if (straightFlush.size() == 5) {
					System.out.println(straightFlush);
					flush = true;
				}
			}			
		}
		
		if (!flush) {
			System.out.println("No Straight Flushes");
		}
	}
	
	public static String GetNextCard(String face) {
		String[] cardFaces = {"2", "3", "4", "5", "6", "7", "8", "9",
				"10", "J", "Q", "K", "A"};
		for (int i = 0; i < cardFaces.length; i++) {
			if (cardFaces[i].equals(face)) {
				return cardFaces[i + 1];
			}
		}
		return null;
	}
}
