import java.util.Scanner;

public class _08_SortArrayOfStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		String[] stringsToSort = new String[number];
		for (int i = 0; i < number; i++) {
			stringsToSort[i] = input.next();
		}
		bubbleSort(stringsToSort);
		System.out.println("Sorted strings:");
		for (String str : stringsToSort) {
			System.out.println(str);
		}
	}

//	Go to http://visualgo.net/sorting.html
//	for an interactive visual demo of the algorithm this method implements
	private static void bubbleSort(String[] stringsToSort) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < stringsToSort.length - 1; i++) {
				if(stringsToSort[i].compareTo(stringsToSort[i + 1]) > 0) {
					String temp = stringsToSort[i];
					stringsToSort[i] = stringsToSort[i + 1]; 
					stringsToSort[i + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
	}
}
