import java.util.Scanner;

public class _02_TriangleArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter triangle coordinates:");
		int aX = input.nextInt();
		int aY = input.nextInt();
		int bX = input.nextInt();
		int bY = input.nextInt();
		int cX = input.nextInt();
		int cY = input.nextInt();
		double area = Math.abs((aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2.0);
		System.out.println("Area = " + (int)area + " cm\u00B2.");
	}

}
