import java.util.Scanner;

public class _05_DecimalToHexadecimal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer in decimal:");
		int decimal = input.nextInt();
		System.out.printf("Your number in hex is %X.", decimal);
	}
}
