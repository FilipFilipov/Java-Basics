import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_Nuts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		TreeMap<String, LinkedHashMap<String, Integer>> companies = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] line = input.nextLine().split(" ");
			String company = line[0];
			String nut = line[1];
			int amount = Integer.parseInt(line[2].replace("kg", ""));
			if (!companies.containsKey(company)) {
				companies.put(company, new LinkedHashMap<String, Integer>());
			}
			LinkedHashMap<String, Integer> nuts = companies.get(company);
			int totalNuts = nuts.containsKey(nut) ? nuts.get(nut) : 0;
			nuts.put(nut, totalNuts + amount);
		}
		
		for (String company : companies.keySet()) {
			String print = company + ": ";
			for (Map.Entry<String, Integer> nut : companies.get(company).entrySet()) {
				print += nut.getKey() + "-" + nut.getValue() + "kg, ";
			}
			System.out.println(print.substring(0, print.length() - 2));
		}
	}
}
