import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class _10_OrderOfProducts {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		ArrayList<Product> products = new ArrayList<>();
		double sum = 0;
		try (Scanner input = new Scanner(new File("Products_10.txt"))) {
			while (input.hasNextLine()) {
				String[] line = input.nextLine().split(" ");
				Product product = new Product(line[0], Double.parseDouble(line[1]));
				products.add(product);
			}
		}
		catch (IOException error) {
			System.err.println("Error");
		}
		
		try (Scanner input = new Scanner(new File("Order_10.txt"))) {
			while (input.hasNextLine()) {
				String[] line = input.nextLine().split(" ");
				double amount = Double.parseDouble(line[0]);
				String name = line[1];
				for (Product product : products) {
					if (name.equals(product.getName())) {
						sum += amount * product.getPrice();
					}
				}
			}
		}
		catch (IOException error) {
			System.err.println("Error");
		}
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Output_10.txt"))) {
			writer.write(String.format("%.2f", sum));
			System.out.println("Results written to Output_10.txt");
		}
		catch (IOException error) {
			System.err.println("Error");
		}
	}
}
