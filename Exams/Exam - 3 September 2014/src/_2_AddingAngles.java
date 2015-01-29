import java.util.Scanner;

public class _2_AddingAngles {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] angles = new int[n];
		for (int i = 0; i < n; i++) {
			angles[i] = input.nextInt();
		}
		
		boolean fullCircle = false;
		if (n >= 3) {
			for (int i = 0; i < angles.length; i++) {
				for (int j = i + 1; j < angles.length; j++) {
					for (int k = j + 1; k < angles.length; k++) {		
						int a = angles[i];
						int b = angles[j];
						int c = angles[k];
						int sum = a + b + c;
						if (sum % 360 == 0) {
							System.out.printf("%d + %d + %d = %d degrees\n",
									a, b, c, sum);
							fullCircle = true;
						}
					}
				}
			}
		}
		
		if (!fullCircle) {
			System.out.println("No");
		}
	}
}
