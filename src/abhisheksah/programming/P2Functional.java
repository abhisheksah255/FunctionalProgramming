package abhisheksah.programming;

import java.util.List;

public class P2Functional {
	
	private static int sum(int a, int b) {
		return a+b ;
	}

	public static void main(String[] args) {

	
		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,45,21,23,54);
		int result =printAddListFunctional(numbers);
		System.out.println(result);
	
	}

	private static int printAddListFunctional(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream().reduce(0,P2Functional::sum);
	}


}
