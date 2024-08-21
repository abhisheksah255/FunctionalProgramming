package abhisheksah.programming;

import java.util.List;

public class P1Excercise {

	public static void main(String[] args) {

	
		List<Integer> numbers = List.of(34,56,78,54,53,56,33,67,48,45,21,23,54);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		System.out.println("Exercise Questions");
		System.out.println("Print Only Odd Numbers from the List");
		numbers.stream().filter(n ->n%2!=0).forEach(System.out::println);
		System.out.println("Print the cubes of odd numbers");
		printCubeOfOddNumberInListFunctional(numbers);
		System.out.println("Print the square of even numbers");
		printSquareOfEvenNumberInListFunctional(numbers);
		
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

	private static void printCubeOfOddNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(n ->n%2!=0).map(n ->n*n*n)
		.forEach(System.out::println);
	}
	
	private static void printSquareOfEvenNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(n ->n%2==0).map(n ->n*n)
		.forEach(System.out::println);
	}



}
