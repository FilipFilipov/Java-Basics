import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _08_SumNumbersFromATextFile {	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("Input_8.txt"))) {
			long sum = 0;
			while (input.hasNextInt()) {
				sum += input.nextInt();
			}
			System.out.println("Sum = " + sum);
		}
		catch (FileNotFoundException error) {
			System.err.println("Error");
		}
	}
}
