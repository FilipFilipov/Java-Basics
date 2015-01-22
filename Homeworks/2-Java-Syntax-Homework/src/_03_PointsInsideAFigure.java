import java.util.Locale;
import java.util.Scanner;

public class _03_PointsInsideAFigure {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter coordinates to check if point is inside figure:");
		double x = input.nextDouble();
		double y = input.nextDouble();
		boolean isInside =
				(x >= 12.5 && x <= 22.5 && y >= 6 && y <= 8.5) ||
				(x >= 12.5 && x <= 17.5 && y >= 8.5 && y <= 13.5) ||
				(x >= 20 && x <= 22.5 && y >= 8.5 && y <= 13.5);
		System.out.println(isInside ? "Inside" : "Outside");
	}

}
