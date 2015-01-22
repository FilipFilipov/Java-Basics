import java.awt.geom.Point2D;
import java.util.Locale;
import java.util.Scanner;

public class _09_PointsInsideTheHouse {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter coordinates to check if point is inside figure:");
		double x = input.nextDouble();
		double y = input.nextDouble();
		boolean isInside =
				isInTriangle(x, y) ||
				(x >= 12.5 && x <= 17.5 && y >= 8.5 && y <= 13.5) ||
				(x >= 20 && x <= 22.5 && y >= 8.5 && y <= 13.5);
		System.out.println(isInside ? "Inside" : "Outside");
	}

	private static boolean isInTriangle(double x, double y) {
		Point2D p1 = new Point2D.Double(12.5, 8.5);
		Point2D p2 = new Point2D.Double(17.5, 3.5);
		Point2D p3 = new Point2D.Double(22.5, 8.5);		
		boolean b1 = getLineSide(x, y, p1, p2) >= 0;
		boolean b2 = getLineSide(x, y, p2, p3) >= 0;
		boolean b3 = y <= 8.5;
		return b1 && b2 && b3;
	}				

//	Positive result means the point is to the right of the line,
//	negative means to the left, zero means the point is part of the line.
//	The line's "forward" direction is defined as p1 -> p2, so in a closed
//	non-intersecting polygon, an inside point should give the
//	same-signed result for all the lines.
	private static double getLineSide(double x, double y, Point2D p1, Point2D p2) {		
		return (x - p2.getX()) * (p1.getY() - p2.getY()) -
				(p1.getX() - p2.getX()) * (y - p2.getY());
	}
}