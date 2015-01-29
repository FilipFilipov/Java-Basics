import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class _4_LogsAggregator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		TreeMap<String, Integer> totalDurations = new TreeMap<>();
		TreeMap<String, TreeSet<String>> ipAdresses = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String ip = input.next();
			String name = input.next();
			int duration = input.nextInt();
			int totalDuration = totalDurations.containsKey(name) ? totalDurations.get(name) : 0;
			totalDurations.put(name, totalDuration + duration);			
			if (!ipAdresses.containsKey(name)) {
				ipAdresses.put(name, new TreeSet<>());
			}
			TreeSet<String> ips = ipAdresses.get(name);
			ips.add(ip);
		}
		
		for (Map.Entry<String, Integer> durations : totalDurations.entrySet()) {
			String user = durations.getKey();
			System.out.println(user + ": " + durations.getValue() + " " + ipAdresses.get(user));
		}
	}
}
