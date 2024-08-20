package abhisheksah.programming;

import java.util.List;

public class P1Functional {
	
	private static void print(int number) {
		System.out.println(number);
	}

	public static void main(String[] args) {

	
	
		printAllNumberInListFunctional(List.of(34,56,78,54,23,56,34,67,48,54,22,23,54));
	}

	private static void printAllNumberInListFunctional(List<Integer> numbers) {

		numbers.stream().forEach(P1Functional::print);//method Reference
	}

}
