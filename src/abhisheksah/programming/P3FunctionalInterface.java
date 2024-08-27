package abhisheksah.programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class P3FunctionalInterface {
	
//	private static boolean isEven(int x) {
//		return x%2==0;
//	}
//	private static int square(int x) {
//		return x*x ;
//	}

	public static void main(String[] args) {

	
		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,45,21,23,54);
		
		Predicate<Integer> isEvenpredicate = x ->x%2==0;
		Predicate<Integer> isEvenpredicate1 = new Predicate<Integer>(){

			@Override
			public boolean test(Integer x) {
				return x%2==0;
			}
			
		};
		
		Function<Integer, Integer> squaremapper = x ->x*x;
		Function<Integer, Integer> squaremapper1 =new Function<Integer, Integer> (){

			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
			};
		
		Consumer<Integer> printaction = System.out::println;
		Consumer<Integer> printaction2 = new Consumer<Integer>()
				{
			public void accept(Integer x) {
				System.out.println(x);
			}
		};
		
		
		numbers.stream().
		filter(isEvenpredicate).
		map(squaremapper).
		forEach(printaction);
		
		
		
		//Behavior Parameterization 
		System.out.println("*************");

		filterAndPrint(numbers, x->x%2!=0);
		System.out.println("*************");
		filterAndPrint(numbers, x->x%2==0);
		System.out.println("*************");
		filterAndPrint(numbers, x->x%3==0);
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> oddPredicate) {
		numbers.stream()
		.filter(oddPredicate)
//		.map(x->x*x*x)
		.forEach(System.out::println);
	}
	
	
	

}
