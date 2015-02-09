import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_UserLogs {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();
		
		while (!line.equals("end")) {
			String[] tokens = line.split("[= ]");
			String ip = tokens[1];
			String user = tokens[5];
			
			if (!logs.containsKey(user)) {
				logs.put(user, new LinkedHashMap<String, Integer>());
			}
			
			LinkedHashMap<String, Integer> log = logs.get(user);
			int count = log.containsKey(ip) ? log.get(ip) : 0;
			log.put(ip, ++count);
			
			line = input.nextLine();
		}
		
		for (String user : logs.keySet()) {
			System.out.println(user + ":");
			String log = logs.get(user).toString();
			System.out.println(log.replaceAll("[{}]", "").replace("=", " => ") + ".");
		}
	}
}
