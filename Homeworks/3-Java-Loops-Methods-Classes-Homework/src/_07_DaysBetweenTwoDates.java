//	This program uses the external Joda-Time library.

import java.util.Scanner;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class _07_DaysBetweenTwoDates {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DateTimeFormatter format = DateTimeFormat.forPattern("dd-MM-yyyy");
		System.out.println("Enter 2 dates on different lines:");
		LocalDate first = format.parseLocalDate(input.nextLine());
		LocalDate second = format.parseLocalDate(input.nextLine());
		Days difference = Days.daysBetween(first, second);
		System.out.println(difference.getDays() + " days difference.");		
	}
}
