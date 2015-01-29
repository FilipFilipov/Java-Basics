import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2_TerroristsWin {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		char[] result = text.toCharArray();
		
		Pattern bomb = Pattern.compile("\\|[^|]*\\|");
		Matcher bombs = bomb.matcher(text);
		while (bombs.find()) {
			char[] bombText = bombs.group().replace("|", "").toCharArray();
			
			int charSum = 0;
			for (char letter : bombText) {
				charSum += letter;			
			}
			int power = charSum % 10;
			
			for (int i = 0; i < result.length; i++) {
				if (i >= bombs.start() - power &&
						i < bombs.end() + power) {
					result[i] = '.';
				}
			}
		}
		
		for (char letter : result) {
			System.out.print(letter);
		}	
	}
}
