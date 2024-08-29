package abhisheksah.programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
				+ noOfStudents + "]";
	}

	
	
}

public class P4CustomClass2 {

	public static void main(String[] args) {

		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), 
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), 
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

//AllMatch,NonMatch,anymatch methods
		Predicate< Course> ratingGreaterThenNintyPredicate = x ->x.getReviewScore()>90;
		Predicate< Course> ratingGreaterThenNintyFivePredicate = x ->x.getReviewScore()>95;
		Predicate< Course> ratingLessThenNintyFivePredicate = x ->x.getReviewScore()<95;
		
		System.out.println(
				courses.stream().allMatch(ratingGreaterThenNintyPredicate)
				);
		System.out.println(
				courses.stream().anyMatch(ratingLessThenNintyFivePredicate)
				);
		System.out.println(
				courses.stream().noneMatch(ratingGreaterThenNintyFivePredicate)
				);
		
		//sorting by using Comparator and store in newlist
		
		Comparator<Course> numberOfStudent=Comparator.comparing(Course::getNoOfStudents);
		System.out.println(courses.stream().sorted(numberOfStudent).collect(Collectors.toList()));
		
		System.out.println(
				courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).reversed()).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream().map(Course::getNoOfStudents).count()
				);
		System.out.println(
				courses.stream().map(Course::getNoOfStudents).reduce(Integer::sum)
				);
		System.out.println(
				courses.stream().map(Course::getNoOfStudents).sorted().distinct().collect(Collectors.toList())
				);
		System.out.println(
				courses.stream().max(numberOfStudent)
				);
		System.out.println(
				courses.stream().min(numberOfStudent)
				);
		
		Comparator<Course> compare2values=Comparator.comparing(Course::getReviewScore).thenComparing(Course::getNoOfStudents);
		
		System.out.println(
				courses.stream().sorted(compare2values).collect(Collectors.toList())
				);
	}
	
}