package sort.insertion;

import java.util.ArrayList;
import java.util.Scanner;

//import org.apache.commons.lang3.time.StopWatch;

public class _3_InsertionSort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] numbers = scan.nextLine().replace("[", "").replace("]", "").split(", ");
		ArrayList<Integer> numbersArr = new ArrayList<Integer>();

		for (String number : numbers) {
			numbersArr.add(Integer.parseInt(number));
		}

		//	StopWatch stopWatch = new StopWatch();
		//	stopWatch.start();

		int current;
		for (int i = 1; i < numbersArr.size(); i++) {
			current = numbersArr.get(i);
			int j = i;
			while (j > 0 && numbersArr.get(j - 1) > current) {				
				numbersArr.set(j, numbersArr.get(j - 1));					
				j--;
			}
			numbersArr.set(j, current);
		}

		//	stopWatch.stop();
		//	long time = stopWatch.getTime();

		System.out.println(numbersArr);
		//  System.out.println(time/1000.0);
	}
}