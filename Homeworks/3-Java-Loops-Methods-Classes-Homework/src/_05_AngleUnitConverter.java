import java.util.Scanner;

public class _05_AngleUnitConverter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of conversions you want to make: ");
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter number and unit:");			
			double number = input.nextDouble();
			String unit = input.next();
			convert(number, unit);			
		}
	}

	private static void convert(double number, String unit) {
		if (unit.equals("deg")) {
			System.out.printf("%.6f rad\n", Math.toRadians(number));
		}
		else {
			System.out.printf("%.6f deg\n", Math.toDegrees(number));
		}
	}
}
