import java.util.Arrays;
import java.util.LinkedHashSet;

public class _04_FullHouseWithJokers {
	//	Prepare a StringBuilder, because we'll be concatenating
	//	a lot of strings, and a LinkedHashSet, which eliminates
	//	duplicates, keeps the insertion order and retrieves values quickly.
	private static StringBuilder fullHouseString = new StringBuilder();
	private static LinkedHashSet<String> fullHouseSet = new LinkedHashSet<String>();

	public static void main(String[] args) {
		//		Generate all full houses without jokers, same as the last task.
		char[] suits = { '♣', '♥', '♠', '♦' };
		String[] faces = { "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "J", "Q", "K", "A"};
		for (String face1 : faces) {
			for (String face2 : faces) {
				if (!face1.equals(face2)) {
					for (int suit1 = 0; suit1 < suits.length; suit1++) {
						for (int suit2 = suit1 + 1; suit2 < suits.length; suit2++) {
							for (int suit3 = suit2 + 1; suit3 < suits.length; suit3++) {
								for (int suit4 = 0; suit4 < suits.length; suit4++) {
									for (int suit5 = suit4 + 1; suit5 < suits.length; suit5++) {
										String[] fullHouse = {
												face1 + suits[suit1],
												face1 + suits[suit2],
												face1 + suits[suit3],
												face2 + suits[suit4],
												face2 + suits[suit5] };
										getFullHousesWithJokers(fullHouse);
									}
								}
							}
						}
					}
				}
			}
		}
		//		Print the whole collection of unique full houses.
		for (String fullHouse : fullHouseSet) {
			System.out.println("(" + fullHouse + ")");
		}
		System.out.printf("%s full houses", fullHouseSet.size());
	}

	private static void getFullHousesWithJokers(String[] fullHouse) {		
//		Each full house can have a joker substituted for any card, all or none
//		of them, meaning 5 objects with 2 states, or 2 to the power of 5 combinations.
		for (int combination = 0; combination < Math.pow(2, 5); combination++) {
			String[] fullHouseCopy = Arrays.copyOf(fullHouse, fullHouse.length);
//			To generate all the possible hands, we take first 5 bit values
//			from the combination number. The range is from 00000(0) to
//			11111(32 or 2 to the power of 5). We then swap the cards in
//			the positions that match the '1' bits with a joker ('*').
			for (int position = 0; position < 5; position++) {
				if (((combination >> position) & 1) == 1) {
					fullHouseCopy[position] = "*";
				}
			}
//			Because different substitutions can produce a hand with
//			a different order of the same cards, we need to keep the cards
//			in every hand sorted or else we'll end up with effective repeats.
			Arrays.sort(fullHouseCopy);
//			Finish building the full house string, add it to the LinkedHashSet
//			and reset the StringBuilder for the next one.
			for (String card : fullHouseCopy) {
				fullHouseString.append(card + " ");											
			}
			fullHouseSet.add(fullHouseString.toString().trim());
			fullHouseString.setLength(0);
		}
	}
}