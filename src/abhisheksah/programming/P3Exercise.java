package abhisheksah.programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P3Exercise {
	
//	private static boolean isEven(int x) {
//		return x%2==0;
//	}
//	private static int square(int x) {
//		return x*x ;
//	}

	public static void main(String[] args) {

	
		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,45,21,23,54);
		int sum=0;
		System.out.println("Question");
		System.out.println("Find Functional Interface behind the second argument of reduce method. Create an implementation for the Functional Interface.\r\n"
				+ "\r\n"
				+ "int sum = numbers.stream() .reduce(0, Integer::sum);");
		
		BinaryOperator<Integer> sumAccumulator1 =new BinaryOperator<Integer>(){

			@Override
			public Integer apply(Integer a, Integer b) {
				return a+b;
			}};
		BinaryOperator<Integer> sumAccumulator = Integer::sum;
		
		sum = numbers.stream() .reduce(0, sumAccumulator1);
		System.out.println("Result :- "+sum);
		
		System.out.println("*******************************************************************************");
		
	System.out.println("Do Behavior Parameterization for the mapping logic.\r\n"
			+ "\r\n"
			+ "List squaredNumbers = numbers.stream() .map(x -> x*x) .collect(Collectors.toList());");	
	
	
	Function<Integer, Integer> squareNumber = x -> x*x;
	Function<Integer, Integer> cubeNumber = x -> x*x*x;
	Function<Integer, Integer> doubleNumber = x -> x+x;
	
	List squaredNumbers = mapAndPrint(numbers, squareNumber);
	
		System.out.println("Result :- "+squaredNumbers);
	
	}

	private static List<? extends Integer> mapAndPrint(List<Integer> numbers,
			Function<? super Integer, ? extends Integer> squareNumber) {
		return numbers.stream()
				.map(squareNumber)
				.collect(Collectors.toList());
	}
		
}
