import java.util.Scanner;

public class _1_DozensOfEggs {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalcount = 0;
		
		for (int i = 0; i < 7; i++) {
			int count = input.nextInt();
			String measure = input.next();
			totalcount += measure.equals("dozens") ? (count * 12) : count;
		}
		
		System.out.printf("%d dozens + %d eggs", totalcount / 12, totalcount % 12);
	}
}
