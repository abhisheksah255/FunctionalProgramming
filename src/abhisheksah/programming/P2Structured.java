package abhisheksah.programming;

import java.util.List;

public class P2Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,54,21,23,54);
		
		int result = printAddListStructured(numbers);
		System.out.println(result);
	}

	private static int printAddListStructured(List<Integer> numbers) {

		int sum=0;
		for(int number : numbers) {
			sum= sum+number;
		}
		
		return sum;
		
	}

	

}
