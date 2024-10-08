package abhisheksah.programming;

import java.util.List;
import java.util.stream.Collectors;

public class P2Functional {
	
	private static int sum(int a, int b) {
		return a+b ;
	}

	public static void main(String[] args) {

	
		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,45,21,23,54);
		int result=0;
		result =printAddListFunctional(numbers);
		System.out.println(result);
		
		result =printAddListFunctional1(numbers);
		System.out.println(result);
		result =printAddListFunctional2(numbers);
		System.out.println(result);
		
		List<Integer> oddNumber=OddNumberList(numbers);
	System.out.println(oddNumber);
	
	List<Integer> squareNumber=squareNumberList(numbers);
	System.out.println(squareNumber);
	
	}
	//these are the ways to print the output as a another list 
	private static List<Integer> OddNumberList(List<Integer> numbers) {
		return numbers.stream().filter(number -> number%2==1).collect(Collectors.toList());
	}
	
	private static List<Integer> squareNumberList(List<Integer> numbers) {
		return numbers.stream().map(number -> number*number).collect(Collectors.toList());
	}
		//These are the 3 ways to to get sum of list
	
	private static int printAddListFunctional(List<Integer> numbers) {
		return numbers.stream().reduce(0,Integer::sum);
	}
	private static int printAddListFunctional1(List<Integer> numbers) {
		return numbers.stream().reduce(0,P2Functional::sum);
	}
	private static int printAddListFunctional2(List<Integer> numbers) {
		return numbers.stream().reduce(0,(x,y) -> x+y);
	}
	
	


}
