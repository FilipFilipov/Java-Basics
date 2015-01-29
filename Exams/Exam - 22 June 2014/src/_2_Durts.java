import java.util.Scanner;

public class _2_Durts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cX = input.nextInt();
		int cY = input.nextInt();
		int r = input.nextInt();
		int n = input.nextInt();
		
		for (int i = 0; i < n; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			boolean isInside =
				(x >= cX - r && x <= cX + r && y >= cY - r / 2.0 && y <= cY + r / 2.0) ||
				(x >= cX - r / 2.0 && x <= cX + r / 2.0 && y >= cY - r && y <= cY + r);
			System.out.println(isInside ? "yes" : "no"); 
		}
	}
}
