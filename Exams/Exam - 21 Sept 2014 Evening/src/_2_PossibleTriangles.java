import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class _2_PossibleTriangles {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		double[] sides = new double[3];
		boolean triangle = false;
		
		String[] line = input.nextLine().split(" ");
		while(!line[0].equals("End")) {
			for (int i = 0; i < 3; i++) {
				sides[i] = Double.parseDouble(line[i]);
			}
			Arrays.sort(sides);
			double a = sides[0], b = sides[1], c = sides[2];
			if (a + b > c) {				
				System.out.printf("%.2f+%.2f>%.2f\n", a, b, c);
				triangle = true;
			}
			line = input.nextLine().split(" ");
		}
		
		if (!triangle) {
			System.out.println("No");
		}
	}
}
