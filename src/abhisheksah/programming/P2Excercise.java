package abhisheksah.programming;


import java.util.List;
import java.util.stream.Collectors;

public class P2Excercise {

	public static void main(String[] args) {

		
		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,45,21,23,54);
		int sum=0;
		
		System.out.println("Exercise Questions");

		System.out.println("Print Only Odd Numbers from the List");
		numbers.stream().filter(n ->n%2!=0).forEach(System.out::println);
		
		System.out.println("Print the cubes of odd numbers");
		printCubeOfOddNumberInListFunctional(numbers);
		
		System.out.println("Print the square of even numbers");
		printSquareOfEvenNumberInListFunctional(numbers);
		
		System.out.println("Square every number in a list and find the sum of squares");
		sum=printSquareListSum(numbers);
		System.out.println(sum);
		
		System.out.println("Square every number in a list and find the sum of Cube");
		sum=printCubeListSum(numbers);
		System.out.println(sum);
		
		System.out.println("Find Sum of Odd Numbers in a list");
		sum=printListOfOddNumberSum(numbers);
		System.out.println(sum);
		
		
		System.out.println("Create a List with Even Numbers Filtered from the Numbers List");
		List<Integer>evenNumber=printNewListOfEvenNumber(numbers);
		System.out.println(evenNumber);
		
		System.out.println("Create a List with lengths of all course titles");
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
//		List<String>courseLength= courses.stream().sorted(Comparator.comparing(str -> str.length())).collect(Collectors.toList());
		
		List<Integer>courseLength= courses.stream().map(str ->str.length()).collect(Collectors.toList());
		
		System.out.println(courseLength);
		
		System.out.println("Print All Courses individually");
		courses.stream().forEach(System.out::println);

		System.out.println("Print Courses Containing the word \"Spring\"");
		courses.stream().filter(n ->n.contains("Spring")).forEach(System.out::println);
		
		System.out.println("Print Courses Whose Name has atleast 4 letters");
		courses.stream().filter(n -> n.length()>=4).forEach(System.out::println);

		System.out.println("Print the number of characters in each course name");
		courses.stream().map(c -> c +" "+ c.length()).forEach(System.out::println);
		
		System.out.println("*********");
	}


	private static List<Integer> printNewListOfEvenNumber(List<Integer> numbers) {
		return numbers.stream().filter(x -> x%2==0).collect(Collectors.toList());
	}

	private static void printCubeOfOddNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(n ->n%2!=0).map(n ->n*n*n)
		.forEach(System.out::println);
	}
	
	private static void printSquareOfEvenNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(n ->n%2==0).map(n ->n*n)
		.forEach(System.out::println);
	}

	private static int printSquareListSum(List<Integer> numbers) {
		return numbers.stream().map(n ->n*n).reduce(0,Integer::sum);
	}


	private static int printCubeListSum(List<Integer> numbers) {
		return numbers.stream().map(n ->n*n*n).reduce(0,Integer::sum);
	}
	private static int printListOfOddNumberSum(List<Integer> numbers) {
		return numbers.stream().filter(n ->n%2!=0)
		.reduce(0,Integer::sum);
	}
	
	
}
