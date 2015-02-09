import java.util.Scanner;

public class _1_GandalfsStash {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int mood = input.nextInt();
		input.nextLine();
		String[] food = input.nextLine().toLowerCase().split("[^a-z]+");

		for (String item : food) {
			switch (item) {
			case "cram":
				mood += 2; break;
			case "lembas":
				mood += 3; break;
			case "apple":
				mood += 1; break;
			case "melon":
				mood += 1; break;
			case "honeycake":
				mood += 5; break;
			case "mushrooms":
				mood -= 10; break;
			default:
				mood -= 1; break;
			}
		}

		String result = "";
		if (mood < -5) {
			result = "Angry";
		}
		else if (mood < 0) {
			result = "Sad";
		}
		else if (mood < 15) {
			result = "Happy";
		}
		else {
			result = "Special JavaScript mood";
		}
		
		System.out.println(mood + "\n" + result);
	}
}
