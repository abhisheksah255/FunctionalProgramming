package abhisheksah.programming;

import java.util.List;

public class P1Functional {
	
//	private static void print(int number) {
//		System.out.println(number);
//	}

	public static void main(String[] args) {

	
		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,45,21,23,54);
		printAllNumberInListFunctional(numbers);
		System.out.println("*********");
		printAllEvenNumberInListFunctional(numbers);
	}

	private static void printAllEvenNumberInListFunctional(List<Integer> numbers) {

		numbers.stream().filter(n ->n%2==0).forEach(System.out::println);
}

	private static void printAllNumberInListFunctional(List<Integer> numbers) {

		numbers.stream().forEach(System.out::println);//method Reference
	}

}
