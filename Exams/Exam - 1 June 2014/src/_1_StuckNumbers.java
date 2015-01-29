import java.util.Scanner;

public class _1_StuckNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = input.nextInt();
		}
		
		boolean stuck = false;
		for (int a : numbers) {
			for (int b : numbers) {
				if (a != b) {
					for (int c : numbers) {
						if (a != c && b != c) {
							for (int d : numbers) {
								if (a != d && b != d && c != d) {
									
									String ab = "" + a + b;
									String cd = "" + c + d;
									if ((ab).equals(cd)) {
										System.out.printf("%d|%d==%d|%d\n", a, b, c, d);
										stuck = true;
									}
								}
							}
						}
					}
				}
			}
		}
		
		if (!stuck) {
			System.out.println("No");
		}
	}
}
