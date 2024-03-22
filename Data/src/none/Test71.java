package none;

import java.util.*;

//Creating List for custom/userdefined class
//practice all methods including stream()
//pojo class @Bean
class Employee {
	private int Id;
	private String name;
	private double salary;
	private String address;
	private String designation;
	//add getter setter  use alt shift s
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
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
	//generate both constructor alt shift s
	public Employee(int id, String name, double salary, String address, String designation) {
		super();
		Id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.designation = designation;
	}
	public Employee() {
		super();
	}
	//generate toString()
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", salary=" + salary + ", address=" + address
				+ ", designation=" + designation + "]";
	}
	
}
class IdComparator implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return Integer.compare(f.getId(), s.getId());
	}
}
class IdComparatorDesc implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return Integer.compare(s.getId(), f.getId());
	}
}
class NameComparator implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return f.getName().compareTo(s.getName());
	}
}
class NameComparatorDesc implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return s.getName().compareTo(f.getName());
	}
}
class SalaryComparator implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return Double.compare(f.getSalary(), s.getSalary());
	}
}
class SalaryComparatorDesc implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return Double.compare(s.getSalary(), f.getSalary());
	}
}
class AddressComparator implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return f.getAddress().compareTo(s.getAddress());
	}
}
class AddressComparatorDesc implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return s.getAddress().compareTo(f.getAddress());
	}
}
class DesigComparator implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return f.getDesignation().compareTo(s.getDesignation());
	}
}
class DesigComparatorDesc implements Comparator<Employee> {
	public int compare(Employee f,Employee s) {
		return s.getDesignation().compareTo(f.getDesignation());
	}
}


public class Test71 {
	public static void main(String[] args) {
    List<Employee> emplist=new ArrayList<Employee>();
    emplist.add(new Employee(1,"sachin",50000,"mumbai","batsman"));
    emplist.add(new Employee(11,"rahul",40000,"bangalore","batsman"));
    emplist.add(new Employee(21,"sourav",40000,"kolkata","captain"));
    emplist.add(new Employee(35,"laxman",50000,"andhra pradesh","batsman"));
    emplist.add(new Employee(69,"zaheer",50000,"hyderabad","bowler"));
    emplist.add(new Employee(156,"gowtham",50000,"mumbai","batsman"));
    emplist.add(new Employee(2,"anil",35000,"punjab","bowler"));
    emplist.add(new Employee(19,"ramesh",34000,"lucknow","allrounder"));
    emplist.add(new Employee(7,"dhoni",60000,"chennai","batsman"));
    emplist.add(new Employee(14,"virat",55000,"bangalore","batsman"));
    //Displaying List as one object
    System.out.println(emplist);
    //Displaying the contents of the list individually
    System.out.println("through for-each loop");
    
    System.out.println("through iterator loop");
    ListIterator<Employee> iterator=emplist.listIterator();
    while(iterator.hasNext()) {
    	System.out.println(iterator.next());
	}
    System.out.println("using foreach method");
    emplist.stream().forEach(x->System.out.println(x));
    //insert a new employee subhman at the end
    Employee newjoinee=new Employee(20,"subhman",60000,"gujrat","batsman");
    emplist.add(emplist.size(),newjoinee);
    System.out.println("new employee added");
    System.out.println(emplist);
    //delete an existing employee anil
      
    Employee ob=emplist.remove(0);
    System.out.println("employee removed "+ob);
    System.out.println(emplist);
   //Displaying few employees first 3
    System.out.println("Displaying 3 employees");
    for(int i=0;i<=2;i++) {
    	System.out.println(emplist.get(i));
    }
   //sorting  
    Collections.sort(emplist,new IdComparator());
    System.out.println("after sorting by id id asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new IdComparatorDesc());
    System.out.println("after sorting by id id desc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new NameComparator());
    System.out.println("after sorting by id Name asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new NameComparatorDesc());
    System.out.println("after sorting by Name desc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new SalaryComparator());
    System.out.println("after sorting by salary asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new SalaryComparatorDesc());
    System.out.println("after sorting by salary desc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new AddressComparator());
    System.out.println("after sorting by address asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new AddressComparatorDesc());
    System.out.println("after sorting by Address desc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new DesigComparator());
    System.out.println("after sorting by designation asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,new DesigComparatorDesc());
    System.out.println("after sorting by Designation desc");
    emplist.stream().forEach(x->System.out.println(x));
    Employee obtosearch=new Employee();
    obtosearch.setName("laxman");
    //Comparable has two limitations
   //1. custom order of sorting is not possible
   //2. Lambda is not applicable though it is a functional interface
   // but implemented by a POJO
   //it is overcomed by Comparator 
   
    
}
}
