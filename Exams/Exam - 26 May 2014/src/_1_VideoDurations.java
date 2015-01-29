import java.util.Scanner;

public class _1_VideoDurations {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long result = 0;
		String line = input.nextLine();
		
		while (!line.equals("End")) {
			String[] time = line.split(":");
			result += 60 * Integer.parseInt(time[0]) + Integer.parseInt(time[1]);
			line = input.nextLine();
		}
		
		System.out.printf("%d:%02d", result / 60, result % 60);
	}
}
