public class _03_FullHouse {

	public static void main(String[] args) {
		char[] suits = { '♣', '♥', '♠', '♦' };
		String[] faces = { "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "J", "Q", "K", "A"};
		int fullHouses = 0;
		for (String face1 : faces) {
			for (String face2 : faces) {
				if (!face1.equals(face2)) {
					for (int suit1 = 0; suit1 < suits.length; suit1++) {
						for (int suit2 = suit1 + 1; suit2 < suits.length; suit2++) {
							for (int suit3 = suit2 + 1; suit3 < suits.length; suit3++) {
								for (int suit4 = 0; suit4 < suits.length; suit4++) {
									for (int suit5 = suit4 + 1; suit5 < suits.length; suit5++) {
										System.out.println("(" +
												face1 + suits[suit1] + " " +
												face1 + suits[suit2] + " " +
												face1 + suits[suit3] + " " +
												face2 + suits[suit4] + " " +
												face2 + suits[suit5] + ")");
										fullHouses++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(fullHouses + " Full houses");
	}
}
