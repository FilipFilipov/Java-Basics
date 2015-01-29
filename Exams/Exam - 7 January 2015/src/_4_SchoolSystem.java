import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_SchoolSystem {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		TreeMap<String, TreeMap<String, ArrayList<Integer>>> allGrades = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] line = input.nextLine().split(" ");
			String name = line[0] + " " + line[1];
			String subject = line[2];
			int grade = Integer.parseInt(line[3]);
			if (!allGrades.containsKey(name)) {
				allGrades.put(name, new TreeMap<String, ArrayList<Integer>>());
			}
			TreeMap<String, ArrayList<Integer>> subGrades = allGrades.get(name);
			if (!subGrades.containsKey(subject)) {
				subGrades.put(subject, new ArrayList<Integer>());
			}
			ArrayList<Integer> grades = subGrades.get(subject);
			grades.add(grade);
		}
		
		for (String name : allGrades.keySet()) {
			String print = name + ": [";
			for (Map.Entry<String, ArrayList<Integer>> subject : allGrades.get(name).entrySet()) {
				int sum = 0;
				for (int grade : subject.getValue()) {
					sum += grade;
				}
				double average = (double)sum / subject.getValue().size();
				print += subject.getKey() + " - " + String.format("%.2f", average) + ", ";
			}
			System.out.println(print.substring(0, print.length() - 2) + "]"); 
		}
	}
}
