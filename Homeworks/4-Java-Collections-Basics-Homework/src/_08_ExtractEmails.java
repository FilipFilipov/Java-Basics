import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _08_ExtractEmails {	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some text:");
		String text = input.nextLine();
		Pattern email = Pattern.compile("([a-zA-Z0-9]+[._-]?[a-zA-Z0-9]+)+"
				+ "@([A-Za-z]+-?[A-Za-z]+)+(\\.[A-Za-z]+-?[A-Za-z]+)+");
		Matcher matcher = email.matcher(text);
		System.out.println("Email address(es) in your text:");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}