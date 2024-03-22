package none;

//using functional interface and lamda expression


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.stream.Collectors;

//Creating List for custom/userdefined class
//practice all methods including stream()
//pojo class @Bean
class Employee2 {
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
	public Employee2(int id, String name, double salary, String address, String designation) {
		super();
		Id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.designation = designation;
	}
	public Employee2() {
		super();
	}
	//generate toString()
	@Override
	public String toString() {
		return "Employee2 [Id=" + Id + ", name=" + name + ", salary=" + salary + ", address=" + address
				+ ", designation=" + designation + "]";
	}
	
}

public class Test72 {
	public static void main(String[] args) {
    List<Employee2> emplist=new ArrayList<Employee2>();
    emplist.add(new Employee2(1,"sachin",50000,"mumbai","batsman"));
    emplist.add(new Employee2(11,"rahul",40000,"bangalore","batsman"));
    emplist.add(new Employee2(21,"sourav",40000,"kolkata","captain"));
    emplist.add(new Employee2(35,"laxman",50000,"andhra pradesh","batsman"));
    emplist.add(new Employee2(69,"zaheer",50000,"hyderabad","bowler"));
    emplist.add(new Employee2(156,"gowtham",50000,"mumbai","batsman"));
    emplist.add(new Employee2(2,"anil",35000,"punjab","bowler"));
    emplist.add(new Employee2(19,"ramesh",34000,"lucknow","allrounder"));
    emplist.add(new Employee2(7,"dhoni",60000,"chennai","batsman"));
    emplist.add(new Employee2(14,"virat",55000,"bangalore","batsman"));
    //Displaying List as one object
    System.out.println(emplist);
    //Displaying the contents of the list individually
    System.out.println("through for-each loop");
    
    System.out.println("through iterator loop");
    ListIterator<Employee2> iterator=emplist.listIterator();
    while(iterator.hasNext()) {
    	System.out.println(iterator.next());
	}
    System.out.println("using foreach method");
    emplist.stream().forEach(x->System.out.println(x));
    //insert a new Employee2 subhman at the end
    Employee2 newjoinee=new Employee2(20,"subhman",60000,"gujrat","batsman");
    emplist.add(emplist.size(),newjoinee);
    System.out.println("new Employee2 added");
    System.out.println(emplist);
    //delete an existing Employee2 anil
      
    Employee2 ob=emplist.remove(0);
    System.out.println("Employee2 removed "+ob);
    System.out.println(emplist);
   //Displaying few Employee2s first 3
    System.out.println("Displaying 3 Employee2s");
    for(int i=0;i<=2;i++) {
    	System.out.println(emplist.get(i));
    }
   //sorting  
    Collections.sort(emplist,
    		(f,s)->Integer.compare(f.getId(), s.getId()));
    System.out.println("after sorting by id id asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->Integer.compare(s.getId(), f.getId()));
    System.out.println("after sorting by id id desc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->f.getName().compareTo(s.getName()));
    System.out.println("after sorting by id Name asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->s.getName().compareTo(f.getName()));
    System.out.println("after sorting by Name desc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->Double.compare(f.getSalary(), s.getSalary()));
    System.out.println("after sorting by salary asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->Double.compare(s.getSalary(), f.getSalary()));
    System.out.println("after sorting by salary desc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->f.getAddress().compareTo(s.getAddress()));
    System.out.println("after sorting by address asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->s.getAddress().compareTo(f.getAddress()));
    System.out.println("after sorting by Address desc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->f.getDesignation().compareTo(s.getDesignation()));
    System.out.println("after sorting by designation asc");
    emplist.stream().forEach(x->System.out.println(x));
    Collections.sort(emplist,
    		(f,s)->s.getDesignation().compareTo(f.getDesignation()));
    System.out.println("after sorting by Designation desc");
    emplist.stream().forEach(x->System.out.println(x));
    Employee2 obtosearch=new Employee2();
    obtosearch.setName("laxman");
    //Comparable has two limitations
   //1. custom order of sorting is not possible
   //2. Lambda is not applicable though it is a functional interface
   // but implemented by a POJO
   //it is overcomed by Comparator 
   Long c=emplist.stream().count();
   System.out.println("Total Employee2");
   List<Employee2> bangloreemplist=new ArrayList<Employee2>();
   bangloreemplist=emplist.stream().filter(x->x.getAddress().equalsIgnoreCase("bangalore")).collect(Collectors.toList());
   System.out.println(bangloreemplist.stream().count());
   System.out.println(bangloreemplist);
   List<Employee2> batsman=new ArrayList<Employee2>();
   batsman=emplist.stream().filter(x->x.getDesignation().equalsIgnoreCase("batsman") && x.getSalary()>=4000 ).collect(Collectors.toList());
   System.out.println(batsman.stream().count());
   System.out.println(batsman);
   
   //redusing many to one
  // double totalsalary=emplist.stream().reduce();
   //mapping one-one
   List<Boolean> mappedList=new ArrayList<Boolean>();
   mappedList=emplist.stream().map(x->x.getSalary()>50000).collect(Collectors.toList());
   System.out.println("mapping true and false by salary");
   System.out.println(emplist);
   System.out.println(mappedList);
   //practice anyMatch,allMatch,noneMatch,distint,max,min
   //finding employee getting highest salary
}
}
