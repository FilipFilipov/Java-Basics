import java.util.Scanner;

public class _1_CountBeers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int beers = 0;
		
		String[] line = input.nextLine().split(" ");
		while (!line[0].equals("End")) {
			int amount = Integer.parseInt(line[0]);
			beers += (line[1].equals("stacks")) ? (amount * 20) : amount;
			line = input.nextLine().split(" ");
		}
		
		System.out.printf("%d stacks + %d beers", beers / 20, beers % 20);
	}
}
