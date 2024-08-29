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
		
//		[Course [name=FullStack, category=FullStack, reviewScore=91, noOfStudents=14000],
//		 Course [name=Kubernetes, category=Cloud, reviewScore=91, noOfStudents=20000],
//		 Course [name=Docker, category=Cloud, reviewScore=92, noOfStudents=20000], 
//		 Course [name=AWS, category=Cloud, reviewScore=92, noOfStudents=21000],
//		 Course [name=Spring Boot, category=Framework, reviewScore=95, noOfStudents=18000],
//		 Course [name=Microservices, category=Microservices, reviewScore=96, noOfStudents=25000],
//		 Course [name=API, category=Microservices, reviewScore=97, noOfStudents=22000], 
//		 Course [name=Spring, category=Framework, reviewScore=98, noOfStudents=20000],
//		 Course [name=Azure, category=Cloud, reviewScore=99, noOfStudents=21000]]

		
		// using limit ,skip, takewhile,dropwhile
		System.out.println(
				courses.stream().sorted(compare2values)
				.limit(4)
				.collect(Collectors.toList())
				);
//		[Course [name=FullStack, category=FullStack, reviewScore=91, noOfStudents=14000],
//		Course [name=Kubernetes, category=Cloud, reviewScore=91, noOfStudents=20000],
//		Course [name=Docker, category=Cloud, reviewScore=92, noOfStudents=20000],
//		Course [name=AWS, category=Cloud, reviewScore=92, noOfStudents=21000]]
		
		System.out.println(
				courses.stream().sorted(compare2values)
				.skip(2)
				.collect(Collectors.toList())
				);
//		[Course [name=Docker, category=Cloud, reviewScore=92, noOfStudents=20000], 
//		 Course [name=AWS, category=Cloud, reviewScore=92, noOfStudents=21000],
//		 Course [name=Spring Boot, category=Framework, reviewScore=95, noOfStudents=18000],
//		 Course [name=Microservices, category=Microservices, reviewScore=96, noOfStudents=25000],
//		 Course [name=API, category=Microservices, reviewScore=97 
		
		

		System.out.println(
				courses.stream()
				.takeWhile(course->course.getNoOfStudents()<21000)
				.collect(Collectors.toList())
				);
//		[Course [name=Spring, category=Framework, reviewScore=98, noOfStudents=20000],
//		 Course [name=Spring Boot, category=Framework, reviewScore=95, noOfStudents=18000]]

		System.out.println(
				courses.stream()
				.dropWhile(c->c.getReviewScore()>93)
				.collect(Collectors.toList())
				);
//		[Course [name=FullStack, category=FullStack, reviewScore=91, noOfStudents=14000],
//		 Course [name=AWS, category=Cloud, reviewScore=92, noOfStudents=21000],
//		 Course [name=Azure, category=Cloud, reviewScore=99, noOfStudents=21000],
//		 Course [name=Docker, category=Cloud, reviewScore=92, noOfStudents=20000], 
//		 Course [name=Kubernetes, category=Cloud, reviewScore=91, noOfStudents=20000]]

		
		
		//min,max,findfirst,findany
		
		Comparator<Course> category=Comparator.comparing(Course::getCategory);
		
		Comparator<Course> review=Comparator.comparing(Course::getReviewScore);
		
		Comparator<Course> name=Comparator.comparing(Course::getName);	
		
		System.out.println(
				courses.stream().sorted(category).collect(Collectors.toList())
				);
	
		System.out.println(
				courses.stream().sorted(review).collect(Collectors.toList())
				);
		System.out.println(
				courses.stream().sorted(name).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream().max(review)
				);
		
		System.out.println(
				courses.stream().min(review)
				.orElse(new Course("Spring", "Framework", 98, 20000))
				);
		
		System.out.println(
				courses.stream()
				.filter(ratingGreaterThenNintyFivePredicate)
				.findFirst()
				.orElse(new Course("Kubernetes", "Cloud", 91, 20000))
				);
		System.out.println( 
				courses.stream()
				.filter(ratingGreaterThenNintyFivePredicate)
				.findAny()
				);
		
		//sum,average,count
		System.out.println( 
				courses.stream()
				.filter(ratingLessThenNintyFivePredicate)
				.mapToInt(Course::getNoOfStudents)
				.sum()
				);
		
		System.out.println( 
				courses.stream()
				.filter(ratingLessThenNintyFivePredicate)
				.mapToInt(Course::getNoOfStudents)
				.average()
				);
		
		
		System.out.println( 
				courses.stream()
				.filter(ratingLessThenNintyFivePredicate)
				.mapToInt(Course::getNoOfStudents)
				.count()
				);
		
		// grouping this 
		System.out.println( 
				courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory))
				);
		
		System.out.println( 
				courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
				);
		
		System.out.println( 
				courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory,
					Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
				);
		System.out.println( 
				courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory,
					Collectors.mapping(Course::getName, Collectors.toList())))
				);
	}
	
}