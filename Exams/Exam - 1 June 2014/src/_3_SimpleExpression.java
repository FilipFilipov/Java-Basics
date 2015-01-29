import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _3_SimpleExpression {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine().replace(" ", "");
		BigDecimal sum = new BigDecimal("0");
		
		Pattern number = Pattern.compile("[+-]?[0-9.]+");
		Matcher numbers = number.matcher(expression);
		while (numbers.find()) {
			BigDecimal currentNum = new BigDecimal(numbers.group());
			sum = sum.add(currentNum);
		}
		
		DecimalFormat myFormater = new DecimalFormat("0.#######");
		System.out.printf("%s", myFormater.format(sum));
	}
}
