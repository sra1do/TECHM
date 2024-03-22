//creating list for custom/iserdefined class
//practice all methods inculing stream()
//pojp class @bean
package Data;
import java.util.*;

class Employee22{
	private int Id;
	private String Name;
	private double Salary;
	private String address;
	private String designation;
	//generate geter and setter alt shift s
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	//generate both constructors alt shift s
	public Employee22(int id, String name, double salary, String address, String designation) {
		super();
		Id = id;
		Name = name;
		Salary = salary;
		this.address = address;
		this.designation = designation;
	}
	public Employee22() {
		super();
	}
	//generate Tostring alt shift s
	@Override
	public String toString() {
		return "Employee22 [Id=" + Id + ", Name=" + Name + ", Salary=" + Salary + ", address=" + address
				+ ", designation=" + designation + "]";
	}
	
	public int compareTo(Employee22 second) {
		return this.Name.compareTo(second.Name);
	}
}
class IdComparator implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return Integer.compare(f.getId(), s.getId());
	}
}
class IdComparatorDesc implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return Integer.compare(s.getId(), f.getId());
	}
}
class NameComparator implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return f.getName().compareTo(s.getName());
	}
}
class NameComparatorDesc implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return s.getName().compareTo(f.getName());
	}
}
class SalaryComparator implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return Double.compare(f.getSalary(), s.getSalary());
	}
}
class SalaryComparatorDesc implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return Double.compare(s.getSalary(), f.getSalary());
	}
}
class AddressComparator implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return f.getAddress().compareTo(s.getAddress());
	}
}
class AddressComparatorDesc implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return s.getAddress().compareTo(f.getAddress());
	}
}
class DesigComparator implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return f.getDesignation().compareTo(s.getDesignation());
	}
}
class DesigComparatorDesc implements Comparator<Employee22> {
	public int compare(Employee22 f,Employee22 s) {
		return s.getDesignation().compareTo(f.getDesignation());
	}
}
public class Test7 {

	public static void main(String[] args) {
		List<Employee22> emplist = new ArrayList<Employee22>();
		emplist.add(new Employee22(10,"sravan",500000,"Ap","Bowler"));
		emplist.add(new Employee22(11,"vedha",500000,"Ap","Bowler"));
		emplist.add(new Employee22(12,"sravan",500000,"Ap","Bowler"));
		emplist.add(new Employee22(13,"harish",500000,"Ap","Bowler"));
		emplist.add(new Employee22(14,"sravan",500000,"Ap","Bowler"));
		emplist.add(new Employee22(15,"sravan",500000,"Ap","Bowler"));
		emplist.add(new Employee22(16,"sravan",500000,"Ap","Bowler"));
		emplist.add(new Employee22(17,"sravan",500000,"Ap","Bowler"));
		//Displaying List as one Object
		System.out.println(emplist);
		//Displaying the contents of the list individually
		System.out.println("Displaying through for-each loop");
		for(Employee22 i:emplist) {
			System.out.println(i);
		}
		System.out.println("Displaying through iteration");
		ListIterator<Employee22> iterator=emplist.listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("using foreach method");
		emplist.stream().forEach(x-> System.out.println(x));
		//insert a new Employee2 vedha at the end
		Employee22 newjoinee=new Employee22(18,"VEDHA",8755412,"AP","CODER");
		emplist.add(emplist.size(),newjoinee);
		System.out.println("New Employee2 Added");
		System.out.println(emplist);
		// delete an exisiting harish
		emplist.remove(new Employee22(13,"harish",500000,"Ap","Bowler"));
		System.out.println("Employee2 Removed");
		System.out.println(emplist);
		// delete an exisiting harish by index
		emplist.remove(emplist.indexOf(new Employee22(14,"sravan",500000,"Ap","Bowler"))+1);
		System.out.println("Employee2 Removed");
		System.out.println(emplist);
		//searching an Employee2
		if(emplist.contains(newjoinee))
			System.out.println("Employee2 is present");
		else
			System.out.println("Employee2 is not present");
		//Displaying few Employee2s first 3
		System.out.println("Displaying 3 Employee2s");
		for(int i=0;i<=2;i++) {
			System.out.println(emplist.get(i));
		}
		//sorting
		//Collections.sort(emplist);
		System.out.println("After sorting");
		emplist.stream().forEach(x->System.out.println(x));
		Employee22 obtosearch=new Employee22();
		obtosearch.setId(12);
		obtosearch.setName("vedha");
		 //int index= Collections.binarySearch(emplist,obtosearch);
		  // System.out.println("found Employee2 with name Vedha is "+index);
			

	}

}
