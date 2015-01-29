import java.util.Scanner;

public class _1_MirrorNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.nextLine();		
		String[] numbers = input.nextLine().split(" ");
		StringBuilder reverser = new StringBuilder(4);
		boolean mirror = false;
		
		for (int i = 0; i < numbers.length - 1; i++) {
			reverser.replace(0, 4, numbers[i]).reverse();
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j].equals(reverser.toString())) {			
					System.out.printf("%s<!>%s\n", numbers[i], reverser);
					mirror = true;
				}				
			}
		}
		
		if (!mirror) {
			System.out.println("No");
		}
	}
}
