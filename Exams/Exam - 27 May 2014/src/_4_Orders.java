import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_Orders {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		LinkedHashMap<String, TreeMap<String, Integer>> orders = new LinkedHashMap<>();
		
		for (int i = 0; i < n; i++) {
			String name = input.next();
			int amount = input.nextInt();
			String product = input.next();
			
			if (!orders.containsKey(product)) {
				orders.put(product, new TreeMap<String, Integer>());
			}
			TreeMap<String, Integer> amounts = orders.get(product);
			int totalAmount = amounts.containsKey(name) ? amounts.get(name) : 0;
			amounts.put(name, totalAmount + amount);		
		}
		
		for (Map.Entry<String, TreeMap<String, Integer>> order : orders.entrySet()) {
			String prodectOrders = order.getValue().toString().replaceAll("[{}]", "");
			System.out.println(order.getKey() + ": " + prodectOrders.replace("=", " "));
		}
	}
}