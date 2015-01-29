import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class _3_ExamScore {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		TreeMap<Integer, TreeMap<String, Double>> averages = new TreeMap<>();
		
		for (int i = 0; i < 3; i++) {
			input.nextLine();
		}
		
		String[] line = input.nextLine().split("\\s*\\|\\s*");
		while (!line[0].contains("-")) {
			String name = line[1];
			int score = Integer.parseInt(line[2]);
			double grade = Double.parseDouble(line[3]);
			if (!averages.containsKey(score)) {
				averages.put(score, new TreeMap<String, Double>());
			}
			TreeMap<String, Double> grades = averages.get(score);
			grades.put(name, grade);
			line = input.nextLine().split("\\s*\\|\\s*");
		}
		
		for (Integer score : averages.keySet()) {
			TreeMap<String, Double> grades = averages.get(score);
			System.out.print(score + " -> " + grades.keySet() + "; ");
			double sum = 0;
			for (double grade : grades.values()) {
				sum += grade;
			}
			System.out.printf("avg=%.2f\n", sum / grades.values().size());
		}
	}
}
