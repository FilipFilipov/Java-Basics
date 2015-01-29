import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _3_Largest3Rectangles {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		String rectangles = input.nextLine();
		
		Pattern digits = Pattern.compile("\\d+");
		Matcher sides = digits.matcher(rectangles);
		ArrayList<Integer> areas = new ArrayList<>();
		
		while (sides.find()) {
			int sideA = Integer.parseInt(sides.group());
			sides.find();
			int sideB = Integer.parseInt(sides.group());
			areas.add(sideA * sideB);
		}
		
		int maxSum = 0;
		for (int i = 0; i < areas.size() - 2; i++) {
			int sum = 0;
			sum += areas.get(i) + areas.get(i + 1) + areas.get(i + 2);
			maxSum = Math.max(sum, maxSum);
		}
		
		System.out.println(maxSum);
	}
}
