package abhisheksah.programming;

import java.util.List;

public class P1Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printAllNumberInListStructured(List.of(34,56,78,54,23,56,34,67,48,54,22,23,54));
	}

	private static void printAllNumberInListStructured(List<Integer> numbers) {

		for(int number :numbers) {
			System.out.println(number);
		}
	}

}
