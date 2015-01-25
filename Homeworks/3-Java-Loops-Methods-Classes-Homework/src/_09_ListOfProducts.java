import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class _09_ListOfProducts {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		ArrayList<Product> products = new ArrayList<>();
		try (Scanner input = new Scanner(new File("Input_9.txt"))) {
			while (input.hasNextLine()) {
				String[] line = input.nextLine().split(" ");
				Product product = new Product(line[0], Double.parseDouble(line[1]));
				products.add(product);
			}
		}
		catch (IOException error) {
			System.err.println("Error");
		}
		Collections.sort(products);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Output_9.txt"))) {
			for (Product product : products) {
				writer.write(String.format("%.2f %s", product.getPrice(), product.getName()));
				writer.newLine();
			}
			System.out.println("Results written to Output_9.txt");
		}
		catch (IOException error) {
			System.err.println("Error");
		}
	}
}
