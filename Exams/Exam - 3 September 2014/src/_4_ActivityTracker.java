import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_ActivityTracker {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		TreeMap<Integer, TreeMap<String, Integer>> activities = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] line = input.nextLine().split("[ /]");
			int month = Integer.parseInt(line[1]);
			String name = line[3];
			int distance = Integer.parseInt(line[4]);
			if (!activities.containsKey(month)) {
				activities.put(month, new TreeMap<String, Integer>());
			}
			TreeMap<String, Integer> activity = activities.get(month);
			int totalDistance = activity.containsKey(name) ? activity.get(name) : 0;
			activity.put(name, totalDistance + distance);
		}
		
		for (Integer month : activities.keySet()) {
			String print = month + ": ";
			for (Map.Entry<String, Integer> user : activities.get(month).entrySet()) {
				print += user.getKey() + "(" + user.getValue() + "), ";
			}
			System.out.println(print.substring(0, print.length() - 2));
		}
	}
}
