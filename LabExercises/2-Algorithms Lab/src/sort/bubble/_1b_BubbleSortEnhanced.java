package sort.bubble;

import java.util.ArrayList;
import java.util.Scanner;

//import org.apache.commons.lang3.time.StopWatch;

public class _1b_BubbleSortEnhanced {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] numbers = scan.nextLine().replace("[", "").replace("]", "").split(", ");
		ArrayList<Integer> numbersArr = new ArrayList<Integer>();

		for (String number : numbers) {
			numbersArr.add(Integer.parseInt(number));
		}

//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();

		boolean swapped;
		int unsorted = numbersArr.size();
		do {
			swapped = false;
			for (int i = 0; i < unsorted - 1; i++) {
				if(numbersArr.get(i) > (numbersArr.get(i + 1))) {
					int temp = numbersArr.get(i);
					numbersArr.set(i, numbersArr.get(i + 1)); 
					numbersArr.set(i + 1, temp);
					swapped = true;
				}
			}
			unsorted--;
		} while (swapped);

//		stopWatch.stop();
//		long time = stopWatch.getTime();

		System.out.println(numbersArr);
//      System.out.println(time/1000.0);
	}
}