import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_OfficeStuff {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		TreeMap<String, LinkedHashMap<String, Integer>> companiesMap = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] line = input.nextLine().split(" - ");
			String company = line[0];
			int amount = Integer.parseInt(line[1]);
			String product = line[2];
			if (!companiesMap.containsKey(company)) {
				companiesMap.put(company, new LinkedHashMap<>());
			}
			LinkedHashMap<String, Integer> productAmounts = companiesMap.get(company);
			int totalAmount = productAmounts.containsKey(product) ? productAmounts.get(product) : 0;
			productAmounts.put(product, totalAmount + amount);
		}
		
		for (Map.Entry<String, LinkedHashMap<String, Integer>> company : companiesMap.entrySet()) {
			String output = company.getKey() + ": " + company.getValue();
			System.out.println(output.replace('=', '-').replaceAll("[{|}]", ""));
		}
	}
}
