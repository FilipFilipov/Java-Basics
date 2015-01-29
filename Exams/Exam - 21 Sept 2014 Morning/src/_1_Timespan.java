import java.util.Scanner;

public class _1_Timespan {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] start = input.nextLine().split(":");
		String[] end = input.nextLine().split(":");
		
		long startSec = convertToSec(start);
		long endSec = convertToSec(end);
		long result = startSec - endSec;
		
		System.out.printf("%d:%02d:%02d", result / 3600, (result % 3600) / 60, result % 60);
	}

	private static long convertToSec(String[] start) {
		return Long.parseLong(start[0]) * 3600 +
				Long.parseLong(start[1]) * 60 +
				Long.parseLong(start[2]);
	}
}
