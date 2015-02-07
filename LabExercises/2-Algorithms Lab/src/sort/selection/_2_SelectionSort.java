package sort.selection;

import java.util.ArrayList;
import java.util.Scanner;

//import org.apache.commons.lang3.time.StopWatch;

public class _2_SelectionSort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] numbers = scan.nextLine().replace("[", "").replace("]", "").split(", ");
		ArrayList<Integer> numbersArr = new ArrayList<Integer>();

		for (String number : numbers) {
			numbersArr.add(Integer.parseInt(number));
		}

//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();

		int min;
		for (int i = 0; i < numbers.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if(numbersArr.get(j) < numbersArr.get(min)) {
					min = j;					
				}
			}
			
			if (min != i) {
				int temp = numbersArr.get(i);
				numbersArr.set(i, numbersArr.get(min)); 
				numbersArr.set(min, temp);
			}			
		}
			
//		stopWatch.stop();
//		long time = stopWatch.getTime();

		System.out.println(numbersArr);
//      System.out.println(time/1000.0);
	}
}