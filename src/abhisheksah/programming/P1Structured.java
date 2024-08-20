package abhisheksah.programming;

import java.util.List;

public class P1Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,54,21,23,54);
		printAllNumberInListStructured(numbers);
		System.out.println("******************");
		printAllEvenNumbersInListStructured(numbers);
	}

	private static void printAllNumberInListStructured(List<Integer> numbers) {

		for(int number :numbers) {
			System.out.println(number);
		}
	}
	
	private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {

		for(int number :numbers) {
			if(number%2==0) {
			System.out.println(number);
		}
		}
	}

}
