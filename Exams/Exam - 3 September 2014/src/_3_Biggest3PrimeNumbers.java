import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class _3_Biggest3PrimeNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] line = input.nextLine().split("[) (]+");
		int[] numbers = new int[line.length - 1];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(line[i + 1]);
		}
		
		TreeSet<Integer> primes = new TreeSet<>(Collections.reverseOrder());
		for (int number : numbers) {
			if (number > 1) {
				boolean prime = true;
				for (int i = 2; i <= Math.sqrt(number); i++) {
					if (number % i == 0) {
						prime = false;
					}
				}
				if (prime) {
					primes.add(number);
				}
			}
		}
		
		if (primes.size() < 3) {
			System.out.println("No");
			return;
		}
		
		int sum = 0;
		Iterator<Integer> treeIterator = primes.iterator();
		for (int i = 0; i < 3; i++) {
			sum += treeIterator.next();	
		}
		
		System.out.println(sum);
	}
}
