package abhisheksah.programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee{
	
	private String name;
	private String domain;
	private int employeeId;
	private int salary;
	private int experience;

	
	
	public Employee(String name, String domain, int employeeId, int salary, int experience) {
		super();
		this.name = name;
		this.domain = domain;
		this.employeeId = employeeId;
		this.salary = salary;
		this.experience = experience;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", domain=" + domain + ", employeeId=" + employeeId + ", salary=" + salary
				+ ", experience=" + experience + "]";
	}
}

public class P4CustomClass {

	public static void main(String[] args) {

	
		List<Employee> employees = List.of(
				new Employee("Abhishek","Backend",2,75439,3),
				new Employee("Aniket","Frontend",5,35001,5),
				new Employee("Rahul","PHP",6,32045,2),
				new Employee("Mukesh","Fullstack",7,34880,4),
				new Employee("Ablish","Android",23,98003,9),
				new Employee("Puneet","Backend",12,56990,5),
				new Employee("Vishwa","Frontend",54,65382,7),
				new Employee("Prasant","Android",76,89600,9),
				new Employee("Aman","UX",3,32045,2),
				new Employee("Mohit","UI",1,67090,3)
				);
		List<Object>result= employees.stream().filter(x ->x.getSalary()>80000).collect(Collectors.toList());
		
	
		Predicate<Employee> experienceGreaterThenFive = employee -> employee.getExperience()>5;
		Predicate<Employee> experienceLessThenFive = employee -> employee.getExperience()<5;
		Predicate<Employee> experienceEqualThenFive = employee -> employee.getExperience()==6;
		
		System.out.println(employees.stream().allMatch(experienceGreaterThenFive));
		System.out.println(employees.stream().noneMatch(experienceLessThenFive));
		System.out.println(employees.stream().anyMatch(experienceEqualThenFive));
		
		System.out.println(result);
		
		//Ascending order
		
		Comparator<Employee> comparewithSalary=
				Comparator.comparingInt(Employee::getSalary);
		System.out.println(employees.stream()
				.sorted(comparewithSalary)
				.collect(Collectors.toList()));

//[Employee [name=Rahul, domain=PHP, employeeId=6, salary=32045, experience=2], Employee [name=Aman, domain=UX, employeeId=3, salary=32045, experience=2], Employee [name=Mukesh, domain=Fullstack, employeeId=7, salary=34880, experience=4], Employee [name=Aniket, domain=Frontend, employeeId=5, salary=35001, experience=5], Employee [name=Puneet, domain=Backend, employeeId=12, salary=56990, experience=5], Employee [name=Vishwa, domain=Frontend, employeeId=54, salary=65382, experience=7], Employee [name=Mohit, domain=UI, employeeId=1, salary=67090, experience=3], Employee [name=Abhishek, domain=Backend, employeeId=2, salary=75439, experience=3], Employee [name=Prasant, domain=Android, employeeId=76, salary=89600, experience=9], Employee [name=Ablish, domain=Android, employeeId=23, salary=98003, experience=9]]

		
		Comparator<Employee> comparewithSalaryAndExperience= 
				Comparator.
				comparing(Employee::getSalary)
				.thenComparing(Employee::getEmployeeId);
//				comparing(Employee::getEmployeeId).thenComparing(Employee::getSalary);
		System.out.println(employees.stream().sorted(comparewithSalaryAndExperience).collect(Collectors.toList()));
//		[Employee [name=Aman, domain=UX, employeeId=3, salary=32045, experience=2], Employee [name=Rahul, domain=PHP, employeeId=6, salary=32045, experience=2], Employee [name=Mukesh, domain=Fullstack, employeeId=7, salary=34880, experience=4], Employee [name=Aniket, domain=Frontend, employeeId=5, salary=35001, experience=5], Employee [name=Puneet, domain=Backend, employeeId=12, salary=56990, experience=5], Employee [name=Vishwa, domain=Frontend, employeeId=54, salary=65382, experience=7], Employee [name=Mohit, domain=UI, employeeId=1, salary=67090, experience=3], Employee [name=Abhishek, domain=Backend, employeeId=2, salary=75439, experience=3], Employee [name=Prasant, domain=Android, employeeId=76, salary=89600, experience=9], Employee [name=Ablish, domain=Android, employeeId=23, salary=98003, experience=9]]

		//Descending Order
		Comparator<Employee> comparewithSalaryDecending= 
				Comparator.comparing(Employee::getSalary).reversed();
		System.out.println(
				employees.stream()
				.sorted(comparewithSalaryDecending)
				.collect(Collectors.toList()));
		
		Comparator<Employee> comparewithSalaryAndExperiencedecending= 
				Comparator.comparing(Employee::getSalary)
				.thenComparing(Employee::getEmployeeId).reversed();
		System.out.println(
				employees.stream()
				.sorted(comparewithSalaryAndExperiencedecending)
				.collect(Collectors.toList()));
		
		System.out.println(
				employees.stream().sorted(comparewithSalaryAndExperiencedecending)
				.limit(2).collect(Collectors.toList())
				);
		
		System.out.println(
				employees.stream().sorted(comparewithSalaryAndExperiencedecending)
				.limit(2).collect(Collectors.toList())
				);
	
	}

}
