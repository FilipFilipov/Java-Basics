import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

 public class _3_LegoBlocks {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		ArrayList<ArrayList<String>> joinedBlock = new ArrayList<>(n);
		
		for (int i = 0; i < 2 * n; i++) {
			String[] line = input.nextLine().trim().split("\\s+");
			ArrayList<String> lineNums = new ArrayList<String>(Arrays.asList(line));
			if (i < n) {
				joinedBlock.add(lineNums);
			}
			else {
				Collections.reverse(lineNums);
				joinedBlock.get(i - n).addAll(lineNums);
			}			
		}
		
		int width = joinedBlock.get(0).size();
		boolean fitting = true;
		long cells = 0;
		
		for (int i = 0; i < n; i++) {
			int size = joinedBlock.get(i).size();
			if (size != width) {
				fitting = false;
			}
			cells += size;
		}
		
		if (fitting) {
			for (ArrayList<String> arrayList : joinedBlock) {
				System.out.println(arrayList);
			}			
		}
		else {			
			System.out.printf("The total number of cells is: %d\n", cells);
		}		
	}
}
