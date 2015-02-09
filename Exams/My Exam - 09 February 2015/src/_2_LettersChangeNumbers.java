import java.util.Locale;
import java.util.Scanner;

public class _2_LettersChangeNumbers {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		String[] tokens = input.nextLine().split("\\s+");
		double total = 0;
		
		for (String token : tokens) {
			double sum = Integer.parseInt(token.substring(1, token.length() - 1));
			
			char before = token.charAt(0);
			if (Character.isUpperCase(before)) {
				sum /= before - 'A' + 1;
			}
			else {
				sum *= before - 'a' + 1;
			}
			
			char after = token.charAt(token.length() - 1);
			if (Character.isUpperCase(after)) {
				sum -= after - 'A' + 1;
			}
			else {
				sum += after - 'a' + 1;
			}
			
			total +=sum;
		}
		
		System.out.printf("%.2f\n", total);
	}
}
