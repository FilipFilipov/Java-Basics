import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _3_ValidUsernames {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] names = input.nextLine().split("[\\s\\\\/()]+");
		ArrayList<String> validNames = new ArrayList<>();
		
		Pattern valid = Pattern.compile("[A-Za-z][\\w]{2,24}");
		for (String name : names) {
			Matcher validName = valid.matcher(name);
			if (validName.matches()) {
				validNames.add(name);
			}
		}
		
		int maxLength = 0;
		String result = "";
		for (int i = 0; i < validNames.size() - 1; i++) {
			int length = validNames.get(i).length() + validNames.get(i + 1).length();
			if (length > maxLength) {
				maxLength = length;
				result = validNames.get(i) + "\n" + validNames.get(i + 1);
			}
		}
		
		System.out.println(result);
	}
}
