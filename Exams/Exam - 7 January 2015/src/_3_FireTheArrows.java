import java.util.Scanner;

public class _3_FireTheArrows {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		char[][] matrix = new char[n][];
		
		for (int i = 0; i < n; i++) {
			String line = input.nextLine();
			matrix[i] = line.toCharArray();
		}
		
		boolean hasMoved = true;
		while (hasMoved) {
			hasMoved = false;
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[row].length; col++) {
					char symbol = matrix[row][col];
					if (symbol != 'o') {
						int dirRow = 0, dirCol = 0;						
						switch (symbol) {
							case '^':
								dirRow = -1; break;
							case '>':
								dirCol = 1; break;
							case '<':
								dirCol = -1; break;
							case 'v':
								dirRow = 1; break;
						}
						
						int nextRow = row + dirRow;
						int nextCol = col + dirCol;
						if (nextCol >= 0 && nextCol < matrix[row].length
								&& nextRow >= 0 && nextRow < matrix.length
								&& matrix[nextRow][nextCol] == 'o') {						
							matrix[nextRow][nextCol] = symbol;
							matrix[row][col] = 'o';
							hasMoved = true;
						} 
					}
				}
			}			
		}
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col]);
			}
			System.out.println();
		}
	}
}